
# SQL and Maven Notes:

## Database and Tables

```sql
DROP DATABASE IF EXISTS student_db;
CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

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

CREATE TABLE marks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    subject VARCHAR(30),
    score INT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

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
```

## Joins

```sql
SELECT students.name, marks.subject, marks.score
FROM students
INNER JOIN marks ON students.id = marks.student_id;

SELECT * FROM students
INNER JOIN marks ON students.id = marks.student_id;

SELECT * FROM students AS s, marks AS m WHERE s.id = m.student_id;

SELECT students.name, marks.subject, marks.score FROM students
LEFT JOIN marks ON students.id= marks.student_id;

SELECT students.name, marks.subject, marks.score FROM students
RIGHT JOIN marks ON students.id= marks.student_id;

SELECT students.name, marks.subject FROM students
CROSS JOIN marks;
```

## UNION

```sql
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

INSERT INTO customers (id, name, city) VALUES
(1, 'Alice', 'New York'),
(2, 'Bob', 'Los Angeles'),
(3, 'Charlie', 'Chicago'),
(4, 'David', 'Houston');

INSERT INTO vendors (id, name, city) VALUES
(101, 'VendorX', 'New York'),
(102, 'VendorY', 'San Francisco'),
(103, 'Alice', 'New York'),
(104, 'Eve', 'Houston');

SELECT name, city FROM customers
UNION
SELECT name, city FROM vendors;

SELECT name, city FROM customers
UNION
SELECT name FROM vendors; -- Error

SELECT name, city FROM customers
UNION
SELECT name, city FROM vendors
ORDER BY name ASC;
```

## CONCAT and Other SQL Functions

```sql
SELECT CONCAT('sathvika',' ','reddy');
SELECT NOW();
SELECT LENGTH('sathvika');
SELECT ROUND(12.9999999999999999999);
```

## Views

```sql
CREATE VIEW public_employees AS
SELECT name, department, salary FROM employees;

SELECT * FROM public_employees;

CREATE OR REPLACE VIEW public_employees AS 
SELECT name, department FROM employees;

DROP VIEW public_employees;

CREATE VIEW top_customers AS
SELECT customer_id, name, total_orders, status FROM customers
WHERE status = 'active' AND total_orders > 5;
```

## Indexes

```sql
SHOW INDEX FROM customers;
```

## Advanced Grouping

```sql
SELECT department, COUNT(*) AS total_employees FROM employees
GROUP BY department;

SELECT department, AVG(salary) AS avg_salary FROM employees
GROUP BY department;
```

## Stored Procedures

```sql
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
    SELECT * FROM employees WHERE id = emp_id;
END //
DELIMITER ;

CALL get_employee_by_id(3);
```

## Maven Intro:

**Maven is a Project Management Tool**, not just a build tool.

### Features
- Manages dependencies
- Provides standardized project structure
- Supports build lifecycle (compile, test, package, install, deploy)
- Plugin-based architecture

### Diagrammatic Flow

```text
+---------+            +---------+
|  Maven  |            |  Maven  |
| Project |            | Project |
+----+----+            +----+----+
     |                      |
     |        HTTP Request  |
     |--------------------->|
     |                      |
     | <--------------------- 
     |       Download        |
     v                      v
+-------------------------------+
|  repo.maven.apache.org       |
|  +------------------------+  |
|  |     Archetypes         |  |
|  |  [ ] [ ] [ ] [ ] [ ]   |  |
|  +------------------------+  |
+-------------------------------+
```

### Maven Lifecycle

1. **validate** – check the project structure
2. **compile** – compile the source code
3. **test** – test the compiled code using a unit testing framework
4. **package** – package the compiled code into a distributable format (e.g., JAR)
5. **verify** – run checks to verify package is valid
6. **install** – install the package to local repo
7. **deploy** – deploy to remote repo

