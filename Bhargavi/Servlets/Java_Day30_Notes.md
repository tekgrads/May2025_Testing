Day30



\#  Cookies and  Sessions in Java Servlets:



---



\##  What are Cookies?



\*\*Cookies\*\* are small data pieces stored on the \*\*client-side (browser)\*\*. They are sent with every HTTP request to the server.



\### Features:



\* Stored in browser

\* Can store multiple key-value pairs

\* Limited in size and number

\* Suitable for short-lived client-side data



---



\##  What is a Session?



\*\*Session\*\* stores data on the \*\*server-side\*\*, and is unique to each client (browser session).



\### Features:



\* Safer than cookies (stored on server)

\* Used to maintain user-specific data (login info, cart, etc.)

\* Can store Java objects using `HttpSession`



---



\## Cookie Example (Adding Two Numbers)



\### AddServlet.java (Using Cookies)



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

&nbsp;	@Override

&nbsp;	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

&nbsp;		Integer num1 = Integer.parseInt(req.getParameter("num1"));

&nbsp;		Integer num2 = Integer.parseInt(req.getParameter("num2"));

&nbsp;		Integer result = num1 + num2;



&nbsp;		Cookie cookie1 = new Cookie("num1", num1.toString());

&nbsp;		Cookie cookie2 = new Cookie("num2", num2.toString());

&nbsp;		Cookie cookie3 = new Cookie("result", result.toString());



&nbsp;		res.addCookie(cookie1);

&nbsp;		res.addCookie(cookie2);

&nbsp;		res.addCookie(cookie3);



&nbsp;		res.sendRedirect("sq");

&nbsp;	}

}

```

⚠️ Disadvantages of Cookies

Can only store a small amount of data.

Can be stolen or tampered with if not properly secured.

Stored on the user’s device and can be cleared anytime.

Automatically sent with every request, which may affect performance.

Cookies allow passing data between servlets, but they have limitations and security concerns.



##### SESSION in Servlets

###### 

###### Session:

A session is created when a user visits the website. It allows the server to remember the user across multiple requests.



Sessions are stored on the server.

A session is specific to the browser instance (based on address).

If you open the same URL in a different browser (or incognito), a new session is created.

---



\### SqServlet.java (Using Cookies)



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

&nbsp;	@Override

&nbsp;	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

&nbsp;		Integer result = 0, num1 = 0, num2 = 0;



&nbsp;		for (Cookie cookie : req.getCookies()) {

&nbsp;			if ("num1".equals(cookie.getName())) {

&nbsp;				num1 = Integer.parseInt(cookie.getValue());

&nbsp;			} else if ("num2".equals(cookie.getName())) {

&nbsp;				num2 = Integer.parseInt(cookie.getValue());

&nbsp;			} else if ("result".equals(cookie.getName())) {

&nbsp;				result = Integer.parseInt(cookie.getValue());

&nbsp;			}

&nbsp;		}



&nbsp;		Integer sq = result \* result;

&nbsp;		res.getWriter().print("Hello the square of " + num1 + " + " + num2 + " is " + sq);

&nbsp;	}

}

```



---



\## Session Example (Adding Two Numbers)



\### AddServlet\\\_Session.java (Using Session)



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

public class AddServlet\_Session extends HttpServlet {

&nbsp;	@Override

&nbsp;	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

&nbsp;		Integer num1 = Integer.parseInt(req.getParameter("num1"));

&nbsp;		Integer num2 = Integer.parseInt(req.getParameter("num2"));

&nbsp;		Integer result = num1 + num2;



&nbsp;		HttpSession sn = req.getSession();

&nbsp;		sn.setAttribute("num1", num1);

&nbsp;		sn.setAttribute("num2", num2);

&nbsp;		sn.setAttribute("result", result);



&nbsp;		res.sendRedirect("sqSessionDemo");

&nbsp;	}

}

```



---



\### SqServlet\\\_Session.java (Reading Session Data)



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

public class SqServlet\_Session extends HttpServlet {

&nbsp;	@Override

&nbsp;	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

&nbsp;		HttpSession sn = req.getSession();



&nbsp;		Integer result = (Integer) sn.getAttribute("result");

&nbsp;		Integer num1 = (Integer) sn.getAttribute("num1");

&nbsp;		Integer num2 = (Integer) sn.getAttribute("num2");



&nbsp;		Integer sq = result \* result;

&nbsp;		res.getWriter().print("Hello the square of " + num1 + " + " + num2 + " is " + sq);

&nbsp;	}

}

```





