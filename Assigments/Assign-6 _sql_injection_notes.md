
# SQL Injection Notes

##  What is SQL Injection?

SQL Injection is a code injection technique used by attackers to insert malicious SQL statements into input fields, aiming to manipulate or access the database.

SQL injection is a code injection technique that might destroy your database.

SQL injection is one of the most common web hacking techniques.

---

##  Example of SQL Injection

**Unsafe Java Code Using Statement Interface:**

```java
String username = request.getParameter("username");
String password = request.getParameter("password");

Statement stmt = connection.createStatement();
String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
ResultSet rs = stmt.executeQuery(query);
```

###  Malicious Input:

- `username = admin`
- `password = ' OR '1'='1`

### Resulting SQL Query:

```sql
SELECT * FROM users WHERE username = 'admin' AND password = '' OR '1'='1'
```

This condition is always true (`'1'='1'`), allowing unauthorized access.

---

##  Importance of PreparedStatement Over Statement

###  Benefits of `PreparedStatement`:

1. **Prevents SQL Injection**
   - Parameters are bound using placeholders (`?`), eliminating direct string concatenation.
2. **Automatic Escaping**
   - Special characters are escaped automatically, avoiding syntax breaks.
3. **Improved Performance**
   - Precompiled queries are efficient for repeated execution.
4. **Better Readability and Maintenance**
   - Clean syntax with parameters improves code readability.
   - Easier to debug and modify.
5.  **Reduces Syntax Errors**
   - Separates SQL logic from input data.
   - Reduces the chance of malformed queries.
6.  **Supports Type Safety**
   - Provides methods like setInt(), setString() etc., ensuring correct data types.
7.  **Secure by Default**
   - Acts as a safe practice, especially for handling user input from forms or APIs.





---

##  Secure Code Using PreparedStatement

```java
String username = request.getParameter("username");
String password = request.getParameter("password");

String query = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement pstmt = connection.prepareStatement(query);
pstmt.setString(1, username);
pstmt.setString(2, password);

ResultSet rs = pstmt.executeQuery();
```

Even if the user tries to inject SQL code, it is treated as plain text, thus protecting the database.

