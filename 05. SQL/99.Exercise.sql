-- 연습문제 --
-- 1. --
-- 도서번호가 1인 도서의 이름
select bookname from book where bookid=1;
-- 가격이 2만원 이상인 도서의 이름
select bookname from book where price >= 20000;
-- 박지성의 총 구매액 (박지성의 고객번호는 1)
select sum(saleprice) as 박지성_총_구매액 from orders where custid=1;
select sum(o.saleprice) from orders o
    join customer c
    on o.custid=c.custid
    where c.name='박지성';
-- 박지성의 총 구매 도수의 수 (박지성의 고객번호는 1)
select count(*) as 박지성_총_구매수 from orders where custid=1;

-- 2. --
-- 마당서점 도서의 총 개수
select count(*) from book;
-- 마당서점에 도서를 출고하는 출판사의 총 개수
select count(distinct publisher) from book;
-- 모든 고객의 이름, 주소
select distinct name, address from customer;
-- 2014년 7월 4일 ~ 7월 7일 사이에 주문 받은 도서의 주문번호
select * from orders;
select * from orders where orderdate between '2014-07-04' and '2014-07-07';
-- 2014년 7월 4일 ~ 7월 7일 사이에 주문 받은 도서를 제외한 도서의 주문번호
select orderid from orders where orderdate not between '2014-07-04' and '2014-07-07';
-- 성이 '김'씨인 고객의 이름과 주소
select name, address from customer where name like '김%';
-- 성이 '김'씨이고 이름이 '아'로 끝나는 고객의 이름과 주소
select name, address from customer where name like '김%' and name like '%아';
select name, address from customer where name like '김%아';