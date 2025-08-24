Complete project:

## 1️⃣ Database (MySQL)

```sql
CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    salary DOUBLE,
    city VARCHAR(50),
    profession VARCHAR(50),
    project VARCHAR(50)
);
```

---

## 2️⃣ **EmployeeDTO.java**

```java
package com.tekgrads.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String city;
    private String profession;
    private String project;

    // Getters & Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }
}
```

---

## 3️⃣ **EmployeeRowMapper.java**

```java
package com.tekgrads.mapper;

import com.tekgrads.dto.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO emp = new EmployeeDTO();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setAge(rs.getInt("age"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setCity(rs.getString("city"));
        emp.setProfession(rs.getString("profession"));
        emp.setProject(rs.getString("project"));
        return emp;
    }
}
```

---

## 4️⃣ **EmployeeDAOImpl.java**

```java
package com.tekgrads.dao;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.mapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public void insertEmployee(EmployeeDTO employee) {
        String sql = "INSERT INTO employee(name, age, salary, city, profession, project) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            employee.getName(),
            employee.getAge(),
            employee.getSalary(),
            employee.getCity(),
            employee.getProfession(),
            employee.getProject()
        );
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        String sql = "UPDATE employee SET name=?, age=?, salary=?, city=?, profession=?, project=? WHERE id=?";
        jdbcTemplate.update(sql,
            employee.getName(),
            employee.getAge(),
            employee.getSalary(),
            employee.getCity(),
            employee.getProfession(),
            employee.getProject(),
            employee.getId()
        );
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
```

---

## 5️⃣ **employee-form.jsp**

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>
    <h2>Employee Form</h2>
    <form action="save" method="post">
        <input type="hidden" name="id" value="${employee.id}" />
        Name: <input type="text" name="name" value="${employee.name}" required /><br/>
        Age: <input type="number" name="age" value="${employee.age}" required /><br/>
        Salary: <input type="number" name="salary" value="${employee.salary}" required step="0.01"/><br/>
        City: <input type="text" name="city" value="${employee.city}" required /><br/>
        Profession: <input type="text" name="profession" value="${employee.profession}" required /><br/>
        Project: <input type="text" name="project" value="${employee.project}" required /><br/>
        <input type="submit" value="Save"/>
    </form>
</body>
</html>
```

---

## 6️⃣ **employee-list.jsp**

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h2>Employee Records</h2>
    <a href="employee-form">Add New Employee</a>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Age</th><th>Salary</th><th>City</th><th>Profession</th><th>Project</th><th>Actions</th>
        </tr>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.age}</td>
                <td>${emp.salary}</td>
                <td>${emp.city}</td>
                <td>${emp.profession}</td>
                <td>${emp.project}</td>
                <td>
                    <a href="edit?id=${emp.id}">Edit</a> |
                    <a href="delete?id=${emp.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
```

---

 With this update:

* Your form will collect **Name, Age, Salary, City, Profession, Project**.
* The list page will show all these fields.
* The DAO handles inserting/updating all new fields.

If you insert sample data:

```sql
INSERT INTO employee(name, age, salary, city, profession, project)
VALUES 
('Rohan Sharma', 28, 55000, 'Bangalore', 'Developer', 'InventorySys'),
('Priya Nair', 26, 60000, 'Mumbai', 'Tester', 'E-Commerce'),
('Aman Verma', 30, 75000, 'Delhi', 'Manager', 'HRPortal'),
('Neha Gupta', 24, 50000, 'Hyderabad', 'Designer', 'TravelApp'),
('Karan Mehta', 27, 65000, 'Pune', 'Developer', 'BankingSuite');
```
Perfect — here’s the updated **EmployeeController.java** so it works with the new fields
(`age`, `city`, `profession`, `project`) without requiring any extra manual mapping.

---

## **EmployeeController.java**

```java
package com.tekgrads.controller;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // List all employees
    @RequestMapping("/employee-list")
    public String getAllEmployees(Model model) {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    // Show add form
    @RequestMapping("/employee-form")
    public String showForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee-form";
    }

    // Save new or updated employee
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("employee") EmployeeDTO employee) {
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:/employee-list";
    }

    // Edit employee
    @RequestMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    // Delete employee
    @RequestMapping("/delete")
    public String delete(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee-list";
    }
}
```


