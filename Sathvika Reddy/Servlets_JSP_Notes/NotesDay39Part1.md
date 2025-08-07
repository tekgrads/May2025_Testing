# Complete spring-mvc-jdbc project:

  * `EmployeeController.java`
  * `HomeController.java`
  * `EmployeeService.java`
  * `EmployeeServiceImpl.java`
  * `EmployeeDAO.java`
  * `EmployeeDAOImpl.java`
  * `EmployeeDTO.java`
  * `EmployeeRowMapper.java`
  * JSP files (like `employee-form.jsp`, `employee-list.jsp`, etc.)
  * Config class: `AppConfig.java` (based on your XML schema error and context)


---

#### **EmployeeController.java**

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
@RequestMapping("/employeeHome")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //@GetMapping
    @RequestMapping("/getAllEmployees")
    public ModelAndView listEmployees() {
    	ModelAndView mv=new ModelAndView("employee-list");
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        
        mv.addObject("employees", employees);
        return mv;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee-form"; // Maps to employee-form.jsp
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        if (employee.getId() != 0) {
            employeeService.updateEmployee(employee);
        } else {
            employeeService.addEmployee(employee);
        }
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Model model) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
```

---

#### **HomeController.java**

```java
package com.tekgrads;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home"); // Maps to /WEB-INF/views/home.jsp
        mv.addObject("message", "Welcome to");
        return mv;
    }
}
```
---

#### **EmployeeDTO.java**

```java
package com.tekgrads.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

---

#### **EmployeeRowMapper.java**

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
        emp.setDepartment(rs.getString("department"));
        emp.setSalary(rs.getDouble("salary"));
        return emp;
    }
}
```

---

#### **EmployeeService.java**

```java
package com.tekgrads.service;

import com.tekgrads.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    void addEmployee(EmployeeDTO employee);
    void updateEmployee(EmployeeDTO employee);
    EmployeeDTO getEmployeeById(int id);
    void deleteEmployee(int id);
}
```

---

#### **EmployeeServiceImpl.java**

```java
package com.tekgrads.service;

import com.tekgrads.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeeDAO.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
```

---

#### **EmployeeDAO.java**

```java
package com.tekgrads.dao;

import com.tekgrads.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
    void insertEmployee(EmployeeDTO employee);
    void updateEmployee(EmployeeDTO employee);
    EmployeeDTO getEmployeeById(int id);
    void deleteEmployee(int id);
}
```

---

#### **EmployeeDAOImpl.java**

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
        String sql = "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        String sql = "UPDATE employee SET name = ?, department = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
```

---

#### **AppConfig.java**

```java
package com.tekgrads.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tekgrads")
public class AppConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/tekgrads");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
```

---

#### **HomeController.java**

```java
package com.tekgrads;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home"); // Maps to /WEB-INF/views/home.jsp
        mv.addObject("message", "Welcome to Tekgrads Employee Management");
        return mv;
    }
}
```

---

#### **EmployeeController.java**

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

    @RequestMapping("/employee-list")
    public String getAllEmployees(Model model) {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @RequestMapping("/employee-form")
    public String showForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("employee") EmployeeDTO employee) {
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:/employee-list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee-list";
    }
}
```

---

## Jsp files:
Place these inside:
`/WEB-INF/views/`

---

#### **home.jsp**

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>${message}</h2>
    <a href="employee-list">View Employees</a>
</body>
</html>
```

---

#### **employee-list.jsp**

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
            <th>ID</th><th>Name</th><th>Department</th><th>Salary</th><th>Actions</th>
        </tr>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
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

#### **employee-form.jsp**

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
        Department: <input type="text" name="department" value="${employee.department}" required /><br/>
        Salary: <input type="number" name="salary" value="${employee.salary}" required step="0.01"/><br/>
        <input type="submit" value="Save"/>
    </form>
</body>
</html>
```
---

## Xml files:

### **web.xml**

Filename: `web.xml`
Location: `src/main/webapp/WEB-INF/web.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         version="3.1"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd">

    <display-name>Spring MVC Application</display-name>

    <!-- DispatcherServlet Configuration -->
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!-- Welcome file -->
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

</web-app>
```

---

###  **pom.xml**

Filename: `pom.xml`
Location: Project root

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.tekgrads</groupId>
    <artifactId>employee-management</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>Employee Management System</name>

    <properties>
        <java.version>1.8</java.version>
        <spring.version>5.3.32</spring.version>
        <jstl.version>1.2</jstl.version>
    </properties>

    <dependencies>

        <!-- Spring MVC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- Servlet API -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>

        <!-- JSTL -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>${jstl.version}</version>
        </dependency>

        <!-- MySQL JDBC -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>

        <!-- Spring JDBC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- Logging -->
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>

    </dependencies>

    <build>
        <finalName>employee-management</finalName>
        <plugins>
            <!-- Maven Compiler Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>

            <!-- WAR Packaging -->
            <plugin>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.2</version>
            </plugin>
        </plugins>
    </build>

</project>
```
## output as:

## Employee List


| ID | Name            | Age | Salary  | City       | Profession | Project     | Actions        |
|----|-----------------|-----|---------|------------|------------|-------------|----------------|
| 1  | sathvikareddy   | 22  | 10000.0 | hyderabad  | Developer  | Project1    | Edit | Delete |
| 2  | sathvika        | 22  | 10000.0 | hyderabad  | Developer  | Project1    | Edit | Delete |
| 3  | sathvika        | 22  | 10000.0 | hyderabad  | Developer  | Project1    | Edit | Delete |
| 4  | sathvika        | 22  | 10000.0 | hyderabad  | Developer  | Project1    | Edit | Delete |

[Add New Employee](#)

