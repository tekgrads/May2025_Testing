<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.tekgrads.Employee, java.util.*" %>

<jsp:useBean id="emp" scope="request" type="com.tekgrads.Employee" />

<h2>Edit Employee</h2>

<form action="UpdateEmployeeServlet" method="post">
    <!-- Hidden Field for Employee ID -->
    <input type="hidden" name="id" value="<%= emp.getId() %>" />

    <!-- Employee Name -->
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= emp.getName() %>" required>
    <br>

    <!-- Age -->
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" value="<%= emp.getAge() %>" required>
    <br>

    <!-- Salary -->
    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" step="0.01" value="<%= emp.getSalary() %>" required>
    <br>

    <!-- City -->
    <label for="city">City:</label>
    <input type="text" id="city" name="city" value="<%= emp.getCity() %>" required>
    <br>

    <!-- Profession -->
    <label for="prof">Profession:</label>
    <input type="text" id="prof" name="prof" value="<%= emp.getProf() %>" required>
    <br>

    <!-- Project -->
    <label for="project">Project:</label>
    <input type="text" id="project" name="project" value="<%= emp.getProject() %>" required>
    <br>

    <!-- Tasks (Multi-Select) -->
    <label for="tasks">Select Tasks (Hold Ctrl to select multiple):</label>
    <select id="tasks" name="tasks" multiple>
        <%
            String[] employeeTasks = emp.getTasks(); // Get assigned tasks
            List<String> taskList = Arrays.asList(employeeTasks); // Convert to List
            String[] allTasks = {"Task 1", "Task 2", "Task 3", "Task 4"}; // All available tasks
            for (String task : allTasks) {
                String selected = taskList.contains(task) ? "selected" : "";
        %>
            <option value="<%= task %>" <%= selected %>><%= task %></option>
        <%
            }
        %>
    </select>
    <br><br>

    <!-- Submit Button -->
    <input type="submit" value="Update">
</form>