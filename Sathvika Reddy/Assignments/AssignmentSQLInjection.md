# Prepare Notes on SQL injection with example and the importance of Prepared Statement over Statement interface in dealing with SQL Injection


# SQL Injection and Importance of PreparedStatement over Statement

## What is SQL Injection?

SQL Injection is a type of security vulnerability where an attacker can modify or tamper with the SQL queries made by a web application by injecting malicious SQL code through user input fields. This can lead to unauthorized access, data leakage, or destruction of data in the database. It is one of the most common and dangerous web security exploits[1][2][3].

### Example of SQL Injection

Suppose you have this Java code for login in a Student Management System:

java
String user = request.getParameter("username");
String pass = request.getParameter("password");

String query = "SELECT * FROM students WHERE username='" + user + "' AND password='" + pass + "'";
ResultSet rs = statement.executeQuery(query);


If a user enters the following as the password:


' OR '1'='1


The SQL query becomes:


SELECT * FROM students WHERE username='anyvalue' AND password='' OR '1'='1'


Since 1=1 is always true, the attacker can log in without knowing the actual password. In some cases, attackers can inject code to read, update, or even delete data.

## How PreparedStatement Prevents SQL Injection:

*PreparedStatement* (or parameterized query) is an interface in Java (and similar concepts exist for other languages) that lets you separate SQL code from the input data. Instead of inserting user input directly into a query, you use placeholders and provide the data separately, which the database engine will treat strictly as data, not code[5][6][4]:

java
String query = "SELECT * FROM students WHERE username = ? AND password = ?";
PreparedStatement pstmt = connection.prepareStatement(query);
pstmt.setString(1, user);
pstmt.setString(2, pass);
ResultSet rs = pstmt.executeQuery();


In this approach, even if an attacker tries to inject SQL code as input, it will just be treated as a regular string—*not* as part of the SQL command—so the attack fails.

## Key Differences: Statement vs PreparedStatement for Security:

| Feature                           | Statement                   | PreparedStatement         |
|------------------------------------|-----------------------------|--------------------------|
| SQL Creation                      | SQL concatenated with input | Uses parameter placeholders |
| Input Handling                    | Treated as code (loophole)  | Always treated as raw data |
| Resistance to SQL Injection        | Unsafe (easily bypassed)    | Safe (input never executes as code) |
| Code Example                      | ...WHERE col='" + x + "'  | ...WHERE col=?          |
| Efficiency on Repeated Queries    | No advantage                | Query plan reused         |

## Why Use PreparedStatement? 

- *Prevents SQL Injection:* Segregates SQL logic from user input so attacker input cannot alter the structure of queries.
- *Improves Code Readability:* Easier to read and maintain compared to complex string concatenations.
- *Performance Benefits:* Query plans can be reused by the DBMS for repeated operations.

