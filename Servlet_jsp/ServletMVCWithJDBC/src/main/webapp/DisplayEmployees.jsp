<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tekgrads.Employee"%>

<html>
<head>
<title>Employee List</title>
<style>
 table {
	width: 80%;
	border-collapse: collapse;
	margin: 20px auto;
} 

th, td {
	border: 1px solid black;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>

	<h2 style="text-align: center;">Employee List</h2>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Salary</th>
			<th>City</th>
			<th>Profession</th>
			<th>Project</th>
			<th>Tasks</th>
			<th></th>
			<th></th>
		</tr>
		<%
			List<Employee> employees = (List<Employee>) request.getAttribute("employees");
		if(employees != null) {
            for (Employee emp : employees) {
        %>
		<tr>
			<td><%= emp.getId() %></td>
			<td><%= emp.getName() %></td>
			<td><%= emp.getAge() %></td>
			<td><%= emp.getSalary() %></td>
			<td><%= emp.getCity() %></td>
			<td><%= emp.getProf() %></td>
			<td><%= emp.getProject() %></td>
			<td><%= String.join(", ", emp.getTasks()) %></td>
			<td><a href="UpdateEmployeeServlet?id=<%= emp.getId() %>">Edit</a></td>
			<td><a href="DeleteEmployeeServlet?id=<%= emp.getId() %>">Delete</a></td>
		</tr>
		<%
            }
		}
        %>
	</table>

	<div style="text-align: center; margin-top: 20px;">
		<a href="AddEmployee.jsp">Add Employee</a>
	</div>


</body>
</html>