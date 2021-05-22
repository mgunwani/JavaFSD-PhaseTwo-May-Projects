<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Index Page</h2>
	
	<form action="FirstServlet" method="get">
		<input type="text" name="username" placeholder="Enter Your Name.." />
		<input type="password" name="password" placeholder="Enter Your Password.." />
		<input type="submit" value="Click Me (GET)" />
	</form>
	
	<hr />
	
	<form action="FirstServlet" method="post">
		<input type="text" name="username" placeholder="Enter Your Name.." />
		<input type="password" name="password" placeholder="Enter Your Password.." />
		<input type="submit" value="Click Me (POST)" />
	</form>
	
</body>
</html>