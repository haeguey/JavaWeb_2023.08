-- 연습문제 --

select * from customer;
select * from book;
select * from orders;

-- 1. --
-- 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select b.publisher from orders o
    join book b on o.bookid=b.bookid
    join customer c on o.custid=c.custid
    where c.name like '박지성';
        
-- 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select c.name, count(DISTINCT b.publisher) from orders o
    join book b on o.bookid=b.bookid
    join customer c on o.custid=c.custid
    group by c.name having count(DISTINCT b.publisher)>=2;
    
-- (생략) 전체 고객의 30% 이상이 구매한 도서
select b.bookname, count(o.bookid) from orders o
    join book b on o.bookid=b.bookid
    group by b.bookname having count(o.bookid) >= 2;   -- 6명이니까 30% 면 1.8권
select * from orders;


-- 2. --
select * from book;

-- 새로운 도서('스포츠 세계', '대한미디어', 10000원)이 마당서점에 입고되었다.
-- (삽입이 안 될 경우 필요한 데이터가 더 있는지 찾아보자)
insert into book
    values(13, '스포츠 세계', '대한미디어', 10000);
-- 또는 아래와 같이 해도 무방하다 --    
insert into book(bookid, bookname, publisher, price)
    values(13, '스포츠 세계', '대한미디어', 10000);    
select * from book;
    
-- '삼성당'에서 출판한 도서를 삭제해야 한다.
delete from book
    where publisher like '삼성당';
select * from book;
commit;
-- ‘이상미디어’에서 출판한 도서를 삭제해야 한다. 삭제가 안 될 경우 원인을 생각해보자
select * from orders;
select * from orders
    where bookid in (select bookid from book where publisher like '이상미디어');
-- foreign key가 orders에도 걸려있어서 orders에서 부터 삭제해야 한다.
delete from book
    where (select bookid from book where publisher like '이상미디어');

-- 출판사 ‘대한미디어’가 ‘대한출판사’로 이름을 바꾸었다.
update book set publisher='대한출판사'
    where publisher like '대한미디어';
select * from customer;

/* 3. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오. */
-- (pg61 from 3장 강의_SQL 기초) --

-- 1. 박지성이 구매한 도서의 출판사 수

-- Solution 1.
select count(DISTINCT b.publisher)
    from book b, customer c, orders o
    where c.name like '박지성' and c.custid=o.custid and b.bookid=o.bookid;

-- Solution 2.
select count(distinct b.publisher) from orders o 
    join book b on o.bookid=b.bookid
    join customer c on o.custid=c.custid
    where c.name like '박지성';

-- 2. 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
-- Solution 1.
select b.bookname, abs(b.price-o.saleprice)
    from book b, customer c, orders o
    where c.name like '박지성' and c.custid=o.custid and b.bookid=o.bookid; 

-- Solution 2.
select b.bookname, b.price, o.saleprice, o.saleprice-b.price from orders o 
    join book b on o.bookid=b.bookid
    join customer c on o.custid=c.custid
    where c.name like '박지성'; 

-- 3. 박지성이 구매하지 않은 도서의 이름
-- Solution 1.
select b.bookname
    from book b, customer c, orders o
    where c.name not like '박지성' and c.custid=o.custid and b.bookid=o.bookid; 

-- Solution 2.
select bookname from book
    minus select b.bookname from orders o 
        join book b on o.bookid=b.bookid
        join customer c on o.custid=c.custid
        where c.name like '박지성';

select * from customer;
select * from book;
select * from orders;

-- 1. 주문하지 않은 고객의 이름(부속질의 사용)
-- Solution 1.
select distinct c.name
    from customer c
    where c.custid not in (select o.custid from orders o);

-- Solution 2.
select name from customer
    where custid not in (select distinct custid from orders);
    
-- 2. 주문 금액의 총액과 주문의 평균 금액
select sum(o.saleprice) as 주문총액, round(avg(o.saleprice), 0) as 주문평균가
    from orders o;
    
-- 3. 고객의 이름과 고객별 구매액
select c.name, sum(o.saleprice) from customer c
    join orders o
    on c.custid = o.custid
    group by c.name;

-- 4. 고객의 이름과 고객이 구매한 도서 목록
-- Solution 1.
select c.name, b.bookname
    from customer c, book b, orders o
    where c.custid = o.custid and b.bookid = o.bookid
    order by c.name;

-- Solution 2.
select c.name, listagg(b.bookname, ', ')    -- listagg means list aggregate
    within group (order by b.bookname) booklist 
    from orders o
    join customer c on o.custid=c.custid
    join book b on o.bookid=b.bookid
    group by c.name; 
        
-- 5. 도서의 가격(book 테이블)과 판매가격(orders테이블)의 차이가 가장 많은 주문
-- solution 1.
select o.orderid, MAX(abs(b.price-o.saleprice))
    from book b, orders o 
    where b.bookid=o.bookid
    group by o.orderid
    order by MAX(abs(b.price-o.saleprice)) desc;

-- solution 2.
select max(abs(o.saleprice-b.price)) from orders o
    join book b on o.bookid=b.bookid;
-- 판가와 정가의 차이가 6000원인 주문 찾기
select o.orderid, o.saleprice, b.price from orders o
    join book b on o.bookid=b.bookid
    where abs(o.saleprice-b.price) = 6000;
-- 위 두개의 SQL을 결합
select o.orderid, o.saleprice, b.price from orders o
    join book b on o.bookid=b.bookid
    where abs(o.saleprice-b.price) = (
        select max(abs(o.saleprice-b.price)) from orders o
            join book b on o.bookid=b.bookid);   
    
 -- 6. 도서의 판매액 평균보다 자신의 구매액이 평균이 더 높은 고객의 이름
/*
 * 출력 결과에 박세리 이외는 나와서는 안된다.
 * 여기서 사용된 avg(o.saleprice)는 각 개인별 평균이므로 판매액 평균이 아니다.
select c.name, sum(o.saleprice), round(avg(o.saleprice),0)
    from customer c
    join orders o
    on c.custid=o.custid
    having sum(o.saleprice) > avg(o.saleprice)
    group by c.name;
*/
-- solution 1.
select round(avg(saleprice)) from orders;

select o.custid, sum(o.saleprice)
    from orders o
    group by o.custid;
    
select c.name, sum(o.saleprice), round(avg(o.saleprice),0)
    from customer c, orders o
    where c.custid=o.custid
    having avg(o.saleprice) > (select round(avg(saleprice)) from orders)
    group by c.name;

-- solution 2.
select avg(saleprice) from orders;
select c.name, avg(o.saleprice) from orders o
    join customer c on o.custid=c.custid
    group by c.name
    having avg(o.saleprice) > (select avg(saleprice) from orders);

    




