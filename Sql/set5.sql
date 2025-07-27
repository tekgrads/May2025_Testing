-- Drop and create the database
DROP DATABASE IF EXISTS student_db_joins;
CREATE DATABASE student_db_joins;
USE student_db_joins;

-- Create students table
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

-- Insert students
INSERT INTO students (id, name) VALUES
(1, 'Rohan'),
(2, 'Aakash'),
(3, 'Priya'),
(4, 'Sneha'),
(5, 'Rahul'),
(6, 'Anjali'),
(7, 'Vikram'),
(8, 'Simran'),
(9, 'Karan'),
(10, 'Neha'),
(11, 'Harry'),
(12, 'Lakshayraj Dash'),
(13, 'Ishita'),
(14, 'Amit'),
(15, 'Meena');

-- Create marks table
CREATE TABLE marks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    subject VARCHAR(30),
    score INT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- Insert marks
INSERT INTO marks (student_id, subject, score) VALUES
(1, 'Math', 92),
(1, 'Science', 88),
(2, 'Math', 81),
(2, 'English', 79),
(3, 'Math', 75),
(3, 'Science', 73),
(4, 'Science', 85),
(5, 'English', 78),
(5, 'Math', 80),
(6, 'Science', 66),
(6, 'English', 68),
(7, 'Math', 55),
(8, 'English', 74),
(10, 'Science', 89),
(10, 'Math', 83),
(12, 'Math', 77),
(12, 'Science', 79),
(13, 'English', 60),
(14, 'Science', 69),
(14, 'English', 72);

INSERT INTO marks (student_id, subject, score) VALUES
(NULL, 'Math', 92);

-- Note: Students 9 (Karan), 11 (Harry), and 15 (Meena) have NO marks.


select * from students;

select * from marks;

SELECT students.name, marks.subject, marks.score FROM students
INNER JOIN marks ON students.id = marks.student_id;


select * from students as s, marks as m where s.id=m.student_id; -- not recommended


SELECT students.name, marks.subject, marks.score FROM students
LEFT JOIN marks ON students.id = marks.student_id;


SELECT students.name, marks.subject, marks.score FROM students
RIGHT JOIN marks ON students.id = marks.student_id;

SELECT students.name, marks.subject FROM students
CROSS JOIN marks;



CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100)
);

CREATE TABLE vendors (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100)
);


-- Insert into customers
INSERT INTO customers (id, name, city) VALUES
(1, 'Alice', 'New York'),
(2, 'Bob', 'Los Angeles'),
(3, 'Charlie', 'Chicago'),
(4, 'David', 'Houston');

-- Insert into vendors
INSERT INTO vendors (id, name, city) VALUES
(101, 'VendorX', 'New York'),
(102, 'VendorY', 'San Francisco'),
(103, 'Alice', 'New York'),  -- Duplicate to test UNION (distinct behavior)
(104, 'Eve', 'Houston');


SELECT name, city FROM customers 
UNION
SELECT name, city FROM vendors;

SELECT name, city FROM customers
UNION
SELECT name FROM vendors;

SELECT age FROM users
UNION
SELECT name FROM students;

SELECT name, city FROM customers 
UNION ALL
SELECT name, city FROM vendors;

SELECT name, city FROM customers 
UNION 
SELECT name, city FROM vendors 
ORDER BY NAME ASC;

SELECT CONCAT('Hello', ' ', 'World') AS greeting;

CREATE TABLE users (
    id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);

INSERT INTO users (id, first_name, last_name) VALUES
(1, 'Alice', 'Johnson'),
(2, 'Bob', 'Smith'),
(3, 'Charlie', 'Brown'),
(4, 'Diana', 'Prince');

SELECT CONCAT(first_name, ' ', last_name) AS full_name
FROM users;

SELECT NOW();

SELECT LENGTH('Harry');

SELECT ROUND(12.6789, 2);
-- Output: 12.68

SELECT DATEDIFF('2025-06-01', '2025-05-01');


CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DECIMAL(10, 2)
);

INSERT INTO employees (id, name, department, salary) VALUES
(1, 'Alice Johnson', 'HR', 55000.00),
(2, 'Bob Smith', 'IT', 75000.00),
(3, 'Charlie Brown', 'Finance', 68000.00),
(4, 'Diana Prince', 'IT', 80000.00);

CREATE VIEW public_employees AS
SELECT name, department, salary
FROM employees;


SELECT * FROM public_employees;

CREATE OR REPLACE VIEW public_employees AS SELECT name, department
FROM employees;


DROP VIEW public_employees;


SELECT customer_id, name, total_orders, status FROM customers
WHERE status = 'active' AND total_orders > 5;



