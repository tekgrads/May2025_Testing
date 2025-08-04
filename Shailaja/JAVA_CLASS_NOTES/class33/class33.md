📘 Class 33: Introduction to Databases
🔹 What is a Database?
A database is an organized collection of structured information or data, typically stored electronically in a computer system. It enables efficient storage, retrieval, and manipulation of data.

🧠 Real-life Analogy: Think of a library — books are organized by genre, author, etc., making them easy to locate.

🔹 Why Do We Need Databases?
To store, manage, and retrieve large amounts of data.

To prevent data duplication and ensure data integrity.

To enable multi-user access for concurrent data manipulation.

🔹 What is SQL?
SQL (Structured Query Language) is a standard language used to interact with relational databases.
It allows you to perform operations like:

CREATE: Insert new data

SELECT: Read data

UPDATE: Modify existing data

DELETE: Remove data

➡️ Known as CRUD operations (Create, Read, Update, Delete)

🔹 SQL vs Excel
Feature	SQL	Excel
Structure	Relational	Tabular
Scalability	High	Low
Concurrency	Multi-user	Single-user
Validation	High	Low

🔹 SQL vs NoSQL
SQL	NoSQL
Relational DB	Non-relational DB
Structured schema	Flexible schema
ACID-compliant	BASE-compliant
Used for predictable workloads	Used for large-scale dynamic data

🧠 BASE in NoSQL:

Basically Available

Soft state

Eventually consistent

📦 Use Case: Sudden traffic spikes like Flipkart’s Big Billion Days.

🔹 DBMS (Database Management System)
A DBMS is software that allows users and applications to interact with databases.

Examples: MySQL, PostgreSQL, Oracle, MongoDB

🔹 What is MySQL?
MySQL is a popular open-source Relational Database Management System (RDBMS).

✅ Real-World Applications:
E-Commerce: Customer & order management

Banking: Transactional data

Social Media: User profiles & feeds

🔸 SQL Commands
🏗 Create and Manage a Database
sql
Copy
Edit
CREATE DATABASE student_db;
SHOW DATABASES;
USE student_db;
📋 Create a Table
sql
Copy
Edit
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL DEFAULT 'No Name',
    age INT,
    email VARCHAR(100) UNIQUE,
    admission_date DATE
);
🔍 Read and Explore
sql
Copy
Edit
SHOW TABLES;
DESCRIBE students;
SELECT * FROM students;
✏ Modify Tables
sql
Copy
Edit
ALTER TABLE students DROP COLUMN admission_date;
RENAME TABLE students_test TO students;
DROP TABLE students;

ALTER TABLE students ADD COLUMN admission_date DATE;
ALTER TABLE students RENAME COLUMN name TO student_name;
ALTER TABLE students RENAME COLUMN student_name TO name;
ALTER TABLE students ADD COLUMN gender VARCHAR(10);
ALTER TABLE students MODIFY COLUMN name VARCHAR(150) NOT NULL;
ALTER TABLE students MODIFY COLUMN gender VARCHAR(10) AFTER email;
🔹 Data Insertion Example
🎓 Student Table
sql
Copy
Edit
CREATE DATABASE schooldb;
USE schooldb;

CREATE TABLE student ( 
    id INT PRIMARY KEY, 
    name VARCHAR(100),
    age INT,
    grade VARCHAR(10),
    date_of_birth DATE
);
✅ Insert Records
sql
Copy
Edit
INSERT INTO student (id, name, age, grade, date_of_birth) VALUES 
(1, 'Ayesha Khan', 16, '10th', '2007-05-15'),
(2, 'Ravi Sharma', 17, '11th', '2006-03-22'),
(3, 'Meena Joshi', 15, '9th', NULL),
(4, 'Arjun Verma', 18, '12th', NULL);

-- Without DOB
INSERT INTO student (id, name, age, grade) VALUES 
(15, 'Ayesha Khan', 16, '10th'),
(25, 'Ravi Sharma', 17, '11th'),
(35, 'Meena Joshi', 15, '9th'),
(45, 'Arjun Verma', 18, '12th'),
(55, 'Sara Ali', 16, '10th'),
(65, 'Karan Mehta', 17, '11th'),
(75, 'Tanya Roy', 15, '9th'),
(85, 'Vikram Singh', 18, '12th');
🔍 Data Filtering
🧾 Select Statements
sql
Copy
Edit
SELECT name, grade FROM student;
SELECT * FROM student WHERE grade = '10th';
SELECT * FROM student WHERE age > 16;
SELECT * FROM student WHERE date_of_birth IS NULL;
SELECT * FROM student WHERE date_of_birth IS NOT NULL;
SELECT * FROM student WHERE grade = '10th' AND age > 15;
SELECT * FROM student WHERE grade = '9th' OR grade = '12th';
SELECT * FROM student WHERE (grade = '10th' OR grade = '11th') AND age >= 16;
🔸 Comparison Operators in MySQL
Operator	Meaning	Example
=	Equals	WHERE age = 16
!= or <>	Not equal	WHERE grade <> '12th'
>	Greater than	WHERE age > 16
<	Less than	WHERE age < 17
>=	Greater than or equal to	WHERE age >= 16
<=	Less than or equal to	WHERE age <= 18
BETWEEN	Range	WHERE age BETWEEN 15 AND 17
IN	Set inclusion	WHERE grade IN ('10th', '12th')
NOT IN	Set exclusion	WHERE grade NOT IN ('9th')
LIKE	Pattern match	WHERE name LIKE 'A%'
NOT LIKE	Pattern not match	WHERE name NOT LIKE '%a'

🔹 NULL Handling
Use IS NULL or IS NOT NULL instead of = NULL

sql
Copy
Edit
SELECT * FROM student WHERE date_of_birth IS NULL;
🔹 Ordering and Limiting Data
sql
Copy
Edit
SELECT * FROM student ORDER BY age ASC;
SELECT * FROM student ORDER BY name DESC;
SELECT * FROM student LIMIT 5;
SELECT * FROM student LIMIT 2, 6;  -- Offset 2, return next 6
🔹 Date Pattern Matching Examples
Pattern	Description
'2025-05-%'	Any day in May 2025
'2024-12-__'	Any 2-digit day in Dec 2024
'__-01-01'	Jan 1st of any year
'202_--'	Any date in the 2020s
'--3_'	Dates ending in 30–39 (syntactically valid)

🔹 UPDATE Queries
sql
Copy
Edit
UPDATE student SET grade = '12th' WHERE id = 2;
UPDATE student SET age = 17, grade = '10th' WHERE id = 3;
UPDATE student SET age = 18;
UPDATE student SET grade = '10th' WHERE grade = '9th';
UPDATE student SET age = age + 1 WHERE age < 18;
UPDATE student SET grade = 'Unknown' WHERE grade IS NULL;
🔹 DELETE Queries
sql
Copy
Edit
DELETE FROM student WHERE id = 2;
DELETE FROM student WHERE grade = '9th';
DELETE FROM student WHERE age < 16;
DELETE FROM student WHERE grade IS NULL;
🔹 Transactions in SQL
A transaction is a group of SQL operations executed as a single unit.
It follows ACID properties:

Property	Description
A – Atomicity	All or none execution
C – Consistency	Maintains valid state
I – Isolation	Transactions do not interfere
D – Durability	Changes persist even after failure

👇 Transaction Syntax
sql
Copy
Edit
SELECT @@autocommit;
SET autocommit = 0;

START TRANSACTION;
UPDATE student SET age = age + 1 WHERE age < 18;
COMMIT;

START TRANSACTION;
UPDATE student SET grade = '10th' WHERE grade = '9th';
ROLLBACK;

SET autocommit = 1;
🔹 Date & Time Functions
Function	Output Type	Example
CURRENT_DATE	Date	2025-05-02
CURRENT_TIME	Time	14:23:45
NOW()	Date & Time	2025-05-02 14:23:45
CURRENT_TIMESTAMP	Date & Time	2025-05-02 14:23:45
LOCALTIME, LOCALTIMESTAMP	Date & Time	2025-05-02 14:23:45

Example:
sql
Copy
Edit
SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;
SELECT NOW();
SELECT LOCALTIME;
🔹 Logs Table Example
sql
Copy
Edit
CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
🔹 Constraints in SQL
✅ Common Constraints
PRIMARY KEY – Uniquely identifies each record

NOT NULL – Field must have a value

UNIQUE – All values must be different

DEFAULT – Set default value if none provided

CHECK – Restricts values based on condition

👇 Examples
sql
Copy
Edit
CREATE TABLE employees (
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE
);

CREATE TABLE products (
    name VARCHAR(100),
    status VARCHAR(20) DEFAULT 'in_stock'
);

CREATE TABLE accounts (
    id INT,
    balance DECIMAL(10,2) CHECK (balance >= 0)
);

CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    age INT CONSTRAINT chk_age CHECK (age >= 5),
    email VARCHAR(100) UNIQUE
);
🔹 Information Schema
The INFORMATION_SCHEMA is a read-only system database containing metadata about:

Databases

Tables

Columns

Constraints

Users