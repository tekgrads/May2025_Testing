

#  Cookies and  Sessions in Java Servlets:

---

##  What are Cookies?

**Cookies** are small data pieces stored on the **client-side (browser)**. They are sent with every HTTP request to the server.

### Features:

* Stored in browser
* Can store multiple key-value pairs
* Limited in size and number
* Suitable for short-lived client-side data

---

##  What is a Session?

**Session** stores data on the **server-side**, and is unique to each client (browser session).

### Features:

* Safer than cookies (stored on server)
* Used to maintain user-specific data (login info, cart, etc.)
* Can store Java objects using `HttpSession`

---

## Cookie Example (Adding Two Numbers)

### AddServlet.java (Using Cookies)

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

---

### SqServlet.java (Using Cookies)

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
public class SqServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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

---

## Session Example (Adding Two Numbers)

### AddServlet\_Session.java (Using Session)

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addSessionDemo")
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

		res.sendRedirect("sqSessionDemo");
	}
}
```

---

### SqServlet\_Session.java (Reading Session Data)

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sqSessionDemo")
public class SqServlet_Session extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sn = req.getSession();

		Integer result = (Integer) sn.getAttribute("result");
		Integer num1 = (Integer) sn.getAttribute("num1");
		Integer num2 = (Integer) sn.getAttribute("num2");

		Integer sq = result * result;
		res.getWriter().print("Hello the square of " + num1 + " + " + num2 + " is " + sq);
	}
}
```


