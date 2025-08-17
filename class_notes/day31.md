JSP (JavaServer Pages)

JSP is a technology used to create dynamic web content. It allows you to write HTML mixed with Java code.
JSP files are compiled into Servlets by the server (like Tomcat).

✅ Features of JSP:

Easier to write compared to servlets (mix of HTML + Java).

Code reusability through tag libraries (JSTL).

Separation of presentation layer (HTML) from business logic (Java).

📝 Example: Simple JSP Page
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
    <h2>Hello, Welcome to JSP!</h2>
    <%
        // Java code inside JSP
        String name = "Laxmi";
        out.println("Hello, " + name + "!");
    %>
</body>
</html>


👉 When opened in a browser, output will be:

Hello, Welcome to JSP!
Hello, Laxmi!

2. MSV in Java (Most Significant Value / Bit)

In Java, MSV generally refers to the Most Significant Bit (MSB) or Most Significant Value in binary representation.
It is the highest bit in a binary number, which decides the magnitude and sign of the number.

For example, in an 8-bit number 10000001:

The MSB is 1, meaning the number is negative (in signed representation).

The rest (0000001) determines the magnitude.

📝 Example: Finding MSB in Java
public class MSVExample {
    public static void main(String[] args) {
        int number = 18;  // binary: 10010

        // Find MSB position using Integer.highestOneBit()
        int msb = Integer.highestOneBit(number);

        System.out.println("Number: " + number);
        System.out.println("MSB (Most Significant Bit Value): " + msb);
    }
}

✅ Output:
Number: 18
MSB (Most Significant Bit Value): 16


👉 Explanation:

18 in binary is 10010.

The MSB value is 16 (binary 10000).



Perfect 👍 Let’s go step by step and explain MVC (Model-View-Controller) in detail with examples in Java.

📘 MVC (Model-View-Controller) in Java

MVC is a design pattern that separates an application into three interconnected components:

Model → Represents the data and business logic.

View → Represents the UI (User Interface).

Controller → Handles user requests, processes them (using Model), and updates the View.

🔹 1. Model

The Model is responsible for the data of the application.

It interacts with the database or performs business logic.

It doesn’t know anything about UI.

✅ Example (Java Model Class):

// Model: Student.java
public class Student {
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
}

🔹 2. View

The View is responsible for displaying the data (UI).

It gets data from the Model via the Controller.

It does not directly interact with the database.

✅ Example (Java View Class):

// View: StudentView.java
public class StudentView {
    public void printStudentDetails(String studentName, int studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

🔹 3. Controller

The Controller acts as a middleman between the Model and the View.

It receives input from the user, processes it using the Model, and updates the View.

✅ Example (Java Controller Class):

// Controller: StudentController.java
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) { model.setName(name); }
    public String getStudentName() { return model.getName(); }

    public void setStudentRollNo(int rollNo) { model.setRollNo(rollNo); }
    public int getStudentRollNo() { return model.getRollNo(); }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}

🔹 4. Main Application (Putting MVC Together)
// Main.java
public class MVCPatternDemo {
    public static void main(String[] args) {
        // Create a Student model
        Student model = new Student("Laxmi", 101);

        // Create a View
        StudentView view = new StudentView();

        // Create a Controller
        StudentController controller = new StudentController(model, view);

        // Initial display
        controller.updateView();

        // Update student info
        controller.setStudentName("Gubba Laxmi");

        // Display updated info
        controller.updateView();
    }
}

✅ Output:
Student: 
Name: Laxmi
Roll No: 101

Student: 
Name: Gubba Laxmi
Roll No: 101

📌 Advantages of MVC

Separation of Concerns → Each layer has a specific role.

Reusability → Models and Views can be reused independently.

Maintainability → Easy to update UI without affecting logic.

Scalability → Suitable for large applications.
Real-Time MVC Example in Java (JSP + Servlet + Model)

Imagine we are building a Student Management Web App.

Model (JavaBean) → Represents the Student data.

View (JSP Page) → Displays Student information.

Controller (Servlet) → Handles the request, fetches data from Model, and forwards it to JSP.

🔹 1. Model (Student.java)
// Student.java (Model)
package model;

public class Student {
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
}

🔹 2. View (studentView.jsp)
<!-- studentView.jsp (View) -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info</title>
</head>
<body>
    <h2>Student Details</h2>
    <p>Name: ${student.name}</p>
    <p>Roll No: ${student.rollNo}</p>
</body>
</html>

🔹 3. Controller (StudentController.java)
// StudentController.java (Controller - Servlet)
package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Student;

import java.io.IOException;

@WebServlet("/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Model: Create a Student object
        Student student = new Student("Laxmi", 101);

        // Add model to request scope
        request.setAttribute("student", student);

        // Forward request to JSP (View)
        RequestDispatcher dispatcher = request.getRequestDispatcher("studentView.jsp");
        dispatcher.forward(request, response);
    }
}

🔹 4. web.xml (if not using annotations)
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="3.1">
    <servlet>
        <servlet-name>StudentController</servlet-name>
        <servlet-class>controller.StudentController</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>StudentController</servlet-name>
        <url-pattern>/student</url-pattern>
    </servlet-mapping>
</web-app>

✅ Workflow of MVC in This Example

User hits URL: http://localhost:8080/yourApp/student.

Controller (Servlet) is triggered → creates Student object.

Controller passes Student (Model) to JSP using request.setAttribute().

View (JSP) displays the student details using ${student.name} and ${student.rollNo}.

📌 Output in Browser
Student Details
Name: Laxmi
Roll No: 101

⚡ Advantages of MVC in Real-Time Apps

Separation of concerns → UI (JSP) is independent from business logic (Servlet & Model).

Maintainability → Easy to change UI without touching logic.

Reusability → Same Model can be reused by different Controllers and Views.

Scalability → Ideal for large web apps like Banking, E-commerce, etc.