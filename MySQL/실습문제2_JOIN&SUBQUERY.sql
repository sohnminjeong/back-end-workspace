-- Sakila : DVD 대여 및 영화 정보와 관련된 데이터 포함

SELECT * FROM category; -- 영화 카테고리 정보 : category_id
SELECT * FROM rental; -- DVD 대여 정보 : customer_id, inventory_id
SELECT * FROM inventory; -- DVD 대여점에서 관리하는 정보 : inventory_id, film_id
SELECT * FROM customer; -- DVD 대여 고객 정보 : customer_id, address_id
SELECT * FROM film; -- 영화 정보 : film_id
SELECT * FROM actor; -- 영화 배우 정보 : actor_id

SELECT * FROM film_category; -- film과 category 연결 : film_id, category_id
SELECT * FROM film_actor; -- film과 actor 연결 : film_id, actor_id

SELECT * FROM address; -- 고객 주소 정보 : address_id, city_id
SELECT * FROM city; -- city_id, country_id
SELECT * FROM country; -- country_id;


select * from actor; -- actor_id, fisrt_name, last_name, last_update
select * from address;  -- address_id, address, district, city_id
select * from country;  -- country_id, country, last_update
select * from city;   -- city_id, country_id, city 
select * from customer; -- fisrt_name, last_name, address_id

-- 1. first_name이 TRACY인 사람들 조회 
-- 필요한 컬럼 : country, city, address, district, frist_name, last_name
-- 필요한 테이블 : country, city, address, customer
SELECT country, city, address, district, first_name, last_name 
FROM country co, city c, address ad, customer cu
WHERE 
co.country_id = c.country_id 
AND ad.city_id = c.city_id 
AND ad.address_id = cu.address_id
AND first_name = 'TRACY';

-- [강사님]
SELECT country, city, address, district, first_name, last_name
FROM customer
	JOIN address USING(address_id)
    JOIN city USING(city_id)
    JOIN country USING(country_id)
WHERE first_name = 'TRACY';

-- 2. 배우 JULIA MCQUEEN이 찍은 영화 제목 조회 (title 기준 정렬 10개까지)
-- 필요한 컬럼 : first_name, last_name, title
-- 필요한 테이블 : actor, film_actor, film
SELECT * FROM film_actor; -- film과 actor 연결 : film_id, actor_id
SELECT first_name, last_name, title
FROM film f
JOIN film_actor fa ON (f.film_id=fa.film_id)
JOIN actor a ON(a.actor_id = fa.actor_id)
WHERE first_name = 'JULIA' AND last_name = 'MCQUEEN'
LIMIT 10;

-- [강사님]
-- [ANSI]
SELECT first_name, last_name, title
-- 가장 많이 가지고 있는 것을 FROM에 위치 시킴
FROM film_actor
 JOIN actor USING(actor_id)
 JOIN film USING(film_id)
WHERE first_name = 'JULIA' AND last_name = 'MCQUEEN'
ORDER BY title
LIMIT 10;

-- [WHERE]
SELECT first_name, last_name, title
FROM actor a, film_acotr fa, film f
WHERE a.actor_id = fa.actor_id
 AND fa.film_id = f.film_id
 AND first_name = 'JULIA'
 AND last_name = 'MCQUEEN'
 ORDER BY title
 LIMIT 10;


-- 3. 영화 NOON PAPI에 나오는 배우들의 이름 조회
-- 필요한 컬럼 : first_name, last_name 
-- 필요한 테이블 : film, film_actor, actor
SELECT first_name, last_name
FROM film f
JOIN film_actor fa ON (f.film_id=fa.film_id)
JOIN actor a ON(a.actor_id = fa.actor_id)
WHERE title = 'NOON PAPI';

-- [강사님]
-- [ANSI]
SELECT first_name, last_name
FROM film_actor
 JOIN  actor USING(actor_id)
 JOIN film USING(film_id)
WHERE title = 'NOON PAPI';

-- [서브쿼리] : 조회에 필요한 테이블은 actor 뿐! 
-- actor와 film_actor : actor_id와 where in()으로 연결 (where =()으로 연결 불가! 이중은 안됨)
-- film_actor과 film : film_id와 where = ()로 연결 
SELECT first_name, last_name
FROM actor
WHERE actor_id IN(
 SELECT actor_id
 FROM film_actor
 WHERE film_id = 
	(SELECT film_id
	FROM film    
	WHERE title = 'NOON PAPI')
);    

-- 4. 각 카테고리별 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 빌린 DVD 대여 수 조회 
-- 필요한 컬럼 : name, count(*)
-- 필요한 테이블 : rental, category, customer, film_category, inventory
SELECT name 'category', count(customer_id)
from category
JOIN film_category USING(category_id)
JOIN inventory USING (film_id)
JOIN rental USING(inventory_id)
JOIN customer USING(customer_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
GROUP BY name;

-- [강사님]
-- [ANSI]
SELECT name category, count(*)
FROM rental
 JOIN inventory USING(inventory_id)
 JOIN customer USING(customer_id)
 JOIN film_category USING(film_id)
 JOIN category USING(category_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
GROUP BY name;

-- [서브쿼리]
SELECT name category, count(*)
FROM rental
 JOIN inventory USING(inventory_id)
 JOIN film_category USING(film_id)
 JOIN category USING(category_id)
WHERE customer_id = (
SELECT customer_id
FROM customer
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org')
GROUP BY name;


-- 5. 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 가장 최근에 빌린 영화 제목과 영화 내용을 조회 
-- 필요한 컬럼 : title, description
-- 필요한 테이블 : film, customer, 
SELECT * FROM customer;  -- customer_id, email
SELECT * FROM rental;    -- rental_id, rental_date, customer_id, inventory_id
SELECT * FROM inventory;   -- inventory_id, film_id 
SELECT * FROM film;      -- film_id, description, title

SELECT title, description
FROM film
JOIN inventory USING(film_id)
JOIN rental USING(inventory_id)
JOIN customer USING(customer_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org' 
ORDER BY rental_date DESC 
LIMIT 1;

-- [강사님]
-- [ANSI]
SELECT title, description 
FROM rental   -- 연결이 가장 많이 있는 rental로 FROM  지정 
 JOIN customer USING(customer_id) 
 JOIN inventory USING(inventorY_id)
 JOIN film USING(film_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
ORDER BY rental_date desc
LIMIT 1;

-- [서브쿼리]
SELECT title, description
FROM rental 
 JOIN inventory USING(inventory_id)
 JOIN film USING(film_id)
WHERE rental_date = (
 SELECT max(rental_date)   
 FROM rental
 JOIN customer USING(customer_id)
 WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org');
-- 최근에 빌린 것을 max(rental_date)로 표현 
-- 서브쿼리 안에 customer을 JOIN했기 때문에 서브쿼리 밖에서는 따로X