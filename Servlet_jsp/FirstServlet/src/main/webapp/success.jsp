<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.tekgrads.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>

Logged in Successfully.<br>

<%

User user1 = (User)session.getAttribute("user");

%>
Hello , <%= user1.getUserName() %> <br>



</body>
</html>