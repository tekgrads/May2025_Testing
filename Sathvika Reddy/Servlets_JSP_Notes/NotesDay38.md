# spring-mvc-jdbc project conversion:

```xml
<!-- web.xml -->
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

* Registers `DispatcherServlet` as the front controller in Spring MVC.
* Loads `spring-servlet.xml` at startup to configure beans.
* Maps all requests (`/`) to the DispatcherServlet named `spring`.

---

```xml
<!-- spring-servlet.xml -->
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

    <mvc:resources mapping="/resources/" location="/resources/" />
</beans>
```

**Explanation:**

* Enables component scanning to detect `@Controller` and other annotations.
* Registers Spring MVC annotation support with `mvc:annotation-driven`.
* Configures view resolver to load JSPs from `/WEB-INF/views/` with `.jsp` suffix.
* Maps static resources from `/resources/`.

---

```jsp
<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>home page </title></head> 
<body>
<h2>${message}</h2>
</body>
</html>
```

**Explanation:**

* JSP page to display dynamic content using `${message}` from the controller.
* Page title is "home page".
* Uses JSTL expression language to display the passed data.

---

```java
// HomeController.java
package com.tekgrads;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home") 
public class HomeController {

    @RequestMapping("/landingPage") 
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home"); // Maps to /WEB-INF/views/home.jsp
        mv.addObject("message", "Welcome to Spring MVC using ModelAndView!");
        return mv;
    }

    @RequestMapping("/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("about"); // Maps to /WEB-INF/views/about.jsp
        mv.addObject("info", "This is the About page powered by Spring XML Config.");
        return mv;
    }
}
```

**Explanation:**

* `@Controller` handles web requests.
* `/home/landingPage` loads home.jsp and displays a welcome message.
* `/home/about` loads about.jsp and shows info message.

---

```jsp
<!-- about.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>about page </title></head> 
<body>
<h2>${info}</h2> 
</body>
</html>
```

**Explanation:**

* JSP page to display data from controller using `${info}`.
* Shows a simple message on the about page.

---

```xml
<!-- pom.xml -->
<packaging>war</packaging>

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
```

---

```java
// WebAppInitializer.java
package com.tekgrads;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class }; // App-level beans (e.g., DataSource, DAO)
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class }; // Spring MVC Configuration
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Maps DispatcherServlet to "/"
    }
}
```

---

```java
// WebMvcConfig.java
package com.tekgrads;

@ComponentScan(basePackages = "com.tekgrads")
import org.springframework.context.annotation.Bean;
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
        registry.addResourceHandler("/resources/")
                .addResourceLocations("/resources/");
    }
}
```

---

```xml
<!-- pom.xml additional dependencies -->
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
```

---

```java
// AppConfig.java
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

```java
// EmployeeService.java
package com.tekgrads.service;

public interface EmployeeService {
    int getTotalEmployees();
}
```

```java
// EmployeeService.java (with full method)
package com.tekgrads.service;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
}
```

---

```java
// EmployeeDTO.java
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

```java
// EmployeeServiceImpl.java
package com.tekgrads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return null;
    }
}
```

---

```java
// EmployeeDAO.java
package com.tekgrads.dao;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
}
```

---

```java
// EmployeeDAOImpl.java
package com.tekgrads.dao.impl;

import com.tekgrads.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JDBCTemplate jdbcTemplate;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }
}
```

---

```java
// EmployeeRowMapper.java
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
