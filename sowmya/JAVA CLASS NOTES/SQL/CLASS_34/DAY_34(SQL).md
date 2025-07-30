

## 🔗 What is a Join?

A **Join** in SQL is used to combine data from two or more tables based on a related column between them.

> It helps fetch meaningful data that is spread across multiple tables.

### 🔹 Types of Joins:

1. **INNER JOIN** – Returns only the rows that have matching values in both tables.
2. **LEFT JOIN** – Returns all rows from the left table and matching rows from the right table. If no match, shows `NULL`.
3. **RIGHT JOIN** – Returns all rows from the right table and matching rows from the left. If no match, shows `NULL`.
4. **FULL JOIN** – Returns all rows from both tables. If there's no match, fills with `NULL`.
5. **CROSS JOIN** – Combines every row from the first table with every row from the second (Cartesian product).

---

## 🛠️ SQL Queries on Joins

```sql
CREATE DATABASE student_db_joins;
USE student_db_joins;

-- Create students table
CREATE TABLE students (
   id INT PRIMARY KEY,
   name VARCHAR(50),
   age INT
);

-- Insert students
INSERT INTO students (id, name, age) VALUES
(1, 'sowmya', 22),
(2, 'ramya', 30),
(3, 'Priya', 21),
(4, 'Sneha', 23),
(5, 'Rachana', 25),
(6, 'Anjali', 26),
(7, 'Vishnu', 21),
(8, 'Saritha', 25),
(9, 'Kavya', 24),
(10, 'Neha', 26),
(11, 'navya', 25),
(12, 'Laxmi', 30),
(13, 'pravalika', 24),
(14, 'Anusha', 26),
(15, 'manisha', 25);

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
(14, 'English', 72),
(NULL, 'Math', 92);

-- Sample inner Joins prints the common records
SELECT students.name, marks.subject, marks.score
FROM students
INNER JOIN marks ON students.id = marks.student_id;

-- Sample left Joins prints the common record and students records
SELECT students.name, marks.subject, marks.score
FROM students
LEFT JOIN marks ON students.id = marks.student_id;

-- Sample right Joins prints the common records and marks record

SELECT students.name, marks.subject, marks.score
FROM students
RIGHT JOIN marks ON students.id = marks.student_id;

-- Sample cross Joins prints the first column in both the records

SELECT students.name, marks.subject
FROM students
CROSS JOIN marks;
```

---

## 🔀 UNION, UNION ALL, CONCAT

### 🔸 `UNION`

Combines results of two `SELECT` queries and **removes duplicates**.

### 🔸 `UNION ALL`

Combines results of two `SELECT` queries and **includes duplicates**.

### 🔸 `CONCAT`

Joins multiple strings into one.

### 🧪 Example Queries

```sql
-- creating table on collegedb

CREATE TABLE CollegeDB (
   student_id INT,
   student_name VARCHAR(50),
   course VARCHAR(50)
);

-- creating table on studentsrecords

CREATE TABLE StudentRecords (
   student_id INT,
   student_name VARCHAR(50),
   course VARCHAR(50)
);

-- Insert values on collgedb and studentrecords
INSERT INTO CollegeDB VALUES
(1, 'sowmya', 'B.Tech'),
(2, 'Sneha', 'B.Sc'),
(3, 'Ramya', 'B.Com');

INSERT INTO StudentRecords VALUES
(2, 'Sneha', 'B.Sc'),
(4, 'navya', 'BCA'),
(5, 'pranavi', 'BBA');

-- UNION examples
SELECT * FROM CollegeDB
UNION
SELECT * FROM StudentRecords;

SELECT student_name FROM CollegeDB
UNION
SELECT student_name FROM StudentRecords;

SELECT course FROM CollegeDB
UNION
SELECT course FROM StudentRecords;

SELECT student_name, course FROM CollegeDB
UNION
SELECT student_name, course FROM StudentRecords;

-- UNION ALL examples
SELECT * FROM CollegeDB
UNION ALL
SELECT * FROM StudentRecords;

SELECT student_name FROM CollegeDB
UNION ALL
SELECT student_name FROM StudentRecords;

SELECT course FROM CollegeDB
UNION ALL
SELECT course FROM StudentRecords;

SELECT student_name, course FROM CollegeDB
UNION ALL
SELECT student_name, course FROM StudentRecords;

-- CONCAT examples
SELECT CONCAT('Hello', ' ', 'World') AS greeting;
SELECT CONCAT('HII',' ','HOW',' ','ARE',' ','YOU') AS WISHING;
```

---


# 📘 SQL Utility Functions

## 🛠️ Common SQL Utility Functions

1. **CONCAT** – Joins strings into one string.
2. **NOW()** – Gets current date and time.
3. **LENGTH()** – Returns string length.
4. **ROUND()** – Rounds a number to given decimals.
5. **DATEDIFF()** – Calculates difference between two dates.
6. **CHAR\_LENGTH()** – Number of characters in a string.
7. **LOWER()** – Converts text to lowercase.
8. **UPPER()** – Converts text to uppercase.
9. **REPLACE()** – Replaces part of a string.
10. **TRIM()** – Removes leading/trailing spaces.
11. **CURDATE()** – Current date.
12. **CURTIME()** – Current time.
13. **DATE()** – Extracts date from datetime.
14. **MONTHNAME()** – Name of the month.
15. **YEAR()** – Year value.
16. **DAY()** – Day of the date.
17. **CEIL()** – Rounds up to nearest whole number.
18. **ABS()** – Absolute value.
19. **MOD()** – Remainder of division.
20. **RAND()** – Random decimal between 0 and 1.
21. **IFNULL()** – Replaces NULL with default value.
22. **COALESCE()** – Returns first non-NULL value.
23. **COUNT()** – Number of rows.
24. **AVG()** – Average value.
25. **SUM()** – Total sum.
26. **MIN()** – Smallest value.
27. **MAX()** – Largest value.

---

## 🔍 Example SQL Queries

```sql
-- CONCAT: Combines strings
SELECT CONCAT('Hello', ' ', 'World') AS greeting;

-- LENGTH: Number of characters
SELECT LENGTH('sowmya') AS length;

-- CHAR_LENGTH: Number of characters
SELECT CHAR_LENGTH('i am learning mysql') AS charlength;

-- LOWER: Converts to lowercase
SELECT LOWER('MySQL') AS lower;

-- UPPER: Converts to uppercase
SELECT UPPER('MySQL') AS upper;

-- REPLACE: Replace characters
SELECT REPLACE('abc', 'b', 'x') AS replacing;

-- TRIM: Remove spaces
SELECT TRIM('  hii hello how are you  ') AS trimming;

-- NOW: Current date and time
SELECT NOW() AS currentdatetime;

-- CURDATE: Current date
SELECT CURDATE() AS currentdate;

-- CURTIME: Current time
SELECT CURTIME() AS currenttime;

-- DATE: Extract date from datetime
SELECT DATE(NOW()) AS currentdate;

-- MONTHNAME: Month name
SELECT MONTHNAME('2025-07-30') AS currentmonth;

-- YEAR: Current year
SELECT YEAR(NOW()) AS currentyear;

-- DAY: Day of the date
SELECT DAY('2025-07-30') AS currentday;

-- DATEDIFF: Days difference
SELECT DATEDIFF('2025-07-30', '2025-06-26') AS gap;

-- ROUND: Round to decimal places
SELECT ROUND(5.6776548, 3) AS roundvalue;

-- FLOOR: Round down
SELECT FLOOR(10.5) AS floorvalue;

-- CEIL: Round up
SELECT CEIL(55.91) AS ceilvalue;

-- ABS: Absolute value
SELECT ABS(-10) AS absolutevalue;

-- MOD: Remainder
SELECT MOD(30, 4) AS remainder;

-- RAND: Random value
SELECT RAND() AS randomvalue;

-- IFNULL: Replace NULL
SELECT IFNULL(NULL, 'mysql') AS defaultvalue;

-- COALESCE: First non-NULL
SELECT COALESCE(NULL, 'hii', 'Hello') AS coalescevalue;

-- COUNT: Count rows
SELECT COUNT(*) AS count;
```

---

## 📊 Aggregate Function Example

```sql
CREATE TABLE studentMarks (
  student_id INT,
  student_name VARCHAR(50),
  score INT
);

INSERT INTO studentMarks (student_id, student_name, score) VALUES
(1, 'sowmya', 85),
(2, 'Sneha', 90),
(3, 'navya', 78),
(4, 'laxmi', 92),
(5, 'pranavi', 88);

-- AVG: Average score
SELECT AVG(score) AS average_score FROM studentMarks;

-- SUM: Total score
SELECT SUM(score) AS total_score FROM studentMarks;

-- MIN: Minimum score
SELECT MIN(score) AS min_score FROM studentMarks;

-- MAX: Maximum score
SELECT MAX(score) AS max_score FROM studentMarks;
```

---




## 🔍 VIEWS

A **View** is a virtual table created from a `SELECT` query.
It shows data from real tables but does **not store** the data itself.

### ✅ Why Use Views?

* Simplify complex queries
* Hide sensitive columns
* Reuse logic (filters, joins)
* Present data in a specific format

---

## 📊 MySQL INDEXES

An **Index** in MySQL is a database object that helps **speed up data retrieval** by making searches faster.
It works like an index in a book — helping the database find rows quickly without scanning the whole table.

### ✅ Why Use Indexes?

1. Speed up `SELECT` queries
2. Improve performance on large tables
3. Note: Indexes take extra storage
4. Indexes may slow down `INSERT/UPDATE/DELETE` because they also need to be updated

### 🧱 Syntax

```sql
CREATE INDEX index_name
ON table_name (column_name);
```

---

## 🧩 Types of Indexes

### 1️⃣ Clustered Index

* Determines **physical order** of data in a table
* Only **one** clustered index per table allowed
* Data rows themselves are stored in the index
* Queries are faster due to order

📌 **Example:** Phone contacts ordered alphabetically – data physically follows the index.

### 2️⃣ Non-Clustered Index

* A separate structure storing column values and **pointers** to actual data
* Multiple non-clustered indexes allowed per table
* Data in the table is **not sorted** by this index

📌 **Example:** Back-of-book index pointing to page numbers

### 🔄 Difference Table

| Feature    | Clustered Index      | Non-Clustered Index         |
| ---------- | -------------------- | --------------------------- |
| Data Order | Physically ordered   | Not physically ordered      |
| Count      | One per table        | Multiple allowed            |
| Structure  | Data stored in index | Index with pointers to rows |
| Speed      | Faster               | Slower than clustered       |

---

## 💡 Example: Clustered vs Non-Clustered Index

### Clustered Index on `EmpID`

```text
+--------+----------+---------+
| EmpID  | Name     | Salary  |
+--------+----------+---------+
| 101    | sowmya   | 50000   |
| 102    | ramya    | 60000   |
| 103    | laxmi    | 70000   |
+--------+----------+---------+
```

Data is **physically sorted** by `EmpID`

### Non-Clustered Index on `Salary`

```text
[50000] --> Points to row with EmpID 101
[60000] --> Points to row with EmpID 102
[70000] --> Points to row with EmpID 103
```

Data is **not sorted** by Salary. Index helps lookup.

---

## 🧪 SQL Queries: Views and Indexes

```sql
-- Create database and use it
CREATE DATABASE VIEWS_SP;
USE VIEWS_SP;

-- Create a sample table
CREATE TABLE customers (
   customer_id INT PRIMARY KEY,  -- Clustered index
   name VARCHAR(100),
   total_orders INT,
   status VARCHAR(20)
);

-- Insert data
INSERT INTO customers (customer_id, name, total_orders, status) VALUES
(1, 'sowmya', 3, 'active'),
(2, 'navya', 10, 'inactive'),
(3, 'sneha', 6, 'active'),
(4, 'ramya', 7, 'active'),
(5, 'pinky', 2, 'inactive');

-- Query using clustered index (by default on primary key)
SELECT * FROM customers;

-- Create a view
CREATE VIEW top_customers AS
SELECT customer_id, name, total_orders, status FROM customers
WHERE status = 'active' AND total_orders > 5;

-- Query the view
SELECT * FROM top_customers;

-- Create a single-column index (non-clustered)
CREATE INDEX idx_cust_name ON customers(name);

-- Create a multi-column index
CREATE INDEX idx_orders_status ON customers (total_orders, status);

-- Drop an index
DROP INDEX idx_cust_name ON customers;

-- Show indexes
SHOW INDEX FROM customers;

-- Add a primary key later to create clustered index
ALTER TABLE customers
ADD PRIMARY KEY (customer_id);
```

---


## 🔍 What is a Subquery?

A **subquery** is a query nested inside another SQL query. It is used to return data that will be used in the main (outer) query.

📌 Also called a **nested query** or **inner query**.

### ✅ Where Can You Use Subqueries?

* In the `WHERE` clause
* In the `FROM` clause
* In the `SELECT` clause

### 🔧 Syntax

```sql
SELECT column_name
FROM table_name
WHERE column_name = (SELECT column_name FROM table_name);
```

### 📌 How it Works:

The **inner query** runs **first**, and its result is passed to the **outer query**.

---

## 🧠 Correlated Subqueries

A **correlated subquery** is a subquery that refers to columns from the outer query. It is executed **once for each row** of the outer query.

### 🔄 Use Case

Used when filtering rows based on calculations that involve the current row of the outer query.

---

# 📘 SQL Queries: Subquery and Correlated Subquery – GitHub Markdown

## 🧪 Table Setup

```sql
CREATE TABLE employees (
   id INT PRIMARY KEY,
   name VARCHAR(100),
   department VARCHAR(100),
   salary DECIMAL(10, 2)
);

INSERT INTO employees (id, name, department, salary) VALUES
(1, 'sowmya', 'HR', 50000.00),
(2, 'ramya', 'IT', 50000.00),
(3, 'Chinni', 'Finance', 75000.00),
(4, 'pinky', 'IT', 50000.00),
(5, 'pranavi', 'Marketing', 90000.00);



## 🔍 Subqueries

-- Employees with salary above average


SELECT name, salary
FROM employees
WHERE salary > (
   SELECT AVG(salary) FROM employees
);

-- Employees in HR department whose name exists in the employee list


SELECT * FROM employees
WHERE department = 'HR'
  AND name IN (SELECT name FROM employees);


-- Employees working in departments where salary is 50000

SELECT name, department
FROM employees
WHERE department IN (
   SELECT department FROM employees WHERE salary = 50000
);


-- Show employee name along with the highest salary in the company


SELECT name, salary,
   (SELECT MAX(salary) FROM employees) AS max_salary
FROM employees;

-- Average salary by department (using subquery as derived table)


SELECT dept_avg.department, dept_avg.avg_salary
FROM (
   SELECT department, AVG(salary) AS avg_salary
   FROM employees
   GROUP BY department
) AS dept_avg;

---

## 🔄 Correlated Subqueries
-- Employees in IT with salary > department average
SELECT name, department, salary
FROM employees e
WHERE department = 'IT'
  AND salary > (
     SELECT AVG(salary)
     FROM employees
     WHERE department = e.department
);


-- Departments with more than one employee
SELECT DISTINCT department
FROM employees e1
WHERE EXISTS (
   SELECT 1
   FROM employees e2
   WHERE e1.department = e2.department
     AND e1.id <> e2.id
);
```

---


## 📘 What is a Stored Procedure?

A **Stored Procedure** is a group of SQL statements saved in the database, which you can run repeatedly by calling its name.

### ✅ Simple Definition:

* Like a function in SQL
* Created once and reused multiple times
* Useful for tasks like inserting, updating, deleting, and calculations

---

## 🧾 Syntax

```sql
DELIMITER //
CREATE PROCEDURE procedure_name()
BEGIN
    -- SQL statements here
END //
DELIMITER ;
```

---

## 🧪 Examples

### 1️⃣ Create a Stored Procedure to List All Employees

```sql
DELIMITER //
CREATE PROCEDURE list_employees()
BEGIN
    SELECT * FROM employees;
END //
DELIMITER ;

-- Call the stored procedure
CALL list_employees();
```

### 2️⃣ Create a Stored Procedure to Get Employee by ID

```sql
DELIMITER //
CREATE PROCEDURE get_employee_by_id(IN emp_id INT)
BEGIN
    SELECT * FROM employees WHERE id = emp_id;
END //
DELIMITER ;

-- Call the stored procedure
CALL get_employee_by_id(3);
```

### 3️⃣ Drop a Stored Procedure

```sql
DROP PROCEDURE IF EXISTS get_employee_by_id;
```

---

