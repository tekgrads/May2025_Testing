# 📘 JDBC with JSP & Servlets

## 🔹 What is JDBC?
**JDBC (Java Database Connectivity)** is an API that allows Java applications to **connect and interact with databases** (like MySQL, Oracle, PostgreSQL, etc.).  

### ✅ Steps in JDBC:
1. Load the JDBC driver  
2. Establish a connection with the database  
3. Create a `Statement` or `PreparedStatement`  
4. Execute queries (`SELECT`, `INSERT`, `UPDATE`, `DELETE`)  
5. Process the results  
6. Close the connection  

---

# 🏗 Real-Time Example: Student Registration System

We will build a **JSP + Servlet + JDBC** application:  
- **Model** → Student (JavaBean)  
- **Controller** → Servlet to handle requests  
- **View** → JSP pages for input/output  
- **Database** → MySQL `studentdb`  

---

## 🔹 1. Database Setup (MySQL)
```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);
```

---

## 🔹 2. Model (Student.java)
```java
// model/Student.java
package model;

public class Student {
    private int id;
    private String name;
    private String email;

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

---

## 🔹 3. JDBC Utility (DBUtil.java)
```java
// util/DBUtil.java
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "your_password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
```

---

## 🔹 4. Controller (StudentServlet.java)
```java
// controller/StudentServlet.java
package controller;

import model.Student;
import util.DBUtil;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("student");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
        dispatcher.forward(request, response);
    }
}
```

---

## 🔹 5. View - JSP Pages

### (a) Input Form (studentForm.jsp)
```jsp
<!-- studentForm.jsp -->
<html>
<head><title>Student Form</title></head>
<body>
    <h2>Register Student</h2>
    <form action="student" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        <input type="submit" value="Register">
    </form>
    <a href="student">View Students</a>
</body>
</html>
```

---

### (b) Student List Page (studentList.jsp)
```jsp
<!-- studentList.jsp -->
<%@ page import="java.util.List, model.Student" %>
<html>
<head><title>Student List</title></head>
<body>
    <h2>All Students</h2>
    <table border="1" cellpadding="5">
        <tr><th>ID</th><th>Name</th><th>Email</th></tr>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            for (Student s : students) {
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
            </tr>
        <% } %>
    </table>
    <br><a href="studentForm.jsp">Add New Student</a>
</body>
</html>
```

---

## 🔹 6. web.xml (if not using annotation)
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="3.1">
    <servlet>
        <servlet-name>StudentServlet</servlet-name>
        <servlet-class>controller.StudentServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>StudentServlet</servlet-name>
        <url-pattern>/student</url-pattern>
    </servlet-mapping>
</web-app>
```

---

# ✅ Workflow
1. User opens `studentForm.jsp` → fills form  
2. Form is submitted to **Servlet (`/student`)**  
3. Servlet inserts data into MySQL using **JDBC**  
4. Servlet fetches all students and forwards to `studentList.jsp`  
5. `studentList.jsp` displays all student records  

---

# 📌 Output

### Form Page (`studentForm.jsp`)
```
Register Student
Name: [____]
Email: [____]
[Register Button]
```

### List Page (`studentList.jsp`)
```
All Students
----------------------------------
ID   |   Name       |   Email
1    |   Laxmi      |   laxmi@mail.com
2    |   Pam        |   pam@mail.com
```

---

# ⚡ Advantages of JDBC with JSP & Servlets
- Direct connection between **Java Web App** and **Database**  
- Clear separation of **Model (JavaBean)**, **View (JSP)**, **Controller (Servlet)**  
- Easy to scale for **CRUD operations** (Create, Read, Update, Delete)  
