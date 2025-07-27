CREATE DATABASE VIEWS_SP;

USE VIEWS_SP;



CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    total_orders INT,
    status VARCHAR(20)
);

INSERT INTO customers (customer_id, name, total_orders, status) VALUES
(1, 'Alice Johnson', 3, 'active'),
(2, 'Bob Smith', 10, 'active'),
(3, 'Charlie Brown', 6, 'inactive'),
(4, 'Diana Prince', 7, 'active'),
(5, 'Eve Adams', 2, 'inactive');

CREATE VIEW top_customers AS
SELECT customer_id, name, total_orders, status FROM customers
WHERE status = 'active' AND total_orders > 5;


SELECT * FROM top_customers


CREATE INDEX idx_cust_name ON customers(name);


--CREATE INDEX idx_name_city ON users(name, city);

DROP INDEX idx_cust_name ON customers;


SHOW INDEX FROM customers;



CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DECIMAL(10, 2)
);

INSERT INTO employees (id, name, department, salary) VALUES
(1, 'Alice Johnson', 'HR', 50000.00),
(2, 'Bob Smith', 'IT', 70000.00),
(3, 'Charlie Brown', 'Finance', 65000.00),
(4, 'Diana Prince', 'IT', 80000.00),
(5, 'Eve Adams', 'Marketing', 60000.00);



SELECT name, salary
FROM employees
WHERE salary > (
    SELECT AVG(salary) FROM employees
);



SELECT department, COUNT(*) AS total_employees FROM employees
GROUP BY department;

SELECT department, AVG(salary) AS avg_salary FROM employees
GROUP BY department;

SELECT department, job_title, COUNT(*) AS count FROM employees
GROUP BY department, job_title;

CREATE TABLE employees_new (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    job_title VARCHAR(100),
    salary DECIMAL(10, 2)
);
INSERT INTO employees_new (id, name, department, job_title, salary) VALUES
(1, 'Alice Johnson', 'HR', 'HR Manager', 50000.00),
(2, 'Bob Smith', 'IT', 'Software Engineer', 70000.00),
(3, 'Charlie Brown', 'Finance', 'Accountant', 65000.00),
(4, 'Diana Prince', 'IT', 'Software Engineer', 80000.00),
(5, 'Eve Adams', 'Marketing', 'Marketing Executive', 60000.00),
(6, 'Frank White', 'HR', 'Recruiter', 52000.00),
(7, 'Grace Lee', 'IT', 'DevOps Engineer', 75000.00),
(8, 'Helen Fox', 'Marketing', 'Marketing Executive', 61000.00);

SELECT department, job_title, COUNT(*) AS count FROM employees_new
GROUP BY department, job_title;


SELECT department, COUNT(*) AS total FROM employees_new
GROUP BY department HAVING COUNT(*) > 1;



CREATE TABLE employees_new_2 (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DECIMAL(10, 2),
    status VARCHAR(20)  -- e.g., 'active' or 'inactive'
);

INSERT INTO employees_new_2 (id, name, department, salary, status) VALUES
(1, 'Alice Johnson', 'HR', 50000.00, 'active'),
(2, 'Bob Smith', 'IT', 70000.00, 'active'),
(3, 'Charlie Brown', 'Finance', 65000.00, 'inactive'),
(4, 'Diana Prince', 'IT', 80000.00, 'active'),
(5, 'Eve Adams', 'Marketing', 60000.00, 'active'),
(6, 'Frank White', 'HR', 52000.00, 'inactive'),
(7, 'Grace Lee', 'IT', 75000.00, 'inactive'),
(8, 'Helen Fox', 'Marketing', 61000.00, 'active');

SELECT department, AVG(salary) AS avg_salary FROM employees_new_2
WHERE status = 'active' GROUP BY department
HAVING AVG(salary) > 60000;



SELECT name, salary
FROM employees
WHERE salary > (
    SELECT AVG(salary) FROM employees
);

SELECT name, department, salary FROM employees e
WHERE salary > (
SELECT AVG(salary) FROM employees
WHERE department = e.department
);


DELIMITER //

CREATE PROCEDURE list_employees()
BEGIN
    SELECT * FROM employees;
END //

DELIMITER ;

CALL list_employees();

DELIMITER //
CREATE PROCEDURE get_employee_by_id(IN emp_id INT)
BEGIN
SELECT * FROM employees WHERE id = emp_id; END //
DELIMITER ;


CALL get_employee_by_id(3);

DROP PROCEDURE IF EXISTS get_employee_by_id;