<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Register Form</h1>
		<form action="<%=request.getContextPath()%>/register" method="post">
			<div class="form-group">
				<label for="first_name">First Name:</label> <input type="text"
					class="form-control" id="first_name" placeholder="First Name"
					name="first_name" required>
			</div>
			<div class="form-group">
				<label for="last_name">Last Name:</label> <input type="text"
					class="form-control" id="last_name" placeholder="Last Name"
					name="last_name" required>
			</div>
			<div class="form-group">
				<label for="user_name">User Name:</label> <input type="text"
					class="form-control" id="user_name" placeholder="User Name"
					name="user_name" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					name="password" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<hr align="center" />
	</div>

</body>
</html>