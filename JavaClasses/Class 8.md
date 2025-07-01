# 📘 Java & Web Technology - Class 8 (14/06/2024)

---

## 🌐 DNS Mapping

- **DNS (Domain Name System)** is like the "phonebook" of the internet.
- It maps **domain names** (like `www.example.com`) to **IP addresses** (like `192.168.1.1`), which the computers understand.
- Without DNS, users would have to remember IP addresses instead of website names.

---

## 💻 JavaScript

- **JavaScript** is a scripting language used to make **websites interactive**.
- It runs in the browser (thanks to engines like **V8**) and allows dynamic updates to the content without reloading the page.

---

## 🗃️ Databases

### 1. **SQL (Structured Query Language)**

- SQL databases are **relational** databases.
- They store data in **tables** with **rows** and **columns**.
- Use **predefined schemas** and support **ACID transactions** (Atomicity, Consistency, Isolation, Durability).
- **Examples**:
  - Oracle
  - MySQL
  - Microsoft SQL Server

### 2. **NoSQL (Not Only SQL)**

- NoSQL databases are **non-relational** and can handle **unstructured or semi-structured data**.
- They are highly **scalable** and good for **big data** and **real-time applications**.
- Data is stored in various formats like **key-value**, **document**, **graph**, or **column-oriented**.
- **Example**:
  - MongoDB (Document-based)

### 🔄 SQL vs NoSQL Summary:

| Feature            | SQL (Relational)        | NoSQL (Non-relational)     |
|--------------------|--------------------------|-----------------------------|
| Schema             | Fixed and Predefined     | Flexible and Dynamic        |
| Data Format        | Tables (Rows & Columns)  | JSON, key-value, documents  |
| Scaling            | Vertical                 | Horizontal (easier to scale)|
| Query Language     | SQL                      | Varies (MongoDB uses MQL)   |
| Examples           | MySQL, Oracle            | MongoDB, CouchDB            |

---

## 🧠 JSON (JavaScript Object Notation)

- **JSON** is a lightweight format used to store and transport data.
- It is easy to read and write for humans, and easy to parse for machines.

### ✅ JSON Example:
```json
{
  "name": "John",
  "age": 25,
  "isStudent": false,
  "skills": ["Java", "Python", "JavaScript"],
  "address": {
    "city": "Hyderabad",
    "pin": 500081
  }
}
```

---

## 🖥️ Servers and Backend Technologies

- **Java**: Core language for enterprise server-side development.
- **Servlets**: Java programs that run on servers and handle requests/responses.
- **Spring MVC**: A Java framework for building scalable web applications.
- **Struts**: Another Java-based web application framework.
- **JS (JavaScript)**: Often used on both front-end and back-end (Node.js).
- **TSF**: Likely a typo/mix-up; could mean JSF (JavaServer Faces).

---

## 📦 Single Fat WAR (Web Application Archive)

- A **WAR file** is a packaged web application containing:
  - **UI (Frontend)**: HTML, CSS, JS
  - **Backend**: Java classes, servlets, configurations
- A "fat" WAR contains **everything in one deployable unit** — frontend and backend bundled together.

---

## ⚡ V8 JavaScript Engine

- **V8** is Google’s high-performance JavaScript engine.
- It compiles JavaScript directly to **native machine code**, enabling fast execution.
- Used in **Google Chrome** and **Node.js**.

---

## 🔥 What are MEAN and MERN Stacks?

Both are **JavaScript-based full-stack development frameworks**.

### 1. **MEAN** Stack:
- **M**ongoDB – NoSQL Database
- **E**xpress.js – Web application framework (Node.js backend)
- **A**ngular – Frontend framework
- **N**ode.js – Runtime for executing JS on the server

### 2. **MERN** Stack:
- **M**ongoDB – NoSQL Database
- **E**xpress.js – Backend framework
- **R**eact – Frontend library
- **N**ode.js – Server environment

---

## 📡 APIs (Application Programming Interfaces)

- APIs allow two software systems to **communicate** with each other.
- In web development, APIs let your frontend code **interact with backend services** or third-party platforms (like OpenAI, Google Maps, etc.).
- APIs define:
  - **How to request data**
  - **How to send data**
  - **What format (usually JSON)**

---

## 🧠 What are Large Language Models (LLMs)?

- **Large Language Models** are **AI models** trained on massive amounts of text data.
- They can:
  - Understand natural language
  - Generate text
  - Summarize, translate, answer questions, code, etc.
- Examples:
  - OpenAI’s **GPT-4**
  - Google’s **Gemini**
  - Meta’s **LLaMA**

---

## 🤖 LangChain and LangGraph

### 🔗 LangChain

- A **Python/JavaScript framework** that helps developers build applications using LLMs.
- Key Features:
  - **Chains**: Sequence of operations like prompt → LLM → output
  - **Agents**: Dynamic decision-makers that use tools based on user inputs
  - **Memory**: Store past conversation context
  - **Retrieval Augmented Generation (RAG)**: Use external knowledge sources

### 🔁 LangGraph

- A framework designed to build **stateful**, **multi-step applications** using **LangChain and LLMs**.
- Uses a **graph-based approach** to model complex interactions:
  - Nodes = tasks or logic
  - Edges = paths between decisions
- Built specifically for **multi-turn workflows** and **agentic behaviors**.

---

## 🤖 What is Agentic AI?

- **Agentic AI** refers to **AI systems that behave like agents**:
  - They make **decisions**, take **actions**, and **adapt** based on goals and environments.
- Agents can:
  - Use tools
  - Plan steps
  - Interact with APIs
  - Learn from feedback
- LangChain supports building such agents using LLMs + tools like browsers, calculators, etc.

---

## ✅ Summary

| Concept             | Description |
|---------------------|-------------|
| DNS Mapping         | Maps website names to IPs |
| JavaScript          | Makes websites interactive |
| SQL vs NoSQL        | SQL = structured, tabular; NoSQL = flexible, document/key-value |
| JSON Format         | Data format using key-value pairs |
| V8 Engine           | Executes JavaScript fast (used in Chrome/Node.js) |
| MEAN / MERN         | Full-stack JS frameworks (Mongo, Express, Angular/React, Node) |
| Single Fat WAR      | Combined deployable unit of UI + backend |
| API                 | Bridge to interact between client/server or external systems |
| LLMs                | Large AI models trained to understand/generate human-like text |
| LangChain           | Framework to build LLM-powered apps |
| LangGraph           | LangChain-based system for multi-step workflows |
| Agentic AI          | AI systems that act like intelligent agents with decision-making |

---
