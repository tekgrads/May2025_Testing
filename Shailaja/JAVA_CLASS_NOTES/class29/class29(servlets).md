🔹 File Types
RAR File: Compressed file format. Extension: .rar

WinRAR File: Archive of multiple files. Extensions: .rar or .zip

JAR File: Java archive containing .class files. Extension: .jar

Real-Life Analogy: Packing items in a box for easy transport.

🔹 Server
A server shares data/services with clients over a network.

Common in websites, applications, networks.

Types of Servers:
1. Web Server

Sends HTML, CSS, JS over HTTP/HTTPS

Example: Apache, Nginx

2. Application Server

Runs backend code and provides services like DB access and security

Example: Tomcat (Java Servlets & JSP)

🔹 Web Container
Part of an Application Server

Manages lifecycle of Servlets and JSPs

Handles HTTP requests and responses

🔹 Servlets
What is a Servlet?
A Java class that handles requests and responses in a web application.

Lifecycle:
init() – Called once when servlet is first created

service() – Called for each request

destroy() – Called when servlet is removed

🔹 GenericServlet vs HttpServlet
Feature	GenericServlet	HttpServlet
Protocol Support	Protocol-independent	Supports only HTTP
Methods	service()	doGet(), doPost(), etc.
Use Case	Generic services (rarely used)	Web apps over HTTP (commonly used)

🔹 Localhost, IP, Port
localhost: Refers to the current machine (127.0.0.1)

IP Address: Unique device identifier in a network

Port: Logical endpoint (e.g., 8080 for Tomcat)
Example: 127.0.0.1:8080 or localhost:8080

🔹 Protocol
Rules for communication over the network

Common Protocols:

HTTP (HyperText Transfer Protocol)

HTML (Markup Language for web pages)

🔹 HTTP Status Codes
Code	Meaning
200	Success
400	Client Error
500	Server Error

🔹 JDBC (Java Database Connectivity)
API to connect Java with databases

Used in Servlets & JSP to handle SQL queries

🔹 Creating and Running a Servlet
Steps:
Create Dynamic Web Project in Eclipse

Add Servlet class extending HttpServlet or GenericServlet

Configure web.xml or use @WebServlet annotation

Deploy using Apache Tomcat

Run via browser: http://localhost:8080/YourApp/ServletURL

🔹 Servlet Programs and Outputs
✅ 1. GenericServlet Program
java
Copy
Edit
public class MyServlet extends GenericServlet {
    int count = 0;
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        res.getWriter().println("this is servlet " + count);
        count++;
    }
}
Output:

kotlin
Copy
Edit
this is servlet 0
this is servlet 1
this is servlet 2
...
✅ 2. HttpServlet Program with POST
HTML Form (sample.html):

html
Copy
Edit
<form action="loginhttp" method="post">
    <input type="text" name="username" />
    <input type="submit" />
</form>
Servlet:

java
Copy
Edit
public class LoginHttpServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("username");
        res.getWriter().println("hello " + name + " post");
    }
}
Input:

ini
Copy
Edit
username = Shailaja
Output:

nginx
Copy
Edit
hello Shailaja post
✅ 3. AddServlet + SqServlet with RequestDispatcher
HTML Form:

html
Copy
Edit
<form action="add">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <input type="submit">
</form>
AddServlet:

java
Copy
Edit
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));
        int k = i + j;
        req.setAttribute("k", k);
        RequestDispatcher rd = req.getRequestDispatcher("sq");
        rd.forward(req, res);
    }
}
SqServlet:

java
Copy
Edit
@WebServlet("/sq")
public class SqServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int k = (int) req.getAttribute("k");
        k = k * k;
        res.getWriter().println("square is " + k);
    }
}
Input:

ini
Copy
Edit
num1 = 4, num2 = 6
Output:

csharp
Copy
Edit
square is 100
Let me know if you want:

PDF version of these notes

Notes on Cookies, Session, ServletConfig, or Filter

Deployment steps for WAR file