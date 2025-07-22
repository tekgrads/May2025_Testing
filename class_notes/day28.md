Java Servlets

---

## 📘 What is a Servlet?

A **Servlet** is a Java class used to handle **HTTP requests and responses** in a **web application**. Servlets run on a **Java-enabled web server (like Apache Tomcat)** and form the **backend logic** of web apps.

---

## 🧱 Servlet Lifecycle

The servlet lifecycle is managed by the **Servlet Container** and consists of:

1. **`init()`** – Initializes the servlet (called once).
2. **`service()`** – Handles client requests (called multiple times).
3. **`destroy()`** – Cleans up before the servlet is removed (called once).

---

## 🔹 Basic Servlet Example

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello from Servlet</h1>");
    }
}
📦 How to Deploy a Servlet?
Create a Dynamic Web Project (Eclipse/IntelliJ).

Write your Servlet class.

Configure the servlet in web.xml or use @WebServlet annotation.

✅ Using web.xml
xml
Copy
Edit
<servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
✅ Using @WebServlet
java
Copy
Edit
@WebServlet("/hello")
public class HelloServlet extends HttpServlet { ... }
📤 HTTP Methods in Servlets
Method	Description
doGet()	Handles HTTP GET requests
doPost()	Handles HTTP POST requests
doPut()	Updates resources
doDelete()	Deletes resources

🧰 Servlet API Packages
javax.servlet.*

javax.servlet.http.*

🧠 Key Interfaces & Classes
Interface/Class	Purpose
HttpServlet	Base class for handling HTTP
HttpServletRequest	Request data like params, headers
HttpServletResponse	Response object to send data
ServletConfig	Config info for servlet
ServletContext	Application-wide context

📌 Advantages of Servlets
Platform-independent (Java-based).

Better performance than CGI.

Scalable and robust.

Lifecycle managed by container.

🚧 Servlet vs JSP
Servlet	JSP
Java code only	HTML with Java inside
Better for logic	Better for UI

