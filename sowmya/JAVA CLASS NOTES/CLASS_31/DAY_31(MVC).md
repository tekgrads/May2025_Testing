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


# HTML Form with Servlet Example (Markdown for Git)

## HtmlTags.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details Form</title>
</head>
<body>
    <h1>Employee Form</h1>
    <form method="post" action="MultiParamServlet">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" step="0.01" required><br><br>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br><br>

        <label>Profession:</label><br>
        <input type="radio" id="developer" name="prof" value="Developer" required>
        <label for="developer">Developer</label>

        <input type="radio" id="architect" name="prof" value="Architect">
        <label for="architect">Architect</label><br><br>

        <label for="project">Select Project:</label>
        <select id="project" name="project" required>
            <option value="Project 1">Project 1</option>
            <option value="Project 2">Project 2</option>
            <option value="Project 3">Project 3</option>
            <option value="Project 4">Project 4</option>
        </select><br><br>

        <label for="tasks">Select Tasks</label>
        <select id="tasks" name="tasks" multiple>
            <option value="Task 1">Task 1</option>
            <option value="Task 2">Task 2</option>
            <option value="Task 3">Task 3</option>
            <option value="Task 4">Task 4</option>
        </select><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
```

---

## MultiParamServlet.java

```java
package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MultiParamServlet")
public class MultiParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MultiParamServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String salary = request.getParameter("salary");
        String city = request.getParameter("city");
        String prof = request.getParameter("prof");
        String project = request.getParameter("project");
        String[] tasks = request.getParameterValues("tasks");

        response.getWriter().println("<h2>User Details</h2>");
        response.getWriter().println("<p><b>Name:</b> " + name + "</p>");
        response.getWriter().println("<p><b>Age:</b> " + age + "</p>");
        response.getWriter().println("<p><b>Salary:</b> " + salary + "</p>");
        response.getWriter().println("<p><b>City:</b> " + city + "</p>");
        response.getWriter().println("<p><b>Profession:</b> " + prof + "</p>");
        response.getWriter().println("<p><b>Selected Project:</b> " + project + "</p>");

        response.getWriter().println("<p><b>Assigned Tasks:</b></p>");
        if (tasks != null && tasks.length > 0) {
            response.getWriter().println("<ul>");
            for (String task : tasks) {
                response.getWriter().println("<li>" + task + "</li>");
            }
            response.getWriter().println("</ul>");
        } else {
            response.getWriter().println("<p>No tasks selected.</p>");
        }

        response.getWriter().println("</body></html>");
    }
}
```

---

## URL

```
http://localhost:8080/FirstServlet/HtmlTags.html
```

---

## Output Example

```
User Details
Name: sowmya
Age: 20
Salary: 30000
City: hyderabad
Profession: Developer
Selected Project: Project 3
Assigned Tasks:
  - Task 1
  - Task 2
  - Task 3
```

After submitting the form, the data is sent to the servlet and the details are displayed on a new page.

