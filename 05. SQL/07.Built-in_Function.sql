/*
 *  4. Built-in Function
 */
 
 /*
  *     4.1 Functions
  */
-- 절대값
select abs(-78);    // 틀린 사용
select abs(-78) from dual;  // 올바린 사용

-- 반올림
select round(3.141592, 0), round(3.141592, 2), round(3.141592, 4) from dual;

-- 문자열 연결
select concat('마당', '서점') from dual;

-- 문자열 대체
select replace('JACK and JUE', 'J', 'BL') from dual;

-- 도서제목에 야구가 포함된 도서를 농구로 변경한 후 변경된 도서 목록을 보여주기
select replace(bookname, '야구', '농구') from book
    where bookname like '%야구%';

-- 굿스포츠에서 출판한 도서의 제목과 제목의 글자 수
select bookname,length(bookname) from book
    where publisher like '굿스포츠';

-- 마당서점의 고객 중에서 같은 성씨를 가진 사람이 몇 명이나 되는지 성별 인원수
select substr(name, 1, 1) as 성, count(name) as 인원수
    from customer 
    group by substr(name, 1, 1);

-- 마당서점은 주문일로부터 10일 후 매출을 확정한다
select orderid, orderdate as 주문일자, orderdate+10 as 확정일자 from orders;

-- 마당서점이 2014년 7월 7일에 주문받은 도서의 주문번호, 주문일, 고객번호, 도서번호
select * from orders where orderdate='2014-0707';
select * from orders where orderdate=to_date('20140707', 'yyyymmdd');
select * from orders where orderdate=to_date('140707', 'ymmdd');

-- 마당서점이 7월7일에서 7월9일까지 판매한 책 이름과 판매가격은?
select o.orderdate, b.bookname, o.saleprice from book b
    join orders o
    on b.bookid=o.bookid
    where o.orderdate between '2014-07-07' and '2014-07-09'
    order by o.orderdate; 

-- 오늘 현재
select sysdate, systimestamp, current_timestamp from dual;

-- MyBook 테이블 만들기
create table MyBook(
    bookid number primary key,
    price NUMBER
);
insert into MyBook values(1, 10000);
insert into MyBook values(2, 20000);
insert into MyBook(bookid) values(3);
insert into MyBook values(4, null);
delete from MyBook where bookid=4;
commit;
select * from MyBook;

-- null 값에 대한 연산
select price+100 from mybook;
select sum(price), avg(price), count(*), count(price) from mybook;
select * from mybook where price is not null;
select bookid, nvl(price, 0) from mybook;

 /*
  *     4.3 ROWNUM
  */
  -- 도서의 가격이 비싼 책 3권
select * from book order by price desc;

select rownum, bookid, bookname, price from book order by price desc;   -- bookid 중 9가 없음
select * from book;

select rownum, a.*
    from (select * from book order by price desc) a;
    
select rownum, a.*
    from (select * from book order by price desc) a
    where rownum <= 3;  -- rownum 비교는 < 및 <= 만 가능함

-- 도서의 가격이 비싼 책 4~6위 출력
select * from(
    select rownum as rnum, a.*
        from (select * from book order by price desc) a
        where rownum <= 6)
        where rnum >= 4;
-- select * from book order by price desc limit 3 offset 3  <-- MySQL code for the same
