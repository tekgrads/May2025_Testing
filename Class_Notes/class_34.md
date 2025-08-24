# SQL and Maven Notes 

## Database and Tables
We create a student database with `students` and `marks` tables.

```sql
DROP DATABASE IF EXISTS student_db;
CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE marks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    subject VARCHAR(30),
    score INT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);
```

### Example Data
```sql
INSERT INTO students (id, name) VALUES
(1, 'Rohan'), (2, 'Aakash'), (3, 'Priya');

INSERT INTO marks (student_id, subject, score) VALUES
(1, 'Math', 92),
(1, 'Science', 88),
(2, 'Math', 81),
(3, 'Science', 73);
```

---

## SQL Joins
### INNER JOIN
Fetch only matched rows from both tables.
```sql
SELECT students.name, marks.subject, marks.score
FROM students
INNER JOIN marks ON students.id = marks.student_id;
```
**Output:**
- Rohan, Math, 92
- Rohan, Science, 88

### LEFT JOIN
All students and their marks (if any).
```sql
SELECT students.name, marks.subject
FROM students
LEFT JOIN marks ON students.id = marks.student_id;
```
**Use Case:** Shows students even if they don’t have marks.

### RIGHT JOIN
All marks and student names (if any).
```sql
SELECT students.name, marks.subject
FROM students
RIGHT JOIN marks ON students.id = marks.student_id;
```

### CROSS JOIN
All combinations of students and marks.
```sql
SELECT students.name, marks.subject
FROM students
CROSS JOIN marks;
```

---

## UNION Example
Combines customer and vendor data.
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

INSERT INTO customers VALUES (1, 'Alice', 'New York');
INSERT INTO vendors VALUES (101, 'VendorX', 'New York');

SELECT name, city FROM customers
UNION
SELECT name, city FROM vendors;
```
**Note:** Removes duplicates automatically.

---

## SQL Functions
### CONCAT
```sql
SELECT CONCAT('Hello', ' ', 'World');
-- Output: Hello World
```

### NOW
```sql
SELECT NOW();
-- Output: Current timestamp
```

### LENGTH
```sql
SELECT LENGTH('Database');
-- Output: 8
```

### ROUND
```sql
SELECT ROUND(45.6789, 2);
-- Output: 45.68
```

---

## Views
Create reusable SELECT query results.
```sql
CREATE VIEW student_scores AS
SELECT students.name, marks.subject, marks.score
FROM students
JOIN marks ON students.id = marks.student_id;

SELECT * FROM student_scores;
```

### Replacing and Dropping
```sql
CREATE OR REPLACE VIEW student_scores AS
SELECT name FROM students;

DROP VIEW student_scores;
```

---

## Indexes
Used to improve search performance.
```sql
CREATE INDEX idx_name ON students(name);
SHOW INDEX FROM students;
```

---

## Grouping Examples
### COUNT by Subject
```sql
SELECT subject, COUNT(*) FROM marks GROUP BY subject;
-- Output: Number of records per subject
```

### AVG Score per Student
```sql
SELECT student_id, AVG(score) FROM marks GROUP BY student_id;
```

---

## Stored Procedures
### Procedure Without Parameters
```sql
DELIMITER //
CREATE PROCEDURE show_students()
BEGIN
    SELECT * FROM students;
END //
DELIMITER ;

CALL show_students();
```

### With Parameters
```sql
DELIMITER //
CREATE PROCEDURE get_marks(IN sid INT)
BEGIN
    SELECT * FROM marks WHERE student_id = sid;
END //
DELIMITER ;

CALL get_marks(1);
```

---

# Maven Overview

## What is Maven?
Maven is a build and dependency management tool for Java projects. It automates compiling, testing, packaging, and deploying Java applications.

## Example Project Structure
```
my-app/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── App.java
```

## Maven Lifecycle Phases
1. **validate** – validate the project structure
2. **compile** – compile source code
3. **test** – run unit tests
4. **package** – create JAR/WAR
5. **verify** – check quality
6. **install** – add JAR to local repo
7. **deploy** – push to remote repo

### Example
```bash
mvn compile
mvn test
mvn package
```

## Dependency Example in `pom.xml`
```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Maven Central Diagram
```
+-----------+              +--------------------------+
| Developer |  <-------->  | Maven Central Repository |
|  Machine  |              | (repo.maven.apache.org)  |
+-----------+              +--------------------------+
        |                               ^
        |     Download Dependencies     |
        +------------------------------->
```

---

