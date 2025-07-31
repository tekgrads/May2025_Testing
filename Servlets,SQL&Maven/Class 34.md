# Class 34: (27/07/2025)

## JOINS

### How to get data from two tables?
- We use **JOINS**.

### 1. INNER JOIN
Joins two tables and returns only matching rows.

```sql
SELECT students.name, marks.subject, marks.score 
FROM students
INNER JOIN marks ON students.id = marks.student_id;

-- Not recommended:
SELECT * 
FROM students AS s, marks AS m 
WHERE s.id = m.student_id;
```

### 2. LEFT JOIN
Includes all rows from the left table (`students`), even if there's no match in `marks`.

```sql
SELECT students.name, marks.subject, marks.score 
FROM students
LEFT JOIN marks ON students.id = marks.student_id;
```

### 3. RIGHT JOIN
Includes all rows from the right table (`marks`), even if there's no match in `students`.

```sql
SELECT students.name, marks.subject, marks.score 
FROM students
RIGHT JOIN marks ON students.id = marks.student_id;
```

### 4. CROSS JOIN
Returns the Cartesian product of two tables.

```sql
SELECT students.name, marks.subject 
FROM students
CROSS JOIN marks;
```

### Key Differences

| Type       | Description                                      |
|------------|--------------------------------------------------|
| INNER JOIN | Only rows with match in both tables              |
| LEFT JOIN  | All rows from left, matched or not               |
| RIGHT JOIN | All rows from right, matched or not              |
| CROSS JOIN | All combinations from both tables                |

---

## UNION

Used to combine result sets of 2 or more `SELECT` statements.

### Requirements:
1. Same number of columns.
2. Compatible data types.
3. Matched by position.

### Example:

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

INSERT INTO customers VALUES
(1, 'Alice', 'New York'),
(2, 'Bob', 'Los Angeles'),
(3, 'Charlie', 'Chicago'),
(4, 'David', 'Houston');

INSERT INTO vendors VALUES
(101, 'VendorX', 'New York'),
(102, 'VendorY', 'San Francisco'),
(103, 'Alice', 'New York'),
(104, 'Eve', 'Houston');
```

```sql
SELECT name, city FROM customers 
UNION
SELECT name, city FROM vendors;

-- Incorrect: mismatched columns
-- SELECT name, city FROM customers UNION SELECT name FROM vendors;

-- Use UNION ALL for duplicates
SELECT name, city FROM customers 
UNION ALL
SELECT name, city FROM vendors;

-- Sorted result
SELECT name, city FROM customers 
UNION 
SELECT name, city FROM vendors 
ORDER BY name ASC;
```

---

## String & Date Functions

| Function       | Description                     | Example                          |
|----------------|---------------------------------|----------------------------------|
| CONCAT()       | Combine strings                 | `CONCAT('A', 'B') → 'AB'`        |
| LENGTH()       | Length in bytes                 | `LENGTH('Hi') → 2`               |
| CHAR_LENGTH()  | Length in characters            | `CHAR_LENGTH('िहिंदी') → 5`     |
| LOWER()        | Lowercase                      | `LOWER('MySQL') → mysql`         |
| UPPER()        | Uppercase                      | `UPPER('hello') → HELLO`         |
| REPLACE()      | Replace substring               | `REPLACE('abc', 'b', 'x') → axc` |
| TRIM()         | Trim whitespace                 | `TRIM(' hello ') → hello`        |
| NOW()          | Current date & time             | `NOW()`                          |
| CURDATE()      | Current date                    | `CURDATE()`                      |
| CURTIME()      | Current time                    | `CURTIME()`                      |
| DATE()         | Extract date from datetime      | `DATE(NOW())`                    |
| MONTHNAME()    | Get month name                  | `MONTHNAME('2025-05-03') → May`  |
| YEAR()         | Get year                        | `YEAR(NOW())`                    |
| DAY()          | Get day of month                | `DAY('2025-05-03') → 3`          |
| DATEDIFF()     | Difference in days              | `DATEDIFF('2025-06-01', '2025-05-01')` |
| ROUND()        | Round to decimals               | `ROUND(5.678, 2) → 5.68`         |
| FLOOR()        | Round down                      | `FLOOR(5.9) → 5`                 |
| CEIL()         | Round up                        | `CEIL(5.1) → 6`                  |
| ABS()          | Absolute value                  | `ABS(-10) → 10`                  |
| MOD()          | Modulus                         | `MOD(10, 3) → 1`                 |
| RAND()         | Random value (0 to 1)           | `RAND()`                         |
| IFNULL()       | Replace NULL                    | `IFNULL(NULL, 'N/A') → N/A`      |
| COALESCE()     | First non-null                  | `COALESCE(NULL, '', 'Hello') → ''` |
| COUNT(), AVG(), SUM(), MIN(), MAX() | Aggregate functions | |

---

## VIEWS

- A **View** is a virtual table created using `SELECT`.
- Does not store data, just a saved query.

**Uses**:
- Simplify complex queries
- Hide sensitive data
- Reuse logic

---

## INDEXES

Helps speed up SELECT queries by allowing faster search.

### Why Use?
- Faster data retrieval
- Efficient for large datasets

### Downsides:
- Extra storage
- Slower INSERT/UPDATE/DELETE

### Syntax:
```sql
CREATE INDEX index_name ON table_name(column_name);
```

---

### Types of Indexes

| Feature         | Clustered Index              | Non-Clustered Index                |
|-----------------|------------------------------|------------------------------------|
| Data Order      | Physically ordered            | Not physically ordered             |
| Count           | One per table                 | Multiple allowed                   |
| Structure       | Data stored in index          | Index with pointers to rows        |
| Speed           | Faster                        | Slower                             |

---

## GROUP BY & HAVING

```sql
CREATE TABLE employees (
   id INT PRIMARY KEY,
   name VARCHAR(100),
   department VARCHAR(100),
   salary DECIMAL(10, 2)
);

INSERT INTO employees VALUES
(1, 'sowmya', 'HR', 50000.00),
(2, 'ramya', 'IT', 50000.00),
(3, 'Chinni', 'Finance', 75000.00),
(4, 'pinky', 'IT', 50000.00),
(5, 'pranavi', 'Marketing', 90000.00);

-- GROUP BY examples
SELECT department, COUNT(*) AS total_employees FROM employees GROUP BY department;
SELECT department, AVG(salary) AS avg_salary FROM employees GROUP BY department;
SELECT department, salary, COUNT(*) FROM employees GROUP BY department, salary;
```

### WHERE vs HAVING

| Feature   | WHERE                          | HAVING                              |
|-----------|--------------------------------|--------------------------------------|
| Purpose   | Filters rows before grouping   | Filters groups after grouping        |
| Works On  | Columns                        | Aggregated values                    |

---

## Advanced GROUP BY Example

```sql
CREATE TABLE employees_new_2 (
   id INT PRIMARY KEY,
   name VARCHAR(100),
   department VARCHAR(100),
   salary DECIMAL(10, 2),
   status VARCHAR(20)
);

INSERT INTO employees_new_2 VALUES
(1, 'sowmya', 'HR', 50000.00, 'active'),
(2, 'navya', 'IT', 70000.00, 'active'),
(3, 'sneha', 'Finance', 65000.00, 'inactive'),
(4, 'pinky', 'IT', 80000.00, 'active'),
(5, 'chinni', 'Marketing', 60000.00, 'active'),
(6, 'kavitha', 'HR', 52000.00, 'inactive'),
(7, 'laxmi', 'IT', 75000.00, 'inactive'),
(8, 'pranavi', 'Marketing', 61000.00, 'active');

SELECT department, AVG(salary) AS avg_salary
FROM employees_new_2
WHERE status = 'active'
GROUP BY department
HAVING AVG(salary) > 60000;
```

---

## SUBQUERIES

```sql
-- Simple Subquery
SELECT name, salary
FROM employees
WHERE salary > (
    SELECT AVG(salary) FROM employees
);

-- Correlated Subquery
SELECT name, department, salary
FROM employees e
WHERE department = 'IT'
  AND salary > (
     SELECT AVG(salary)
     FROM employees
     WHERE department = e.department
);
```

### When to Avoid Subqueries
- When JOINs can be used instead
- When subquery runs for every row (correlated)

---

## DELIMITER in Stored Procedures

MySQL uses `;` to end statements. Stored procedures contain multiple `;`, so we use `DELIMITER` to avoid early termination.

```sql
DELIMITER //

CREATE PROCEDURE list_employees()
BEGIN
    SELECT * FROM employees;
END //

DELIMITER ;

CALL list_employees();

-- Procedure with parameter
DELIMITER //

CREATE PROCEDURE get_employee_by_id(IN emp_id INT)
BEGIN
    SELECT * FROM employees WHERE id = emp_id;
END //

DELIMITER ;

CALL get_employee_by_id(3);

-- Drop procedure
DROP PROCEDURE IF EXISTS get_employee_by_id;
```
