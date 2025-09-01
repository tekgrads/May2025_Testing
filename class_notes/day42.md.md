# Spring Data JPA — Complete Guide with Examples

Spring Data JPA is a part of the **Spring Data** project, making it easier to implement JPA-based repositories.  
It reduces boilerplate code and provides powerful query methods out of the box.

---

## 🔹 Key Features
- Simplifies **CRUD operations**
- Supports **derived query methods**
- Provides **JPQL, native queries, and specifications**
- Built-in **pagination and sorting**
- Handles **entity relationships** easily

---

## 1. Setting Up Spring Data JPA

**Dependencies (Gradle)**

```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    runtimeOnly 'com.mysql:mysql-connector-j'
}
```

**application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 2. Basic Entity Example

```java
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    // getters and setters
}
```

---

## 3. Repository Example

```java
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Derived query methods
    List<Product> findByName(String name);
    List<Product> findByPriceBetween(double min, double max);
}
```

---

## 4. Service Layer Example

```java
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(String name, double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return productRepository.save(product);
    }

    public List<Product> getProductsInRange(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }
}
```

---

## 5. Using JPQL and Native Queries

```java
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findProductsExpensiveThan(@Param("price") double price);

    @Query(value = "SELECT * FROM product WHERE name LIKE %:keyword%", nativeQuery = true)
    List<Product> searchByName(@Param("keyword") String keyword);
}
```

---

## 6. Paging and Sorting

```java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
}
```

Usage:

```java
Page<Product> page = productRepository.findAll(PageRequest.of(0, 5, Sort.by("price").descending()));
page.getContent().forEach(System.out::println);
```

---

## 7. Entity Relationships

### One-to-One (User ↔ Profile)
```java
@OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
private Profile profile;
```

### One-to-Many / Many-to-One (Department ↔ Employee)
```java
@OneToMany(mappedBy = "department")
private List<Employee> employees;
```

### Many-to-Many (Student ↔ Course)
```java
@ManyToMany(mappedBy = "courses")
private Set<Student> students;
```

(See [Entity Relationship Detailed Examples](spring-data-jpa-relationships.md))

---

## 8. Auditing (Created Date, Modified Date)

```java
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
```

Enable auditing in your Spring Boot application:

```java
@EnableJpaAuditing
@SpringBootApplication
public class MyApplication {}
```

---

## 9. Specifications (Dynamic Queries)

```java
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> cb.equal(root.get("name"), name);
    }

    public static Specification<Product> priceGreaterThan(double price) {
        return (root, query, cb) -> cb.greaterThan(root.get("price"), price);
    }
}
```

Repository:

```java
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {}
```

Usage:

```java
List<Product> results = productRepository.findAll(
    Specification.where(ProductSpecifications.hasName("Laptop"))
                 .and(ProductSpecifications.priceGreaterThan(500))
);
```

---

## 🔑 Best Practices

- Use **`LAZY` fetching** instead of `EAGER` to improve performance.  
- Prefer **DTOs** for returning data in APIs.  
- Always handle **transactions** at the service layer (`@Transactional`).  
- Use **`JpaSpecificationExecutor`** for complex dynamic queries.  
- Use **paging and sorting** instead of fetching all records.  

---

