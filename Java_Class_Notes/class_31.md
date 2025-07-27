
# JSP (Java Server Pages)

JSP is a Java-based technology used to build web pages that generate dynamic content.  
It allows writing HTML and Java code together, making it easy to develop interactive content.  
JSP runs on the **server side** and is commonly used in web applications built using Java.  
Internally, JSP is converted into a **Servlet**.

---

# MVC (Model View Controller)

### Model
- Helps to carry and manage the data.
- **Examples**: Database access, business logic, calculations.

### View
- Responsible for rendering and displaying data.
- **Examples**: JSP page, HTML page.

### Controller
- Handles user input and application flow.
- **Examples**: Servlet or Spring Controller.

### Real-Time Example (Restaurant)
- In a restaurant, the waiter shows the menu.
- We place an order, and the waiter sends the request to the kitchen.
- After preparation, the food is served.

**Mapping:**
- **Model**: Kitchen/Chef – Prepares the food.
- **View**: Waiter – Displays menu, serves food.
- **Controller**: Order Taker/Manager – Takes order, communicates with the kitchen.

### Separation of Concerns
Each component has its own responsibility and does not interfere with others.

---

## Another Example (Login Web Page)

- The browser has a login page (view).
- User submits details → Controller (Servlet) handles input.
- Controller validates using Model → returns result to JSP (view).

**Mapping:**
- **View**: Login page (HTML/JSP)
- **Controller**: Servlet
- **Model**: Java class to validate user

**Flow**:
User submits login form → Servlet receives → Uses service/model to validate → forwards to JSP (View)

---

# MVC Program: Login Example

## login.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Login Page</title></head>
<body>
  <form action="LoginServlet_New" method="post">
    User ID: <input type="text" name="userId" /><br>
    Password: <input type="password" name="password" /><br>
    <input type="submit" />
  </form>
</body>
</html>
```

## LoginServlet_New.java
```java
package com.tekgrads;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet_New")
public class LoginServlet_New extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LoginService service = new LoginService();
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    boolean isLoginSuccess = service.authenticate(userId, password);
    if (isLoginSuccess) {
      User user = service.getUser(userId);
      request.getSession().setAttribute("user", user);
      RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
      rd.forward(request, response);
    } else {
      response.sendRedirect("login.jsp");
    }
  }
}
```

## LoginService.java
```java
package com.tekgrads;

public class LoginService {
  public boolean authenticate(String userId, String password) {
    return "test1".equals(userId) && "1234".equals(password);
  }

  public User getUser(String userId) {
    User user = new User();
    user.setUserId(userId);
    user.setUserName("Test1");
    return user;
  }
}
```

## User.java
```java
package com.tekgrads;

public class User {
  private String userName;
  private String userId;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
```

## success.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.tekgrads.User" %>
<!DOCTYPE html>
<html>
<head><title>Login Success</title></head>
<body>
  Logged in Successfully.<br>
  <% User a = (User) session.getAttribute("user"); %>
  Hello, <%= a.getUserName() %><br>
</body>
</html>
```

### Flow:
login.jsp → LoginServlet_New → LoginService → User → success.jsp  
(Or redirect back to login.jsp on failure)

**URL:**  
`http://localhost:8080/FirstServlet/login.jsp`

**Output:**  
```
Logged in Successfully.
Hello, Test1
```

---

# JSP Tags

There are 4 types of JSP tags:

### 1. Directive Tag
Used to give instructions to the JSP engine.

**Syntax:**
```jsp
<%@ directive attribute="value" %>
```

**Example:**
```jsp
<%@ page import="java.io.PrintWriter" %>
```

### 2. Declaration Tag
Used to declare methods or variables.

**Syntax:**
```jsp
<%! declaration %>
```

**Example:**
```jsp
<%! int square(int n) { return n * n; } %>
```

### 3. Scriptlet Tag
Used to write Java code inside the JSP.

**Syntax:**
```jsp
<% Java code %>
```

**Example:**
```jsp
<% int x = 5; out.println("Value of x: " + x); %>
```

### 4. Expression Tag
Used to print the result of a Java expression.

**Syntax:**
```jsp
<%= expression %>
```

**Example:**
```jsp
<%= 10 + 20 %>
```

---

## Example: JSP using Tags
```jsp
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>JSP Tags Example</title></head>
<body>
  <h3>JSP tags</h3>

  <%! 
    public String printMessage() {
      return "this is print method using declarative tag";
    }
  %>
  <br>

  <%
    int i = 1;
    int j = 2;
    int k = i + j;
    out.println("result is " + k);
  %>
  <br>

  name is: <%= request.getParameter("name") %>
  <br>

  <% out.println(printMessage()); %>
  <br>

  Value of k using expression tag is <%= k %>
</body>
</html>
```

**URL:**  
`http://localhost:8080/FirstServlet/jsptags.jsp?name=tekgrads`

**Output:**
```
JSP tags
result is 3
name is: tekgrads
this is print method using declarative tag
Value of k using expression tag is 3
```

---

## Example: JSP with Loop and Include

### main.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import ="java.util.Date"%>
<!DOCTYPE html>
<html>
<head><title>JSP with Include</title></head>
<body>
  <% for (int i = 0; i < 5; i++) { %>
    <br>value of i = <%= i %>
  <% } %>
  <br>
  The time is <%= new Date() %>
  <br>
  <%@ include file="/secondjsp.jsp" %>
</body>
</html>
```

### secondjsp.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Second JSP</title></head>
<body>
  This is another jsp file.
</body>
</html>
```

**Output:**
```
value of i = 0
value of i = 1
value of i = 2
value of i = 3
value of i = 4
The time is [current timestamp]
This is another jsp file.
```

---

## Scope Comparison: `request`, `session`, and `context`

- **request**: Lives for a single HTTP request.
- **session**: Lives for a user's session (across multiple requests).
- **context (application)**: Shared across the entire application.

---

# Example: Implicit Objects

## File: implicitjsp.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Implicit Objects</title></head>
<body>

<%!
  public void jspInit() {
    String defaultUser = getServletConfig().getInitParameter("defaultUser");
    ServletContext context = getServletContext();
    context.setAttribute("defaultUser", defaultUser);
  }
%>

<%
  String userName = request.getParameter("name");
  ServletContext context = request.getServletContext();
  if (userName != null && !userName.isEmpty()) {
    session.setAttribute("savedUserName", userName);
    context.setAttribute("savedUserName", userName);
    pageContext.setAttribute("pageContextUserName", userName, PageContext.APPLICATION_SCOPE);
    pageContext.findAttribute("savedUserName");
  }
%>

Request parameter has username as <%= userName %><br>
Session parameter has username as <%= session.getAttribute("savedUserName") %><br>
Context parameter has username as <%= context.getAttribute("savedUserName") %><br>
PageContext parameter has username as <%= context.getAttribute("savedUserName") %><br>
Config parameter has username as <%= getServletConfig().getInitParameter("defaultUser") %><br>
Context parameter from init as <%= context.getAttribute("defaultUser") %><br>

</body>
</html>
```

## web.xml
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

  <display-name>My Web Application</display-name>

  <servlet>
    <servlet-name>implicitjsp</servlet-name>
    <jsp-file>/implicitjsp.jsp</jsp-file>
    <init-param>
      <param-name>defaultUser</param-name>
      <param-value>Default username</param-value>
    </init-param>
  </servlet>

  <servlet-mapping>
    <servlet-name>implicitjsp</servlet-name>
    <url-pattern>/implicitjsp.jsp</url-pattern>
  </servlet-mapping>
</web-app>
```

**URL:**  
`http://localhost:8080/FirstServlet/implicitjsp.jsp?name=tekgrads`

**Output:**
```
Request parameter has username as tekgrads
Session parameter has username as tekgrads
Context parameter has username as tekgrads
PageContext parameter has username as tekgrads
Config parameter has username as Default username
Context parameter from init as Default username
```
