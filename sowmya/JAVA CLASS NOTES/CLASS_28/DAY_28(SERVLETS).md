
Core Java helps in writing OOPs programs.

---

## File Types

## RAR File

A RAR file is a compressed file that contains one or more files or folders in a smaller size.
**Extension:** `.rar`

## WinRAR File

It is a group of individual files packed as an archive.
**Extensions:** `.rar` or `.zip`

### Real-time Example:

Buying products in a shop and packing them in a cover.

## JAR File

It is a group of `.class` files bundled into a package and included in the classpath.
**Extension:** `.jar`

---

## Server

A **server** is a system that shares data or services with other systems (clients) over a network.

### Main Features:

* Responds to requests from clients.
* Common in websites, apps, and networks.

---

## Web Server

A **web server** serves website content to users over the internet using HTTP/HTTPS protocols.

### Main Features:

* Handles HTTP requests from web browsers.
* Sends HTML, CSS, JavaScript, images, etc., to the client.
* Works behind websites like Google, Amazon, Instagram, etc.
* Used for reading files, images, web pages, etc.

### Examples:

* Apache
* Nginx

---

## Application Server

An **Application Server** is software that runs backend code (like Java programs) and provides services like security, database access, and transaction management.

* Supports dynamic web pages capable of executing code.

### Example:

* **Tomcat**: Has a servlet container that holds and exposes servlets to the outside world.

---

## Web Container

A **Web Container** is part of a server that loads, runs, and manages Java-based web components like Servlets and JSPs.
It handles HTTP requests, creates servlet instances, and sends responses back to the client.

---

## Server-side Programming

**Server-side programming** is code that runs on a web server to:

* Handle user requests
* Connect to databases
* Generate dynamic content for the browser

### Examples of Server-side Languages:

* Java
* Python
* JavaScript (Node.js)
* .NET

---

## JDBC (Java Database Connectivity)

**JDBC** allows Java programs to connect and work with databases.
It is used to send SQL queries, get results, and update data from a Java application.

* We can run SQL queries and retrieve information.

### Example:

Receiving requests from HTML pages using technologies like **Servlets** and **JSP (Java Server Pages)**.




## SERVLETS

A **Servlet** is a Java program that runs on a web server and handles requests from web browsers, then sends back a response.

Receiving the request from HTML pages is done using technologies like **Servlets** and **JSP (Java Server Pages)**.

---

## Running a Servlet

To run any Servlet, we must create the Servlet and use a server like **Tomcat**.

### Steps to Add the Tomcat Server:

1. Go to **Window** → **Show View** → **Others** → **Servers**.
2. This will create a empty server.
3. Add the **Tomcat Server**.

Tomcat has a special feature called the **Servlet Container**, where the servlets are hosted and managed.

---

## Localhost

**Localhost** is the name a computer uses to refer to itself.

* It is used by developers to test websites or applications on their own machine before making them public.

---

## IP (Internet Protocol) Address

An **IP address** is a unique number assigned to each device connected to a computer network (like the Internet).

* It helps identify and locate devices so they can communicate with each other.

---

## Port

A **port** is a number that helps a computer know which program or service should handle the incoming or outgoing data.

### Example:

To represent a full address: `IP_ADDRESS:PORT`

Real time Example:
on hyderabad we are going some house here hyderabad called ip address and house address called port number

---

## Protocol

A **protocol** is a set of rules that devices follow to communicate over a network.

### Common Protocols:

* HTTP (Hypertext Transfer Protocol)
* HTML (Hypertext Markup Language)

---

## HTTP Error Codes

### 200: Success

* All successful attempts.

### 400: Client Error

* There is a problem with the client request.

### 500: Server Error

* The server encountered an exception or error.

---

## Creating and Running a Servlet

1. Create a Servlet in your dynamic web project.
2. Create an HTML file inside the `webapp` directory.
3. Add HTML tags and logic.
4. Save and refresh the Tomcat server.
5. Run your project using the browser:

```text
localhost:8080/FirstServlet/sample.html
```
