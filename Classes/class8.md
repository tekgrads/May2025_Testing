## 1️⃣ SQL vs NoSQL

### 📊 SQL (Structured Query Language)

- **Type:** Relational Database (data in tables)
- **Schema:** Fixed (defined columns and types)
- **Properties:** ACID (ensures data accuracy and integrity)
- **Examples:** MySQL, PostgreSQL, Oracle, MS SQL Server

#### ✅ Example (MySQL):

```sql
CREATE TABLE Students (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT
);

INSERT INTO Students VALUES (1, 'Alice', 22);

SELECT * FROM Students;
📁 NoSQL (Not Only SQL)
Type: Non-relational (Document, Key-Value, Graph, Column)

Schema: Flexible (fields can vary)

Properties: BASE (high availability, eventual consistency)

Examples: MongoDB, CouchDB, Cassandra, Redis

✅ Example (MongoDB - Document Store):
json
Copy
Edit
{
  "_id": 1,
  "name": "Alice",
  "age": 22
}
javascript
Copy
Edit
db.students.insertOne({ _id: 1, name: "Alice", age: 22 });
db.students.find();
2️⃣ Server-Side Java & UI-Backend Separation
In web apps:

Frontend (HTML/CSS/JS): Handles what the user sees

Backend (Java): Handles business logic, databases

🧱 Architecture:
css
Copy
Edit
[User Interface (HTML/JS)] <--> [Servlets/Controllers] <--> [Service Layer] <--> [DAO] <--> [Database]
✅ Example (Java Servlet):
java
Copy
Edit
@WebServlet("/greet")
public class GreetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().write("Hello from server-side Java!");
    }
}
3️⃣ Spring Framework and MongoDB
🌱 Spring Framework
A lightweight Java framework

Popular modules: Spring Boot, Spring MVC, Spring Data

🍃 MongoDB + Spring Boot Integration
✅ Sample Entity:
java
Copy
Edit
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
}
✅ Sample Repository:
java
Copy
Edit
public interface StudentRepository extends MongoRepository<Student, String> {}
✅ Sample Controller:
java
Copy
Edit
@RestController
public class StudentController {
    @Autowired
    private StudentRepository repo;

    @GetMapping("/students")
    public List<Student> getAll() {
        return repo.findAll();
    }
}
4️⃣ Sample Data Structures in Java
🧺 Array
java
Copy
Edit
int[] arr = {1, 2, 3, 4};
🔗 Linked List
java
Copy
Edit
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}
📚 Stack (Using ArrayList)
java
Copy
Edit
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.pop();
🔐 HashMap
java
Copy
Edit
Map<String, Integer> map = new HashMap<>();
map.put("Math", 90);
System.out.println(map.get("Math"));  // Output: 90
5️⃣ Training AI Models
🧠 Steps to Train an AI Model
Data Collection – Gather raw data (CSV files, images, etc.)

Preprocessing – Clean the data (remove noise, normalize, etc.)

Model Selection – Choose an algorithm (e.g., decision tree, neural network)

Training – Teach the model with your data

Evaluation – Test performance (accuracy, precision, recall)

Deployment – Use the model in a real-world application