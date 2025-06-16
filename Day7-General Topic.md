
# Tech Concepts with Examples 

## 1. SQL vs NoSQL (with Examples)

### SQL (Structured Query Language)
- Relational DBs: tables, rows, and columns.
- Example: MySQL, PostgreSQL.
```sql
SELECT * FROM Students WHERE grade = 'A';
```
- Like using Excel sheets for your data.

### NoSQL (Not Only SQL)
- Document, key-value, graph, or column stores.
- Example: MongoDB, Redis.
```json
{ "name": "Alice", "grade": "A" }
```
- Like dumping everything in labeled boxes.

## 2. Server - Java Used As
- Java used to build backend logic, APIs.
- Runs services with Spring Boot, handles client requests.
- Acts like the brain while clients are the face.

## 3. Separation of UI and Backend
- Frontend: HTML/CSS/JS — Looks pretty.
- Backend: Java, Python — Thinks deeply.
- Like a restaurant: Waiter (UI), Chef (backend).

## 4. Spring + MongoDB Sample Data Structure
```java
@Document("students")
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
    private List<String> courses;
}
```
- JSON equivalent in Mongo:
```json
{ "name": "Bob", "age": 22, "courses": ["Math", "Java"] }
```

## 5. Training AI Models
- Use Python, TensorFlow, PyTorch.
- Involves data, training loops, GPUs.
- Like teaching a toddler repeatedly until they say "cat" when shown a cat.

## 6. When JS and Python Are Used

### JavaScript
- Used for frontend interactivity.
- Also backend (Node.js).
- Example: Buttons dancing on click.

### Python
- Used in AI, data science, automation.
- Backend APIs with Flask, FastAPI.
- Example: Robot thinking how to answer you.


