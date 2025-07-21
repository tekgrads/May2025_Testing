# Class 30: (19-07-2025)

## HTTP Request Methods:
- If you **don’t want the entered data to be visible in the URL**, use **POST**.
- `getPost` / `doPost` methods are used to handle requests.
- The **user doesn't know** when the request is forwarded to a second servlet.

---

## Passing Data to Second Servlets:
1. **Session**
2. **Cookies**

---

### **Cookies:**
- Created on the **server** and stored in the **web browser**.
- Remembers user data across sessions.

### **Session:**
- Data is stored on the **server side** (not in the browser).
- Data is saved only when available.
- The server session is **tied to the browser**.

---

## Scopes:
- **RequestScope**: Exists for one request only.
- **SessionScope**: Lasts until the browser window is closed.
- **ContextScope**: Lasts for the entire lifecycle of the servlet container.

---

## ServletConflict:
- Refers to **parameters** passed to a specific servlet which might cause conflict.

---

## Sending Complex HTML as a Response

### **JSP (Java Server Pages):**
- JSP pages run on the server.
- Allows embedding Java code directly into HTML.
- Makes web application development easier.

---

### **Example JSP Code:**
```jsp
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Details Form</title>
</head>
<body>

    <h1>Employee Form</h1>
    
    <form method="post" action="AddEmployeeServlet">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required> <br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required> <br><br>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" step="0.01" required> <br><br>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required> <br><br>

        <label>Profession:</label><br>
        <input type="radio" id="developer" name="prof" value="Developer" required>
        <label for="developer">Developer</label>

        <input type="radio" id="architect" name="prof" value="Architect">
        <label for="architect">Architect</label>
        <br><br>

        <label for="project">Select Project:</label>
        <select id="project" name="project" required>
            <option value="Project 1">Project 1</option>
            <option value="Project 2">Project 2</option>
            <option value="Project 3">Project 3</option>
            <option value="Project 4">Project 4</option>
        </select>
        <br><br>

        <label for="tasks">Select Tasks (Hold Ctrl to select multiple):</label>
        <select id="tasks" name="tasks" multiple>
            <option value="Task 1">Task 1</option>
            <option value="Task 2">Task 2</option>
            <option value="Task 3">Task 3</option>
            <option value="Task 4">Task 4</option>
        </select>
        <br><br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>
