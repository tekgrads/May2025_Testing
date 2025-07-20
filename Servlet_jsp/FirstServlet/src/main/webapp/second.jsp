<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(int i =0 ;i<5;i++) {
%>
<br> i = <%=i %>
<%} %>
<br>



The time is <%= new Date() %>
<br>

<%@ include file="/third.jsp" %>
</body>
</html>