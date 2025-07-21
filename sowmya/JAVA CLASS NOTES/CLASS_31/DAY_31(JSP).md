# JSP (Java Server Pages)

JSP is a Java-based technology used to build web pages that generate dynamic content.
It allows writing HTML and Java code together, making it easy to develop interactive content.
JSP runs on the **server side** and is commonly used in web applications built using Java.
Internally, JSP is converted into a **Servlet**.

---

## 📌 JSP Tags

There are 4 types of JSP tags they are:

## 1. Directive Tag

Used to give instructions to the JSP engine (like importing classes, setting page encoding, etc.)

**Syntax:**

```jsp
<%@ directive attribute="value" %>
```

**Example:**

```jsp
<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html" %>
```

---

## 2. Declaration Tag

Used to declare methods or variables that can be used later in the JSP file.

**Syntax:**

```jsp
<%! declaration %>
```

**Example:**

```jsp
<%! int square(int n) { return n * n; } %>
```

---

## 3. Scriptlet Tag

Used to write Java code inside the service method that gets executed on the server.

**Syntax:**

```jsp
<% Java code %>
```

**Example:**

```jsp
<%
  int x = 5;
  out.println("Value of x: " + x);
%>
```

---

## 4. Expression Tag

Used to output the value of a Java expression directly into HTML.

**Syntax:**

```jsp
<%= expression %>
```

**Example:**

```jsp
<%= 10 + 20 %>
```

---

## Implicit Objects

Implicit objects are built-in objects in JSP that you can use directly without creating them. They help you work with data like requests, responses, sessions, and output easily.

| Object        | Description                                 |
| ------------- | ------------------------------------------- |
| `request`     | Represents the HTTP request from the client |
| `response`    | Used to send a response to the client       |
| `session`     | Represents the user's session               |
| `application` | Shared data across the whole application    |
| `out`         | Sends output to the browser                 |
| `config`      | Servlet configuration info                  |
| `pageContext` | Provides access to all page-related data    |
| `page`        | Refers to the current JSP page (as object)  |
| `exception`   | Available only in error pages               |

---



## Example 1: JSP using Tags

```jsp
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h3>JSP tags</h3>

  <%-- Declaration tag --%>
  <%! 
    public String printMessage() {
      return "this is print method using declarative tag";
    }
  %>
  <br>

  <%-- Scriptlet tag --%>
  <% 
    int i = 1;
    int j = 2;
    int k = i + j;
    out.println("result is " + k);
  %>
  <br>

  <%-- Expression tag --%>
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

## Example 2: JSP with Loop and Include

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import ="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>jsp page</title>
</head>
<body>
  <% for (int i = 0; i < 5; i++) { %>
    <br>value of i = <%= i %>
  <% } %>
  <br>

  The time is <%= new Date() %>
  <br>

  <%-- Including another JSP file --%>
  <%@ include file="/secondjsp.jsp" %>
</body>
</html>
```

**secondjsp.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
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
The time is Mon Jul 21 14:12:56 IST 2025
This is another jsp file.
```

---


## Difference Between `request`, `session`, and `context`

* **requestScope**: Used for only one HTTP request.
* **sessionScope**: Persists across multiple requests from the same user (browser session). Opening a different browser creates a new session.
* **context**: Application-wide scope, persists for the entire life cycle of the servlet.

---

## Example 3: Program on Implicit Objects

### File: `implicitjsp.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
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
<br>
Request parameter has username as <%= userName %><br>
Session parameter has username as <%= session.getAttribute("savedUserName") %><br>
Context parameter has username as <%= context.getAttribute("savedUserName") %><br>
PageContext parameter has username as <%= context.getAttribute("savedUserName") %><br>
Config parameter has username as <%= getServletConfig().getInitParameter("defaultUser") %><br>
Context parameter from init as <%= context.getAttribute("defaultUser") %><br>

</body>
</html>
```

---

### File: `web.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
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

---

### URL:

```
http://localhost:8080/FirstServlet/implicitjsp.jsp?name=tekgrads
```

### Output:

```
Request parameter has username as tekgrads
Session parameter has username as tekgrads
Context parameter has username as tekgrads
PageContext parameter has username as tekgrads
Config parameter has username as Default username
Context parameter from init as Default username
```

---
