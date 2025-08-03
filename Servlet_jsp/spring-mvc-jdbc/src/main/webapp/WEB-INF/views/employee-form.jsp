<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>
    <h2>${employee.id == 0 ? 'Add' : 'Edit'} Employee</h2>
	
    <form:form method="post" modelAttribute="employee" action="${pageContext.request.contextPath}/employeeHome/save">          		
        <p>
           <form:input path="id" type="hidden"/>
        </p>
        <p>
            Name: <form:input path="name"/>
        </p>
        <p>
            Department: <form:input path="department"/>
        </p>
        <p>
            Salary: <form:input path="salary"/>
        </p>
        <p>
            <input type="submit" value="Save"/>
        </p>
    </form:form>

    <p><a href="${pageContext.request.contextPath}/employeeHome/getAllEmployees">Back to list</a></p>    
</body>
</html>
