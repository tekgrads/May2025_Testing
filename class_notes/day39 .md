Spring MVC + JDBC Project
🔹 1. Project Overview

We’ll build a simple Student Management App where:

Users can view a list of students (from a database).

Add new students using a form.

Data is stored in MySQL using JDBC Template.

🔹 2. Project Structure
spring-mvc-jdbc/
│── pom.xml
│── src/main/java/com/example/controller/StudentController.java
│── src/main/java/com/example/dao/StudentDao.java
│── src/main/java/com/example/dao/StudentDaoImpl.java
│── src/main/java/com/example/model/Student.java
│── src/main/resources/application.properties
│── src/main/webapp/WEB-INF/web.xml
│── src/main/webapp/WEB-INF/dispatcher-servlet.xml
│── src/main/webapp/WEB-INF/views/students.jsp
│── src/main/webapp/WEB-INF/views/add-student.jsp

🔹 3. Configuration Files
pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
    http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>spring-mvc-jdbc</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <dependencies>
        <!-- Spring MVC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.34</version>
        </dependency>

        <!-- Spring JDBC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.34</version>
        </dependency>

        <!-- MySQL Connector -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.3.0</version>
        </dependency>

        <!-- JSTL -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

        <!-- Servlet API -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>

web.xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="3.1">
    <display-name>Spring MVC JDBC</display-name>

    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>

dispatcher-servlet.xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.example"/>

    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <!-- DataSource -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/springdb"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
    </bean>

    <!-- JdbcTemplate -->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!-- DAO -->
    <bean id="studentDao" class="com.example.dao.StudentDaoImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    </bean>
</beans>

🔹 4. Java Classes
Model: Student.java
package com.example.model;

public class Student {
    private int id;
    private String name;
    private String email;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

DAO: StudentDao.java
package com.example.dao;

import com.example.model.Student;
import java.util.List;

public interface StudentDao {
    int save(Student s);
    List<Student> getStudents();
}

DAO Implementation: StudentDaoImpl.java
package com.example.dao;

import com.example.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Student s) {
        String query = "INSERT INTO students(name, email) VALUES(?, ?)";
        return jdbcTemplate.update(query, s.getName(), s.getEmail());
    }

    @Override
    public List<Student> getStudents() {
        return jdbcTemplate.query("SELECT * FROM students", new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                return s;
            }
        });
    }
}

Controller: StudentController.java
package com.example.controller;

import com.example.dao.StudentDao;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentDao.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentDao.save(student);
        return "redirect:/students";
    }
}

🔹 5. JSP Views
students.jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>Students List</title></head>
<body>
<h2>Students</h2>
<a href="add">Add Student</a>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th></tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

add-student.jsp
<html>
<head><title>Add Student</title></head>
<body>
<h2>Add Student</h2>
<form action="add" method="post">
    Name: <input type="text" name="name"/><br/>
    Email: <input type="text" name="email"/><br/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>

🔹 6. Database Setup

Run this SQL in MySQL:

CREATE DATABASE springdb;
USE springdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

🔹 7. Expected Output

Navigate to: http://localhost:8080/spring-mvc-jdbc/students
→ Shows a list of students (empty initially).

Click Add Student, enter details.

Student gets stored in MySQL and displayed in the list.