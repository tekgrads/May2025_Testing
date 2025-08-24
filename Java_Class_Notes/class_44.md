

## 1. Servlets

* **Merits:**  
  - First step in building Java web applications.  
  - Could directly handle HTTP requests and responses.  

* **Limitations (Why we moved ahead):**  
  - Too much boilerplate (`HttpServletRequest`, `HttpServletResponse`).  
  - Business logic and presentation were mixed (no clear separation).  
  - Hard to maintain and test.  

---

## 2. Spring Core (IoC & DI)

* **Merits:**  
  - Introduced **Inversion of Control (IoC)** and **Dependency Injection (DI)**.  
  - Helped in decoupling components.  

* **Limitations:**  
  - Did not provide proper support for web requests or views.  
  - Heavy XML-based configuration.  
  - Needed integration with other frameworks for complete applications.  

---

## 3. Spring MVC

* **Merits:**  
  - Followed **MVC pattern** (Model, View, Controller).  
  - Introduced `DispatcherServlet`, Controllers, and ViewResolvers.  

* **Limitations:**  
  - Required a lot of configuration (XML/JavaConfig).  
  - Depended heavily on JSP/Thymeleaf for views (not ideal for APIs).  
  - Database logic (JDBC/Hibernate) was still manual and repetitive.  

---

## 4. Spring Data JPA

* **Merits:**  
  - Simplified persistence using **Repositories, JPA, Query Methods**.  

* **Limitations:**  
  - Still required XML/Java configurations for full applications.  
  - Dependency versions had to be managed manually.  
  - Focused mainly on data access, not on REST APIs.  

---

## 5. Spring REST (MVC + JPA)

* **Merits:**  
  - Allowed creating REST APIs using **@RestController**.  
  - Supported JSON/XML responses.  

* **Limitations:**  
  - Still configuration-heavy (DispatcherServlet, web.xml, DataSource beans).  
  - Managing multiple dependencies for REST + JPA was difficult.  
  - Needed external servers like Tomcat/Jetty for deployment.  

---

## 6. Spring Boot

* **Merits:**  
  - Provides **auto-configuration**, reducing boilerplate setup.  
  - Comes with **Spring Boot Starter JPA, Web, Test** for easy dependency management.  
  - Has an **embedded server** (Tomcat/Jetty) → no manual WAR deployment.  
  - Production-ready features: Actuator, monitoring, externalized config.  

* **Limitations:**  
  - Slightly opinionated (may add extra dependencies).  
  - Customizing auto-configuration can be tricky.  
  - For very small apps, it might feel heavy.  

---

# Spring REST + Data JPA Project

```java
// src/main/java/com/tekgrads/SpringRestDataJpaApplication.java
package com.tekgrads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestDataJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringRestDataJpaApplication.class, args);
    }
}
````

---

```java
// src/main/java/com/tekgrads/entity/Employee.java
package com.tekgrads.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;

    // Constructors
    public Employee() {}
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
```

---

```java
// src/main/java/com/tekgrads/dto/EmployeeDTO.java
package com.tekgrads.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private Double salary;

    // Constructors
    public EmployeeDTO() {}
    public EmployeeDTO(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
```

---

```java
// src/main/java/com/tekgrads/mapper/EmployeeMapper.java
package com.tekgrads.mapper;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary());
    }

    public static Employee toEntity(EmployeeDTO dto) {
        return new Employee(dto.getName(), dto.getSalary());
    }
}
```

---

```java
// src/main/java/com/tekgrads/repository/EmployeeRepository.java
package com.tekgrads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tekgrads.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

---

```java
// src/main/java/com/tekgrads/service/EmployeeService.java
package com.tekgrads.service;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
```

---

```java
// src/main/java/com/tekgrads/service/impl/EmployeeServiceImpl.java
package com.tekgrads.service.impl;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.entity.Employee;
import com.tekgrads.mapper.EmployeeMapper;
import com.tekgrads.repository.EmployeeRepository;
import com.tekgrads.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(saved);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
```

---

```java
// src/main/java/com/tekgrads/controller/EmployeeController.java
package com.tekgrads.controller;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted with id: " + id;
    }
}
```

---

```properties
# src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/tekgradsdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

```xml
<!-- pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.tekgrads</groupId>
    <artifactId>spring-rest-datajpa</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <name>spring-rest-datajpa</name>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.1</version>
        <relativePath/>
    </parent>

    <dependencies>
        <!-- Spring Boot Web Starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot JPA Starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- MySQL Connector -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok (Optional for boilerplate reduction) -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- Spring Boot Test -->
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
```

---

## How to Run & Test

1. Run the application:

   ```sh
   mvn spring-boot:run
   ```

2. Test using **Postman** or **cURL**:

   * `POST /api/employees` → Create employee
   * `GET /api/employees` → Get all employees
   * `GET /api/employees/{id}` → Get employee by ID
   * `DELETE /api/employees/{id}` → Delete employee


```
