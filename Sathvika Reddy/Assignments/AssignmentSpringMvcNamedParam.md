# Spring-Mvc-Named-Param Assignment:
```markdown
## pom.xml:

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.tekgrads</groupId>
  <artifactId>spring-mvc-named-param</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>spring-mvc-named-param</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    
    <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-context</artifactId>
     <version>6.2.9</version>
   </dependency>
   
    <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-webmvc</artifactId>
     <version>6.2.9</version>
   </dependency>
   
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-jdbc</artifactId>
     <version>6.2.9</version>
   </dependency>
   
   <dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <version>8.0.33</version>
   </dependency>
   
   <dependency>
     <groupId>javax.servlet</groupId>
     <artifactId>servlet-api</artifactId>
     <version>2.5</version>
     <scope>provided</scope>
   </dependency>
   
   <dependency>
     <groupId>javax.servlet</groupId>
     <artifactId>jstl</artifactId>
     <version>1.2</version>
   </dependency>
   
   <dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.0.0</version>
   </dependency>
   
   <dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
   </dependency>
   <dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
   </dependency>
  </dependencies>
</project>

## web.xml:

<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
 https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
version="5.0"
>

    <display-name>Spring MVC Named Param</display-name>

    <servlet>
        <servlet-name>spring</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>spring</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>

## employee-list.jsp:

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>

    <a href="${pageContext.request.contextPath}/employeeHome/add">Add Employee</a>
    <br><br>

    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Salary</th>
                <th>City</th>
                <th>Profession</th>
                <th>Project</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
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
                        <a href="${pageContext.request.contextPath}/employeeHome/edit/${emp.id}">Edit</a>
                        |
                        <a href="${pageContext.request.contextPath}/employeeHome/delete/${emp.id}" 
                           onclick="return confirm('Are you sure you want to delete this employee?');">
                           Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

## spring-servlet.xml:

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <context:component-scan base-package="com.tekgrads" />
    <mvc:annotation-driven />

    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost:3306/tekgrads" />
        <property name="username" value="root" />
        <property name="password" value="password" />
    </bean>

    <bean id="namedParameterJdbcTemplate"
          class="org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate">
        <constructor-arg ref="dataSource" />
    </bean>
</beans>

## EmployeeDTO.java:

package com.tekgrads.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String city;
    private String profession;
    private String project;

    public EmployeeDTO() {}

    public EmployeeDTO(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}

## EmployeeDAO.java:

package com.tekgrads.dao;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    void saveEmployee(EmployeeDTO employee);
    void deleteEmployee(int id);
}

## EmployeeDAOImpl.java:

package com.tekgrads.dao.impl;

import com.tekgrads.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private RowMapper<EmployeeDTO> rowMapper = new RowMapper<EmployeeDTO>() {
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
    };

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id=:id";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), rowMapper);
    }

    @Override
    public void saveEmployee(EmployeeDTO employee) {
        if (employee.getId() == 0) {
            String sql = "INSERT INTO employee(name, salary) VALUES(:name, :salary)";
            jdbcTemplate.update(sql, new MapSqlParameterSource()
                    .addValue("name", employee.getName())
                    .addValue("salary", employee.getSalary()));
        } else {
            String sql = "UPDATE employee SET name=:name, salary=:salary WHERE id=:id";
            jdbcTemplate.update(sql, new MapSqlParameterSource()
                    .addValue("id", employee.getId())
                    .addValue("name", employee.getName())
                    .addValue("salary", employee.getSalary()));
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=:id";
        jdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }
}

## EmployeeService.java:

package com.tekgrads.service;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    void saveEmployee(EmployeeDTO employee);
    void deleteEmployee(int id);
}

## EmployeeServiceImpl.java:

package com.tekgrads.service.impl;

import com.tekgrads.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;
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
    public EmployeeDTO getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void saveEmployee(EmployeeDTO employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}

## EmployeeController.java:

package com.tekgrads.controller;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employeeHome")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employeeHome/getAllEmployees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employeeHome/getAllEmployees";
    }
}

## Employee Table Output:

#### http://localhost:8080/spring-mvc-named-param/employeeHome/getAllEmployees

### Employees

**Add Employee**

+----+----------------+-----+----------+-----------+------------+-----------+----------------+
| ID | Name           | Age | Salary   | City      | Profession | Project   | Actions        |
+----+----------------+-----+----------+-----------+------------+-----------+----------------+
| 1  | sathvikareddy  | 22  | 1,000.0  | hyderabad| Developer  | Project 3 | Edit | Delete |
| 2  | sathvikadamera | 22  | 10,000.0 | hyderabad| Developer  | Project 1 | Edit | Delete |
| 3  | sathvika       | 22  | 10,000.0 | hyderabad| Developer  | Project 1 | Edit | Delete |
| 4  | sathvika       | 22  | 10,000.0 | hyderabad| Developer  | Project 1 | Edit | Delete |
| 6  | Damera Sathvika| 0   | 20,000.0 |           |            |           | Edit | Delete |
+----+----------------+-----+----------+-----------+------------+-----------+----------------+

#### http://localhost:8080/spring-mvc-named-param/employeeHome/addoredit/1

+--------------------------------+
|        Add / Edit Employee      |
+--------------------------------+
| Name:    [ tekgrads           ] |
|                                |
| Salary:  [ 5000000            ] |
|                                |
|          [ Save ]               |
+--------------------------------+

#### to delete:

+------------------------------------------------+
|        Are you sure you want to delete        |
|                 this employee?               |
+------------------------------------------------+
| [ OK ]    [ Cancel ]                          |
+------------------------------------------------+
```
