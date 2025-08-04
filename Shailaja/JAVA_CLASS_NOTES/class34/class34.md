MAVEN (Project Management Tool)
🔹 What is Maven?
Maven is not just a build tool—it is a complete project management tool that helps manage the entire project lifecycle, automating many steps that were earlier done manually.

✅ Maven Handles:
Source code & test management

Project structure standardization

Library & dependency management

Configuration handling

Reporting & documentation

Integration with Apache projects

Build/test/run task automation

🧰 Key Features:
Standard project structure

Dependency handling via POM (Project Object Model)

Easy integration with IDEs

Centralized plugin & build management

Open-source and community-supported

📦 Maven Archetypes
Archetypes are project templates for creating standard structures.

📍 Repository: https://repo1.maven.apache.org/

bash
Copy
Edit
mvn archetype:generate
Artifact ID: Name of your project

🔁 Maven Build Lifecycle Phases
Phase	Purpose
validate	Check if project is correct
compile	Compile .java files
test	Run unit tests
package	Bundle into .jar or .war
verify	Validate integration or system test results
install	Save to local Maven repository
deploy	Upload to remote repository

🔧 Example:

bash
Copy
Edit
cd firstmavenproject
mvn compile
mvn package
🔗 SQL JOINS
Joins allow fetching data from multiple tables using relationships between them.

1️⃣ INNER JOIN
Returns only matching rows from both tables.

sql
Copy
Edit
SELECT s.name, m.subject, m.score 
FROM students s
INNER JOIN marks m ON s.id = m.student_id;
2️⃣ LEFT JOIN
Returns all rows from the left table and matches from the right.

sql
Copy
Edit
SELECT s.name, m.subject, m.score 
FROM students s
LEFT JOIN marks m ON s.id = m.student_id;
3️⃣ RIGHT JOIN
Returns all rows from the right table and matches from the left.

sql
Copy
Edit
SELECT s.name, m.subject, m.score 
FROM students s
RIGHT JOIN marks m ON s.id = m.student_id;
4️⃣ CROSS JOIN
Returns the Cartesian product (all combinations).

sql
Copy
Edit
SELECT s.name, m.subject 
FROM students s
CROSS JOIN marks m;
🔁 Join Comparison Table
Join Type	Description
INNER JOIN	Only matching rows from both tables
LEFT JOIN	All rows from the left + matched right
RIGHT JOIN	All rows from the right + matched left
CROSS JOIN	All combinations from both tables

🔀 UNION in SQL
Combines result sets of multiple SELECT statements.

✅ Rules:
Must have same number of columns

Columns must have compatible data types

Merging is based on position, not name

sql
Copy
Edit
SELECT name, city FROM customers
UNION
SELECT name, city FROM vendors;
💡 Use UNION ALL to include duplicates
💡 Use ORDER BY after the final query

🧮 String, Numeric & Date Functions
Function	Description	Example
CONCAT()	Combines strings	'A' + 'B' → AB
LENGTH()	Byte length	'Hi' → 2
CHAR_LENGTH()	Character count	'हिंदी' → 5
LOWER() / UPPER()	Case conversion	LOWER('MySQL') → mysql
REPLACE()	Substring replace	REPLACE('abc','b','x') → axc
TRIM()	Remove spaces	' hello ' → hello
NOW() / CURDATE() / CURTIME()	Current timestamp parts	
MONTHNAME() / YEAR() / DAY()	Extract parts from date	
DATEDIFF()	Difference between dates	DATEDIFF('2025-06-01', '2025-05-01') → 31
ROUND(), FLOOR(), CEIL()	Rounding	
ABS()	Absolute value	ABS(-10) → 10
MOD()	Remainder	MOD(10, 3) → 1
RAND()	Random number (0–1)	
IFNULL(), COALESCE()	NULL handling	

📊 VIEWS
A View is a virtual table based on a SELECT query.

No actual data storage

Simplifies complex queries

Can be used to hide sensitive data

⚡ INDEXES
Indexes improve search performance on large datasets.

✅ Why Use:
Faster SELECT operations

Improve query execution speed

❌ Downsides:
Additional storage

Slower INSERT, UPDATE, DELETE

🔧 Syntax:
sql
Copy
Edit
CREATE INDEX idx_name ON table_name(column_name);
🆚 Index Types
Feature	Clustered Index	Non-Clustered Index
Data Order	Physically ordered	Logical pointers
Count Allowed	One per table	Multiple per table
Performance	Faster reads	Slower than clustered

📁 GROUP BY & HAVING
sql
Copy
Edit
SELECT department, COUNT(*) AS total_employees 
FROM employees 
GROUP BY department;
sql
Copy
Edit
SELECT department, AVG(salary) AS avg_salary 
FROM employees 
GROUP BY department 
HAVING AVG(salary) > 60000;
Clause	Filters On	When Applied
WHERE	Row values	Before grouping
HAVING	Aggregate values	After grouping

👇 Advanced GROUP BY Example
sql
Copy
Edit
SELECT department, AVG(salary) AS avg_salary
FROM employees_new_2
WHERE status = 'active'
GROUP BY department
HAVING AVG(salary) > 60000;
🔍 SUBQUERIES
✅ Simple Subquery
sql
Copy
Edit
SELECT name, salary 
FROM employees 
WHERE salary > (
    SELECT AVG(salary) FROM employees
);
🔄 Correlated Subquery
sql
Copy
Edit
SELECT name, department, salary 
FROM employees e 
WHERE department = 'IT'
AND salary > (
    SELECT AVG(salary) 
    FROM employees 
    WHERE department = e.department
);
❗ When to Avoid:
If a JOIN can achieve the same result more efficiently

Avoid correlated subqueries for large datasets (slow performance)

🧾 STORED PROCEDURES
Used to encapsulate logic into reusable SQL blocks.

✅ Syntax for Procedures
sql
Copy
Edit
DELIMITER //

CREATE PROCEDURE list_employees()
BEGIN
    SELECT * FROM employees;
END //

DELIMITER ;
sql
Copy
Edit
CALL list_employees();
👤 Procedure with Parameters
sql
Copy
Edit
DELIMITER //

CREATE PROCEDURE get_employee_by_id(IN emp_id INT)
BEGIN
    SELECT * FROM employees WHERE id = emp_id;
END //

DELIMITER ;

CALL get_employee_by_id(3);
❌ Drop a Procedure
sql
Copy
Edit
DROP PROCEDURE IF EXISTS get_employee_by_id;