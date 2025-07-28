MVC (Model View Controller)
Definition
MVC is a design pattern used to separate concerns in a web application:

Model: Contains business logic, data, and state.

View: Handles presentation (UI).

Controller: Handles user input and application flow.

Real-Time Analogy (Restaurant)
Model: Chef/Kitchen – Prepares food.

View: Waiter – Displays menu and serves food.

Controller: Order Taker – Takes order and manages communication.

Login Page Example (Web App)
View: login.jsp – UI that collects user input.

Controller: LoginServlet_New – Receives request, performs logic.

Model: LoginService & User – Handles data validation and user data.

Flow
User submits form in login.jsp.

LoginServlet_New receives request.

Calls LoginService.authenticate() for validation.

On success, fetches User, stores in session, forwards to success.jsp.

On failure, redirects to login.jsp.

MVC Program: Login Example
1. login.jsp
jsp
Copy
Edit
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
</head>
<body>
  <form action="LoginServlet_New" method="post">
    User ID: <input type="text" name="userId" /><br>
    Password: <input type="password" name="password" /><br>
    <input type="submit" />
  </form>
</body>
</html>
2. LoginServlet_New.java
java
Copy
Edit
package com.tekgrads;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet_New")
public class LoginServlet_New extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LoginService service = new LoginService();

    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    boolean isLoginSuccess = service.authenticate(userId, password);
    if (isLoginSuccess) {
      User user = service.getUser(userId);
      request.getSession().setAttribute("user", user);
      RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
      rd.forward(request, response);
    } else {
      response.sendRedirect("login.jsp");
    }
  }
}
3. LoginService.java
java
Copy
Edit
package com.tekgrads;

public class LoginService {
  public boolean authenticate(String userId, String password) {
    return "test1".equals(userId) && "1234".equals(password);
  }

  public User getUser(String userId) {
    User user = new User();
    user.setUserId(userId);
    user.setUserName("Test1");
    return user;
  }
}
4. User.java
java
Copy
Edit
package com.tekgrads;

public class User {
  private String userName;
  private String userId;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
5. success.jsp
jsp
Copy
Edit
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.tekgrads.User" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Success</title>
</head>
<body>
  Logged in Successfully.<br>
  <% User a = (User) session.getAttribute("user"); %>
  Hello, <%= a.getUserName() %><br>
</body>
</html>
URL to Test
bash
Copy
Edit
http://localhost:8080/FirstServlet/login.jsp
Expected Output
On Successful Login (userId: test1, password: 1234):
nginx
Copy
Edit
Logged in Successfully.
Hello, Test1
On Failed Login:
Redirects back to login.jsp.