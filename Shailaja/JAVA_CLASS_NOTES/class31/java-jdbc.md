Database and Servlet Integration Notes
Database Table
A table stores data in rows and columns.

Rows (Records): Represent individual entries.

Columns (Fields): Represent attributes (e.g., eid, ename, sal, did).

Primary Key
Uniquely identifies each row.

Must be unique and non-null.

Foreign Key
Links one table to another using a primary key from the referenced table.

Maintains relational integrity.

DBMS (Database Management System)
Software that manages structured data.

Supports CRUD operations (Create, Read, Update, Delete).

Examples: Oracle, MySQL, PostgreSQL.

HTML Form (HtmlTags.html)
html
Copy
Edit
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
Java Servlet (MultiParamServlet.java)
java
Copy
Edit
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
Access Form
URL: http://localhost:8080/FirstServlet/HtmlTags.html

Output Example
yaml
Copy
Edit
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
MySQL Setup
Download MySQL
Link: https://dev.mysql.com/downloads/mysql/8.0.html
Select version 9.3.0 Innovation → 64-bit MSI Installer

Download JDBC Driver
Link: https://dev.mysql.com/downloads/connector/j/
Download Platform Independent ZIP → Extract → Copy .jar to:

markdown
Copy
Edit
YourProject/
└── WEB-INF/
    └── lib/
        └── mysql-connector-java-<version>.jar
JDBC Core Interfaces
Interface	Purpose
Connection	Establish connection to DB
Statement	Execute static SQL queries
PreparedStatement	Execute parameterized SQL safely
DriverManager	Manages drivers for various DBs

JDBC Connection Code Snippets
Load Driver Class
java
Copy
Edit
Class.forName("com.mysql.cj.jdbc.Driver");
Establish Connection
java
Copy
Edit
Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
Using PreparedStatement
java
Copy
Edit
PreparedStatement pstmt = con.prepareStatement("INSERT INTO table_name VALUES (?, ?)");
pstmt.setString(1, "John");
pstmt.setInt(2, 25);
pstmt.executeUpdate();