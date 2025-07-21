## Cookies in Servlets

## Cookie:

A cookie is a small piece of information created by a web server and stored in the web browser to remember user data across multiple requests or visits.

* Cookies are stored on the user's browser.
* Cookies are sent back to the server with each request.

### 📌 Real-time Example

You add items to an online shopping cart → cookies help remember those items even if you refresh or come back later.

---

## Example Program Using Cookies

### 🔹 add.html

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h1>LoginForm</h1>
  <form action="add">
    <label>Number 1</label> <input type="text" name="num1" /><br>
    <label>Number 2</label> <input type="text" name="num2" /><br>
    <input type="submit" value="Submit" />
  </form>
</body>
</html>
```

### 🔹 AddServlet.java

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    Integer num1 = Integer.parseInt(req.getParameter("num1"));
    Integer num2 = Integer.parseInt(req.getParameter("num2"));
    Integer result = num1 + num2;

    res.addCookie(new Cookie("num1", num1.toString()));
    res.addCookie(new Cookie("num2", num2.toString()));
    res.addCookie(new Cookie("result", result.toString()));

    res.sendRedirect("sq");
  }
}
```

### 🔹 SqServlet.java

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    int num1 = 0, num2 = 0, result = 0;

    for (Cookie c : req.getCookies()) {
      switch (c.getName()) {
        case "num1": num1 = Integer.parseInt(c.getValue()); break;
        case "num2": num2 = Integer.parseInt(c.getValue()); break;
        case "result": result = Integer.parseInt(c.getValue()); break;
      }
    }

    int sq = result * result;
    res.getWriter().print("Square of " + num1 + " and " + num2 + " is: " + sq);
  }
}
```

### ✅ Output

```
Square of 5 and 8 is: 169
```

**Flow:**

* `add.html` → `AddServlet` → `SqServlet`
* Form action sends data to `/add` → `AddServlet` uses cookies to forward data → `SqServlet` reads cookies and prints square.

---

## ⚠️ Disadvantages of Cookies

* Can only store a small amount of data.
* Can be stolen or tampered with if not properly secured.
* Stored on the user’s device and can be cleared anytime.
* Automatically sent with every request, which may affect performance.

> Cookies allow passing data between servlets, but they have limitations and security concerns.

---



# SESSION in Servlets

## Session:

A **session** is created when a user visits the website. It allows the server to remember the user across multiple requests.

* Sessions are stored **on the server**.
* A session is specific to the browser instance (based on address).
* If you open the same URL in a different browser (or incognito), a new session is created.

### 💡 Real-Life Example

> When you log in to a website and navigate across pages without logging in again — that's the session keeping you logged in.

---

## 💻 Example Code: Session Handling in Servlets

### 🔸 `addsession.html`

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Session program</title>
</head>
<body>
  <h1>LoginForm</h1>
  <form action="addSession">
    <label>Number 1</label> <input type="text" name="num1" /><br>
    <label>Number 2</label> <input type="text" name="num2" /><br>
    <input type="submit" value="Submit" />
  </form>
</body>
</html>
```

### 🔸 `AddServlet_Session.java`

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/addSession")
public class AddServlet_Session extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Integer num1 = Integer.parseInt(req.getParameter("num1"));
    Integer num2 = Integer.parseInt(req.getParameter("num2"));
    Integer result = num1 + num2;

    HttpSession sn = req.getSession();
    sn.setAttribute("num1", num1);
    sn.setAttribute("num2", num2);
    sn.setAttribute("result", result);

    res.sendRedirect("sqSession");
  }
}
```

### 🔸 `SqServletSession.java`

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/sqSession")
public class SqServletSession extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession hs = req.getSession();

    Integer num1 = (Integer) hs.getAttribute("num1");
    Integer num2 = (Integer) hs.getAttribute("num2");
    Integer result = (Integer) hs.getAttribute("result");

    Integer sq = result * result;
    res.getWriter().print("Square of " + num1 + " and " + num2 + " is: " + sq);
  }
}
```

---

## ✅ Output

```
Square of 10 and 10 is: 400
```

---

## 🔄 Flow Summary

1. `addsession.html` → sends request to `addSession` servlet.
2. `AddServlet_Session.java` → creates a session, stores values, redirects to `sqSession`.
3. `SqServletSession.java` → retrieves session data and displays the result.

> Since session data is stored server-side, copying the URL to another browser won't work (session IDs differ).

---

## CONTEXT in Servlets

##  ServletContext:

* A **ServletContext** is created **once per web application** when the server starts.
* Used to store **global data**, accessible by all servlets and JSPs.
* Enables communication between servlets by sharing values.
* If a request parameter is missing, the servlet can use a **default value** (set using annotations).
* Even when a new browser window is opened, context parameters remain accessible.
* Available throughout the **lifecycle of the servlet container**.

---

## 💻 Example Code: `AddServletContext.java`

```java
package com.tekgrads;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(
    urlPatterns = "/Session")
public class AddServletContext extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String userName = request.getParameter("name");
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        if (userName != null && !userName.isEmpty()) {
            session.setAttribute("savedUserName", userName);
            context.setAttribute("savedUserName", userName);
        }

        writer.println("Request parameter has username as: " + userName + "<br>");
        writer.println("Session parameter has username as: " + (String) session.getAttribute("savedUserName") + "<br>");
        writer.println("Context parameter has username as: " + (String) context.getAttribute("savedUserName") + "<br>");
    }
}
```

---

## 🌐 URL Examples & Output

### ✅ New Tab (Same Browser)

**URL:**

```
http://localhost:8080/FirstServlet/Session?name=tekgrads
```

**Output:**

```
Request parameter has username as tekgrads
Session parameter has username as tekgrads
Context parameter has username as tekgrads
```

### 🚫 Another Tab (No Name Parameter)

**URL:**

```
http://localhost:8080/FirstServlet/Session
```

**Output:**

```
Request parameter has username as null
Session parameter has username as tekgrads
Context parameter has username as tekgrads
```

### 🌐 Another Browser

**URL:**

```
http://localhost:8080/FirstServlet/Session
```

**Output:**

```
Request parameter has username as null
Session parameter has username as null
Context parameter has username as tekgrads
```

---




## ServletConfig:

* Used to pass **initialization parameters** to a specific servlet.
* Defined either via **annotations** or in `web.xml`.
* Created **once per servlet** by the **web container**.
* Accessible using `this.getServletConfig()`.
* The default method in `HttpServlet` is:

```java
public void init(ServletConfig config)
```

---

## 💻 Example Code: `AddServletConfig.java`

```java
package com.tekgrads;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(
    urlPatterns = "/Session",
    initParams = { @WebInitParam(name = "name", value = "Default Username") }
)
public class AddServletConfig extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        System.out.println("Servlet config is created");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String userName = request.getParameter("name");
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        if (userName != null && !userName.isEmpty()) {
            session.setAttribute("savedUserName", userName);
            context.setAttribute("savedUserName", userName);
        }

        writer.println("Request parameter has username as: " + userName + "<br>");
        writer.println("Session parameter has username as: " + session.getAttribute("savedUserName") + "<br>");
        writer.println("Context parameter has username as: " + context.getAttribute("savedUserName") + "<br>");
        writer.println("Config parameter has default username as: " + this.getServletConfig().getInitParameter("name") + "<br>");
    }
}
```

---

## 🌐 URL Example (New Tab)

**URL:**

```
http://localhost:8080/FirstServlet/Session
```

**Expected Output:**

```
Request parameter has username as null
Session parameter has username as null
Context parameter has username as null
Config parameter has default username as Default Username
```

### 📌 Console Output:

```
Servlet config is created
```

> Note: ServletConfig is initialized only **once**, even if the servlet is accessed multiple times.

---

## 🧾 Another Way: Using `web.xml`

### web.xml Example:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <display-name>My Web Application</display-name>

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

    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>com.tekgrads.LoginServlet</servlet-class>
        <init-param>
            <param-name>username</param-name>
            <param-value>password</param-value>
        </init-param>
    </servlet>

    <!-- Servlet Mapping -->
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>

</web-app>
```

---
