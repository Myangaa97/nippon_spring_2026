CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100),
    price NUMERIC(10, 2),
    published_year INT
);

INSERT INTO books (title, author, price, published_year) VALUES
    ('Clean Code', 'Robert Martin', 45000, 2008),
    ('The Pragmatic Programmer', 'Andy Hunt', 52000, 1999),
    ('Design Patterns', 'Gang of Four', 61000, 1994),
    ('Refactoring', 'Martin Fowler', 48000, 2018),
    ('Head First Java', 'Kathy Sierra', 39000, 2022);

select * from books

-- update hiih
update books set price = 55000 where id = 3;

-- Andy Hunt nom 55000 bolgoh
update books set price = 55000 where id = 2;

-- Ketty Sierra
update books set published_year = 2023 where id = 5;

-- Gang of Four 4th edition bolgon uurchluh
update books set title = 'Design Patter 4th Edition' where id = 3;

-- 
INSERT INTO books (title, author, price, published_year) VALUES
    ('Mark Heckler', 'Mark Heckler', 50000, 2021);

update books set title = 'Spring Boot Up & Running', price = 60000 where id = 6;

-- Delete data
delete from books where id = 2;
delete from books where id = 3;





