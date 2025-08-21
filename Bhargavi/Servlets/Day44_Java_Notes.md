Day44
# Evolution of Java Web Development:

## 1. Servlets:

* **Merits:** First step to build web applications, could handle HTTP requests and responses directly.
* **Demerits (Why advance was needed):**

  * Too much boilerplate (`HttpServletRequest`, `HttpServletResponse`).
  * Business logic mixed with presentation (poor separation of concerns).
  * Hard to test and maintain.

---

## 2. Spring Core (IoC & DI):

* **Merits:** Introduced **Inversion of Control & Dependency Injection** to decouple components.
* **Demerits:**

  * No proper support for handling **web requests or views**.
  * XML-based configuration was verbose and complex.
  * Needed integration with other frameworks for complete applications.

---

## 3. Spring MVC:

* **Merits:** Followed **MVC pattern**, introduced `DispatcherServlet`, Controllers, ViewResolvers.
* **Demerits:**

  * Required lots of configuration (XML/JavaConfig).
  * Heavy reliance on JSP/Thymeleaf for view rendering (not API-friendly).
  * Writing database logic (JDBC/Hibernate) was still manual and repetitive.

---

## 4. Spring Data JPA:

* **Merits:** Simplified data persistence with **Repositories, JPA, Query Methods**.
* **Demerits:**

  * Still required lots of XML/Java configurations for the overall application.
  * Dependency management was manual (needed correct versions).
  * Focused mainly on database layer, not on exposing APIs.

---

## 5. Spring REST (using MVC + JPA):

* **Merits:** Exposed APIs with **@RestController**, produced JSON/XML responses.
* **Demerits:**

  * Configuration-heavy (DispatcherServlet, web.xml, datasource beans).
  * Managing multiple dependencies for REST + JPA was difficult.
  * Still required external servers (Tomcat, Jetty) to deploy.

---

## 6. Spring Boot:

* **Merits:**

  * Provides **auto-configuration** and eliminates boilerplate setup.
  * Comes with **Spring Boot Starter JPA, Starter Web, Starter Test** for easy dependency management.
  * **Embedded server (Tomcat/Jetty)** → no need to deploy WAR manually.
  * Production-ready features like Actuator, monitoring, externalized config.
* **Demerits:**

  * Slightly **opinionated**, may add dependencies you don’t need.
  * Learning curve for customizing auto-configuration.
  * Can become heavy for very small apps.

---

# spring-rest-datajpa:

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
```

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

## How to Run & Test:

1. Run with:

   ```sh
   mvn spring-boot:run
   ```
2. Use **Postman** to test:

   * `POST /api/employees` → Create employee
   * `GET /api/employees` → Get all employees
   * `GET /api/employees/{id}` → Get one employee
   * `DELETE /api/employees/{id}` → Delete employee

---
