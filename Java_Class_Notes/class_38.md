
# Spring MVC + JDBC (Java Config) Project

## `web.xml`

```xml
<display-name>Spring MVC XML</display-name>

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
```

**Explanation:**

* Registers **DispatcherServlet** as the front controller.
* Loads `spring-servlet.xml` at startup.
* Maps all requests `/` to the servlet.

---

## `spring-servlet.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
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
        <property name="prefix" value="/WEB-INF/views/" />
        <property name="suffix" value=".jsp" />
    </bean>

    <mvc:resources mapping="/resources/**" location="/resources/" />
</beans>
```

**Explanation:**

* Enables component scanning.
* Enables Spring MVC annotations.
* Configures JSP view resolver.
* Serves static resources.

---

## JSP Views

### `home.jsp`

```jsp
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Home Page</title></head> 
<body>
<h2>${message}</h2>
</body>
</html>
```

### `about.jsp`

```jsp
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>About Page</title></head> 
<body>
<h2>${info}</h2> 
</body>
</html>
```

---

## Controller

```java
package com.tekgrads;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home") 
public class HomeController {

    @RequestMapping("/landingPage") 
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("message", "Welcome to Spring MVC using ModelAndView!");
        return mv;
    }

    @RequestMapping("/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("about");
        mv.addObject("info", "This is the About page powered by Spring XML Config.");
        return mv;
    }
}
```

---

## Maven Dependencies

```xml
<packaging>war</packaging>

<dependencies>
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
</dependencies>
```

---

## Java Config Initializer

```java
package com.tekgrads;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
```

---

## Spring MVC Java Config

```java
package com.tekgrads;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tekgrads")
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
```

---

## AppConfig with JDBC

```java
package com.tekgrads.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.tekgrads")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/student_db");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
```

---

## Employee Service

```java
package com.tekgrads.service;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
}
```

---

## Employee DTO

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

    public EmployeeDTO() {}

    public EmployeeDTO(int id, String name, int age, double salary, String city, String profession, String project) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.profession = profession;
        this.project = project;
    }

    // Getters and Setters...
}
```

---

## Employee Service Implementation

```java
package com.tekgrads.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return null; // To be implemented
    }
}
```

---

## Employee DAO

```java
package com.tekgrads.dao;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
}
```

---

## Employee DAO Implementation

```java
package com.tekgrads.dao.impl;

import com.tekgrads.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.rowmapper.EmployeeRowMapper;
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
}
```

---

## Employee RowMapper

```java
package com.tekgrads.rowmapper;

import com.tekgrads.dto.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setAge(rs.getInt("age"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setCity(rs.getString("city"));
        employee.setProfession(rs.getString("profession"));
        employee.setProject(rs.getString("project"));
        return employee;
    }
}
```

