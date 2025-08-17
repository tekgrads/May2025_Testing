# Spring Data JPA – One-to-One Mapping Demo

This project demonstrates how to use **Spring Boot + Spring Data JPA** for:
- Automatic table creation
- Applying constraints
- One-to-One mapping (`User` ↔ `Profile`)

---

## 📌 Technologies Used
- Java 17+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- MySQL Database

---

## 📂 Project Structure
```
spring-data-jpa-demo/
 ┣ src/main/java/com/example/demo/
 ┃ ┣ DemoApplication.java
 ┃ ┣ User.java
 ┃ ┣ Profile.java
 ┃ ┣ UserRepository.java
 ┃ ┣ ProfileRepository.java
 ┃ ┗ UserController.java
 ┣ src/main/resources/
 ┃ ┗ application.properties
 ┗ pom.xml
```

---

## ⚙️ Configuration (`application.properties`)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jpadb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🗄️ Database Setup
Run in MySQL:
```sql
CREATE DATABASE jpadb;
```

Spring Boot will auto-create tables `users` and `profiles`.

---

## 👤 User Entity
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;
}
```

---

## 📄 Profile Entity
```java
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
```

---

## 🗂️ Repositories
```java
public interface UserRepository extends JpaRepository<User, Long> {}
public interface ProfileRepository extends JpaRepository<Profile, Long> {}
```

---

## 🌐 REST Controller
```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/{userId}/profile")
    public Profile addProfile(@PathVariable Long userId, @RequestBody Profile profile) {
        User user = userRepository.findById(userId).orElseThrow();
        profile.setUser(user);
        return profileRepository.save(profile);
    }
}
```

---

## ▶️ How to Run
1. Import project into **IntelliJ IDEA** or **Eclipse** (Maven project).  
2. Run `DemoApplication.java`.  
3. Test endpoints:

### ➡️ Create User
```http
POST /api/users
Content-Type: application/json

{
  "username": "john_doe",
  "password": "secret123"
}
```

### ➡️ Add Profile to User
```http
POST /api/users/1/profile
Content-Type: application/json

{
  "fullName": "John Doe",
  "email": "john@example.com"
}
```

✅ Output: A profile linked to the user.

---

## 📌 Summary
- Spring Data JPA auto-generates tables and constraints from entities.  
- `@OneToOne` annotation establishes a **One-to-One mapping** between `User` and `Profile`.  
- Repositories provide built-in CRUD methods without writing SQL.  
