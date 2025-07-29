# 📘 Database and SQL Markdown Guide for GitHub

## 🗃️ What is a Database (DB)?

A **Database** is an organized collection of structured information or data, typically stored electronically in a computer system.

> 💡 **Real-world example:** Clothes stored in an organized manner at home.

We need databases to:

* Store, manage, and retrieve large amounts of data
* Prevent data duplication
* Allow multiple users to access data

---

## ⚙️ DBMS (Database Management System)

A **DBMS** is software that helps manage data stored in databases. It allows:

* CRUD operations: Create, Read, Update, Delete
* Structured table format: rows (records) and columns (fields)
* Ensures data security, consistency, and integrity

Popular DBMS examples: `MySQL`, `Oracle`, `PostgreSQL`

---

## 🧾 Tables

Data is stored in **tables**:

```
+------+--------+--------+------+
| eid  | ename  |  sal   | d_id |
+------+--------+--------+------+
| ...  |  ...   |  ...   | ...  |
+------+--------+--------+------+
```

* Each **row** represents a record
* Each **column** represents an attribute

---

## 💻 What is SQL?

**SQL (Structured Query Language)** is used to manage and manipulate data in relational databases like MySQL.

### Basic CRUD Operations in SQL

* **Create** → `INSERT`
* **Read** → `SELECT`
* **Update** → `UPDATE`
* **Delete** → `DELETE`

#### Examples:

```sql
-- INSERT
INSERT INTO table_name (column1, column2) VALUES (value1, value2);

-- SELECT
SELECT * FROM table_name;

-- UPDATE
UPDATE table_name SET column1 = value1 WHERE condition;

-- DELETE
DELETE FROM table_name WHERE condition;
```

---

## 🧮 RDBMS (Relational Database Management System)

Stores data in **tables** using SQL.

### Features:

* Structured data, schema-based
* Supports relationships using primary/foreign keys
* Follows **ACID** properties
* Highly available and scalable

---

## 🔐 ACID Properties

* **A - Atomicity:** All-or-nothing transactions
* **C - Consistency:** Data remains valid before and after
* **I - Isolation:** Transactions don't interfere
* **D - Durability:** Data persists after commit

---

## 📦 NoSQL (Non-Relational DBs)

Stores data in key-value, document, graph, or column formats.

### Features:

* Schema-less (flexible structure)
* Scales horizontally
* Best for unstructured data (e.g., JSON)
* Follows **BASE** principles

### BASE:

* **Basically Available**
* **Soft State**
* **Eventually Consistent**

NoSQL Examples: `MongoDB`, `Cassandra`, `Firebase`

---

## 🔁 ACID vs BASE

| Feature      | **ACID**             | **BASE**                     |
| ------------ | -------------------- | ---------------------------- |
| Used In      | RDBMS (SQL)          | NoSQL                        |
| Consistency  | Strong (Immediate)   | Eventual                     |
| Availability | Lower                | High                         |
| Reliability  | High (e.g., Banking) | Moderate (e.g., Social Apps) |
| Scalability  | Vertical (Scale-up)  | Horizontal (Scale-out)       |
| Performance  | Slower (safe)        | Faster (real-time)           |
| Example DBs  | MySQL, PostgreSQL    | MongoDB, Cassandra           |

---

## 🔑 Keys in SQL

### Primary Key

* Uniquely identifies each row
* One per table, cannot be NULL

### Foreign Key

* Links one table to another
* Maintains referential integrity

### Unique Key

* Ensures unique values
* Allows NULL (once)

---

## 🐬 MySQL Overview

* Open-source RDBMS using SQL
* Used in web development
* High performance and scalable

Used in: Banking, E-Commerce, Social Media


## 🔐 Common Constraints

| Constraint      | Description                                |
| --------------- | ------------------------------------------ |
| PRIMARY KEY     | Uniquely identifies each record            |
| NOT NULL        | Ensures column cannot be empty             |
| UNIQUE          | All values in the column must be different |
| AUTO\_INCREMENT | Automatically increases the numeric value  |
| DEFAULT         | Sets a default value for the column        |
| FOREIGN KEY     | Creates a relationship between two tables  |

---

## 🛠️ Creating a Table in the Database

```sql
-- Create and use the database
CREATE DATABASE student_db;
SHOW DATABASES;
USE student_db;

-- Create the table
CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL DEFAULT 'No Name',
  age INT,
  email VARCHAR(100) UNIQUE,
  course VARCHAR(50),
  admission_date DATE
);
```

---

## 📋 Table Operations

### 📄 View All Tables
*it will show all the tables.

```sql
SHOW TABLES;
```

### 🧱 View Table Structure
*it will shows the structre of the table

```sql
*DESCRIBE student;
```

### 📊 View Table Data
*it will shows the data on the table.

```sql
SELECT * FROM student;
```

### ✏️ Rename a Table
*it will gives the new name for the old table name


```sql
RENAME TABLE old_tablename TO new_tablename;
```

### ❌ Drop a Table
*it will deletes the table and its data permenentaly


```sql
DROP TABLE tablename;
```

---

## ✏️ Alter Table

### 📝 Rename a Column
*To rename a column in an existing table


```sql
*ALTER TABLE tablename RENAME COLUMN old_column_name TO new_column_name;
```

### ❌ Drop a Column
*It is used for dropping a cloumn on the table

```sql
ALTER TABLE tablename DROP COLUMN column_name;
```

### ➕ Add a Column
*it will adds the new cloumn

```sql
ALTER TABLE tablename ADD COLUMN column_name datatype constraints;
```

### 🔄 Modify a Column
*it will modifies the column data type

```sql
ALTER TABLE tablename MODIFY COLUMN column_name new_datatype new_constraints;
```

### ↕️ Change Column Order
*it is used to change the order of columns in a table

```sql
ALTER TABLE tablename MODIFY COLUMN column_name datatype AFTER another_column;
```

---

## 🧪 Example SQL Snippets

```sql
-- View all tables
SHOW TABLES;

-- View structure of the student table
DESCRIBE student;

-- View data from the student table
SELECT * FROM student;

-- Rename a table
RENAME TABLE student TO student_info;
RENAME TABLE student_info TO student;

-- Drop the student table
DROP TABLE student;

-- Rename a column
ALTER TABLE student RENAME COLUMN name TO studentname;

-- Drop a column
ALTER TABLE student DROP COLUMN course;

-- Add a new column
ALTER TABLE student ADD COLUMN course VARCHAR(100);

-- Modify a column
ALTER TABLE student MODIFY COLUMN studentname VARCHAR(150) NOT NULL;

-- Change column order
ALTER TABLE student MODIFY COLUMN age VARCHAR(10) AFTER course;

-- View updated data
SELECT * FROM student;
```

---





## 🛠️ 1. Creating a New Database

```sql
CREATE DATABASE databasename;
```

---

## 📂 2. Selecting the Database

```sql
USE databasename;
```

---

## 🧱 3. Creating the Table

```sql
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    salary INT,
    dept VARCHAR(20),
    joining_date DATE
);
```

📝 `id`, `name`, `age`, `salary`, `dept`, and `joining_date` are columns with specific data types representing employee details.

---

## ➕ 4. Inserting Data into the Table

```sql
INSERT INTO Employee (id, name, age, salary, dept, joining_date) VALUES
(1, 'Sowmya', 30, 50000, 'HR', '2021-06-15'),
(2, 'Namya', 28, 60000, 'Finance', '2022-01-10'),
(3, 'Sneha', 35, 75000, 'IT', '2020-09-20'),
(4, 'Kavitha', 40, 80000, 'Sales', '2019-04-05'),
(5, 'Swetha', 27, 55000, 'IT', '2023-03-25');
```

---

## 🔍 5. Basic SELECT Queries

Retrieve all data:

```sql
SELECT * FROM Employee;
```

Select specific columns:

```sql
SELECT name, salary FROM Employee;
```

With condition:

```sql
SELECT name, dept FROM Employee WHERE dept = 'IT';
```

---

## ❔ 6. Checking for NULL Values

```sql
SELECT * FROM Employee WHERE salary IS NULL;
```

---

## 🚫 7. Checking for NOT NULL Values

```sql
SELECT * FROM Employee WHERE dept IS NOT NULL;
```

---


## 8. 🔗 AND and OR Conditions

### ✅ AND

Both conditions must be satisfied.

```sql
SELECT * FROM student WHERE condition1 AND condition2;
```

### ✅ OR

At least one condition must be satisfied.

```sql
SELECT * FROM student WHERE condition1 OR condition2;
```

### ✅ Combining AND & OR

You can use both for complex queries.

---

## 🔁 Comparison Operators

| Operator | Description                | Example                                            |
| -------- | -------------------------- | -------------------------------------------------- |
| =        | Equals                     | `WHERE age = 16`                                   |
| !=       | Not equal to               | `WHERE grade != '12th'`                            |
| <>       | Not equal to (alternative) | `WHERE grade <> '12th'`                            |
| >        | Greater than               | `WHERE age > 16`                                   |
| <        | Less than                  | `WHERE age < 17`                                   |
| >=       | Greater than or equal to   | `WHERE age >= 16`                                  |
| <=       | Less than or equal to      | `WHERE age <= 18`                                  |
| BETWEEN  | Within a range (inclusive) | `WHERE age BETWEEN 15 AND 17`                      |
| IN       | Matches any in a list      | `WHERE grade IN ('10th', '12th')`                  |
| NOT IN   | Excludes list items        | `WHERE grade NOT IN ('9th', '11th')`               |
| LIKE     | Pattern matching           | `WHERE name LIKE 'A%'` (names starting with A)     |
| NOT LIKE | Pattern not matching       | `WHERE name NOT LIKE '%a'` (names not ending in a) |

---

## 9. 🔼 ASC – Ascending Order

Used with `ORDER BY` to sort in ascending order.

```sql
SELECT * FROM student ORDER BY column1 ASC;
```

---

## 10. 🔽 DESC – Descending Order

Used with `ORDER BY` to sort in descending order.

```sql
SELECT * FROM student ORDER BY column1 DESC;
```

---

## 11. 🔢 LIMIT – Limit Number of Rows

Controls how many rows are returned.

```sql
SELECT * FROM tablename LIMIT 5;
```

Return only first 5 rows.

```sql
SELECT * FROM tablename LIMIT 2,6;
```

Skip first 2 rows and return next 6 rows (from row 3 to row 8).

---

## 12. ✏️ UPDATE – Modify Data

Used to update existing records.

```sql
UPDATE table_name
SET column1 = value1, column2 = value2
WHERE condition;
```

---

## 13. 🗑️ DELETE – Remove Data

Used to delete rows from a table.

```sql
DELETE FROM table_name
WHERE condition;
```

---


# 📘 Employee Database Creation and SQL Queries

```sql
-- creating a database
CREATE DATABASE Employeedb;

-- select the database
USE Employeedb;

-- creating the table 
CREATE TABLE Employee ( 
    id INT PRIMARY KEY, 
    name VARCHAR(100),
    age INT,
    salary INT,
    dept VARCHAR(20),
    joining_date DATE
);

-- inserting the values
INSERT INTO Employee (id, name, age, salary, dept, joining_date) VALUES
(1, 'sowmya', 30, 50000, 'HR', '2021-06-15'),
(2, 'navya', 28, 60000, 'Finance', '2022-01-10'),
(3, 'sneha', 35, 75000, 'IT', '2020-09-20'),
(4, 'kavitha', 40, 80000, 'Sales', '2019-04-05'),
(5, 'swetha', 27, 55000, 'IT', '2023-03-25'),
(6, 'pranavi', 32, 70000, 'Marketing', '2021-11-18'),
(7, 'laxmi', 29, 62000, 'HR', '2022-05-10'),
(8, 'aadvika', 26, 48000, 'Finance', '2023-01-01'),
(9, 'pooja', 38, 82000, 'IT', '2018-07-21'),
(10, 'sam', 31, 56000, 'Sales', '2020-10-12'),
(11, 'ruchitha', 34, 74000, 'Finance', '2019-03-17'),
(12, 'sathvika', 25, 47000, 'HR', '2023-06-22'),
(13, 'anusha', 37, 90000, 'IT', '2017-12-30'),
(14, 'bhargavi', 33, 66000, 'Marketing', '2020-08-05'),
(15, 'prashanthi', 36, 88000, 'Finance', '2018-02-14'),
(16, 'rinky', 29, 54000, 'Sales', '2021-09-27'),
(17, 'pinky', 41, 95000, 'IT', '2016-11-11'),
(18, 'rachana', 24, 46000, 'HR', '2023-04-03'),
(19, 'preethi', 30, 60000, 'Marketing', '2022-12-09'),
(20, 'pallavi', 28, 58000, 'Sales', '2021-07-19');

-- showing the table
SELECT * FROM Employee;

-- selecting certain columns
SELECT name, salary FROM Employee;

-- conditions
SELECT name, salary FROM Employee WHERE salary > 50000;
SELECT * FROM Employee WHERE dept = 'HR';
SELECT * FROM Employee WHERE age > 30;
SELECT name FROM Employee WHERE joining_date = '2018-07-21';

-- checking for NULL values
SELECT * FROM Employee;
SELECT * FROM Employee WHERE dept IS NULL;

-- AND condition
SELECT * FROM Employee WHERE dept = 'HR' AND age > 20;

-- OR condition
SELECT * FROM Employee WHERE dept = 'HR' OR age < 20;

-- AND and OR combined
SELECT * FROM Employee
WHERE (salary > 20000 OR salary > 70000) AND age >= 30;

-- comparison operators
SELECT * FROM Employee WHERE age = 30;
SELECT * FROM Employee WHERE age != 30;
SELECT * FROM Employee WHERE age > 30;
SELECT * FROM Employee WHERE age < 30;
SELECT * FROM Employee WHERE age >= 30;
SELECT * FROM Employee WHERE age <= 30;

-- BETWEEN
SELECT * FROM Employee WHERE age BETWEEN 30 AND 35;

-- IN
SELECT * FROM Employee WHERE dept IN ('HR', 'SALES');

-- NOT IN
SELECT * FROM Employee WHERE dept NOT IN ('HR', 'SALES');

-- LIKE
SELECT * FROM Employee WHERE name LIKE 's%'; -- starts with 's'
SELECT * FROM Employee WHERE name LIKE '%a'; -- ends with 'a'

-- NOT LIKE
SELECT * FROM Employee WHERE name NOT LIKE 's%';
SELECT * FROM Employee WHERE name NOT LIKE '%a';

-- ascending order
SELECT * FROM Employee ORDER BY age ASC;

-- descending order
SELECT * FROM Employee ORDER BY age DESC;

-- limit
SELECT * FROM Employee LIMIT 3; -- first 3 rows
SELECT * FROM Employee LIMIT 2, 6; -- skip first 2 rows, next 6 rows

-- update
UPDATE Employee SET name = 'navya' WHERE id = 2;
SELECT * FROM Employee;

UPDATE Employee SET age = 20, dept = 'HR' WHERE id = 19;
UPDATE Employee SET age = age + 1 WHERE age = 28;

-- delete
DELETE FROM Employee WHERE id = 5;
SELECT * FROM Employee;
```

---


# 📘 Employee Database: Transactions in SQL (Markdown for Git)

## 🔄 TRANSACTION
A **transaction** is a sequence of one or more SQL statements executed as a single unit of work. Transactions ensure data consistency and integrity.

### 🔐 ACID Properties
Transactions follow four key principles:

1. **Atomicity (A)**  
   A transaction is either completed in full or not at all.

2. **Consistency (C)**  
   The database remains in a consistent state before and after the transaction.

3. **Isolation (I)**  
   Each transaction executes independently without interference from others.

4. **Durability (D)**  
   Once a transaction is committed, it remains saved even in the event of a system crash.

---

## ✅ COMMIT, AUTOCOMMIT, ROLLBACK

### 📝 COMMIT
The `COMMIT` command is used to **permanently save** all the changes made during the current transaction.

```sql
COMMIT;
```

### 🔁 AUTOCOMMIT
By default, **autocommit mode** is enabled. Each SQL statement is treated as a separate transaction and is committed automatically.

#### 🔍 Check Status:
```sql
SELECT @@autocommit;
```

#### 🚫 Disable Autocommit:
```sql
SET autocommit = 0;
```

#### ✅ Enable Autocommit:
```sql
SET autocommit = 1;
```

### ↩️ ROLLBACK
The `ROLLBACK` command is used to **undo** transactions that have not yet been committed.

---

## 🧪 SQL commit autocommit rollback
```sql
-- check current autocommit status
SELECT @@autocommit;

-- disable autocommit
SET autocommit = 0;

-- start transaction and commit
START TRANSACTION;
UPDATE Employee SET age = age + 1 WHERE age = 30;
COMMIT;

-- rollback transaction
START TRANSACTION;
UPDATE Employee SET age = 30 WHERE age = 28;
-- exception or issue
ROLLBACK;

-- successful transaction
START TRANSACTION;
UPDATE Employee SET age = 30 WHERE age = 28;
COMMIT;

-- check the result
SELECT * FROM Employee;

-- re-enable autocommit
SET autocommit = 1;
```

---



## 📅 CURRENT DATE AND TIME FUNCTIONS
| Function             | Description                                 |
|----------------------|---------------------------------------------|
| `CURRENT_DATE`       | Returns current date in format `YYYY-MM-DD` |
| `CURRENT_TIME`       | Prints the current time                     |
| `CURRENT_TIMESTAMP` or `NOW()` | Prints current date and time         |
| `LOCALTIME`          | Prints the database server time             |
| `LOCALTIMESTAMP`     | Prints the local timestamp                  |

### 🔍 Example
```sql
-- creating a database
CREATE DATABASE Employeedb;
-- select the database
USE Employeedb;

-- date/time functions
SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;
-- or
SELECT NOW();
SELECT LOCALTIME;
SELECT LOCALTIMESTAMP;

-- table using timestamp
CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- inserting into log table
INSERT INTO logs (event, created_at) VALUES ('data_import', NOW());
SELECT * FROM logs;
```

---

## 🔐 CONSTRAINTS IN SQL
Constraints ensure **data integrity** and define **rules** on column values.

| Constraint    | Description                                                 |
|---------------|-------------------------------------------------------------|
| `NOT NULL`    | Column **must have a value** (no empty cells)               |
| `UNIQUE`      | All values in the column must be **different**              |
| `PRIMARY KEY` | Uniquely **identifies each row** (`NOT NULL + UNIQUE`)      |
| `FOREIGN KEY` | Links a column to another table’s **primary key**           |
| `CHECK`       | Ensures that values meet a **specific condition**           |
| `DEFAULT`     | Sets a **default value** for the column if none is provided |

### 🧪 Example with Constraints
```sql
-- create and select database
CREATE DATABASE schooldb;
USE schooldb;

-- NOT NULL constraint
CREATE TABLE school (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL
);

-- UNIQUE constraint
CREATE TABLE studentdeatils (
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE
);

-- DEFAULT constraint
CREATE TABLE faculty (
    name VARCHAR(100),
    subject VARCHAR(20) DEFAULT 'Maths'
);

-- insert values to test default
INSERT INTO faculty (name) VALUES ('sowmya');
INSERT INTO faculty (name, subject) VALUES ('sneha', 'science');
SELECT * FROM faculty;

-- CHECK constraint
CREATE TABLE salary (
    id INT,
    amount DECIMAL(10,2) CHECK (amount >= 0)
);

-- valid insert
INSERT INTO salary (id, amount) VALUES 
    (1, 1000.00), (2, 2250.50), (3, 3330.00), (4, 9900.99);

SELECT * FROM salary;

-- invalid insert (negative value will raise error)
INSERT INTO salary (id, amount) VALUES (5, -100.00);

-- PRIMARY KEY and CHECK with CONSTRAINT keyword
CREATE TABLE studentsinfo (
    roll_no INT PRIMARY KEY,
    age INT CONSTRAINT chk_age CHECK (age >= 5),
    email VARCHAR(100) UNIQUE
);
```

---




## 1. Primary Key
A **primary key** is a column (or set of columns) in a table that **uniquely identifies each row**.
- Must be **unique**
- Cannot be **NULL**

---

## 2. Foreign Key
A **foreign key** is a column in one table that **links to the primary key** of another table.
- Maintains relationships between tables.

---

## 3. ON UPDATE CASCADE
When the **parent key is updated**, this will **automatically update** the child table.

---

## 4. ON DELETE SET NULL
When the **parent row is deleted**, this sets the corresponding foreign key in the child table to **NULL**.

---

## 5. Foreign Key Constraint
A rule that ensures a column in one table refers to a valid value in another table’s primary key.
- Maintains **referential integrity**
- Links tables safely

---

## 6. INFORMATION_SCHEMA
A **read-only system database** that contains metadata about:
- Databases
- Tables
- Columns
- Constraints

---

## 7. Referenced Table Name
The name of the table containing the **primary key** that another table's foreign key **references**.

---

## 8. CASCADE – Simple Definition
Automatically affects related rows when a change occurs in the parent table.

### Types of CASCADE:
- `ON DELETE CASCADE`: Deletes related child rows when a parent is deleted.
- `ON UPDATE CASCADE`: Updates child rows when the parent value changes.

---

## 🔍 Example SQL Queries: CASCADE, INFORMATION_SCHEMA

```sql
-- Create database
CREATE DATABASE Attendance;
USE Attendance;

-- Create parent table
CREATE TABLE class_attendance (
    class_id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(50) NOT NULL
);

-- Create child table with CASCADE and SET NULL
CREATE TABLE students_attendance (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    class_id INT,
    FOREIGN KEY (class_id) REFERENCES class_attendance(class_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

-- Insert records
INSERT INTO class_attendance (class_name)
VALUES ('maths'), ('physics'), ('chemistry');

SELECT * FROM class_attendance;

INSERT INTO students_attendance (student_name, class_id)
VALUES ('sowmya', 1), ('pranavni', 1), ('swetha', 2),
       ('laxmi', 3), ('ramya', 2), ('sneha', 3);

SELECT * FROM students_attendance;

-- Show foreign key definition
SHOW CREATE TABLE students_attendance;

-- Use INFORMATION_SCHEMA to find foreign key references
SELECT
    table_name,
    column_name,
    constraint_name,
    referenced_table_name,
    referenced_column_name
FROM
    information_schema.key_column_usage
WHERE
    referenced_table_name IS NOT NULL
    AND table_schema = 'Attendance';

-- Additional Queries
SHOW DATABASES;

SELECT * FROM class_attendance;
SELECT * FROM students_attendance;

-- Test ON UPDATE CASCADE
UPDATE class_attendance
SET class_id = 10
WHERE class_id = 1;

SELECT * FROM class_attendance;

-- Test ON DELETE SET NULL
DELETE FROM class_attendance WHERE class_id = 2;

SELECT * FROM class_attendance;
SELECT * FROM students_attendance;
```