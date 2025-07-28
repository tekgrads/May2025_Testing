 Cookies in Servlets
Definition:
Cookies are small text data stored in the browser and sent to the server with every request.

Flow:

add.html → sends form to /add

AddServlet → adds numbers, stores them in cookies, redirects to /sq

SqServlet → retrieves cookies, calculates square

Output Example:

csharp
Copy
Edit
Square of 5 and 8 is: 169
Limitations:

Small storage

Stored client-side (security risk)

Sent with every request

✅ Session in Servlets
Definition:
Session is server-side storage for user-specific data across multiple requests.

Flow:

addsession.html → sends form to /addSession

AddServlet_Session → stores data in HttpSession, redirects to /sqSession

SqServletSession → retrieves session data, calculates square

Output Example:

csharp
Copy
Edit
Square of 10 and 10 is: 400
Notes:

New browser = new session

URL sharing won’t persist session data

✅ ServletContext
Definition:
Shared storage for all servlets in a web application. Used to store application-wide data.

Flow:

Servlet reads request param and stores it in:

HttpSession (user-specific)

ServletContext (global)

Example URL + Output:

pgsql
Copy
Edit
http://localhost:8080/FirstServlet/Session?name=tekgrads

Request parameter has username as: tekgrads  
Session parameter has username as: tekgrads  
Context parameter has username as: tekgrads
✅ ServletConfig
Definition:
Used to pass initialization parameters to a specific servlet (via annotations or web.xml).

Output Example:

pgsql
Copy
Edit
Request parameter has username as: null  
Session parameter has username as: null  
Context parameter has username as: null  
Config parameter has default username as: Default Username
Console Output:

arduino
Copy
Edit
Servlet config is created
✅ web.xml Usage
Purpose:

Declare servlets and mappings

Set init-params for ServletConfig

Example Mapping:

xml
Copy
Edit
<servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>com.tekgrads.LoginServlet</servlet-class>
    <init-param>
        <param-name>username</param-name>
        <param-value>password</param-value>
    </init-param>
</servlet>
<servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/login</url-pattern>
</servlet-mapping>


1. Cookies in Servlet
Files:

add.html

html
Copy
Edit
<form action="add">
Enter 1st number: <input type="text" name="num1"><br>
Enter 2nd number: <input type="text" name="num2"><br>
<input type="submit">
</form>
AddServlet.java

java
Copy
Edit
package com.tekgrads;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int sum = num1 + num2;
        Cookie cookie = new Cookie("sum", sum + "");
        res.addCookie(cookie);
        res.sendRedirect("sq");
    }
}
SqServlet.java

java
Copy
Edit
package com.tekgrads;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int sum = 0;
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("sum")) {
                sum = Integer.parseInt(c.getValue());
            }
        }
        int square = sum * sum;
        res.getWriter().println("Square of " + sum + " is: " + square);
    }
}
Output:

vbnet
Copy
Edit
Input: num1 = 5, num2 = 8
Output: Square of 13 is: 169
2. Session in Servlet
Files:

addsession.html

html
Copy
Edit
<form action="addSession">
Enter 1st number: <input type="text" name="num1"><br>
Enter 2nd number: <input type="text" name="num2"><br>
<input type="submit">
</form>
AddServlet_Session.java

java
Copy
Edit
package com.tekgrads;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet_Session extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int sum = num1 + num2;
        HttpSession session = req.getSession();
        session.setAttribute("sum", sum);
        res.sendRedirect("sqSession");
    }
}
SqServletSession.java

java
Copy
Edit
package com.tekgrads;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SqServletSession extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int sum = (int) session.getAttribute("sum");
        int square = sum * sum;
        res.getWriter().println("Square of " + sum + " is: " + square);
    }
}
Output:

vbnet
Copy
Edit
Input: num1 = 10, num2 = 10
Output: Square of 20 is: 400
3. ServletContext Example
URL:

pgsql
Copy
Edit
http://localhost:8080/FirstServlet/Session?name=tekgrads
Servlet:

java
Copy
Edit
public class Session extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        ServletContext context = getServletContext();
        session.setAttribute("username", name);
        context.setAttribute("username", name);
        PrintWriter out = resp.getWriter();
        out.println("Request parameter has username as: " + name);
        out.println("Session parameter has username as: " + session.getAttribute("username"));
        out.println("Context parameter has username as: " + context.getAttribute("username"));
    }
}
Output:

pgsql
Copy
Edit
Request parameter has username as: tekgrads
Session parameter has username as: tekgrads
Context parameter has username as: tekgrads
4. ServletConfig Example
ServletConfig Example Servlet:

java
Copy
Edit
public class Config extends HttpServlet {
    ServletConfig config;
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("Servlet config is created");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        ServletContext context = getServletContext();
        String defaultName = config.getInitParameter("username");
        PrintWriter out = resp.getWriter();
        out.println("Request parameter has username as: " + name);
        out.println("Session parameter has username as: " + session.getAttribute("username"));
        out.println("Context parameter has username as: " + context.getAttribute("username"));
        out.println("Config parameter has default username as: " + defaultName);
    }
}
web.xml Configuration:

xml
Copy
Edit
<servlet>
    <servlet-name>Config</servlet-name>
    <servlet-class>com.tekgrads.Config</servlet-class>
    <init-param>
        <param-name>username</param-name>
        <param-value>Default Username</param-value>
    </init-param>
</servlet>
<servlet-mapping>
    <servlet-name>Config</servlet-name>
    <url-pattern>/config</url-pattern>
</servlet-mapping>
Output:

pgsql
Copy
Edit
Request parameter has username as: null
Session parameter has username as: null
Context parameter has username as: null
Config parameter has default username as: Default Username
Console Output:

arduino
Copy
Edit
Servlet config is created