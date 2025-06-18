# 📘 Java Note – Class 8 (14/06/2024)

## 🌐 DNS Mapping
- Maps domain names (e.g., `www.site.com`) to IP addresses.
- Like a phonebook for the internet.
- Without DNS, users would need to remember numeric IPs.

---

## 💻 JavaScript & V8 Engine
- JavaScript adds interactivity to web pages and runs in the browser.
- **V8 Engine** (by Google): Converts JS to machine code for fast execution (used in Chrome, Node.js).

---

## 🗃 SQL vs NoSQL Databases

**SQL:**
- Structured, relational, uses tables.
- Follows ACID properties.
- Examples: MySQL, Oracle.

**NoSQL:**
- Flexible, handles semi/unstructured data.
- Supports horizontal scaling.
- Examples: MongoDB, CouchDB.

| Feature   | SQL                | NoSQL                      |
|-----------|--------------------|-----------------------------|
| Schema    | Fixed              | Flexible                   |
| Format    | Tables             | JSON / Key-Value           |
| Scaling   | Vertical           | Horizontal                 |
| Language  | SQL                | MQL / Others               |

---

## 🧠 JSON Format

- Lightweight data exchange format.
- Uses key-value pairs.
- Easy to read/write and parse.
{
  "name": "John",
  "age": 25,
  "skills": ["Java", "Python"],
  "address": { "city": "Hyderabad" }
}
## 🖥 Backend Tech

- **Java**: Core backend logic.
- **Servlets**: Handle HTTP requests.
- **Spring MVC / Struts**: Java frameworks for scalable web apps.
- **WAR (Web Application Archive)**: Contains frontend + backend in one deployable file.

## 📦 Single Fat WAR

- All-in-one deployable `.war` file:
  - **Frontend**: HTML, CSS, JS
  - **Backend**: Java servlets, configs

## 🔥 MEAN vs MERN Stacks

| Stack | Frontend | Backend             | DB       |
|-------|----------|----------------------|----------|
| MEAN  | Angular  | Express + Node.js    | MongoDB  |
| MERN  | React    | Express + Node.js    | MongoDB  |

## 📡 APIs

- Interfaces for communication between systems.
- Web APIs use JSON to send/receive data between frontend, backend, or external services.

## 🤖 Large Language Models (LLMs)

- Trained on huge datasets.
- Capabilities: text generation, summarization, translation, etc.
- Examples: **GPT-4**, **Gemini**, **LLaMA**

## 🔗 LangChain & LangGraph

**LangChain:**
- Framework to build LLM-based apps.
- Key Components:
  - Chains, Agents, Memory, RAG

**LangGraph:**
- Adds multi-step workflows to LangChain.
- Graph structure:
  - Nodes = Steps
  - Edges = Decisions

## 🧠 Agentic AI

- AI that acts autonomously like agents:
  - Make decisions
  - Use tools
  - Adapt using feedback

## 🛠 Tech Use Cases

**Java for Backend:**
- Handles business logic and APIs (e.g., Spring Boot).

**Separation of UI & Backend:**
- UI = Waiter (HTML/JS)
- Backend = Chef (Java/Python)

**Spring + MongoDB Example:**
@Document("students")
public class Student {
    private String name;
    private int age;
    private List<String> courses;
}
```

**Equivalent JSON:**
```json
{ "name": "Bob", "age": 22, "courses": ["Math", "Java"] }
```

**Training AI Models:**
- Use Python with TensorFlow / PyTorch.
- Needs: data, GPUs, training loops.

---

## 🧩 JS vs Python Use

| Language | Used For              | Example                |
|----------|-----------------------|------------------------|
| JS       | Frontend + Node.js    | Interactive UI         |
| Python   | AI, data, backend APIs| Automation, AI Models  |