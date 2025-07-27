# JDBC and its Connectivity:

---

##  JDBC:

```text
JDBC (Java Database Connectivity) is a Java API used to connect and interact with databases. 
It enables executing SQL statements from Java applications. 
JDBC provides interfaces for querying and updating data in a database. 
It supports different databases using JDBC drivers.
```

---

##  Importance of Driver Class / DriverManager:

```text
Driver class (like com.mysql.cj.jdbc.Driver) is required to register the JDBC driver with DriverManager. 
It enables the Java application to establish a connection with the database. 
DriverManager is responsible for managing multiple JDBC drivers and establishing a connection through them. 
It returns a Connection object to perform database operations.
```

---

##  SOLID Principles:

```text
1. Single Responsibility Principle – A class should have only one reason to change.
2. Open/Closed Principle – Classes should be open for extension but closed for modification.
3. Liskov Substitution Principle – Derived classes should be substitutable for their base classes.
4. Interface Segregation Principle – Do not force clients to depend on interfaces they do not use.
5. Dependency Inversion Principle – High-level modules should not depend on low-level modules; both should depend on abstractions.
```

---

##  `addemployee.jsp`

```jsp
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
```

---

##  `AddEmployeeServlet.java`

```java
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
```

---

##  `displayemployee.jsp`

```jsp
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
```

---

##  `DisplayEmployeeServlet.java`

```java
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
```

---

##  `editemployee.jsp`

```jsp
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
```

---

##  `UpdateEmployeeServlet.java`

```java
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
```

---

##  `DeleteEmployeeServlet.java`

```java
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
```

---

##  `EmployeeService.java`

```java
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
```

---

## `Employee.java`

```java
package com.tekgrads;

public class Employee {
    Integer id;
    String name;
    Integer age;
    Double salary;
    String city;
    String prof;
    String project;
    String[] tasks;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProf() { return prof; }
    public void setProf(String prof) { this.prof = prof; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }

    public String[] getTasks() { return tasks; }
    public void setTasks(String[] tasks) { this.tasks = tasks; }
}
```
---

##  `EmployeeDAO.java`

```java
package com.tekgrads;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/tekgrads";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found!");
        }
    }

    public int saveEmployee(Employee employee) {
        int employeeId = -1;
        String sql = "INSERT INTO employee (name, age, salary, city, profession, project) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, employee.getName());
            stmt.setInt(2, employee.getAge());
            stmt.setDouble(3, employee.getSalary());
            stmt.setString(4, employee.getCity());
            stmt.setString(5, employee.getProf());
            stmt.setString(6, employee.getProject());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                employeeId = rs.getInt(1);
                saveTasks(employeeId, employee.getTasks());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeId;
    }

    private void saveTasks(int employeeId, String[] tasks) {
        if (tasks == null || tasks.length == 0) return;
        String sql = "INSERT INTO employee_tasks (employee_id, task) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (String task : tasks) {
                stmt.setInt(1, employeeId);
                stmt.setString(2, task);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        Employee employee = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setCity(rs.getString("city"));
                employee.setProf(rs.getString("profession"));
                employee.setProject(rs.getString("project"));
                employee.setTasks(getTasksByEmployeeId(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> getEmployees() {
        String sql = "SELECT * FROM employee";
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setCity(rs.getString("city"));
                emp.setProf(rs.getString("profession"));
                emp.setProject(rs.getString("project"));
                emp.setTasks(getTasksByEmployeeId(emp.getId()));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String[] getTasksByEmployeeId(int id) {
        List<String> taskList = new ArrayList<>();
        String sql = "SELECT task FROM employee_tasks WHERE employee_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                taskList.add(rs.getString("task"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList.toArray(new String[0]);
    }

    public boolean updateEmployee(Employee employee) {
        boolean updated = false;
        String sql = "UPDATE employee SET name=?, age=?, salary=?, city=?, profession=?, project=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setInt(2, employee.getAge());
            stmt.setDouble(3, employee.getSalary());
            stmt.setString(4, employee.getCity());
            stmt.setString(5, employee.getProf());
            stmt.setString(6, employee.getProject());
            stmt.setInt(7, employee.getId());
            if (stmt.executeUpdate() > 0) {
                updated = true;
                updateTasks(employee.getId(), employee.getTasks());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    private void updateTasks(int id, String[] tasks) {
        String deleteSQL = "DELETE FROM employee_tasks WHERE employee_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement delStmt = conn.prepareStatement(deleteSQL)) {
            delStmt.setInt(1, id);
            delStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        saveTasks(id, tasks);
    }

    public boolean deleteEmployee(int id) {
        boolean deleted = false;
        String deleteTasksSQL = "DELETE FROM employee_tasks WHERE employee_id = ?";
        String deleteEmpSQL = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);
            try (PreparedStatement delTasks = conn.prepareStatement(deleteTasksSQL)) {
                delTasks.setInt(1, id);
                delTasks.executeUpdate();
            }
            try (PreparedStatement delEmp = conn.prepareStatement(deleteEmpSQL)) {
                delEmp.setInt(1, id);
                if (delEmp.executeUpdate() > 0) {
                    deleted = true;
                }
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
```


