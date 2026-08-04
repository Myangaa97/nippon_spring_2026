select * from courses;
select * from students; 
select * from enrollments;

-- JOIN
--select enrollments.id, students.id from enrollments, students;
select e.id, s.id, s.name from enrollments e, students s;

select * from enrollments e
join students s
on e.student_id = s.id;

select e.id, e.course_id , s.name from enrollments e
join students s
on e.student_id = s.id;

select e.id, c.title, s.name from enrollments e
join students s
on e.student_id = s.id
join courses c
on e.course_id = c.id;

select * from books;

-- 1. Bvh uls hot ner, ulsiin ner hamt haruulna, gehdee uls ASC haruul
select ci.city, c.country from city ci
join country c
on ci.country_id = c.country_id
order by c.country asc;

-- 2. Jvjigchid ner, owog ard ymar kinond togloson title-r haruul
select * from actor limit 10;
select * from film limit 10;
select * from film_actor limit 10;

select a.first_name || ' ' || a.last_name as "Full Name",
f.title
join film_actor fa
on a.actor_id = fa.actor_id
join film f
on f.film_id = fa.film_id;

select * from country c
join city ci
using (country_id);

-- Ex03
-- customer -n ner bolon hayg
-- use a JOIN
select
c.first_name, c.last_name,
a.address,
a.district,
a.postal_code,
ci.city, co.country
from
customer c
join address a
using (address_id)
join city ci
using (city_id)
join country co
using (country_id);

