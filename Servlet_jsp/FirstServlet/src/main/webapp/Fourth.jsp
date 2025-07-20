<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!

public void jspInit() {
    String defaultUser = getServletConfig().getInitParameter("defaultUser");
    ServletContext context = getServletContext();
    context.setAttribute("defaultUser", defaultUser);
}
%>
<%

String userName = request.getParameter("name");
ServletContext context = request.getServletContext();
if (userName != null && !userName.isEmpty()) {
	session.setAttribute("savedUserName", userName);
	context.setAttribute("savedUserName", userName);
	pageContext.setAttribute("pageContextUserName", userName, PageContext.APPLICATION_SCOPE);
	pageContext.findAttribute("savedUserName");
}

%>
<br>
Request parameter has username as <%=userName%><br>
Session parameter has username as <%=session.getAttribute("savedUserName") %><br>
Context parameter has username as <%=context.getAttribute("savedUserName") %><br>
PageContext parameter has username as <%=context.getAttribute("savedUserName") %><br>
Config parameter has username as <%=getServletConfig().getInitParameter("defaultUser") %><br>
Context parameter from init  as <%=context.getAttribute("defaultUser") %><br>