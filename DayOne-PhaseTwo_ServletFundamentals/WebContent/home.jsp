<!-- Page Directive: Import -->
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP Directives</h2>
	
	<!-- Header of the Page -->
	<%@ include file="header.jsp" %>
	
	<hr/>
	
	<!-- Main Content Here -->
	Current Date: <%= new Date() %>
	
	<hr/>
	
	<!-- Footer of the Page -->
	<%@ include file="footer.jsp" %>
	
</body>
</html>