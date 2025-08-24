
# Introduction to Databases

A **database** is a collection of structured information that is stored and accessed electronically. It allows users to efficiently store, retrieve, and manage data.

---

## Why Use a Database?

- To organize and manage large amounts of data
- For fast searching and filtering
- To maintain data accuracy (integrity)
- To support multi-user access securely

---

## What is SQL?

**SQL (Structured Query Language)** is the standard language used to interact with **Relational Databases**.

### SQL is used to:
- Create databases and tables
- Insert, retrieve, update, and delete data
- Manage access and structure of the database

---

## SQL Operations

SQL operations are mainly categorized into:

1. **DDL (Data Definition Language)** – Create, alter, drop structures  
2. **DML (Data Manipulation Language)** – Insert, update, delete data  
3. **DQL (Data Query Language)** – Retrieve data (`SELECT`)  
4. **DCL (Data Control Language)** – Grant or revoke permissions  
5. **TCL (Transaction Control Language)** – Manage transactions (`COMMIT`, `ROLLBACK`)

---

## Relational vs Non-Relational Databases

| Feature               | Relational Database (RDBMS)       | Non-Relational Database (NoSQL)     |
|-----------------------|------------------------------------|--------------------------------------|
| Data Structure        | Tables (Rows & Columns)            | Collections, Documents, Key-Value    |
| Schema                | Fixed schema                       | Dynamic schema                       |
| Query Language        | SQL                                | No standard language (e.g. MongoDB uses JSON queries) |
| Relationships         | Supports relationships             | Usually no joins                     |
| Examples              | MySQL, PostgreSQL, Oracle          | MongoDB, Cassandra, Redis            |

---

## CRUD Operations

CRUD stands for the four basic operations performed on data:

1. **C – Create:** Add new data to the database  
   `INSERT INTO table_name VALUES (...);`

2. **R – Read:** Retrieve data from the database  
   `SELECT * FROM table_name;`

3. **U – Update:** Modify existing data  
   `UPDATE table_name SET column = value WHERE condition;`

4. **D – Delete:** Remove data  
   `DELETE FROM table_name WHERE condition;`

---

## How to Create and Drop a Database in SQL

### Create a Database

```sql
CREATE DATABASE school;
````

### Use the Database

```sql
USE school;
```

### Drop (Delete) a Database

```sql
DROP DATABASE school;
```
## Example: Set1.sql

```sql
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



---

## 1. Create a New Database

```sql
CREATE DATABASE student_db;
````

Creates a new database named `student_db`.

---

## 2. Show All Databases

```sql
SHOW DATABASES;
```

Displays a list of all available databases.

---

## 3. Select a Database to Use

```sql
USE student_db;
```

Sets `student_db` as the active database for the session.

---

## 4. Create a Table: `students`

```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL DEFAULT 'No Name',
    age INT,
    email VARCHAR(100) UNIQUE,
    admission_date DATE
);
```

Creates a table `students` with the following columns:

* `id`: unique student ID
* `name`: student's name with a default value
* `age`: student age
* `email`: must be unique
* `admission_date`: date of admission

---

## 5. Show All Tables in the Database

```sql
SHOW TABLES;
```

Lists all the tables in the current database.

---

## 6. Describe Table Structure

```sql
DESCRIBE students;
```

Displays column names, data types, keys, and other metadata of the `students` table.

---

## 7. View Table Data

```sql
SELECT * FROM students;
```

Fetches all records from the `students` table.

---

## 8. Drop a Column from the Table

```sql
ALTER TABLE students DROP COLUMN admission_date;
```

Removes the `admission_date` column from the `students` table.

---

## 9. Rename a Table

```sql
RENAME TABLE students_test TO students;
```

Renames the table `students_test` to `students`.

---

## 10. Drop the Table

```sql
DROP TABLE students;
```

Deletes the `students` table and all its data.

---

## 11. Add a New Column to the Table

```sql
ALTER TABLE students ADD COLUMN admission_date DATE;
```

Adds a new column `admission_date` of type `DATE`.

---

## 12. Rename a Column

```sql
ALTER TABLE students RENAME COLUMN name TO student_name;
```

Renames the column `name` to `student_name`.

```sql
ALTER TABLE students RENAME COLUMN student_name TO name;
```

Renames `student_name` back to `name`.

---

## 13. Add Another Column

```sql
ALTER TABLE students ADD COLUMN gender VARCHAR(10);
```

Adds a column `gender` to store gender information.

---

## 14. Modify Column Properties

```sql
ALTER TABLE students MODIFY COLUMN name VARCHAR(150) NOT NULL;
```

Increases the length of `name` to 150 characters.

---

## 15. Change Column Order

```sql
ALTER TABLE students MODIFY COLUMN gender VARCHAR(10) AFTER email;
```

Moves the `gender` column to appear right after the `email` column.


```

## Example: Set2.sql
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

INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (1, 'Ayesha Khan', 16, '10th', '2007-05-15');
INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (2, 'Ravi Sharma', 17, '11th', '2006-03-22');
INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (3, 'Meena Joshi', 15, '9th', NULL);
INSERT INTO student (id, name, age, grade, date_of_birth) VALUES (4, 'Arjun Verma', 18, '12th', NULL);

INSERT INTO student (id, name, age, grade) VALUES (15, 'Ayesha Khan', 16, '10th'),
(25, 'Ravi Sharma', 17, '11th'),
(35, 'Meena Joshi', 15, '9th'),
(45, 'Arjun Verma', 18, '12th'),
(55, 'Sara Ali', 16, '10th'),
(65, 'Karan Mehta', 17, '11th'),
(75, 'Tanya Roy', 15, '9th'),
(85, 'Vikram Singh', 18, '12th');

select * from student;

SELECT name, grade FROM student;

SELECT * FROM student WHERE grade = '10th';

SELECT * FROM student WHERE age > 16;

SELECT * FROM student WHERE date_of_birth = NULL;

SELECT * FROM student WHERE date_of_birth is NULL;

SELECT * FROM student WHERE date_of_birth is not NULL;

SELECT * FROM student WHERE grade = '10th' AND age > 15;

SELECT * FROM student WHERE grade = '9th' OR grade = '12th';


SELECT * FROM student
WHERE (grade = '10th' OR grade = '11th') AND age >= 16;


SELECT * FROM student ORDER BY age ASC;


SELECT * FROM student ORDER BY name DESC;

select * from student;

SELECT * FROM student LIMIT 5;

SELECT * FROM student LIMIT 2, 6;

SELECT * FROM student WHERE name LIKE 'A%';


UPDATE student
SET grade = '12th' WHERE id = 2;

UPDATE student
SET age = 17, grade = '10th' WHERE id = 3;


UPDATE student SET age = 18;

UPDATE student
SET grade = '10th' WHERE grade = '9th';



UPDATE student
SET age = age + 1 WHERE age < 18;

UPDATE student
SET grade = 'Unknown' WHERE grade IS NULL;

DELETE FROM student WHERE id = 2;

select * from student;


DELETE FROM student WHERE grade = '9th';

DELETE FROM student WHERE age < 16;

DELETE FROM student WHERE grade IS NULL;

SELECT @@autocommit;

SET autocommit = 0;


start transaction;

UPDATE student SET age = age + 1 WHERE age < 18;

commit;


start transaction;

UPDATE student SET grade = '10th' WHERE grade = '9th';
-- exception
rollback;


start transaction;

UPDATE student SET grade = '10th' WHERE grade = '9th';
-- exception
commit;

select * from student;

SET autocommit = 1;



SELECT CURRENT_DATE;

SELECT CURRENT_TIME;


SELECT CURRENT_TIMESTAMP;
-- or
SELECT NOW();


SELECT LOCALTIME;
SELECT LOCALTIMESTAMP;

CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO logs (event, created_at) VALUES ('data_import', NOW());

select * from logs;

output:

| id | name         | age | grade | date\_of\_birth |
| -- | ------------ | --- | ----- | --------------- |
| 1  | Ayesha Khan  | 18  | 10th  | 2007-05-15      |
| 3  | Meena Joshi  | 18  | 10th  | *(NULL)*        |
| 4  | Arjun Verma  | 18  | 12th  | *(NULL)*        |
| 15 | Ayesha Khan  | 18  | 10th  | *(NULL)*        |
| 25 | Ravi Sharma  | 18  | 11th  | *(NULL)*        |
| 35 | Meena Joshi  | 18  | 10th  | *(NULL)*        |
| 45 | Arjun Verma  | 18  | 12th  | *(NULL)*        |
| 55 | Sara Ali     | 18  | 10th  | *(NULL)*        |
| 65 | Karan Mehta  | 18  | 11th  | *(NULL)*        |
| 75 | Tanya Roy    | 18  | 10th  | *(NULL)*        |
| 85 | Vikram Singh | 18  | 12th  | *(NULL)*        |


# Transactions and ACID Properties in SQL

## What is a Transaction?

A **transaction** is a group of one or more SQL statements that are executed as a single unit.
A transaction ensures that either all operations are performed successfully, or none are applied to the database.

In SQL, a transaction typically follows this pattern:

```sql
START TRANSACTION;

-- SQL operations (e.g., UPDATE, INSERT, DELETE)

COMMIT;   -- or ROLLBACK;
```

---

## COMMIT

* `COMMIT` is used to **save all changes** made during the current transaction.
* Once committed, the changes become permanent in the database.
* Changes cannot be undone after a commit.

**Example:**

```sql
START TRANSACTION;
UPDATE accounts SET balance = balance - 1000 WHERE id = 1;
UPDATE accounts SET balance = balance + 1000 WHERE id = 2;
COMMIT;
```

---

## ROLLBACK

* `ROLLBACK` is used to **undo changes** made during the transaction.
* It reverts the database to the state before the transaction began.

**Example:**

```sql
START TRANSACTION;
UPDATE accounts SET balance = balance - 1000 WHERE id = 1;
-- Error happens here
ROLLBACK;
```

---

## AUTOCOMMIT

* **Autocommit mode** means each individual SQL statement is automatically committed when it is executed.
* It is enabled by default in most SQL systems.

**To disable autocommit (manual commit needed):**

```sql
SET autocommit = 0;
```

**To enable autocommit again:**

```sql
SET autocommit = 1;
```

---

# ACID Properties

The reliability of a transaction is based on the **ACID** properties:

| Property        | Description                                                                                |
| --------------- | ------------------------------------------------------------------------------------------ |
| **Atomicity**   | All operations in a transaction are completed; if one fails, all fail.                     |
| **Consistency** | Ensures that the database is in a valid state before and after the transaction.            |
| **Isolation**   | Ensures that concurrent transactions do not affect each other’s execution.                 |
| **Durability**  | Once a transaction is committed, the changes are permanent, even if a system crash occurs. |

---


