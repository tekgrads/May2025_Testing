# Day 29

## Servlet Basics and Examples

### What is a Servlet?

A Servlet is a Java class used to handle HTTP requests and generate responses in a web application. It runs on a web server (like Apache Tomcat) and is part of Java EE.

---

### Servlet Life Cycle

A servlet goes through three major phases:

1. **Initialization (init())**: Called only once when the servlet is first created.  
2. **Service (service() or doGet(), doPost())**: Called for each request. Handles client input and generates responses.  
3. **Destruction (destroy())**: Called once when the servlet is taken out of service.

---

### HTTP Methods

To handle requests from HTML pages, use `HttpServlet`:

- **GET**: Retrieves data.  
- **POST**: Submits data.

---

### Deployment Descriptor (web.xml)

Java files are located in `WEB-INF` folder (private). To access them, define a Deployment Descriptor (`web.xml`).

**Real-World Example**: Like a gated community, security checks who's entering and seeks owner's permission.

**Steps**:  
- Create `web.xml` under `WEB-INF`.  
- Copy template and configure url-pattern like `/one`.  

---

### Example: `ServletOne.java`

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletOne extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet one");
    }
}
````

**web.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://jakarta.ee/xml/ns/jakartaee
                             http://jakarta.ee/xml/ns/jakartaee/web-app_4_0.xsd"
         version="4.0">

    <!-- Servlet Declaration -->
    <servlet>
        <servlet-name>ServletOne</servlet-name>
        <servlet-class>com.tekgrads.ServletOne</servlet-class>
    </servlet>

    <!-- Servlet Mapping -->
    <servlet-mapping>
        <servlet-name>ServletOne</servlet-name>
        <url-pattern>/one</url-pattern>
    </servlet-mapping>
</web-app>
```

Run in browser:
`http://localhost:8080/FirstServlet/one`

This URL maps to `ServletOne` class based on `web.xml` configuration.

---

### Modified Example: Counting Requests

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletOne extends GenericServlet {
    int count = 0;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet one " + count++);
    }
}
```

**Console Output:**

```
servlet one 0
servlet one 1
servlet one 2
...
```

Each hit to the servlet URL increments and prints the count value.

---

### Request Scope in Servlets

RequestScope is a scope in web applications where the data (object/variable) is available only during a single HTTP request. Once the request is completed and the response is sent back to the client, the data is discarded.

---

### Example: ServletOne with Counter Output

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletOne extends GenericServlet {
    int count = 0;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().print("this is servlet " + count++);
    }
}
```

**Output Example:**

```
this is servlet 11
```

---

### Sending Request Using HTML Form (GET method)

**GetForm.html**

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h1>Get Form</h1>
    <form action="one">
        <label>Name:</label>
        <input type="text" name="name"/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
```

**web.xml Configuration**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://jakarta.ee/xml/ns/jakartaee
                             http://jakarta.ee/xml/ns/jakartaee/web-app_4_0.xsd"
         version="4.0">

    <servlet>
        <servlet-name>ServletOne</servlet-name>
        <servlet-class>com.tekgrads.ServletOne</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ServletOne</servlet-name>
        <url-pattern>/one</url-pattern>
    </servlet-mapping>
</web-app>
```

**ServletOne.java**

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletOne extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        res.getWriter().print("hello " + name);
    }
}
```

**Output Example:**

```
hello tekgrads
```

---

### GET vs POST

**GET Method**

* Data visible in URL
* Not secure
* Limited data size

**POST Method**

* Data sent in body of request
* Secure
* Suitable for large/sensitive data

---

### Example: Login Form (GET Method)

**LoginForm.html**

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h1>LoginForm</h1>
    <form action="login">
        <label>UserName</label> <input type="text" name="username" /><br>
        <label>Password</label> <input type="password" name="password" /><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
```

**web.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <display-name>My Web Application</display-name>

    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>com.tekgrads.LoginServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
</web-app>
```

**LoginServlet.java**

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LoginServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        res.getWriter().print("Hello " + userName + " welcome");

        System.out.println("Password is " + password);
    }
}
```

**Output Example:**

Browser: `Hello tekgrads welcome`
Console: `Password is tekgrads`

URL:
`http://localhost:8080/FirstServlet/login?username=tekgrads&password=tekgrads`

---

### Example: Login Form (POST Method)

(Similar setup, but use `method="post"` in form)

---

### HttpServlet Example with doGet and doPost

```java
@WebServlet("/loginHttp")
public class LoginHttpServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        res.getWriter().print("Hello " + userName + " this is a post method");
        System.out.println("Password is " + password);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        res.getWriter().print("Hello " + userName + " this is a get method");
        System.out.println("Password is " + password);
    }
}
```

✅ Use `doGet()` for reading data
✅ Use `doPost()` for submitting secure/form data

---

### RequestDispatcher Example

**add.html**

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Addition</title>
</head>
<body>
  <h1>Addition Form</h1>
  <form action="add">
    <label>Number 1</label> <input type="text" name="num1" /><br>
    <label>Number 2</label> <input type="text" name="num2" /><br>
    <input type="submit" value="Submit" />
  </form>
</body>
</html>
```

**AddServlet.java**

```java
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));
        Integer result = num1 + num2;

        RequestDispatcher rd = req.getRequestDispatcher("/sq");
        req.setAttribute("result", result);
        rd.forward(req, res);
    }
}
```

**SqServlet.java**

```java
@WebServlet("/sq")
public class SqServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Integer result = (Integer) req.getAttribute("result");
        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));
        Integer sq = result * result;

        res.getWriter().print("Square of " + num1 + " and " + num2 + " is " + sq);
    }
}
```

**Output Example:**

```
Square of 10 and 20 is 900

