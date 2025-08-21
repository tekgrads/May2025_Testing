Day43
# Spring boot Introduction:

# Spring Initializr Usage:
Spring Initializr is an online tool provided by Spring (https://start.spring.io/) to quickly bootstrap a Spring Boot project. It allows developers to select project metadata (groupId, artifactId, name, description), dependencies, Java version, and packaging type. It then generates a ready-to-use Maven/Gradle project structure.

---

# Why Spring Boot was introduced:
Spring Boot was introduced to overcome limitations in traditional Spring MVC:
- In Spring MVC, developers had to do heavy XML configuration (dispatcher-servlet.xml, web.xml, data sources, etc.).
- Dependency management was complex and often required specifying versions manually.
- Setting up production-ready features like embedded servers (Tomcat/Jetty), security, metrics, and logging required extra steps.
- Boot simplifies development with auto-configuration, opinionated defaults, embedded servers, and production-ready features.

---

# Spring MVC vs Spring Boot MVC:
- **Spring MVC**: Traditional web framework requiring manual configuration, setup of dispatcher servlet, and XML/Java-based bean definitions.
- **Spring Boot MVC**: Built on top of Spring MVC but with auto-configuration, embedded servers, simplified dependency management, and less boilerplate.

---

# Spring Boot Application Properties:
Spring Boot `application.properties` (or `application.yml`) is used to externalize configuration.  
- Instead of hardcoding values (DB URL, username, logging levels, Thymeleaf paths), properties provide flexibility.  
- It allows separating environment-specific configs (dev, test, prod).  
- Boot auto-binds these properties into beans (DataSource, ThymeleafViewResolver, etc.).  

---

# Files in Project:

## pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.5.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.tekgrads</groupId>
	<artifactId>springboot-mvc</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>springboot-mvc</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
````

---

## application.properties (default)

```properties
spring.application.name=springboot-mvc
```

---

## SpringbootMvcApplication.java (default)

```java
package com.tekgrads.springboot_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMvcApplication.class, args);
	}

}
```

---

## EmployeeDAO.java

```java
package com.tekgards.dao;

import java.util.List;
import com.tekgrads.dto.EmployeeDTO;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    void addEmployee(EmployeeDTO employee);
    void updateEmployee(EmployeeDTO employee);
    void deleteEmployee(int id);
}
```

---

## EmployeeController.java

```java
package com.tekgrads.controller;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public ModelAndView listEmployees() {
    	ModelAndView mv = new ModelAndView("employee-list"); 
        List<EmployeeDTO> employees = employeeService.getAllEmployees();     
        mv.addObject("employees", employees);
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView showAddForm(Model model) {
    	ModelAndView mv = new ModelAndView("employee-form");        
        mv.addObject("employee", new EmployeeDTO());
        return mv;
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:/employeeHome/getAllEmployees";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editEmployee(@PathVariable("id") int id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        ModelAndView mv = new ModelAndView("employee-form");        
        mv.addObject("employee", employee);      
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employeeHome/getAllEmployees";
    }
}
```

---

## HomeController.java

```java
package com.tekgrads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("about"); // maps to about.html in /templates
		mav.addObject("info", "This is the About Page using Thymeleaf + ModelAndView");
		return mav;
	}

}
```

---

## EmployeeDAOImpl.java

```java
package com.tekgrads.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tekgards.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.rowmapper.EmployeeRowMapper;

@Repository
@Qualifier("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
           

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        String sql = "INSERT INTO employees ( name, department, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        String sql = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
```

---

## EmployeeDTO.java

```java
package com.tekgrads.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
```

---

## EmployeeRowMapper.java

```java
package com.tekgrads.rowmapper;

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
        emp.setDepartment(rs.getString("department"));
        emp.setSalary(rs.getDouble("salary"));
        return emp;
    }
}
```

---

## EmployeeServiceImpl.java

```java
package com.tekgrads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tekgards.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;

@Service
@Qualifier("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
    public EmployeeDTO getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
```

---

## EmployeeService.java

```java
package com.tekgrads.service;

import java.util.List;
import com.tekgrads.dto.EmployeeDTO;

public interface EmployeeService {
	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployeeById(int id);

	void addEmployee(EmployeeDTO employee);

	void updateEmployee(EmployeeDTO employee);

	void deleteEmployee(int id);
}
```

---

## SpringbootMvcApplication.java

```java
package com.tekgrads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tekgrads")
public class SpringbootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMvcApplication.class, args);
	}

}
```

---

## about.html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>About Page</title>
</head>
<body>
    <h2 th:text="${info}">Default Info</h2>
</body>
</html>
```

---

## employee-list.html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>

        <!-- Loop over employees -->
        <tr th:each="emp : ${employees}">
            <td th:text="${emp.id}">1</td>
            <td th:text="${emp.name}">John Doe</td>
            <td th:text="${emp.department}">IT</td>
            <td th:text="${emp.salary}">5000</td>
            <td>
                <a th:href="@{/employeeHome/edit/{id}(id=${emp.id})}">Edit</a> |
                <a th:href="@{/employeeHome/delete/{id}(id=${emp.id})}"
                   th:onclick="'return confirm(\'Are you sure?\')'">Delete</a>
            </td>
        </tr>
    </table>

    <p><a th:href="@{/employeeHome/add}">Add Employee</a></p>
</body>
</html>
```

---

## application.properties (custom)

```properties
spring.application.name=springboot-mvc
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.cache=false 
spring.datasource.url=jdbc:mysql://localhost:3306/student_db_joins
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

```
```