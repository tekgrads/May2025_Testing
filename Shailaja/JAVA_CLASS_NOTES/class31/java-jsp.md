JSP (JavaServer Pages)
JSP is a server-side technology that enables the creation of dynamic, platform-independent web content using Java and HTML. Internally, JSP is converted to a servlet.

JSP Tags
1. Directive Tag
Used to instruct the JSP engine (e.g., for imports or page settings).

Syntax:

jsp
Copy
Edit
<%@ directive attribute="value" %>
Example:

jsp
Copy
Edit
<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html" %>
2. Declaration Tag
Used to declare variables or methods for use in JSP.

Syntax:

jsp
Copy
Edit
<%! declaration %>
Example:

jsp
Copy
Edit
<%! int square(int n) { return n * n; } %>
3. Scriptlet Tag
Used to write Java code inside JSP service logic.

Syntax:

jsp
Copy
Edit
<% Java code %>
Example:

jsp
Copy
Edit
<%
  int x = 5;
  out.println("Value of x: " + x);
%>
4. Expression Tag
Used to print a value directly into the response output.

Syntax:

jsp
Copy
Edit
<%= expression %>
Example:

jsp
Copy
Edit
<%= 10 + 20 %>
Implicit Objects in JSP
Object	Description
request	HTTP request object
response	HTTP response object
session	User-specific session
application	ServletContext shared across the app
out	Used to send output to browser
config	ServletConfig for the page
pageContext	Provides access to scoped variables
page	Reference to current JSP
exception	Error object (only on error pages)

Example 1: JSP using Tags
File: jsptags.jsp

jsp
Copy
Edit
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h3>JSP tags</h3>

  <%! 
    public String printMessage() {
      return "this is print method using declarative tag";
    }
  %>
  <br>

  <%
    int i = 1;
    int j = 2;
    int k = i + j;
    out.println("result is " + k);
  %>
  <br>

  name is: <%= request.getParameter("name") %>
  <br>

  <% out.println(printMessage()); %>
  <br>

  Value of k using expression tag is <%= k %>
</body>
</html>
URL:
http://localhost:8080/FirstServlet/jsptags.jsp?name=tekgrads

Output:

pgsql
Copy
Edit
JSP tags
result is 3
name is: tekgrads
this is print method using declarative tag
Value of k using expression tag is 3
Example 2: JSP with Loop and Include
File: loopinclude.jsp

jsp
Copy
Edit
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
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

  <%@ include file="/secondjsp.jsp" %>
</body>
</html>
File: secondjsp.jsp

jsp
Copy
Edit
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
Output:

java
Copy
Edit
value of i = 0
value of i = 1
value of i = 2
value of i = 3
value of i = 4
The time is Mon Jul 21 14:12:56 IST 2025
This is another jsp file.
Scope Differences in JSP
Scope	Description
requestScope	Lives for a single HTTP request
sessionScope	Persists across multiple requests by same user
context	Shared across all users and requests (application-wide)

Example 3: JSP Implicit Object Usage
File: implicitjsp.jsp

jsp
Copy
Edit
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
File: web.xml

xml
Copy
Edit
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
URL:

bash
Copy
Edit
http://localhost:8080/FirstServlet/implicitjsp.jsp?name=tekgrads
Output:

pgsql
Copy
Edit
Request parameter has username as tekgrads
Session parameter has username as tekgrads
Context parameter has username as tekgrads
PageContext parameter has username as tekgrads
Config parameter has username as Default username
Context parameter from init as Default username