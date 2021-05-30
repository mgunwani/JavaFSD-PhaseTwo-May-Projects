<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="header.jsp"%>

	<h2>Dashboard Page</h2>
	<%
		session = request.getSession(false);
	if (session.getAttribute("uname") != null) {
		out.println("Session Id : " + session.getId());
		out.println("<br /><br />");
		out.println("Session Creation Date : " + new Date(session.getCreationTime()));
		out.println("<br /><br />");
		out.println("Welcome " + session.getAttribute("uname") + "!!");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>


</body>
</html>