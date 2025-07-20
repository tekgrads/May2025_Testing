package com.tekgrads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/tekgrads";
	private static final String USER = "root";
	private static final String PASSWORD = "Admin@123";
	
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
