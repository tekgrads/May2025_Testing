# 🛡️ SQL Injection & Importance of PreparedStatement in Java

---

## 💥 What is SQL Injection?

**SQL Injection** is a **security vulnerability** that allows an attacker to interfere with the queries an application makes to its database.

It occurs when **user input is directly embedded into an SQL query**, enabling attackers to manipulate the SQL logic and gain unauthorized access or modify the database.

---

## ⚠️ Example of SQL Injection

### 🔻 Java Code using `Statement` Interface (VULNERABLE):

```java
String user = request.getParameter("username");
String pass = request.getParameter("password");

Statement stmt = conn.createStatement();
String query = "SELECT * FROM users WHERE username = '" + user + "' AND password = '" + pass + "'";
ResultSet rs = stmt.executeQuery(query);
```

### 🧨 Malicious Input:

```text
username: admin
password: ' OR '1'='1
```

### 🔍 Final Query:

```sql
SELECT * FROM users WHERE username = 'admin' AND password = '' OR '1'='1';
```

- The condition `'1'='1'` always evaluates to true.
- As a result, **attackers bypass authentication** and login as any user.

---

## 🛑 Dangers of SQL Injection:

- Unauthorized data access
- Data manipulation (INSERT, UPDATE, DELETE)
- Data leakage
- Dropping tables or databases (`DROP TABLE users;`)
- Server compromise

---

## ✅ How to Prevent SQL Injection?

Use **PreparedStatement** instead of Statement.

---

## 🔐 PreparedStatement Example (SAFE):

```java
String user = request.getParameter("username");
String pass = request.getParameter("password");

String query = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement pstmt = conn.prepareStatement(query);
pstmt.setString(1, user);
pstmt.setString(2, pass);

ResultSet rs = pstmt.executeQuery();
```

- `?` are placeholders (also called **parameter markers**)
- Input values are **automatically escaped and sanitized**
- Prevents attackers from injecting SQL code

---

## ⚙️ How PreparedStatement Prevents SQL Injection

| Feature                    | `Statement` Interface      | `PreparedStatement`           |
|----------------------------|----------------------------|-------------------------------|
| User input concatenated?   | ✅ Yes                     | ❌ No                          |
| Query parsed once?         | ❌ Every time              | ✅ Precompiled                 |
| Prevents SQL Injection?    | ❌ Vulnerable              | ✅ Safe                        |
| Better performance?        | ❌                         | ✅ Yes, for repeated queries   |

---

## 🧠 Summary

| Point                              | PreparedStatement Benefit               |
|------------------------------------|-----------------------------------------|
| Prevents SQL Injection             | ✅ Escapes special characters            |
| Improves performance               | ✅ Caches query plan                     |
| Easier to read and maintain        | ✅ Clear separation of query & data      |
| No need for manual input escaping  | ✅ Handled internally                    |

---

> 🛡️ **Always use `PreparedStatement` to write secure, robust, and injection-proof SQL code.**
