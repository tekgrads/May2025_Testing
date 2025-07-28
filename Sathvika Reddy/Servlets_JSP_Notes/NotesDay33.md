#  Database Basics:

## DB vs DBMS

* **Database (DB)**: A collection of structured data stored electronically.
* **DBMS (Database Management System)**: Software to interact with the database, allowing CRUD operations efficiently.

## Why Do We Need a DB?

* To store, manage, retrieve, and manipulate large amounts of data efficiently and securely.
* Ensures data integrity, consistency, and supports multiple users.

## What is MySQL?

* MySQL is an open-source Relational Database Management System (RDBMS) based on Structured Query Language (SQL).
* Widely used in web applications for storing structured data.

## Define Schema

* A schema is the **structure** of a database: tables, columns, datatypes, and relationships.
* Example: `student_db` schema contains a `students` table with fields like `id`, `name`, `age`, etc.

---

#  ACID vs BASE

## ACID Properties

* **Atomicity**: All operations in a transaction complete or none do.
* **Consistency**: Data must be valid before and after a transaction.
* **Isolation**: Transactions don't interfere with each other.
* **Durability**: Once a transaction commits, changes are permanent.

## BASE (for NoSQL)

* **Basically Available**: System is available most of the time.
* **Soft state**: Data may change over time.
* **Eventual consistency**: Updates will propagate to all nodes eventually.

## SQL vs NoSQL

| Feature   | SQL                 | NoSQL                        |
| --------- | ------------------- | ---------------------------- |
| Structure | Structured (tables) | Unstructured/semi-structured |
| Schema    | Fixed               | Dynamic                      |
| Example   | MySQL, PostgreSQL   | MongoDB, Cassandra           |

---

#  SQL: Common Operations

## CRUD Operations

* **C**reate: `INSERT INTO`
* **R**ead: `SELECT`
* **U**pdate: `UPDATE`
* **D**elete: `DELETE`

---

#  Low-Level Design

* Defines the **internal schema** of a database and **table relationships**.
* Examples: Primary Key, Foreign Key, table normalization, constraints, indexes.

---

# 🛠️ SQL Syntax Examples

## Create Database Syntax

```sql
CREATE DATABASE student_db;
```

## Use Database

```sql
USE student_db;
```

## Drop Database

```sql
DROP DATABASE student_db;
```

## Test Example

```sql
CREATE DATABASE test;
DROP DATABASE test;
```

---

#  Example: `student_db`

```sql
CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students (
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100) NOT NULL DEFAULT 'no name',
 age INT,
 email VARCHAR(100) UNIQUE,
 admission_date DATE
);
```

---

#  Commonly Used Datatypes & Constraints

* **INT**: Whole numbers
* **VARCHAR(n)**: Variable-length string
* **DATE**: Stores date
* **AUTO\_INCREMENT**: Auto-generates unique ID
* **PRIMARY KEY**: Uniquely identifies each row
* **NOT NULL**: Field must have a value
* **DEFAULT**: Default value if not provided
* **UNIQUE**: No duplicate values allowed

---

#  Table Commands (Using `students`)

## Show Table

```sql
SHOW TABLES;
```

## View Table Data

```sql
SELECT * FROM students;
```

## Describe Table

```sql
DESCRIBE students;
```

## Rename Table

```sql
RENAME TABLE students TO students_test;
```

## Drop Table

```sql
DROP TABLE students;
```

## Rename Column

```sql
ALTER TABLE students_test RENAME COLUMN name TO full_name;
```

## Drop Column

```sql
ALTER TABLE students_test DROP COLUMN age;
```

## Change Column Order

```sql
ALTER TABLE students_test MODIFY full_name VARCHAR(100) AFTER id;
```

---

#  Example: `schooldb`

```sql
CREATE DATABASE schooldb;
USE schooldb;

CREATE TABLE student (
 id INT PRIMARY KEY,
 name VARCHAR(100),
 age INT,
 grade VARCHAR(10),
 date_of_birth DATE
);

INSERT INTO student (id, name, age, grade, date_of_birth) 
VALUES (1, 'Ayesha Khan', 16, '10th', '2007-05-15'),
       (2, 'Ravi Sharma', 17, '11th', '2006-03-22'),
       (3, 'Meena Joshi', 15, '9th', NULL),
       (4, 'Arjun Verma', 18, '12th', NULL);

-- Insert multiple rows at once
INSERT INTO student (id, name, age, grade) 
VALUES (15, 'Ayesha Khan', 16, '10th'),
       (25, 'Ravi Sharma', 17, '11th'),
       (35, 'Meena Joshi', 15, '9th'),
       (45, 'Arjun Verma', 18, '12th'),
       (55, 'Sara Ali', 16, '10th'),
       (65, 'Karan Mehta', 17, '11th'),
       (75, 'Tanya Roy', 15, '9th'),
       (85, 'Vikram Singh', 18, '12th');
```

---

#  Select Queries

## Select All

```sql
SELECT * FROM student;
```

## Select Specific Columns

```sql
SELECT name, grade FROM student;
```

## With WHERE Clause

```sql
SELECT * FROM student WHERE grade = '12th';
```

## Comparison Operators

```sql
SELECT * FROM student WHERE age >= 17;
```

## Order By

```sql
SELECT * FROM student ORDER BY age DESC;
```

## Limit

```sql
SELECT * FROM student LIMIT 5;
```

## Like

```sql
SELECT * FROM student WHERE name LIKE 'A%';
```

---

#  Update Queries

## Update Specific Row

```sql
UPDATE student SET grade = '12th' WHERE id = 2;
```

## Update All Rows

```sql
UPDATE student SET age = 18;
```

## Increment Age by One

```sql
UPDATE student SET age = age + 1;
```

---

#  Delete Queries

## Delete Entire Table

```sql
DROP TABLE student;
```

## Delete Specific Row

```sql
DELETE FROM student WHERE id = 25;
```

## Delete Column

```sql
ALTER TABLE student DROP COLUMN grade;
```

---

#  Transaction Concepts

## What is a Transaction?

* A group of SQL operations that execute as a single unit.
* Ensures **ACID** properties.

## Autocommit & Manual Commit

```sql
-- Turn off autocommit
SET autocommit = 0;

-- Manual commit
COMMIT;

-- Rollback
ROLLBACK;
```

---

#  Date-Time Functions

## Current Date and Time

```sql
SELECT NOW();
```

## Current Local Time

```sql
SELECT CURTIME();
```

## Current Timestamp

```sql
SELECT CURRENT_TIMESTAMP();
```

---

#  Foreign Key Example

```sql
CREATE DATABASE school;
USE school;

CREATE TABLE classes (
 class_id INT AUTO_INCREMENT PRIMARY KEY, 
 class_name VARCHAR(50) NOT NULL 
);

CREATE TABLE students (
 student_id INT AUTO_INCREMENT PRIMARY KEY,
 student_name VARCHAR(100) NOT NULL,
 class_id INT,
 FOREIGN KEY (class_id) REFERENCES classes (class_id)
 ON UPDATE CASCADE 
 ON DELETE SET NULL
);

-- Insert into classes
INSERT INTO classes (class_name) VALUES ('Mathematics'), ('Science'), ('History');

-- Insert into students
INSERT INTO students (student_name, class_id) 
VALUES ('Alice', 1), ('bob', 2), ('charlie', 1);
```

## View Tables

```sql
SELECT * FROM classes;
SELECT * FROM students;
```


