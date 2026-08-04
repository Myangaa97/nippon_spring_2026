create database school;

create table students (
	id serial primary key,
	name varchar(100) not null,
	email varchar(100) unique not null,
	enrolled_at date default current_date
);

CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    credits INT not null check (credits > 0)
);

CREATE TABLE enrollments (
    student_id INT REFERENCES students(id) on delete cascade,
    course_id INT REFERENCES courses(id) on delete cascade,
    grade numeric(3, 1),
    primary key (student_id, course_id)
);

INSERT INTO students (name, email) VALUES
('Bat-Erdene', 'bat@example.com'),
('Sarnai', 'sarnai@example.com'),
('Temuulen', 'temuulen@example.com'),
('Anu', 'anu@example.com');

INSERT INTO courses (title, credits) VALUES
('Databases', 3),
('Web Development', 4),
('Algorithms', 3);

INSERT INTO enrollments (student_id, course_id, grade) VALUES
(1, 1, 3.7), (1, 2, 3.3),
(2, 1, 4.0), (2, 3, 3.9),
(3, 2, 2.8),
(4, 1, 3.5), (4, 2, 3.8), (4, 3, 3.0);

