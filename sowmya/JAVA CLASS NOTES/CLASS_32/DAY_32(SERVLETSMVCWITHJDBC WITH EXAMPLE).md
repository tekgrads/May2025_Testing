
---

## 🔌 JDBC Core Concepts

### Loading the Driver

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

* Loads the JDBC driver into heap memory.
* Must be used inside a try-catch or Static Initialization Block (SIB).

### Driver Classes

* Provided by vendors like **MySQL**, **Oracle**.
* Used to connect and insert data into the database.

### Connecting to the Database

```java
Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
```

* Establishes a connection.
* Promotes **loose coupling**.

### Preparing SQL Queries

```java
PreparedStatement pstmt = con.prepareStatement("INSERT INTO table VALUES (?, ?)");
pstmt.setString(1, "Sowmya");
pstmt.setInt(2, 20);
```

* Safer, cleaner, and prevents SQL Injection.

---

## 🔄 JDBC Interfaces Summary

| Interface             | Description                            |
| --------------------- | -------------------------------------- |
| **Driver**            | Interface for DB drivers (e.g., MySQL) |
| **Connection**        | DB session handler                     |
| **Statement**         | Executes basic SQL queries             |
| **PreparedStatement** | Executes parameterized queries         |
| **CallableStatement** | Calls stored procedures                |
| **ResultSet**         | Represents SQL query results           |
| **ResultSetMetaData** | Info about `ResultSet` columns         |
| **DatabaseMetaData**  | Info about the database structure      |
| **SQLException**      | Handles SQL-related errors             |

---

## 🌐 Web Application Flow

```text
HTML Form → Servlet → DAO Class (Save Data to DB)
HTML Form ← Servlet ← DAO Class (Retrieve Data)
```

* **Servlet** handles requests.
* **DAO** encapsulates database operations.
here each have there own responsibility.



### DAO use in JDBC

DAO (Data Access Object) is a design pattern used in Java to separate the database access code from the rest of the application logic.

In JDBC, the DAO is a Java class that:

* Connects to the database
* Performs operations like INSERT, SELECT, UPDATE, DELETE
* Handles the data transfer between the database and Java objects

### Purpose

* Makes code cleaner and easier to maintain
* Promotes separation of concerns (database logic is separate from business logic)

---

## SOLID Principles

1. **S – Single Responsibility Principle (SRP)**
   A class should have only one reason to change, meaning it should have only one job.

2. **O – Open/Closed Principle (OCP)**
   A class should be open for extension but closed for modification.

3. **L – Liskov Substitution Principle (LSP)**
   Subclasses should be usable in place of their parent class without errors.

4. **I – Interface Segregation Principle (ISP)**
   A class should not be forced to implement methods it doesn’t use.

5. **D – Dependency Inversion Principle (DIP)**
   High-level classes should not depend on low-level classes. Both should depend on abstractions (interfaces).

### Summary Table

| Principle | Definition                                 | Simple Example                                  |
| --------- | ------------------------------------------ | ----------------------------------------------- |
| **SRP**   | One class = One job                        | Separate data and printing classes              |
| **OCP**   | Extend without changing existing code      | Add new shape classes without editing old ones  |
| **LSP**   | Subclasses replace parent without breaking | Parrot is a Bird; Ostrich can't fly = wrong use |
| **ISP**   | Don’t force unused methods                 | Separate interfaces for print, scan, fax        |
| **DIP**   | Depend on interfaces, not concrete classes | Computer depends on `Keyboard` interface        |

---

## Normalization:

Normalization is the process of organizing data in a database to remove duplicate data and ensure data is stored efficiently.

### Why Normalization?

* Avoid data redundancy (no repeating data)
* Ensure data consistency
* Make database easier to maintain and update

---

## 1NF – First Normal Form

A table is in 1NF if:

* All columns have atomic (single) values
* No repeating groups

**Not in 1NF:**

| ID | Name  | Subject        |
| -- | ----- | -------------- |
| 1  | Sowmy | Maths, Science |

**In 1NF:**

| ID | Name  | Subject |
| -- | ----- | ------- |
| 1  | Sowmy | Maths   |
| 1  | Sowmy | Science |

---

## 2NF – Second Normal Form

* Table must be in 1NF
* Every non-key column should depend on the whole primary key

**Not in 2NF:**

| StudentID | SubjectID | StudentName |
| --------- | --------- | ----------- |
| 101       | M01       | Ramya       |

**In 2NF:**

**Student Table:**

| StudentID | StudentName |
| --------- | ----------- |
| 101       | Ramya       |

**Student Details Table:**

| StudentID | SubjectID |
| --------- | --------- |
| 101       | M01       |

---

## 3NF – Third Normal Form

* Table must be in 2NF
* No indirect dependencies (non-key → non-key)

**Not in 3NF:**

| EmpID | EmpName | DeptID | DeptName |
| ----- | ------- | ------ | -------- |
| 1     | Sam     | D1     | HR       |

**In 3NF:**

**Employees Table:**

| EmpID | EmpName | DeptID |
| ----- | ------- | ------ |
| 1     | Sam     | D1     |

**Departments Table:**

| DeptID | DeptName |
| ------ | -------- |
| D1     | HR       |

---

## BCNF – Boyce-Codd Normal Form

* Table is in 3NF
* Every determinant must be a super key

**Example:**
Say, one room has only one teacher, and one teacher teaches only one subject.
But Room → Teacher, Teacher → Subject, but Room is not a super key.

**Solution:** Break the table to remove dependency problems.

---

## SQL Injection – Simple Definition

SQL Injection is a method used by attackers to insert harmful SQL commands into a database query through user input fields (like forms),
to access or damage data stored in a DBMS.

### Simplified Meaning:

An attacker "injects" fake SQL code into a website’s input box to trick the database into running unwanted actions — like logging in without a password or deleting important data.

### Why It's Dangerous:

* Can leak private data
* Can delete or change records
* May even crash the database

### To Prevent sql injection:

* Use prepared statements (parameterized queries)
* Validate and sanitize all user inputs
* Limit database permissions for web users





## 📥 Download MySQL Workbench

* Official link: [https://dev.mysql.com/downloads/workbench/](https://dev.mysql.com/downloads/workbench/)
* Download the **MSI installer** for Windows.
* Workbench is used for writing and executing SQL queries.

---

## 💻 Java DAO Example – Employee details

### `Employee.java`

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

### `EmployeeDAO.java`

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

---


## 🔗 MySQL Workbench

* [Download MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
* Use MySQL Workbench to manage your MySQL database and execute queries.

---

## 📁 File: `EmployeeService.java`

Handles all employee operations by delegating to the DAO layer.

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

## 📝 File: `AddEmployee.jsp`

A form to collect employee details from the user.

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

## 🌐 `AddEmployeeServlet.java`

Handles form submission and saves data using the service layer.

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

## 🔗 URL:

```
http://localhost:8080/ServletMVCWITHJDBC/AddEmployee.jsp
```

After submission, the user will be redirected to `DisplayEmployee.jsp`, which displays all employee data with **edit** and **delete** options.


## 📄 `DisplayEmployee.jsp`

This JSP page shows a list of employees and provides Edit/Delete options.

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

## ☕ `DisplayEmployeeServlet.java`

Fetches employee data from the database and forwards it to `DisplayEmployee.jsp`.

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





## 📄 `editEmployee.jsp`

Form to update existing employee details.

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

## ☕ `UpdateEmployeeServlet.java`

Servlet that handles both loading the form and processing the update.

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

## 🔗 URL Navigation

```
http://localhost:8080/ServletMVCWITHJDBC/DisplayEmployeeServlet
```

### ➕ Add Employee

* Takes you to `AddEmployee.jsp` to enter a new employee.

### ✏️ Edit

* Loads selected employee into `editEmployee.jsp`.

### ❌ Delete

* Removes the corresponding employee record.

---

url for update
```
http://localhost:8080/ServletMVCWITHJDBC/UpdateEmployeeServlet?id=1
```

here you edit and update button the form it will redirect to DisplayEmployeeServlet page



url for delete

```
http://localhost:8080/ServletMVCWITHJDBC/DisplayEmployeeServlet
click on delete link it will deletes the details of the student
```




## 🛠️ MySQL Workbench Setup – cretae Tekgrads Database

### ✅ Instructions

1. Open **MySQL Workbench**.
2. Execute the following SQL commands to create the database and tables.
3. These tables will be used in your JSP + Servlet + JDBC project.

---

## 📦 Create Database

```sql
CREATE DATABASE tekgrads;
USE tekgrads;
SHOW DATABASES;
```

---

## 🧾 Create Tables

### `employee`

```sql
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    salary DOUBLE,
    city VARCHAR(100),
    profession VARCHAR(100),
    project VARCHAR(100)
);
```

### `employee_tasks`

```sql
CREATE TABLE employee_tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    task VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);
```

---

## 🔍 View Data

```sql
SELECT * FROM employee;
SELECT * FROM employee_tasks;
```

---

## 🌐 Integration with URL

Use servlets to perform **insert**, **update**, and **delete** operations via form submissions in your web app. When a user submits a form:

* Data is sent to the servlet using POST or GET.
* Servlet performs the operation using JDBC.
* Changes reflect immediately in MySQL Workbench.

---

