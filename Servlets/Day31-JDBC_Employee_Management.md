
# JDBC and Employee Management System

## JDBC Overview

**JDBC (Java Database Connectivity)** is a Java API used to connect and interact with databases. It enables executing SQL statements from Java applications. JDBC provides interfaces for querying and updating data in a database and supports different databases using JDBC drivers.

## Importance of Driver Class / DriverManager

- **Driver Class** (e.g., `com.mysql.cj.jdbc.Driver`) is required to register the JDBC driver with DriverManager.
- **DriverManager** manages multiple JDBC drivers and establishes a connection through them.
- It returns a `Connection` object to perform database operations.

## SOLID Principles

1. **Single Responsibility Principle**  A class should have only one reason to change.
2. **Open/Closed Principle**  Classes should be open for extension but closed for modification.
3. **Liskov Substitution Principle**  Derived classes should be substitutable for their base classes.
4. **Interface Segregation Principle** Do not force clients to depend on interfaces they do not use.
5. **Dependency Inversion Principle** High-level modules should not depend on low-level modules; both should depend on abstractions.

## JSP & Servlet Files

### `addemployee.jsp`
```jsp
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!-- Form HTML omitted for brevity -->
```
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Details Form</title>
</head>
<body>
    <h1>Employee Form</h1>
    <form method="post" action="AddEmployeeServlet">
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

        <label for="tasks">Select Tasks (Hold Ctrl to select multiple):</label>
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

### `AddEmployeeServlet.java`
```java
// Servlet for handling form submission and saving employee details
```
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddEmployeeServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeService service = new EmployeeService();

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String salary = request.getParameter("salary");
        String city = request.getParameter("city");
        String prof = request.getParameter("prof");
        String project = request.getParameter("project");
        String[] tasks = request.getParameterValues("tasks");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(Integer.parseInt(age));
        employee.setSalary(Double.parseDouble(salary));
        employee.setCity(city);
        employee.setProf(prof);
        employee.setProject(project);
        employee.setTasks(tasks);

        service.addEmployee(employee);
        response.sendRedirect("DisplayEmployeeServlet");
    }
}

### `displayemployee.jsp`
```jsp
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!-- Display employee details in table -->
```
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tekgrads.Employee" %>

<html>
<head>
    <title>Employee List</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Employee List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Salary</th>
            <th>City</th>
            <th>Profession</th>
            <th>Project</th>
            <th>Tasks</th>
            <th></th>
            <th></th>
        </tr>
        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null) {
                for (Employee emp : employees) {
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getAge() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= emp.getCity() %></td>
            <td><%= emp.getProf() %></td>
            <td><%= emp.getProject() %></td>
            <td><%= String.join(", ", emp.getTasks()) %></td>
            <td><a href="UpdateEmployeeServlet?id=<%= emp.getId() %>">Edit</a></td>
            <td><a href="DeleteEmployeeServlet?id=<%= emp.getId() %>">Delete</a></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <div style="text-align: center; margin-top: 20px;">
        <a href="AddEmployee.jsp">Add Employee</a>
    </div>
</body>
</html>


### `DisplayEmployeeServlet.java`
```java
// Servlet for fetching and displaying all employees
```
package com.tekgrads;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayEmployeeServlet")
public class DisplayEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplayEmployeeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeService service = new EmployeeService();
        List<Employee> employees = service.getEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/DisplayEmployees.jsp").forward(request, response);
    }
}

### `editemployee.jsp`
```jsp
<!-- Form pre-filled with employee data for editing -->
```
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.tekgrads.Employee, java.util.*" %>
<jsp:useBean id="emp" scope="request" type="com.tekgrads.Employee" />

<h2>Edit Employee</h2>
<form action="UpdateEmployeeServlet" method="post">
    <!-- Hidden Field for Employee ID -->
    <input type="hidden" name="id" value="<%= emp.getId() %>" />

    <!-- Name -->
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= emp.getName() %>" required><br>

    <!-- Age -->
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" value="<%= emp.getAge() %>" required><br>

    <!-- Salary -->
    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" step="0.01" value="<%= emp.getSalary() %>" required><br>

    <!-- City -->
    <label for="city">City:</label>
    <input type="text" id="city" name="city" value="<%= emp.getCity() %>" required><br>

    <!-- Profession -->
    <label for="prof">Profession:</label>
    <input type="text" id="prof" name="prof" value="<%= emp.getProf() %>" required><br>

    <!-- Project -->
    <label for="project">Project:</label>
    <input type="text" id="project" name="project" value="<%= emp.getProject() %>" required><br>

    <!-- Tasks -->
    <label for="tasks">Select Tasks (Hold Ctrl to select multiple):</label>
    <select id="tasks" name="tasks" multiple>
        <%
            String[] employeeTasks = emp.getTasks();
            List<String> taskList = Arrays.asList(employeeTasks);
            String[] allTasks = {"Task 1", "Task 2", "Task 3", "Task 4"};
            for (String task : allTasks) {
                String selected = taskList.contains(task) ? "selected" : "";
        %>
        <option value="<%= task %>" <%= selected %>><%= task %></option>
        <% } %>
    </select><br><br>

    <!-- Submit Button -->
    <input type="submit" value="Update">
</form>

### `UpdateEmployeeServlet.java`
```java
// Handles fetching and updating employee details
```
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateEmployeeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        EmployeeService service = new EmployeeService();
        Employee employee = service.getEmployee(Integer.parseInt(id));
        request.setAttribute("emp", employee);
        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeService service = new EmployeeService();
        String id = request.getParameter("id");

        Employee employee = new Employee();
        employee.setId(Integer.parseInt(id));
        employee.setName(request.getParameter("name"));
        employee.setAge(Integer.parseInt(request.getParameter("age")));
        employee.setSalary(Double.parseDouble(request.getParameter("salary")));
        employee.setCity(request.getParameter("city"));
        employee.setProf(request.getParameter("prof"));
        employee.setProject(request.getParameter("project"));
        employee.setTasks(request.getParameterValues("tasks"));

        service.updateEmployee(employee);
        response.sendRedirect("DisplayEmployeeServlet");
    }
}
### `DeleteEmployeeServlet.java`
```java
// Deletes an employee record
```
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteEmployeeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeService service = new EmployeeService();
        String id = request.getParameter("id");
        service.deleteEmployee(Integer.parseInt(id));
        response.sendRedirect("DisplayEmployeeServlet");
    }
}

### EmployeeService.java
package com.tekgrads;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public int addEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    public boolean deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
