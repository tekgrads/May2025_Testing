SQL Injection

## 1. What is SQL Injection?
**SQL Injection (SQLi)** is a type of **security vulnerability** where an attacker inserts or "injects" malicious SQL code into a query, allowing them to:
- Access unauthorized data
- Modify or delete data
- Bypass authentication
- Execute administrative operations on the database

It usually occurs when **user input is directly included** in SQL queries **without proper validation or sanitization**.

---

## 2. Example of SQL Injection

### ❌ Vulnerable Code
```java
String username = request.getParameter("username");
String password = request.getParameter("password");

String query = "SELECT * FROM users WHERE username = '" + username +
               "' AND password = '" + password + "'";

ResultSet rs = statement.executeQuery(query);
If a user enters:

pgsql
Copy
Edit
username: admin
password: ' OR '1'='1
The SQL query becomes:

sql
Copy
Edit
SELECT * FROM users WHERE username = 'admin' AND password = '' OR '1'='1'
Since '1'='1' is always true, the attacker can bypass login.

3. Types of SQL Injection
In-band SQLi – Attacker uses the same communication channel to launch the attack and gather results.

Error-based SQLi: Uses database error messages to get information.

Union-based SQLi: Combines results from multiple queries using UNION.

Blind SQLi – Results are not visible directly; attacker asks true/false questions to extract data.

Boolean-based Blind SQLi: Changes in page content indicate true/false.

Time-based Blind SQLi: Uses database delays (e.g., SLEEP(5)) to infer data.

Out-of-band SQLi – Uses different channels (like DNS or HTTP requests) to send data.

4. Prevention Methods
✅ Use Prepared Statements (Parameterized Queries)
java
Copy
Edit
String query = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement pstmt = connection.prepareStatement(query);
pstmt.setString(1, username);
pstmt.setString(2, password);
ResultSet rs = pstmt.executeQuery();
✅ Use Stored Procedures
Encapsulate queries in the database and only pass parameters.

✅ Input Validation & Sanitization
Reject unexpected characters (like ', --, ;).

Use whitelists for allowed values.

✅ Limit Database Privileges
Use least privilege principle — the application’s DB user should have minimal rights.

✅ Use ORM (Object Relational Mapping) Tools
Frameworks like Hibernate, JPA, etc., abstract raw SQL queries.

5. Summary Table
Aspect	Details
Definition	Exploiting user input to manipulate SQL queries
Risk	Data theft, modification, deletion, authentication bypass
Types	In-band, Blind, Out-of-band
Prevention	Prepared statements, stored procedures, validation, least privilege

