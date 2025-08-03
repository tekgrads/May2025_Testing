<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee List</title>
</head>
<body>
	<h2>Employee List</h2>
	<table border="1" cellpadding="5">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Salary</th>
		</tr>
		<c:forEach var="emp" items="${employees}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.department}</td>
				<td>${emp.salary}</td>
				<td><a
					href="${pageContext.request.contextPath}/employeeHome/edit/${emp.id}">Edit</a>
					| <a
					href="${pageContext.request.contextPath}/employeeHome/delete/${emp.id}"
					onclick="return confirm('Are you sure?')">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="${pageContext.request.contextPath}/employeeHome/add">Add Employee</a></p>
</body>
</html>
