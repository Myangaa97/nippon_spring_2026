create table clubs (
	id serial primary key,
	name varchar(150) not null unique ,
	founded_date date default current_date ,
	is_active boolean default true
);

create table members (
	id serial primary key,
	club_id int references clubs (id),
	email varchar(200) not null unique,
	full_name varchar (100) not null,
	subscription_fee numeric(10, 2) check (subscription_fee >= 0),
	joined_at timestamptz default now()
    );

-- Data definition Language DDL
-- 1.
alter table members add column phone varchar(20);

-- 2.
alter table members alter column full_name type varchar(250);

-- 3.
alter table clubs add column category varchar(50) default 'General' not null;

-- 4.
alter table clubs add constraint check_category_length check (length(category ) > 2);

insert into clubs (name, category, is_active)
values ('Chess Club', 'Board games', true);
select * from clubs;

insert into members (club_id, email, full_name, subscription_fee)
values
(1, 'myangaa@email.com', 'Myangaa', 5000.0),
(1, 'scholes@emial.com', 'Scholes', 10000.0);
select * from members;

-- Level 3 - 1
truncate table members restart identity;

-- Level 4 - 1
drop table clubs cascade;
select * from members;

drop table members;
drop database club_system;