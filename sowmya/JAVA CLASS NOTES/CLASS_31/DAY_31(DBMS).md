# Database and Servlet Example – Markdown for Git

---

## 📘 Database Table

A table in a database is a structured way to store data in **rows** and **columns**, like a spreadsheet.

* **Rows (Records)**: Represent individual entries.
* **Columns (Fields)**: Represent attributes of the data.

### Example Table

| eid | ename | sal | did |
| --- | ----- | --- | --- |
|     |       |     |     |

➡️ `eid`, `ename`, `sal`, `did` represent columns. Each row in the table is a complete record.

### 🔑 Primary Key
*by using the key we can retirve the data because it is unique.
* Uniquely identifies each row.
* Cannot be null.
* Must be unique.

### 🔗 Foreign Key

* Links one table to another using the primary key of the referenced table.
* Maintains relational integrity.

---

## 💾 What is DBMS?

**DBMS (Database Management System)** is software that helps you **store**, **manage**, and **access** structured data.

### Key Features:

* Create, Read, Update, Delete (CRUD) operations
* Data stored in tables
* Ensures **security**, **consistency**, and **integrity**

### Examples of RelationDBMS:

* Oracle
* MySQL
* PostgreSQL
note:these have proper structres and having rules.

---

## 🌐 HTML Form Example (HtmlTags.html)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details Form</title>
</head>
<body>
    <h1>Employee Form</h1>
    <form method="post" action="MultiParamServlet">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" step="0.01" required><br><br>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br><br>

        <label>Profession:</label><br>
        <input type="radio" id="developer" name="prof" value="Developer" required>
        <label for="developer">Developer</label>
        <input type="radio" id="architect" name="prof" value="Architect">
        <label for="architect">Architect</label><br><br>

        <label for="project">Select Project:</label>
        <select id="project" name="project" required>
            <option value="Project 1">Project 1</option>
            <option value="Project 2">Project 2</option>
            <option value="Project 3">Project 3</option>
            <option value="Project 4">Project 4</option>
        </select><br><br>

        <label for="tasks">Select Tasks:</label>
        <select id="tasks" name="tasks" multiple>
            <option value="Task 1">Task 1</option>
            <option value="Task 2">Task 2</option>
            <option value="Task 3">Task 3</option>
            <option value="Task 4">Task 4</option>
        </select><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
```

---

## ☕ Java Servlet: MultiParamServlet.java

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MultiParamServlet")
public class MultiParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MultiParamServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String salary = request.getParameter("salary");
        String city = request.getParameter("city");
        String prof = request.getParameter("prof");
        String project = request.getParameter("project");
        String[] tasks = request.getParameterValues("tasks");

        response.getWriter().println("<h2>User Details</h2>");
        response.getWriter().println("<p><b>Name:</b> " + name + "</p>");
        response.getWriter().println("<p><b>Age:</b> " + age + "</p>");
        response.getWriter().println("<p><b>Salary:</b> " + salary + "</p>");
        response.getWriter().println("<p><b>City:</b> " + city + "</p>");
        response.getWriter().println("<p><b>Profession:</b> " + prof + "</p>");
        response.getWriter().println("<p><b>Selected Project:</b> " + project + "</p>");

        response.getWriter().println("<p><b>Assigned Tasks:</b></p>");
        if (tasks != null && tasks.length > 0) {
            response.getWriter().println("<ul>");
            for (String task : tasks) {
                response.getWriter().println("<li>" + task + "</li>");
            }
            response.getWriter().println("</ul>");
        } else {
            response.getWriter().println("<p>No tasks selected.</p>");
        }

        response.getWriter().println("</body></html>");
    }
}
```

---

## 🔗 URL to Access Form

```
http://localhost:8080/FirstServlet/HtmlTags.html
```

---

## 🖥️ Output

```
User Details
Name: sowmya
Age: 20
Salary: 30000
City: hyderabad
Profession: Developer
Selected Project: Project 3
Assigned Tasks:
 - Task 1
 - Task 2
 - Task 3
```

➡️ After submitting the form, it goes to the servlet and prints the details on the response page.



---

## 🔽 Download MySQL 64-bit for Windows

➡️ Go to the official MySQL website:

[https://dev.mysql.com/downloads/mysql/8.0.html](https://dev.mysql.com/downloads/mysql/8.0.html)

* Select **version 9.3.0 Innovation**
* Download the **64-bit MSI Installer**

---

## 🔌 JDBC Interfaces in Core Java

Java provides a set of **interfaces** to interact with databases. These interfaces are part of the **JDBC API** and allow Java applications to communicate with relational databases like MySQL.

### Key JDBC Interfaces:

1. `Connection` Interface
2. `Statement` Interface
3. `PreparedStatement` Interface

> ✅ These interfaces are implemented by the **database driver classes**, specific to each database system (e.g., MySQL, Oracle, PostgreSQL).

We **interact with these interfaces**, call their methods, but the actual logic is provided by the **JDBC driver classes**.

---

## 📦 Download JDBC Driver for MySQL

➡️ Download the **MySQL Connector/J**:

[https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)

* Select **Platform Independent** ZIP file
* Download and **extract** the ZIP archive
* Inside the extracted folder, locate the **`mysql-connector-java-<version>.jar`** file

---

## 📁 Setup in Java Web Project

1. Copy the `mysql-connector-java-<version>.jar` file
2. Paste it into your Java Web Project under:

```
YourProject/
└── WEB-INF/
    └── lib/
        └── mysql-connector-java-<version>.jar
```

✅ This allows the servlet or Java class to use MySQL JDBC APIs.

---

You're now ready to use `Connection`, `Statement`, or `PreparedStatement` interfaces to connect and operate on a MySQL database in your Java web project.




---

## 🚀 Loading the JDBC Driver Class

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

* Loads the driver class into heap memory.
* This is a **checked exception**, so it must be placed in a `try-catch` block or a **Static Initialization Block (SIB)**.

---

## 🧩 Driver Classes

* Provided by **database vendors** like MySQL, Oracle, etc.
* Once loaded, they allow us to **insert values using SQL queries**.

---

## 🔗 Connection Interface

* `Connection` interface is used to **establish a connection** with the database.
* Use:

```java
Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
```

* Makes the code **loosely coupled**, as it hides the driver implementation details.

---

## 🧾 PreparedStatement Interface

* `PreparedStatement` is used to **frame SQL queries** safely and efficiently.
* Values are set based on data types, making it less error-prone.

```java
PreparedStatement pstmt = con.prepareStatement("INSERT INTO table_name VALUES (?, ?)");
pstmt.setString(1, "John");
pstmt.setInt(2, 25);
```

* Prevents **SQL injection**.

---

## 🛠️ Summary

| Concept             | Purpose                      |
| ------------------- | ---------------------------- |
| `Class.forName`     | Load JDBC driver             |
| `Connection`        | Connect to DB                |
| `PreparedStatement` | Frame and execute SQL safely |
| `DriverManager`     | Manage DB drivers            |


