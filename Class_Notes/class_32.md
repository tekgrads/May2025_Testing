
# JDBC with JSP & Servlets 

## JDBC Core Concepts

### Loading the Driver

```java
Class.forName("com.mysql.cj.jdbc.Driver");
````

* Loads the JDBC driver into heap memory.
* Usually done inside a try-catch or Static Initialization Block (SIB).

### Driver Classes

* Provided by DB vendors like MySQL, Oracle.
* Helps Java connect and communicate with databases.

### Connecting to the Database

```java
Connection con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
```

* Establishes a connection to the database.
* Promotes loose coupling between layers.

### Preparing SQL Queries

```java
PreparedStatement pstmt = con.prepareStatement("INSERT INTO table VALUES (?, ?)");
pstmt.setString(1, "Sathvika");
pstmt.setInt(10,50);
```

* Safe and secure.
* Prevents SQL Injection.

## JDBC Interfaces Summary

| Interface         | Description                            |
| ----------------- | -------------------------------------- |
| Driver            | Connects JDBC with the database driver |
| Connection        | Interface for DB connection session    |
| Statement         | Executes basic SQL queries             |
| PreparedStatement | Executes parameterized queries         |
| CallableStatement | Calls stored procedures                |
| ResultSet         | Stores results from SQL queries        |
| ResultSetMetaData | Info about `ResultSet` columns         |
| DatabaseMetaData  | Info about DB structure                |
| SQLException      | Handles SQL-related exceptions         |

## Web Application Flow

```
HTML Form → Servlet → DAO (JDBC Logic)
HTML Form ← Servlet ← DAO (Get Data from DB)
```

* Servlet handles HTTP requests and responses.
* DAO (Data Access Object) performs DB operations.

## DAO Pattern in JDBC

### What is DAO?

DAO is a design pattern that separates the database access code from the business logic.

### Purpose of DAO

* Clean, maintainable code.
* Promotes Separation of Concerns.

### DAO Responsibilities

* Connect to DB
* Perform CRUD operations (Create, Read, Update, Delete)
* Map data between Java objects and DB records


# SOLID Principles – General Explanation with Simple Examples

The SOLID principles are five rules that help us build systems (like software or organizations) that are easy to manage, update, and grow. These principles apply to design thinking in many areas, not just programming.

---

## 1. Single Responsibility Principle (SRP)

**Definition:**  
Something should do one job and do it well.

**Example:**  
A coffee machine should only make coffee. Cleaning or restocking should be done by another person or device, not by the coffee machine itself.

---

## 2. Open/Closed Principle (OCP)

**Definition:**  
Things should be easy to extend with new features, but you shouldn't have to change how they already work.

**Example:**  
A phone allows you to install new apps (extend it), but you don’t need to open or change the phone’s system to do so.

---

## 3. Liskov Substitution Principle (LSP)

**Definition:**  
If something works with one type of item, it should also work with a similar kind of item without causing problems.

**Example:**  
If you can drive a regular car, you should also be able to drive an electric car without learning a whole new method — both should follow the same rules for driving.

---

## 4. Interface Segregation Principle (ISP)

**Definition:**  
Don't give people more than they need to do their job.

**Example:**  
At an ATM, you are given a simple menu: Withdraw, Check Balance, Deposit. It doesn't show the bank manager’s advanced options — just what a regular user needs.

---

## 5. Dependency Inversion Principle (DIP)

**Definition:**  
Big systems should not depend directly on small details. Instead, both should rely on common ideas or agreements.

**Example:**  
A restaurant owner (high-level) doesn’t care which specific brand of food delivery person is used (low-level), as long as they follow a general contract: deliver food on time. The system is based on a shared expectation, not on a specific delivery company.


# Database Normalization

Normalization is the process of organizing data in a database to reduce redundancy (duplicate data) and improve data integrity.

It involves dividing large tables into smaller, related tables and linking them using keys.

---

## Goals of Normalization

- Eliminate redundant (repeated) data
- Ensure data dependencies make sense
- Make the database easier to maintain and update

---

## Types of Normalization (Normal Forms)

---

### 1. First Normal Form (1NF)

**Rule:**  
Each column should contain atomic (indivisible) values.  
No repeating groups or arrays.

**Example – Not in 1NF:**

| ID | Name  | Subjects         |
|----|-------|------------------|
| 1  | Ravi  | Math, Science    |
| 2  | Priya | English, History |

**Convert to 1NF:**

| ID | Name  | Subject  |
|----|-------|----------|
| 1  | Ravi  | Math     |
| 1  | Ravi  | Science  |
| 2  | Priya | English  |
| 2  | Priya | History  |

---

### 2. Second Normal Form (2NF)

**Rule:**  
It should be in 1NF and every non-key column should depend on the whole primary key.

**Example – Not in 2NF:**

| StudentID | Subject | StudentName |
|-----------|---------|-------------|
| 1         | Math    | Ravi        |
| 1         | Science | Ravi        |

**Issue:**  
StudentName depends only on StudentID, not on the full combination (StudentID + Subject).

**Convert to 2NF:**

**Student Table**

| StudentID | StudentName |
|-----------|-------------|
| 1         | Ravi        |

**Enrollment Table**

| StudentID | Subject  |
|-----------|----------|
| 1         | Math     |
| 1         | Science  |

---

### 3. Third Normal Form (3NF)

**Rule:**  
It should be in 2NF and no non-key column should depend on another non-key column.

**Example – Not in 3NF:**

| EmpID | EmpName | DeptID | DeptName |
|-------|---------|--------|----------|
| 1     | Asha    | D01    | HR       |
| 2     | Raj     | D02    | Finance  |

**Issue:**  
DeptName depends on DeptID, not EmpID.

**Convert to 3NF:**

**Employee Table**

| EmpID | EmpName | DeptID |
|-------|---------|--------|
| 1     | Asha    | D01    |
| 2     | Raj     | D02    |

**Department Table**

| DeptID | DeptName |
|--------|----------|
| D01    | HR       |
| D02    | Finance  |

---

### 4. Boyce-Codd Normal Form (BCNF)

**Rule:**  
It is a stricter version of 3NF. Every determinant must be a candidate key.

**When is it needed?**  
If a table has overlapping candidate keys and dependencies.

**Simple Explanation:**  
If there are fields that determine other fields but are not primary keys, the table might need BCNF.

---


| Normal Form | Removes                          | Focus                              |
|-------------|----------------------------------|-------------------------------------|
| 1NF         | Repeating groups                 | Atomic values                       |
| 2NF         | Partial dependency               | Full primary key dependency         |
| 3NF         | Transitive dependency            | Non-key to non-key dependency       |
| BCNF        | Dependency on non-candidate key  | Every determinant must be a key     |

---

## Employee.java 
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String[] getTasks() {
		return tasks;
	}
	public void setTasks(String[] tasks) {
		this.tasks = tasks;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

## EmployeeDAO.java

package com.tekgrads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/tekgrads";
	private static final String USER = "root";
	private static final String PASSWORD = "password";
	
	static {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        throw new RuntimeException("MySQL JDBC Driver not found!");
	    }
	}


	// Save Employee
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

			// Get generated employee ID
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

	// Save Employee Tasks
	private void saveTasks(int employeeId, String[] tasks) {
		if (tasks == null || tasks.length == 0)
			return;
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

	// Fetch Employee by ID
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
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = null;
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setCity(rs.getString("city"));
				employee.setProf(rs.getString("profession"));
				employee.setProject(rs.getString("project"));
				employee.setTasks(getTasksByEmployeeId(employee.getId()));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	// Fetch Employee Tasks
	private String[] getTasksByEmployeeId(int employeeId) {
		List<String> taskList = new ArrayList<>();
		String sql = "SELECT task FROM employee_tasks WHERE employee_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, employeeId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				taskList.add(rs.getString("task"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskList.toArray(new String[0]);
	}

	// Update Employee
	public boolean updateEmployee(Employee employee) {
		boolean isUpdated = false;
		String sql = "UPDATE employee SET name = ?, age = ?, salary = ?, city = ?, profession = ?, project = ? WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, employee.getName());
			stmt.setInt(2, employee.getAge());
			stmt.setDouble(3, employee.getSalary());
			stmt.setString(4, employee.getCity());
			stmt.setString(5, employee.getProf());
			stmt.setString(6, employee.getProject());
			stmt.setInt(7, employee.getId());

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				isUpdated = true;
				updateTasks(employee.getId(), employee.getTasks());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	// Update Employee Tasks
	private void updateTasks(int employeeId, String[] tasks) {
		// First, delete old tasks
		String deleteSQL = "DELETE FROM employee_tasks WHERE employee_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
			deleteStmt.setInt(1, employeeId);
			deleteStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Then, insert updated tasks
		saveTasks(employeeId, tasks);
	}

	// Delete Employee
	public boolean deleteEmployee(int id) {
		boolean isDeleted = false;
		String deleteTasksSQL = "DELETE FROM employee_tasks WHERE employee_id = ?";
		String deleteEmployeeSQL = "DELETE FROM employee WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			conn.setAutoCommit(false); // Start transaction

			// Delete associated tasks
			try (PreparedStatement deleteTasksStmt = conn.prepareStatement(deleteTasksSQL)) {
				deleteTasksStmt.setInt(1, id);
				deleteTasksStmt.executeUpdate();
			}

			// Delete employee
			try (PreparedStatement deleteEmployeeStmt = conn.prepareStatement(deleteEmployeeSQL)) {
				deleteEmployeeStmt.setInt(1, id);
				int rows = deleteEmployeeStmt.executeUpdate();
				if (rows > 0) {
					isDeleted = true;
				}
			}

			conn.commit(); // Commit transaction
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

}

## EmployeeService.java

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

## UpdateEmployeeServlet.java

package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id =  request.getParameter("id");
			EmployeeService service = new EmployeeService();
			Employee employee = service.getEmployee(Integer.parseInt(id));
			request.setAttribute("emp", employee);
			request.getRequestDispatcher("editEmployee.jsp").forward(request, response);

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
		String id =  request.getParameter("id");

		// Creating Employee object and setting values using setters
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(id));
		employee.setName(name);
		employee.setAge(Integer.parseInt(age));
		employee.setSalary(Double.parseDouble(salary));
		employee.setCity(city);
		employee.setProf(prof);
		employee.setProject(project);
		employee.setTasks(tasks);
		service.updateEmployee(employee);
		response.sendRedirect("DisplayEmployeeServlet");

	}


}