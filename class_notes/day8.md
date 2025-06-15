
# Java and Database Concepts Overview

## 1. SQL vs NoSQL

### SQL (Structured Query Language)
- **Relational database**: Data is stored in tables with rows and columns.
- **Schema-based**: Fixed schema required.
- **Examples**: MySQL, PostgreSQL, Oracle

### Example (MySQL):
```sql
CREATE TABLE Student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

INSERT INTO Student (id, name, age) VALUES (1, 'John', 20);
```

### NoSQL (Not Only SQL)
- **Non-relational database**: Data can be stored as documents, key-value, graphs, or wide-columns.
- **Schema-less**: More flexible.
- **Examples**: MongoDB, Cassandra, Redis

### Example (MongoDB Document):
```json
{
    "_id": 1,
    "name": "John",
    "age": 20
}
```

## 2. Server-side Java: Separation of UI and Backend

Java is often used on the **server side** to separate the user interface (frontend) from business logic (backend). This separation improves maintainability and scalability.

### Typical Structure:
- **Frontend**: HTML, CSS, JS (Angular, React)
- **Backend**: Java (Spring Boot, Servlets)
- **Database**: MySQL, MongoDB, etc.

### Example:
- Frontend sends data via HTTP request (REST API)
- Java backend handles request, processes data, stores in DB

## 3. Spring Framework

Spring is a powerful Java framework for building enterprise-level applications.

### Key Features:
- **Dependency Injection (DI)**
- **Aspect-Oriented Programming (AOP)**
- **Spring Boot** for fast development
- **Spring MVC** for web applications
- **Spring Data** for database operations

### Sample Spring Boot Code:
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
```

## 4. MongoDB with Spring

Spring Data MongoDB allows easy integration of MongoDB in Spring applications.

### Sample Code:
```java
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
}

public interface StudentRepository extends MongoRepository<Student, String> {}
```

## 5. Sample Data Structures in Java

### Array:
```java
int[] numbers = {1, 2, 3, 4};
```

### ArrayList:
```java
ArrayList<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
```

### HashMap:
```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
```

### Stack:
```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.pop();  // Removes 20
```

### Queue (LinkedList):
```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
queue.poll();  // Removes "A"
```

---

## Summary

| Concept        | Description |
|----------------|-------------|
| SQL            | Relational, structured tables |
| NoSQL          | Non-relational, flexible storage |
| Java Backend   | Handles business logic |
| Spring         | Framework for fast Java development |
| MongoDB        | NoSQL DB integrated with Spring |
| Data Structures| Arrays, Lists, Maps, Stacks, Queues |
