Java Servlets – Steps, Types, and Methods

---

## ✅ What is a Servlet?

A **Servlet** is a Java class used to process client requests and generate responses, typically in **web applications**. Servlets are server-side components that extend the capabilities of servers.

---

## 🚀 Steps to Create and Run a Servlet

### 1. **Create a Servlet Class**
- Extend `HttpServlet`
- Override `doGet()` or `doPost()` method

```java
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // logic here
    }
}
2. Compile the Servlet
Use a Java compiler (javac) or IDE like Eclipse.

3. Deploy on a Servlet Container
Example: Apache Tomcat

Place class file in WEB-INF/classes

4. Configure the Servlet
Using web.xml (Deployment Descriptor):
xml
Copy
Edit
<servlet>
    <servlet-name>MyServlet</servlet-name>
    <servlet-class>MyServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>MyServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
OR using @WebServlet annotation:
java
Copy
Edit
@WebServlet("/hello")
public class MyServlet extends HttpServlet { ... }
🧱 Servlet Lifecycle Methods
init() – Called once when servlet is first created.

service() – Called every time a request is received.

destroy() – Called once when servlet is being removed.

🔁 Common HTTP Methods in Servlets
Method Name	Description
doGet()	Handles HTTP GET requests
doPost()	Handles HTTP POST requests
doPut()	Handles HTTP PUT requests
doDelete()	Handles HTTP DELETE requests

🧰 Important Interfaces and Classes
Interface/Class	Use
HttpServlet	Base class to create HTTP servlet
HttpServletRequest	To access request data like parameters, headers
HttpServletResponse	To send response back to the client
ServletConfig	To get configuration data for a single servlet
ServletContext	To share data between servlets

📂 Types of Servlets
Type	Description
GenericServlet	Protocol-independent (not limited to HTTP)
HttpServlet	Most commonly used, handles HTTP requests only

✨ Advantages of Servlets
Portable (Java-based)

Efficient (multi-threaded)

Scalable and maintainable

Easy integration with Java technologies (JSP, JDBC)

