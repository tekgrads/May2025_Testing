# Overview of SQL, NoSQL, Server-side Java, Spring Framework, MongoDB, Data Structures, and AI Model Training

## 1. SQL vs NoSQL

### SQL (Structured Query Language)
- **Relational Database**: Data is stored in tables.
- **Schema-based**: Fixed schema with columns and data types.
- **ACID properties**: Strong consistency.
- **Examples**: MySQL, PostgreSQL, Oracle, MS SQL Server

#### Example (MySQL)
```sql
CREATE TABLE Students (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT
);

INSERT INTO Students VALUES (1, 'Alice', 22);

SELECT * FROM Students;
NoSQL (Not Only SQL)
Non-relational Database: Document, key-value, graph, or column stores.

Flexible Schema: Can store different fields per record.

BASE properties: High availability.

Examples: MongoDB, CouchDB, Cassandra, Redis

Example (MongoDB - Document Store)
json
Copy
Edit
{
  "_id": 1,
  "name": "Alice",
  "age": 22
}
javascript

db.students.insertOne({ _id: 1, name: "Alice", age: 22 });
db.students.find();
2. Server-Side Java and UI-Backend Separation
In Java web development, the server handles business logic, and the frontend/UI handles user interactions.

Architecture Example
css

[User Interface (HTML/JS)] <--> [Servlets/Controllers] <--> [Service Layer] <--> [DAO] <--> [Database]
Example Code (Java Servlet)
java

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().write("Hello from server-side Java!");
    }
}
3. Spring Framework and MongoDB
Spring Framework
Lightweight Java framework for building enterprise apps.

Core modules: Spring Boot, Spring Data, Spring MVC, etc.

MongoDB Integration with Spring Boot
Sample Entity

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
}
Sample Repository

public interface StudentRepository extends MongoRepository<Student, String> {}
Sample Controller

@RestController
public class StudentController {
    @Autowired
    private StudentRepository repo;

    @GetMapping("/students")
    public List<Student> getAll() {
        return repo.findAll();
    }
}
4. Sample Data Structures
Array

int[] arr = {1, 2, 3, 4};
Linked List
java
Copy
Edit
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}
Stack (using ArrayList)

Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.pop();
HashMap

Map<String, Integer> map = new HashMap<>();
map.put("Math", 90);
System.out.println(map.get("Math"));
5. Training AI Models
Key Steps in AI Model Training
Data Collection: Raw dataset (CSV, images, etc.)

Preprocessing: Cleaning, normalization

Model Selection: Choose algorithm (e.g., decision tree, neural net)

Training: Fit model to data

Evaluation: Test accuracy, precision, recall

Deployment: Use in application