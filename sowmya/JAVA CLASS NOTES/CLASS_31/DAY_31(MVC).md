# MVC (Model View Controller)



### Model

* Helps to carry and manage the data.
* **Examples**: Database access, business logic, calculations.

### View

* Responsible for rendering and displaying data.
* **Examples**: JSP page, HTML page.

### Controller

* Handles user input and application flow.
* **Examples**: Servlet or Spring Controller.

---

##  Real-Time Example (Restaurant)
*if we go for the restaurant the waiter comes and show the menu
after that we order the item and waiter send request to cook for that order
after completion of the item prepared the waiter takes that and the presenter presents the food

* **Model**: Kitchen/Chef – Prepares the food.
* **View**: Waiter – Displays menu, serves food.
* **Controller**: Order Taker/Manager – Takes order, communicates with the kitchen.

### Separation of Concerns:

Each component has its own responsibility and does not interfere with others.

---

##  Another Example (Login Web Page)

* the web browser have login page(view) we submit the details here
and the model takes that gives to servlet(controller)checks the username and password are correct or not.
the controller send the respnose to the model. the model gives to jsp 
jsp gives the user which is visible on the screen.

* **View**: Login page (HTML/JSP)
* **Controller**: Servlet
* **Model**: Logic to validate user (Java classes)

User submits login form → Servlet receives → Servlet uses service/model to validate → forwards to JSP (View).

---

## Example:. MVC Program: Login Example

### `login.jsp`

```jsp
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
```

### `LoginServlet_New.java`

```java
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
```

### `LoginService.java`

```java
package com.tekgrads;

public class LoginService {
  public boolean authenticate(String userId, String password) {
    // dummy check
    return "test1".equals(userId) && "1234".equals(password);
  }

  public User getUser(String userId) {
    User user = new User();
    user.setUserId(userId);
    user.setUserName("Test1");
    return user;
  }
}
```

### `User.java`

```java
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
```

### `success.jsp`

```jsp
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
```

---

### Flow is

* `login.jsp` → `LoginServlet_New` → `LoginService` → `User` → `success.jsp` (or back to login on failure)

---


##  URL 

```
http://localhost:8080/FirstServlet/login.jsp
```

##  Output (on successful login)

```
Logged in Successfully.
Hello, Test1
```

---
