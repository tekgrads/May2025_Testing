CREATE DATABASE student_db;

SHOW DATABASES;

USE student_db;


CREATE TABLE students (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL DEFAULT 'No Name',
age INT,
email VARCHAR(100) UNIQUE,
admission_date DATE
);

SHOW TABLES;

DESCRIBE students;

SELECT * FROM students;

ALTER TABLE students DROP COLUMN admission_date;

RENAME TABLE students_test TO students;

DROP TABLE students;

ALTER TABLE students ADD COLUMN admission_date DATE;

ALTER TABLE students RENAME COLUMN name TO student_name;

ALTER TABLE students RENAME COLUMN student_name TO name;

ALTER TABLE students ADD COLUMN gender VARCHAR(10);

ALTER TABLE students MODIFY COLUMN name VARCHAR(150) NOT NULL;

ALTER TABLE students MODIFY COLUMN gender VARCHAR(10) AFTER email;


