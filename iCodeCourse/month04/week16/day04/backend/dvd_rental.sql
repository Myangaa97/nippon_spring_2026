select * from actor;

-- zuwhun bagana songoh

select first_name from actor;

select first_name, last_name from actor;

-- First Name | Last Name
select first_name as "First Name", last_name "Last Name" from actor;

select city_id, city from city;
select country from country;
select * from film;

-- LIMIT
-- 10 mur awah
select * from country limit 10;


-- ORDER
-- ASC, DESC
select * from country order by country asc limit 100;
select * from city order by city asc limit 10;
select * from film order by title desc limit 20;

--neg baganand
select first_name || ' '|| last_name as "Full Name" from actor;

-- DISTINCT - dawhardalt alga bolgodog
select distinct first_name from actor;

-- country-s afganistan haih
select * from country where country = 'Italy';

-- Warren nert bvh actor ylgaj haruul
select * from actor where first_name = 'Warren';

-- R rating title, description, rating
select title, description, rating from film where rating = 'R';

--
select first_name, last_name, email from customer where active = 0;

--
select title, rental_rate from film where rental_rate > 3;

-- "is null gej bichne"
select rental_id, rental_date from rental where return_date is null;

--
select title, length, rental_rate from film where rental_rate < 1 and length > 180;

-- allen, chase, davis bvh actor haruul
select * from actor where last_name = 'Allen' or  last_name = 'Chase' or last_name = 'Davis';
select * from actor where last_name in ('Allen','Chase','Davis');

--
select payment_id, amount, payment_date  from payment
where
payment_date:: date in ('2007-02-15','2007-02-16');

--
select * from film order by film_id not in (1, 2, 3) asc limit 20;

--
select * from payment where payment_id between 17500 and 17505;











