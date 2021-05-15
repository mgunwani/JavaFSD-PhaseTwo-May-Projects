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

	<form>
		<input type="text" name="username" placeholder="Enter Username.." />
		<input type="submit" value="Click Me" />
	</form>

	<!-- Declaration Tag -->
	<%! int number=10; %>
	<%! 
		int addition(int num1, int num2) {
			return num1 + num2;
		} 
	%>
	<!-- Expression Tag -->
	<h2><%= "Hello Everyone.." %></h2>
	<h4><%= "Value of Number : " + number %></h4>
	<h4><%= "Result : " + addition(100, 200) %></h4>
	<h4><%= java.util.Calendar.getInstance().getTime() %></h4>
	<h4><%= "Welcome " + request.getParameter("username") + "!!" %></h4>
	
	<!-- Scriptlet Tag -->
	<h4><% out.print("Hello Users");  %></h4>
	<%
		String name = request.getParameter("username");
		out.print("Welcome " + name + "!!");
	%>
	
</body>
</html>