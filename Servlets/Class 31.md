# Class 31: (20/07/2025)

## MVC: Model View Controller

### Model (M)
- Represents data & rules of the application.
- Responsible for retrieving, updating, and storing data.

### View (V)
- Responsible for presenting data to users.
- Separation of concerns – focuses only on presentation.
- Gets data from the controller and displays it.

### Controller (C)
- Acts as a middleman between view and model.
- Handles user input.
- Processes incoming requests and coordinates actions.

### Real-Time Example:
| Component | Real-World Analogy |
|----------|---------------------|
| **Model** | Chef – cooks the food. |
| **View**  | Waiter – serves the food. |
| **Controller** | Person between Chef and Waiter. |

---

## Servlet Example (MVC in Java Web App)

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


## MySQL

- Used for managing **relational databases**.
- Tables are created using **primary keys**.
- Other relational database systems include:
  1. **Oracle**
  2. **PostgreSQL**

### Relational Database Features:
- Has a **proper structure**, defined **schema**, and follows **rules** in a representational/tabular format.

---

## NoSQL

- Does **not** follow a proper structure.
- Schema-less and more flexible than relational databases.
- Examples include MongoDB, CouchDB, etc.

---

## Connecting a Database with Java

To connect a database with Java, we use **JDBC**.

### JDBC: Java Database Connectivity

- A **software component** that allows Java applications to interact with a database.
- Each database (MySQL, Oracle, PostgreSQL, etc.) has its **own JDBC driver**.

---

## JDBC Driver Classes

- A **driver class** is required to connect any database to a Java application.
- The driver acts as a bridge between the Java code and the database.

---

## Setting Up MySQL JDBC in a Java Web Project

### Steps:

1. **Download** the MySQL JDBC Connector:  
   `mysql-connector-java-<version>.jar`

2. **Copy** the `.jar` file into your Java Web Project under:


Paste it into your Java Web Project under:

>>>lib>>> mysql-connector-java-<version>.jar

This allows the servlet or Java class to use MySQL JDBC APIs.
