select * from Book;
select * from Customer;
select * from Orders;
select publisher, price from Book where bookname like '축구의 역사';
select publisher, price from Book where bookname='축구의 역사';

/*
1. query (질의어)
    
select field_name;
    from table_name;
    join table_name;
    on joining_condition);
    where field_name;
    having group_condition;
    order by field_names asc(or desc);
    ex) select * from book order by price desc;    
갯수 조절을 위한 필드가 추가됨

*/
select * from book order by price desc;
select distint price from book;

/* 기본 구문 */
select * from customer;
select * from book;
select * from orders;
select name, address from customer;

-- book 테이블에 있는 출판사 이름은?
select distinct publisher from book;

/* 
    1.1 조회 조건
*/
-- 가격이 1만원 이상인 책
select * from book where price >= 10000;
-- 대한미디어에서 출간한 책
select * from book where publisher='대한미디어';
-- 축구와 관련된 책
select * from book where bookname like '%축구%';
-- 가격이 10000원 이상, 20000원 이하인 책
select * from book where price >= 10000 and price <= 20000;
-- 가격이 10000원 미만, 20000원 초과인 책
select * from book where price < 10000 or price > 20000;
-- 가격이 10000원 이상, 20000원 이하인 책
select * from book where price between 10000 and 20000;
-- 가격이 13000원이 아닌 책
select * from book where price != 13000;
-- 가격이 7의 배수인 책
select * from book where mod(price, 7) = 0;
-- 가격이 10000 또는 20000 또는 30000원인 책
select * from book where price in (10000, 20000, 30000);
-- 나무수, 굿스포츠, 삼성당에서 출간한 책
select * from book where publisher='나무수' 
    or publisher='굿스포츠' or publisher='삼성당';
select * from book where publisher in ('나무수', '굿스포츠', '삼성당');
-- 미국과 영국에 사는 고객은?
select * from customer where address like '%미국%' or address like '%영국%';
-- 전화번호가 null인 고객은?
select * from customer where phone is null;

/* 
    1.2 order by (순서)
*/
select * from book;
select * from customer;
-- 책 이름의 오름차순 (ascending order)으로 정렬
select * from book order by bookname;
-- 책 가격의 내림차순 (descending order)으로 정렬 (가격이 같으면 테이블 내에 앞의 필드를 기준으로 내림차순으로 결정?))
select * from book order by price desc;
-- 책 가격의 내림차순(descending order)으로 정렬, 같으면 책 이름의 오름차순으로 정렬
select * from book order by price desc, bookname;   -- bookname asc;
-- 대한민국에 사는 고객을 이름순으로 정렬
select * from customer where address like '%대한민국%' order by name;

/*
    1.3 function (함수)
*/
select * from orders;

-- 고객의 수는?
select count(*) from customer;
select count(*) as tot_customers from customer;     // as --> alias
-- 주문금액의 합계, 평균은?
select sum(saleprice) as tot_price, avg(saleprice) as avg_price, max(saleprice) as max_price, min(saleprice) as min_price from orders;
-- 대한미디어에서 출간한 책 가격의 평균은?
select avg(price) from book where publisher='대한미디어';
select * from orders;
select * from book;
select * from customer;

