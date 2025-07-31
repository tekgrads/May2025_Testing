# Class 33: (26/07/2025)

## Introduction to Databases

### What is a Database?
- A database is an organized collection of structured information or data, typically stored electronically in a computer system.
- It is the way to store data in a format that is easily accessible.

**Example**: Library

### Why do we need databases?
- Store, manage, and retrieve large amounts of data.
- Prevent data duplication to maintain data integrity.
- Allow multiple users to access and manipulate data simultaneously.

---

## What is SQL?
**Structured Query Language**: Used to communicate and manipulate data in relational databases.

### Common Operations in DB (CRUD):
- **Create** → `INSERT`
- **Read** → `SELECT`
- **Update** → `UPDATE`
- **Delete** → `DELETE`

---

## Comparison with Excel

**SQL**:
- Relational
- Structured
- Set of rules

**NoSQL**:
- Non-relational
- Can scale up
- Structure is not important

**BASE**:
- NoSQL follows BASE
- Used when not worried about data structure
- Example use case: Sudden spike in transactions like Big Billion Days

---

## DBMS (Database Management System)
- Software that interacts with users, applications, and the DB to capture and analyze data.

---

## What is MySQL?
- Open-source RDBMS (Relational Database Management System)

### Real-World Use Cases:
- **E-Commerce**: Store customer data
- **Banking**: Handle transactions securely
- **Social Network**: Manage user data

---

## SQL Commands: Examples

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
```

---

## How to Insert Data into DB

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

INSERT INTO student (id, name, age, grade, date_of_birth) VALUES 
(1, 'Ayesha Khan', 16, '10th', '2007-05-15'),
(2, 'Ravi Sharma', 17, '11th', '2006-03-22'),
(3, 'Meena Joshi', 15, '9th', NULL),
(4, 'Arjun Verma', 18, '12th', NULL);

INSERT INTO student (id, name, age, grade) VALUES 
(15, 'Ayesha Khan', 16, '10th'),
(25, 'Ravi Sharma', 17, '11th'),
(35, 'Meena Joshi', 15, '9th'),
(45, 'Arjun Verma', 18, '12th'),
(55, 'Sara Ali', 16, '10th'),
(65, 'Karan Mehta', 17, '11th'),
(75, 'Tanya Roy', 15, '9th'),
(85, 'Vikram Singh', 18, '12th');

SELECT * FROM student;
```

---

## Filtering

```sql
SELECT name, grade FROM student;
SELECT * FROM student WHERE grade = '10th';
SELECT * FROM student WHERE age > 16;
SELECT * FROM student WHERE date_of_birth IS NULL;
SELECT * FROM student WHERE date_of_birth IS NOT NULL;
SELECT * FROM student WHERE grade = '10th' AND age > 15;
SELECT * FROM student WHERE grade = '9th' OR grade = '12th';
SELECT * FROM student WHERE (grade = '10th' OR grade = '11th') AND age >= 16;
```

---

## Comparison Operations in MySQL

| Operator | Description | Example |
|----------|-------------|---------|
| = | Equals | `WHERE age = 16` |
| != | Not equal to | `WHERE grade != '12th'` |
| <> | Not equal to (alternative) | `WHERE grade <> '12th'` |
| > | Greater than | `WHERE age > 16` |
| < | Less than | `WHERE age < 17` |
| >= | Greater than or equal to | `WHERE age >= 16` |
| <= | Less than or equal to | `WHERE age <= 18` |
| BETWEEN | Within a range | `WHERE age BETWEEN 15 AND 17` |
| IN | Matches any in list | `WHERE grade IN ('10th', '12th')` |
| NOT IN | Excludes list items | `WHERE grade NOT IN ('9th', '11th')` |
| LIKE | Pattern match | `WHERE name LIKE 'A%'` |
| NOT LIKE | Pattern not matching | `WHERE name NOT LIKE '%a'` |

---

## NULL Handling

- Can't use `= NULL`
- Use `IS NULL` or `IS NOT NULL`

```sql
SELECT * FROM student ORDER BY age ASC;
SELECT * FROM student ORDER BY name DESC;
SELECT * FROM student LIMIT 5;
SELECT * FROM student LIMIT 2, 6;
SELECT * FROM student WHERE name LIKE 'A%';
```

---

## More Date Pattern Examples

| Pattern | Matches |
|---------|---------|
| '2025-05-%' | Any day in May 2025 |
| '2024-12-__' | All 2-digit days in Dec 2024 |
| '__-01-01' | 1st January of any year |
| '202_-__-__' | Any date in the 2020s decade |
| '__-__-3_' | Days 30-39 (syntactically valid) |

---

## UPDATE Queries

```sql
UPDATE student SET grade = '12th' WHERE id = 2;
UPDATE student SET age = 17, grade = '10th' WHERE id = 3;
UPDATE student SET age = 18;
UPDATE student SET grade = '10th' WHERE grade = '9th';
UPDATE student SET age = age + 1 WHERE age < 18;
UPDATE student SET grade = 'Unknown' WHERE grade IS NULL;
```

---

## DELETE Queries

```sql
DELETE FROM student WHERE id = 2;
DELETE FROM student WHERE grade = '9th';
DELETE FROM student WHERE age < 16;
DELETE FROM student WHERE grade IS NULL;
```

---

## Transactions

- Sequence of one or more SQL statements executed as a single unit.

**ACID Properties**:
- **A**: Atomicity
- **C**: Consistency
- **I**: Isolation
- **D**: Durability

```sql
SELECT @@autocommit;
SET autocommit = 0;

START TRANSACTION;
UPDATE student SET age = age + 1 WHERE age < 18;
COMMIT;

START TRANSACTION;
UPDATE student SET grade = '10th' WHERE grade = '9th';
ROLLBACK;

SET autocommit = 1;
```

---

## Date and Time Functions

| Function | Returns | Example Output |
|----------|---------|----------------|
| CURRENT_DATE | Date only | 2025-05-02 |
| CURRENT_TIME | Time only | 14:23:45 |
| NOW() | Date & Time | 2025-05-02 14:23:45 |
| CURRENT_TIMESTAMP | Date & Time | 2025-05-02 14:23:45 |
| LOCALTIME | Date & Time | 2025-05-02 14:23:45 |

```sql
SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;
SELECT NOW();
SELECT LOCALTIME;
SELECT LOCALTIMESTAMP;
```

---

## Logs Table Example

```sql
CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

---

## Constraints

```sql
CREATE DATABASE employee;
USE employee;

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

INSERT INTO products (name) VALUES ('Laptop');
INSERT INTO products (name, status) VALUES ('Mobile Phone', 'out_of_stock');

CREATE TABLE accounts (
    id INT,
    balance DECIMAL(10,2) CHECK (balance >= 0)
);

INSERT INTO accounts (id, balance) VALUES 
(1, 1000.00), 
(2, 250.50),
(3, 0.00),
(4, 99999.99);
-- Fails
-- INSERT INTO accounts (id, balance) VALUES (5, -100.00);

CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    age INT CONSTRAINT chk_age CHECK (age >= 5),
    email VARCHAR(100) UNIQUE
);
```

---

## Information Schema
- Read-only system database that contains metadata about:
  - Databases
  - Tables
  - Columns
  - Constraints
