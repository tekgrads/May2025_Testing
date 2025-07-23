# MVC with Servlets:

## Understanding MVC with Servlets and JDBC

The **Model-View-Controller (MVC)** architectural pattern is a standard approach in web development, separating an application's concerns into three core components:

  * **Model:** This layer manages the application's data, business rules, and logic. It's independent of the user interface. When using JDBC, the Model would directly interact with the database for data operations.
  * **View:** The View is responsible for presenting data from the Model to the user. In Servlet-based applications, **JSPs (JavaServer Pages)** or HTML files typically serve as the Views.
  * **Controller:** This component handles user input, interacts with the Model, and then selects the appropriate View to display the results. **Servlets** commonly function as Controllers, processing requests and forwarding them to the correct JSP.

### MVC in a Login Application

Here's how the MVC pattern applies to a login application:

**1. Model:**

  * **`User.java`**: This class represents the **Model**'s data structure, specifically a `User` object with `userId` and `userName` properties. It holds the core data.

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

  * **`LoginService.java`**: This class acts as part of the **Model** (or a service layer interacting with the Model). It contains the business logic for user authentication and fetching user details. In a real-world scenario, this is where JDBC would be used to interact with a database to validate credentials and retrieve user information.

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

**2. View:**

  * **`success.jsp` and `login.jsp`**: These JSP files serve as the **View** components. `login.jsp` would display the login form to the user, and `success.jsp` would present a successful login message, possibly along with user-specific data. These JSPs would utilize technologies like Expression Language (EL) to display data from the Model.

**3. Controller:**

  * **`LoginServlet_New.java`**: This Servlet functions as the **Controller**. It receives the `POST` request from the login form, extracts user input, and then interacts with the `LoginService` (Model) to perform authentication. Based on the authentication outcome, it determines whether to forward the request to `success.jsp` or redirect to `login.jsp`.

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

-----

## JSP (JavaServer Pages) and its Tags

JSP is a technology that enables the creation of dynamic web content by embedding Java code directly within HTML. Web servers like Tomcat compile JSPs into Servlets before execution.

Here are a few common JSP tags:

  * **Scriptlet (`<% Java code %>`)**: This tag allows you to embed blocks of Java code directly within the JSP. While functional, modern JSP development often favors other approaches for better separation of concerns.
  * **Expression Language (EL) (`${expression}`)**: A concise and powerful way to access data stored in various scopes (page, request, session, application) without writing explicit Java code. It's the preferred method for displaying data in JSPs.
  * **JSP Standard Tag Library (JSTL) (`<c:forEach>`, `<c:if>`, etc.)**: JSTL provides a set of custom tags that offer common functionalities like loops, conditional statements, and XML processing, contributing to cleaner JSP code by reducing the need for scriptlets.

-----

