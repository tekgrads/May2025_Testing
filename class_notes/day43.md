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
springboot-jpa-demo/
 ├── src/main/java/com/example/demo/
 │   ├── DemoApplication.java
 │   ├── entity/
 │   │    └── Product.java
 │   ├── repository/
 │   │    └── ProductRepository.java
 │   ├── service/
 │   │    └── ProductService.java
 │   └── controller/
 │        └── ProductController.java
 └── src/main/resources/
      └── application.properties
2. Dependencies
Gradle (build.gradle)

gradle
Copy code
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    runtimeOnly 'com.mysql:mysql-connector-j'
}
3. Configuration
application.properties

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
server.port=8080
4. Entity
java
Copy code
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
5. Repository
java
Copy code
package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
6. Service
java
Copy code
package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
7. Controller
java
Copy code
package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.findByName(name);
    }
}
8. Main Application
java
Copy code
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
9. Test with cURL or Postman
Create Product

bash
Copy code
POST http://localhost:8080/products
Content-Type: application/json

{
  "name": "Laptop",
  "price": 75000
}
Get All Products

bash
Copy code
GET http://localhost:8080/products
Get Products by Name

bash
Copy code
GET http://localhost:8080/products/Laptop