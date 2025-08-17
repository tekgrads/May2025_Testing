# Spring Data JPA – Entity Relationships Examples

This guide covers the main types of **Entity Relationships** in Spring Data JPA with examples.

---

## 📌 1. One-to-One Relationship

### Example: `User` ↔ `Profile`
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;
}

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

➡️ Each user has exactly one profile.

---

## 📌 2. One-to-Many Relationship

### Example: `Department` ↔ `Employee`
```java
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```

➡️ A department has many employees, but each employee belongs to one department.

---

## 📌 3. Many-to-One Relationship

This is just the reverse of **One-to-Many**.

➡️ In the above example:  
- Many employees belong to one department.  
- `@ManyToOne` is placed in the child entity (`Employee`).

---

## 📌 4. Many-to-Many Relationship

### Example: `Student` ↔ `Course`
```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
```

➡️ A student can enroll in many courses, and a course can have many students.

---

## 📌 5. Cascade Types in Relationships

- **ALL** → Propagates all operations (persist, merge, remove, refresh, detach).  
- **PERSIST** → Saves related entities when the parent is saved.  
- **REMOVE** → Deletes related entities when the parent is deleted.  
- **MERGE** → Updates related entities when the parent is updated.  

---

## 📌 6. Fetch Types

- **LAZY (default for collections)** → Loads relationship on demand.  
- **EAGER (default for @OneToOne, @ManyToOne)** → Loads relationship immediately.  

```java
@OneToMany(fetch = FetchType.LAZY)
private List<Employee> employees;
```

---

## ▶️ Summary
- **One-to-One** → Each entity has exactly one related entity.  
- **One-to-Many / Many-to-One** → Parent-child relationship.  
- **Many-to-Many** → Relationship with a join table.  
- **Cascade & Fetch** define behavior of persistence and loading.  

Spring Data JPA makes it easy to map these relationships without writing SQL.
