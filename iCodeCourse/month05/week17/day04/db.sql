-- Table baiwal 'IF EXISTS' ustgana
drop table if exists books;

create table authors (
	id serial primary key,
	name varchar(255)
);

alter table books
add constraint fk_books_author
foreign key(author_id)
references author(id)
	--on delete cascade
	on delete set null
	--on delete restrict
	
-- LEFT JOIN
select * from books b
left join authors a
on a.id = b.author_id;

select * from authors a
left join books b
on a.id = b.author_id;

-- RIGHT JOIN
select * from books b
right join authors a
on a.id = b.author_id;

select * from authors a
right join books b
on a.id = b.author_id;

--INNER JOIN
select * from books b
inner join authors a
on b.author_id = a.id;

-- FULL JOIN / FULL OUTER JOIN
select * from books b
full outer join authors a
on a.id = b.author_id;

-- CROSS JOIN
select * from books b
cross join authors a;
	