
# Core Java 

Core Java helps in writing **Object-Oriented Programming (OOPs)** programs. It also plays a major role in developing dynamic web applications using technologies like Servlets, JSP, JDBC, etc.

---

## File Types in Java and Web Applications

### RAR File

- A **RAR file** is a file that contains one or more files/folders in a smaller size.
- **Extension:** `.rar`

### WinRAR File

- **WinRAR** is software used to create and extract `.rar` and `.zip` files.
- It compresses multiple files into a single file.
- **Extensions:** `.rar`, `.zip`


### JAR File (Java Archive)

- A **JAR file** is a collection of `.class` files, metadata, and resources bundled together.
- Used to distribute Java applications and libraries.
- **Extension:** `.jar`

### What is a Server?

A **server** is a machine or software that provides services/data to other machines (clients) over a network.

#### Key Characteristics:

- Responds to client requests.
- Hosts web pages, APIs, databases, etc.

---

## Web Server

A **Web Server** delivers web content like HTML, CSS, JavaScript, images to users via HTTP/HTTPS protocols.

### Features:

- Handles HTTP requests from browsers.
- Sends static content to the client.
- Hosts sites like Google, Amazon, etc.

### Examples:

- Apache HTTP Server
- Nginx

---

## Application Server

An **Application Server** runs backend code and supports dynamic operations.

### Responsibilities:

- Executes Java programs like Servlets and JSPs.
- Handles business logic, security, transactions, etc.

### Example:

- **Apache Tomcat** – acts as a servlet container. It contains a servlet container that stores all servlets and expose it to outside devices.

---

## Web Container (Servlet Container)

- A **Web Container** manages Java web components like Servlets and JSPs.
- It creates servlet objects, calls methods like `doGet()` and `doPost()`, and handles HTTP requests/responses.

---

## Server-side Programming

**Server-side programming** involves running logic on the server to generate dynamic content.

### Features:

- Handles form data from HTML.
- Interacts with databases.
- Returns HTML or JSON responses.

### Examples of Server-side Languages:

- Java
- Python
- PHP
- Node.js
- C# (.NET)

---

## JDBC (Java Database Connectivity)

**JDBC** is a Java API for connecting and interacting with databases.

### Features:

- Allows executing SQL queries from Java.
- Useful for CRUD operations.
- Works with technologies like **Servlets** and **JSP**.

---

## Servlets in Java

### What is a Servlet?

A **Servlet** is a Java class used to handle HTTP requests and generate dynamic responses (HTML, JSON, etc.).

- Runs on a server inside a **Servlet container**.
- Communicates with front-end (HTML) pages.

---

## Running a Servlet with Tomcat

To run a servlet, follow these steps:

### Steps to Add Tomcat in Eclipse:

1. Go to **Window → Show View → Others → Servers**.
2. Add a new server (Tomcat).
3. Configure runtime and set project deployment.

> Tomcat includes a **Servlet Container** to manage and run servlets.


## Protocol

A **Protocol** is a set of rules that enable devices to communicate.

### Common Protocols:

- **HTTP** – for web data transfer.
- **HTTPS** – secure HTTP.
- **FTP** – file transfer.
- **SMTP** – email sending.

---

## HTTP Response Codes

| Code | Type            | Description                                  |
|------|-----------------|----------------------------------------------|
| 200  | Success         | Request processed successfully.              |
| 400  | Client Error    | Issue with the client request (bad input).   |
| 500  | Server Error    | Issue in server logic or configuration.      |

---

## Creating and Running a Servlet

### Steps:

1. Create a new Dynamic Web Project in Eclipse.
2. Create a Java class extending `HttpServlet`.
3. Override `doGet()` or `doPost()` methods.
4. Create a `sample.html` page in the `webapp` folder.
5. Add Tomcat server and deploy the project.
6. Access the servlet via browser:

```
http://localhost:8080/YourProject/sample.html
```
