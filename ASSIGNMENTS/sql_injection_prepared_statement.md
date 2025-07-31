
# SQL Injection & Importance of PreparedStatement

## What is SQL Injection?

SQL Injection is a type of security vulnerability that occurs when untrusted user input is included in an SQL query without proper validation or escaping.

It allows attackers to:
- View sensitive data (like passwords, credit card info)
- Modify or delete data
- Bypass authentication
- Execute administrative operations on the database

## Example of SQL Injection using Statement

Consider a login form in Java using `Statement`:

```java
String userInput = "admin'; --";
String password = "anything";

Statement stmt = connection.createStatement();
String sql = "SELECT * FROM users WHERE username = '" + userInput + "' AND password = '" + password + "'";
ResultSet rs = stmt.executeQuery(sql);
```

Final Query:

```sql
SELECT * FROM users WHERE username = 'admin'; --' AND password = 'anything';
```

- The `--` turns the rest into a comment.
- The condition always becomes true.
- The attacker logs in without a valid password.

## Solution: Use PreparedStatement

Instead of directly embedding user input into the query, use placeholders (`?`) and bind values safely.

Safe Code Example:

```java
String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement pstmt = connection.prepareStatement(sql);
pstmt.setString(1, userInput);
pstmt.setString(2, password);
ResultSet rs = pstmt.executeQuery();
```

- Input is treated as data, not code.
- Prevents SQL injection automatically.

## PreparedStatement vs Statement

| Feature                     | Statement                                | PreparedStatement                          |
|-----------------------------|------------------------------------------|--------------------------------------------|
| SQL Injection Risk          | High                                     | Very Low                                   |
| Input Validation            | Needs manual escaping                    | Handled automatically                      |
| Performance                 | Parsed every time                        | Precompiled once, reused                   |
| Code Clarity                | Messy with many parameters               | Clean with `?` placeholders                |
| Security Best Practice      | Vulnerable                               | Strongly Recommended                       |

## Importance of PreparedStatement in Preventing SQL Injection

1. Escapes Special Characters Automatically  
   - Prevents attackers from injecting SQL commands.

2. Separates SQL Code and Data  
   - Makes it impossible for user input to alter the query logic.

3. Improves Performance  
   - The SQL query is compiled once and reused multiple times.

4. Reduces Developer Mistakes  
   - Less chance of manual escaping errors.


- Avoid using `Statement` with user input.
- Always use `PreparedStatement` or ORM frameworks for database operations involving user data.
- It’s a best practice for security, readability, and performance.
