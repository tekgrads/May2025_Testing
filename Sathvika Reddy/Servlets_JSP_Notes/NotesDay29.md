

# **Servlet Basics and Examples**

## What is a Servlet?

A **Servlet** is a Java class used to handle HTTP requests and generate responses in a web application. It runs on a web server (like Apache Tomcat) and is part of Java EE.

---

## Servlet Life Cycle

A servlet goes through **three major phases**:

1. **Initialization** (`init()`):
   Called only once when the servlet is first created.

2. **Service** (`service()` or `doGet()`, `doPost()`):
   Called for each request. Handles client input and generates responses.

3. **Destruction** (`destroy()`):
   Called once when the servlet is taken out of service.

---

## Sample Servlet Example:


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
        String name = req.getParameter("name");
        res.getWriter().print("<h1>Hello " + name + " welcome</h1>");
    }
}
```

### GetForm.html:

```html
<form action="one">
    <label>Name:</label>
    <input type="text" name="name"/>
    <input type="submit" value="Submit"/>
</form>
```

---

##  Login Example with `HttpServlet`

### LoginHttpServlet:

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginHttp")
public class LoginHttpServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        res.getWriter().print("Hello " + userName + " welcome from post");
        System.out.println("Password is " + password);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        res.getWriter().print("Hello " + userName + " welcome from Get");
        System.out.println("Password is " + password);
    }
}
```

### LoginForm.html

```html
<form action="loginHttp" method="post">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <input type="submit" value="Submit"/>
</form>
```

---

##  What are Cookies?

Cookies are small key-value pairs sent from the server to the browser and stored on the client side. They are used to maintain session data like user info or preferences across requests.

---

##  Adding Numbers and Using Cookies

### AddingServlet:

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));
        Integer result = num1 + num2;

        Cookie cookie1 = new Cookie("num1", num1.toString());
        Cookie cookie2 = new Cookie("num2", num2.toString());
        Cookie cookie3 = new Cookie("result", result.toString());

        res.addCookie(cookie1);
        res.addCookie(cookie2);
        res.addCookie(cookie3);

        res.sendRedirect("sq");
    }
}
```

### add.html

```html
<form action="add">
    <input type="text" name="num1" />
    <input type="text" name="num2" />
    <input type="submit" value="Submit" />
</form>
```

---

### SqServlet: (Read Cookies and Square the Result)

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Integer result = 0, num1 = 0, num2 = 0;

        for (Cookie cookie : req.getCookies()) {
            if ("num1".equals(cookie.getName())) {
                num1 = Integer.parseInt(cookie.getValue());
            } else if ("num2".equals(cookie.getName())) {
                num2 = Integer.parseInt(cookie.getValue());
            } else if ("result".equals(cookie.getName())) {
                result = Integer.parseInt(cookie.getValue());
            }
        }

        Integer sq = result * result;
        res.getWriter().print("Hello the square of " + num1 + " + " + num2 + " is " + sq);
    }
}
```


