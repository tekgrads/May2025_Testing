<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Testing JSP</h3>
<%!

public String printMessage(){	
	return "from printMessage method";
}
%>
<%

int i =1;
int j = 2;
int k=i+j;

out.println(k);



%>
<br>
Request param is <%= request.getParameter("name") %>

<%
out.println(printMessage());
%>
<br>

Value of k from expression tag is <%=k %>
</body>
</html>