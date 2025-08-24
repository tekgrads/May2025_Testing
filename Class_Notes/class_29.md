# SERVLETS

A **Servlet** is a Java program that runs on a web server, handles client requests (usually from browsers), and sends responses

Servlets and JSPs (JavaServer Pages) are used to receive and handle requests from HTML pages.

---

## Setup Instructions

### After Creating a Servlet:
- Navigate to: **Window → Perspective → Java**
- Add `src/main/java` to your project.

### Import Jakarta Libraries:
- Right-click project → **Properties** → **Java Build Path**
- Add JAR files (Tomcat/lib), and Jakarta EE/WebApp libraries.
- Save and apply the configuration.
- Import classes like `jakarta.servlet.http.HttpServlet`.

---

## Java Editions

- **J2EE (Jakarta EE)**: Used for enterprise-level web applications.
- **J2SE**: Used for core Java applications.

---

## Types of Servlets

```
Servlet
  └── GenericServlet
        └── HttpServlet
```

### GenericServlet
- Protocol-independent.
- Must override the `service()` method.

### HttpServlet
- Used for HTTP-specific functionality.
- Provides `doGet()` and `doPost()` methods.

> You can explore the source code of `HttpServlet` for better understanding.

---

## Lifecycle of a Servlet

```
       ┌────────────┐
       │  Loading   │
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
     │  service()   │  ← Called per request
     └────┬─────────┘
            ↓
     ┌──────────────┐
     │  destroy()   │  ← Called once
     └──────────────┘
```

---

## HTTP Methods

| Method | Purpose           | Visibility in URL | Suitable for     |
|--------|-------------------|-------------------|------------------|
| GET    | Retrieve data     | Visible            | Query/display    |
| POST   | Submit data       | Hidden (in body)   | Form/file uploads|


---

## Example: Simple Servlet

### ServletOne.java
```java

package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletOne extends GenericServlet{
	int count=0;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("<h1>Hello "+ name +" welcome</h1>");
		
	}

}


## Sending Data from HTML Form (GET Method)

### GetForm.html
```html
<form action="one">
    <label>Name:</label>
    <input type="text" name="name"/>
    <input type="submit" value="Submit"/>
</form>
```

### ServletOne.java (Form Data)
```java
public class ServletOne extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        res.getWriter().print("Hello " + name);
    }
}
```

```

---

## Example: Login Form using GET

### LoginForm.html
```html
<form action="login">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <input type="submit" value="Submit"/>
</form>
```

### LoginServlet.java
```java

package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginHttp")
public class LoginHttpServlet extends HttpServlet{	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("Hello "+ userName +" welcome from post");
		
		System.out.println("Password is "+ password);
       
    }
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("Hello "+ userName +" welcome from Get");
		
		System.out.println("Password is "+ password);
       
    }
	
	
	
}


---

## Example: Login Form using POST

### LoginForm.html
```html
<form action="login" method="post">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <input type="submit" value="Submit"/>
</form>
```

---

## HttpServlet with doGet() and doPost()

### LoginHttpServlet.java
```java
package com.tekgrads;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginProcess")
public class LoginProcessServlet extends HttpServlet{	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("");
		
		System.out.println("Password is "+ password);
       
    }
	
	
	
}

---

## RequestDispatcher Example

Use `RequestDispatcher` to forward a request from one servlet to another.

### HTML Form (add.html)
```html
<form action="add">
    <input type="text" name="num1" />
    <input type="text" name="num2" />
    <input type="submit" value="Submit" />
</form>
```

### AddServlet.java
```java

package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer num1 = Integer.parseInt(req.getParameter("num1"));
		Integer num2 = Integer.parseInt(req.getParameter("num2"));
		Integer result = num1+num2;
//		RequestDispatcher rd = req.getRequestDispatcher("/sq");
		req.setAttribute("result", result);
//		rd.forward(req, res);
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

### SqServlet.java
```java
package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		Integer result = (Integer)req.getAttribute("result");
//		Integer num1 = Integer.parseInt(req.getParameter("num1"));
//		Integer num2 = Integer.parseInt(req.getParameter("num2"));
		Integer result = 0;
		Integer num1 = 0;
		Integer num2 = 0;
		
		for (Cookie cookie : req.getCookies()) {
	        if ("num1".equals(cookie.getName())) {
	             num1 = Integer.parseInt(cookie.getValue());
	            // Do something with value
	        } else if("num2".equals(cookie.getName())) {
	        	 num2 = Integer.parseInt(cookie.getValue());
	        } else if("result".equals(cookie.getName())) {
	        	result =  Integer.parseInt(cookie.getValue());
	        }
	    }
		Integer sq = result*result;
		res.getWriter().print("Hello the square of "+num1+" "+num2+" is" + sq);
		
		
		
			

	}
}



---