
#  Cookies and Sessions in Servlets

##  Cookies in Servlets

A **cookie** is a small piece of information created by a web server and stored in the web browser to remember user data across multiple requests or visits.

- Stored on the user's browser.
- Sent back to the server with each request.



#### `AddServlet.java`
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


#### `SqServlet.java`
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

##  Sessions in Servlets

A **session** is created when a user visits the website. It stores user data server-side.

- Sessions are unique to a browser instance.
- Can hold user data across multiple requests.


###  Session Example


#### `AddServlet_Session.java`
```java

package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
		Integer result = num1+num2;
		HttpSession sn = req.getSession();
		sn.setAttribute("num1", num1);
		sn.setAttribute("num2", num2);
		sn.setAttribute("result", result);
		res.sendRedirect("sqSessionDemo");
	}
}


#### `SqServletSession.java`
```java

package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sqSessionDemo")
public class SqServlet_Session extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession sn = req.getSession();
		
		Integer result = (Integer)sn.getAttribute("result");
		Integer num1 = (Integer)(sn.getAttribute("num1"));
		Integer num2 = (Integer)(sn.getAttribute("num2"));
		
		Integer sq = result*result;
		res.getWriter().print("Hello the square of "+num1+" "+num2+" is" + sq);
		
		
		
			

	}
}

```

---


