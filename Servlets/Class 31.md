# Class 31: (20-07-2025)

## MVC: Model-View-Controller

### **Model (M):**
- Represents **data** and **rules** of the application.
- Responsible for **retrieving**, **updating**, and **storing** data.

### **View (V):**
- Responsible for **presenting data to users**.
- Follows **Separation of Concerns**.
- Concerned only with its task (presentation).
- **Receives data from the controller** and displays it.

### **Controller (C):**
- Acts as a **middleman** between View and Model.
- Handles **user input**.
- **Processes incoming requests** and coordinates the flow.

---

### **Real-Time Analogy:**
- **Model**: Chef – prepares the food.
- **View**: Waiter – presents the food.
- **Controller**: The person taking the order and relaying information.

---

## Example Servlet (Controller Code):
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
