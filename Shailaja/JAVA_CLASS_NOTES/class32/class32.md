JDBC Core Concepts
Loading the JDBC Driver
java
Copy
Edit
Class.forName("com.mysql.cj.jdbc.Driver");
Loads the JDBC driver class into heap memory.

Typically executed within a try-catch block or a Static Initialization Block (SIB).

Essential for initializing the MySQL JDBC driver and enabling subsequent database connectivity.

Driver Classes
Provided by vendors such as MySQL and Oracle.

Facilitate connection between Java applications and relational databases.

Establishing a Database Connection
java
Copy
Edit
Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
Initiates a session with the database.

Promotes loose coupling between application code and the database.

Preparing and Executing SQL Queries
java
Copy
Edit
PreparedStatement pstmt = con.prepareStatement("INSERT INTO table VALUES (?, ?)");
pstmt.setString(1, "Sowmya");
pstmt.setInt(2, 20);
Uses parameterized queries to ensure safety and maintainability.

Helps in preventing SQL Injection and simplifies dynamic query generation.

JDBC Interfaces Overview
Interface	Description
Driver	Interface for JDBC drivers (e.g., MySQL, Oracle)
Connection	Manages the session with the database
Statement	Used for executing static SQL statements
PreparedStatement	Used for executing parameterized SQL queries
CallableStatement	Executes stored procedures
ResultSet	Stores results returned by SQL queries
ResultSetMetaData	Provides metadata about columns in a ResultSet
DatabaseMetaData	Provides metadata about the database structure
SQLException	Handles SQL-related exceptions

Web Application Architecture
Request Flow:

pgsql
Copy
Edit
HTML Form → Servlet → DAO Class (Insert/Update/Delete in DB)
HTML Form ← Servlet ← DAO Class (Read from DB)
Servlets: Handle incoming HTTP requests and route the logic.

DAO (Data Access Object): Encapsulates all JDBC code to interact with the database, maintaining a clean separation between business logic and data access.

Importance of DAO in JDBC
DAO (Data Access Object) is a structural design pattern that abstracts and encapsulates all access to the data source.

Responsibilities of DAO in JDBC:
Establishing a connection with the database.

Executing CRUD operations (Create, Read, Update, Delete).

Mapping data between Java objects and database records.

Advantages:
Promotes code maintainability and readability.

Facilitates Separation of Concerns (SoC) between data handling and business logic.

SOLID Principles in Java
Principle	Description	Example
SRP (Single Responsibility)	Each class should have only one responsibility	Separate DAO and Service logic
OCP (Open/Closed)	Classes should be open for extension, but closed for modification	Extend functionality using interfaces
LSP (Liskov Substitution)	Subclasses must replace parent classes without breaking functionality	Valid subclass usage (e.g., Bird vs. Ostrich)
ISP (Interface Segregation)	Clients should not be forced to depend on unused interfaces	Split interfaces based on specific behavior (Print, Scan)
DIP (Dependency Inversion)	Depend on abstractions, not concrete implementations	Use interfaces instead of concrete classes

Database Normalization
Normalization is the process of organizing data to reduce redundancy and improve data integrity.

First Normal Form (1NF)
Ensure atomic values (no multi-valued columns).

Eliminate repeating groups.

Before 1NF:

ID	Name	Subject
1	Sowmy	Maths, Science

After 1NF:

ID	Name	Subject
1	Sowmy	Maths
1	Sowmy	Science

Second Normal Form (2NF)
Must be in 1NF.

Non-key attributes must depend on the full primary key.

Before 2NF:

StudentID	SubjectID	StudentName
101	M01	Ramya

After 2NF:
Student Table

StudentID	StudentName
101	Ramya

StudentDetails Table

StudentID	SubjectID
101	M01

Third Normal Form (3NF)
Must be in 2NF.

No transitive dependencies (non-key → non-key).

Before 3NF:

EmpID	EmpName	DeptID	DeptName
1	Sam	D1	HR

After 3NF:
Employees Table

EmpID	EmpName	DeptID
1	Sam	D1

Departments Table

DeptID	DeptName
D1	HR

Boyce-Codd Normal Form (BCNF)
Must be in 3NF.

Every determinant must be a super key.

Example Problem:
If Room → Teacher and Teacher → Subject, but Room is not a super key, then it's not in BCNF.

Solution:
Split the table to ensure all dependencies follow BCNF rules.

SQL Injection: Definition and Prevention
What is SQL Injection?
SQL Injection is a type of cyber-attack in which malicious SQL statements are inserted into input fields, aiming to manipulate the backend database.

Dangers:
Unauthorized data access

Data deletion or corruption

Total database compromise

Example:
sql
Copy
Edit
SELECT * FROM users WHERE username = '' OR '1'='1'
Prevention Techniques:
Use PreparedStatement with parameterized queries.

Validate and sanitize user inputs.

Limit database privileges for web-access roles.

MySQL Workbench – Setup Guide
Download:
Official site: https://dev.mysql.com/downloads/workbench

Purpose:
Graphical interface to manage databases.

Used for writing, executing, and debugging SQL queries.

MySQL Database & Tables for Application
Create Database
sql
Copy
Edit
CREATE DATABASE tekgrads;
USE tekgrads;
SHOW DATABASES;
Create Tables
employee Table:

sql
Copy
Edit
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    salary DOUBLE,
    city VARCHAR(100),
    profession VARCHAR(100),
    project VARCHAR(100)
);
employee_tasks Table:

sql
Copy
Edit
CREATE TABLE employee_tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    task VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);
View Data
sql
Copy
Edit
SELECT * FROM employee;
SELECT * FROM employee_tasks;
URL Routing and Navigation Summary
Add Employee:
URL: /AddEmployee.jsp
Submits form data via AddEmployeeServlet.

Edit Employee:
URL: /UpdateEmployeeServlet?id=1
Fetches existing record, allows editing, and updates via POST.

Delete Employee:
URL: /DeleteEmployeeServlet?id=1
Performs record deletion, then redirects to display page.

Display Employees:
URL: /DisplayEmployeeServlet
Shows all employee records using DisplayEmployees.jsp.