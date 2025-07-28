
# MVC with Servlets and JDBC

## Understanding MVC with Servlets

The **Model-View-Controller (MVC)** architectural pattern separates an application's concerns into three core components:

### 1. Model
- Manages the application's data, business rules, and logic.
- When using JDBC, the Model interacts directly with the database.

### 2. View
- Responsible for presenting data from the Model to the user.
- JSPs (JavaServer Pages) or HTML files usually serve as the View in servlet-based applications.

### 3. Controller
- Handles user input, interacts with the Model, and selects the appropriate View.
- Typically implemented using Servlets in Java web applications.

---

## MVC in a Login Application

### 1. Model Layer

#### User.java
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

#### LoginService.java
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

### 2. View Layer

#### login.jsp
```jsp
<form action="LoginServlet_New" method="post">
    <label for="userId">User ID:</label>
    <input type="text" name="userId" required />
    <br/>
    <label for="password">Password:</label>
    <input type="password" name="password" required />
    <br/>
    <input type="submit" value="Login" />
</form>
```

#### success.jsp
```jsp
<%@ page import="com.tekgrads.User" %>
<%
    User user = (User) session.getAttribute("user");
%>
<h2>Welcome, <%= user.getUserName() %>!</h2>
```

### 3. Controller Layer

#### LoginServlet_New.java
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

---

## JSP (JavaServer Pages) and Its Tags

JSP enables the creation of dynamic web content by embedding Java code in HTML. JSPs are compiled into Servlets by servers like Tomcat.

### Common JSP Tags

#### 1. Scriptlet
```jsp
<%
// Java code here
int count = 0;
%>
```

#### 2. Expression Language (EL)
```jsp
<p>Hello ${user.userName}</p>
```
- Accesses data from scopes: page, request, session, application.

#### 3. JSTL (JSP Standard Tag Library)
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty user}">
    <p>Welcome, ${user.userName}!</p>
</c:if>
```

---

## Summary
- MVC architecture separates concerns into Model, View, and Controller.
- Servlets act as Controllers, JSPs as Views, and Java classes using JDBC form the Model.
- JSPs support dynamic content with tags like EL and JSTL, promoting clean and maintainable code.
