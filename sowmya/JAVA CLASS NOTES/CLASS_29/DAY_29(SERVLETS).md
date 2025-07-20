# SERVLETS

A **Servlet** is a Java program that runs on a web server and handles requests from web browsers, then sends back a response.

Receiving the request from HTML pages is done using technologies like **Servlets** and **JSP (Java Server Pages)**.

---

## Setup Steps

### After creating a servlet:

* Go to **Window → Perspective → Java** to add `src/main/java`.

### To import the Jakarta files:

* Right-click the project → **Properties** → Search for **Java Build Path** → Add jar files, Tomcat, and WebApp libraries → Save and Apply.
* Then import Jakarta classes like `HttpRequest`.

---

## Java Editions

* **J2EE**: Web application projects, maintained by Oracle. Includes all Jakarta files.
* **J2SE**: Core Java projects.

---

## Types of Servlets

```
Servlet
  └── GenericServlet
        └── HttpServlet
```

### GenericServlet

* A class providing a basic structure for servlets.
* Can be extended to create any type of servlet.
* Must override the `service()` method.

### HttpServlet

* Simplifies writing web applications.
* Provides built-in methods like `doGet()` and `doPost()`.

> Tip: Download the source code of `HttpServlet` and explore its implementation.

---

## Lifecycle of a Servlet

```
       ┌────────────┐
       │  Loading   │  (by container)
       └────┬───────┘
            ↓
     ┌──────────────┐
     │ Instantiation│
     └────┬─────────┘
            ↓
     ┌──────────────┐
     │   init()     │  ← Called once
     └────┬─────────┘
            ↓
     ┌──────────────┐
     │  service()   │  ← Called for each request
     └────┬─────────┘
            ↓
     ┌──────────────┐
     │  destroy()   │  ← Called once
     └──────────────┘
```

### Lifecycle Methods

1. **Loading**: Servlet container loads the class on first request.
2. **Instantiation**: Container calls `init()` once for initialization.
3. **Request Handling**: Container calls `service()` for every request.
4. **Destruction**: Container calls `destroy()` before removing the servlet.

---

## HTTP Methods

To handle requests from HTML pages, use **HttpServlet**:

1. **GET**: Retrieves data.
2. **POST**: Submits data.

---

## Deployment Descriptor (web.xml)

Java files are located in `WEB-INF` folder (private). To access them, define a **Deployment Descriptor** (`web.xml`).

### Real-World Example:

> Like a gated community, security checks who’s entering and seeks owner’s permission.

### Steps:

1. Create `web.xml` under `WEB-INF`.
2. Copy template and configure `url-pattern` like `/one`.

---

## Example: ServletOne.java

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
```

### web.xml

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

### Run in browser:

```
localhost:8080/FirstServlet/one
```

> This URL maps to `ServletOne` class based on `web.xml` configuration.

---

## Modified Example: Counting Requests

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

### Console Output:

```
servlet one 0
servlet one 1
servlet one 2
servlet one 3
servlet one 4
servlet one 5
servlet one 6
```

Each hit to the servlet URL increments and prints the `count` value.


## RequestScope in Servlets

**RequestScope** is a scope in web applications where the data (object/variable) is available only during a single HTTP request.
Once the request is completed and the response is sent back to the client, the data is discarded.

---

## ServletOne.java (with counter)

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
        // Print output to browser using response
        res.getWriter().print("this is servlet " + count++);
    }
}
```

### Explanation:

Every time the servlet is hit from the browser, it displays the output along with the count.

**Output Example:**

```
this is servlet 11
```

> This means the servlet was hit 11 times.

---

## Sending Request Using HTML Form (GET method)

### GetForm.html

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

### Explanation:

* The form submits to `/one`, which is mapped in `web.xml`.
* It sends a request to `ServletOne.java`.

---

## web.xml Configuration

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

### Explanation:

* Maps the URL `/one` to the `ServletOne` class.

---

## ServletOne.java (with form data)

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
        // Get parameter from form
        String name = req.getParameter("name");
        res.getWriter().print("hello " + name);
    }
}
```

### Output:

If the name is entered as **tekgrads** on the form:

```
hello tekgrads
```

---

### Summary:

* The HTML form submits to the `/one` URL.
* `web.xml` maps `/one` to `ServletOne.java`.
* The servlet retrieves the form input and sends a response back.

> Note: When using GET method, the input is visible in the URL, which is **insecure**.

---



# GET Method

* Used to **retrieve data**.
* Data is visible in the browser's URL, e.g., `?name=tekgrads`.
* Cannot send large amounts of data.
* **Insecure**, but **fast**.

### Example: Login Form using GET

#### `LoginForm.html`

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

#### `web.xml`

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

#### `LoginServlet.java`

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

#### Output:

* If you enter username as `tekgrads`, and password as `tekgrads`:

```
Hello tekgrads welcome
```

* Console: `Password is tekgrads`
* URL:

```
http://localhost:8080/FirstServlet/login?username=tekgrads&password=tekgrads
```

---


### Summary:

* The HTML form submits to the `/login` URL.
* `web.xml` maps `/login` to `LoginServlet.java`.
* The servlet retrieves the form input and sends a response back.


# POST Method

* Used to **submit data** securely.
* Data is sent in the **body** of the request, **not in URL**.
* Suitable for large/sensitive data, form submissions, file uploads, etc.

### Example: Login Form using POST

#### `LoginForm.html`

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h1>LoginForm</h1>
    <form action="login" method="post">
        <label>UserName</label> <input type="text" name="username" /><br>
        <label>Password</label> <input type="password" name="password" /><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
```

#### `web.xml`
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



#### `LoginServlet.java`

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



#### Output:

* If you enter username as `tekgrads`, and password as `tekgrads`:

```
Hello tekgrads welcome
```

* Console: `Password is tekgrads`
* URL remains unchanged:

```
http://localhost:8080/FirstServlet/login
```

---
### Summary:

* The HTML form submits to the `/login` URL.
* `web.xml` maps `/login` to `LoginServlet.java`.
* The servlet retrieves the form input and sends a response back.

> In summary:
>
> * **GET** is simple and fast but **not secure**.
> * **POST** is **secure**, supports **larger** data and is commonly used in form handling.




# HttpServlet Example with doGet and doPost Methods


### doGet

* `doGet()` handles **HTTP GET** requests.
* It is used when the client wants to **retrieve data** from the server.

### doPost

* `doPost()` handles **HTTP POST** requests.
* It is used when the client sends **data to the server**, such as submitting a form.
* Data is **hidden** (not shown in the URL).
* Suitable for **secure or large data** submission.

---

## Example: Login Form using GET and POST

### GET Login Form (LoginForm.html)

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h1>LoginForm</h1>
    <form action="loginHttp">
        <label>UserName</label> <input type="text" name="username" /><br>
        <label>Password</label> <input type="password" name="password" /><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
```

### POST Login Form (LoginForm.html)

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h1>LoginForm</h1>
    <form action="loginHttp" method="post">
        <label>UserName</label> <input type="text" name="username" /><br>
        <label>Password</label> <input type="password" name="password" /><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
```

---

## Servlet Code: LoginHttpServlet.java

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//instead of calling web.xml we can use @WebServlet and the /loginHttp we can pass as action on forms
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

---

## Output:

* After entering name and password:

  * The **name** is displayed on the **browser**.
  * The **password** is printed in the **console**.

* In **doGet()**, the **URL contains** the data:

  ```
  http://localhost:8080/YourApp/loginHttp?username=tekgrads&password=tekgrads
  ```

* In **doPost()**, the **URL does not display** the data.

---

> ✅ Use `doGet()` for reading data.
> ✅ Use `doPost()` for submitting secure/form data.





## HttpServlet: doGet and doPost

* `HttpServlet` can handle both **GET** and **POST** requests.
* If the request is a **GET**, it will call `doGet()`.
* If the request is a **POST**, it will call `doPost()`.

---

## GenericServlet

* `GenericServlet` is a protocol-independent servlet.
* It can handle both `doGet()` and `doPost()` logic if implemented inside `service()` method.

---

## RequestDispatcher

* `RequestDispatcher` is used in servlets to forward a request from one resource (like a servlet) to another within the **same web application**.

---

## Example: Sending Request to Another Servlet

### HTML Form (add.html)

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

---

### Servlet: AddServlet.java

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));
        Integer result = num1 + num2;

        // Forward to SqServlet with result as attribute
        RequestDispatcher rd = req.getRequestDispatcher("/sq");
        req.setAttribute("result", result);
        rd.forward(req, res);
    }
}
```

---

### Servlet: SqServlet.java

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

---

## Output

If we enter numbers in the HTML form (e.g., 10 and 20), then the result will be:

```
Square of 10 and 20 is 900
```

This message is displayed in the browser after processing the request using both servlets.

