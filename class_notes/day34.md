SQL Functions

SQL functions are predefined operations that simplify queries by performing calculations, formatting data, or extracting values.

🟢 1.1 Aggregate Functions

Aggregate functions work on a set of rows and return a single value.

Function	Purpose	Example	Output
COUNT()	Counts number of rows	SELECT COUNT(*) FROM Students;	50
SUM()	Adds numeric values	SELECT SUM(salary) FROM Employees;	550000
AVG()	Finds average value	SELECT AVG(age) FROM Students;	21.3
MIN()	Finds lowest value	SELECT MIN(age) FROM Students;	18
MAX()	Finds highest value	SELECT MAX(age) FROM Students;	26

✅ Use Case: In Mahveen Project, to calculate average student age:

SELECT AVG(age) AS Average_Age FROM Students;

🟢 1.2 String Functions

String functions deal with textual data.

Function	Purpose	Example	Output
UPPER()	Converts to uppercase	SELECT UPPER('mahveen');	MAHVEEN
LOWER()	Converts to lowercase	SELECT LOWER('MAHVEEN');	mahveen
CONCAT()	Joins strings	SELECT CONCAT(first_name,' ',last_name) FROM Students;	Rahul Sharma
SUBSTRING()	Extracts part of string	SELECT SUBSTRING('Database',1,4);	Data
LENGTH()	Returns length	SELECT LENGTH('Mahveen');	7

✅ Use Case: Display student full name in Mahveen Project:

SELECT CONCAT(first_name, ' ', last_name) AS FullName FROM Students;

🟢 1.3 Date & Time Functions
Function	Purpose	Example	Output
NOW()	Current date & time	SELECT NOW();	2025-08-16 19:35:00
CURDATE()	Current date	SELECT CURDATE();	2025-08-16
CURTIME()	Current time	SELECT CURTIME();	19:35:00
DATEDIFF()	Days between dates	SELECT DATEDIFF('2025-08-20','2025-08-16');	4
YEAR()	Extracts year	SELECT YEAR('2025-08-16');	2025

✅ Use Case: Find how many days left before student’s exam:

SELECT DATEDIFF(exam_date, CURDATE()) AS Days_Left FROM Exams;

🟢 1.4 Numeric Functions
Function	Purpose	Example	Output
ROUND()	Rounds number	SELECT ROUND(123.456,2);	123.46
CEIL()	Smallest integer greater than number	SELECT CEIL(7.2);	8
FLOOR()	Largest integer smaller than number	SELECT FLOOR(7.8);	7
ABS()	Absolute value	SELECT ABS(-50);	50
POWER()	Exponent	SELECT POWER(2,3);	8

✅ Use Case: Round student grade percentage:

SELECT ROUND(percentage, 1) AS Rounded_Percentage FROM Results;

🔹 2. SQL Joins (With Examples)

A JOIN combines rows from multiple tables based on a common key.

Let’s assume Mahveen Project has these tables:

Students

student_id	name	age
1	Rahul	20
2	Anjali	22
3	Kiran	21

Courses

course_id	course_name	student_id
101	Java	1
102	DBMS	2
103	Python	4
🟢 2.1 INNER JOIN

Returns rows where match exists in both tables.

SELECT s.name, c.course_name
FROM Students s
INNER JOIN Courses c ON s.student_id = c.student_id;


✅ Output:

name	course_name
Rahul	Java
Anjali	DBMS
🟢 2.2 LEFT JOIN

Returns all rows from Students + matching rows from Courses.

SELECT s.name, c.course_name
FROM Students s
LEFT JOIN Courses c ON s.student_id = c.student_id;


✅ Output:

name	course_name
Rahul	Java
Anjali	DBMS
Kiran	NULL
🟢 2.3 RIGHT JOIN

Returns all rows from Courses + matching rows from Students.

SELECT s.name, c.course_name
FROM Students s
RIGHT JOIN Courses c ON s.student_id = c.student_id;


✅ Output:

name	course_name
Rahul	Java
Anjali	DBMS
NULL	Python
🟢 2.4 FULL OUTER JOIN

Returns all rows from both tables (matches + non-matches).
(Some databases like MySQL simulate FULL JOIN using UNION)

SELECT s.name, c.course_name
FROM Students s
LEFT JOIN Courses c ON s.student_id = c.student_id
UNION
SELECT s.name, c.course_name
FROM Students s
RIGHT JOIN Courses c ON s.student_id = c.student_id;


✅ Output:

name	course_name
Rahul	Java
Anjali	DBMS
Kiran	NULL
NULL	Python
🟢 2.5 SELF JOIN

Joins a table with itself.

SELECT A.name AS Student1, B.name AS Student2
FROM Students A, Students B
WHERE A.age = B.age AND A.student_id <> B.student_id;


✅ Output:

Student1	Student2
Rahul	Kiran
🔹 3. Mahveen Project – Real-Time Example

Project Goal: Build a Student Management System to track students, courses, teachers, and results.

Tables Used:

Students(student_id, name, age, grade)

Teachers(teacher_id, name, subject)

Courses(course_id, course_name, student_id, teacher_id)

Results(result_id, student_id, marks, percentage, exam_date)

✅ Real-Time Queries in Mahveen Project

Functions Example

Find average marks of students:

SELECT AVG(marks) FROM Results;


Get full name of teachers in uppercase:

SELECT UPPER(CONCAT(first_name,' ',last_name)) FROM Teachers;


Joins Example

List all students with their course and teacher:

SELECT s.name AS Student, c.course_name, t.name AS Teacher
FROM Students s
INNER JOIN Courses c ON s.student_id = c.student_id
INNER JOIN Teachers t ON c.teacher_id = t.teacher_id;


Show all students with their exam result (even if missing):

SELECT s.name, r.percentage
FROM Students s
LEFT JOIN Results r ON s.student_id = r.student_id;

Mahveen Project – Student Management System
🔹 1. Project Introduction

The Mahveen Project is a Student Management System that helps schools, colleges, or training institutes manage students, courses, teachers, and exam results in a structured way.

It uses:

Database (MySQL/SQL Server/Oracle) → to store all information.

Backend (Java/Node.js/Python etc.) → to handle business logic.

Frontend (HTML/CSS/JS/React etc.) → to allow teachers & students to interact.

✅ Main Goal: Reduce manual work and maintain accurate records for students & their academics.

🔹 2. Project Objectives

Maintain student details (name, age, contact, grade).

Assign students to different courses.

Assign teachers to courses.

Store exam results of students.

Generate useful reports (average marks, top scorers, attendance, etc.).

Ensure data consistency using SQL functions and joins.

🔹 3. Database Design (ERD)
Tables:

Students

student_id (PK)

first_name

last_name

age

grade

Teachers

teacher_id (PK)

name

subject

Courses

course_id (PK)

course_name

student_id (FK → Students)

teacher_id (FK → Teachers)

Results

result_id (PK)

student_id (FK → Students)

marks

percentage

exam_date

🔹 4. Features
🟢 Student Module

Add new students

Update student details

View all students

🟢 Teacher Module

Add teachers

Assign teachers to courses

🟢 Course Module

Register students to courses

View student-course-teacher mapping

🟢 Result Module

Store marks & calculate percentage

Find top student per subject

Track improvement