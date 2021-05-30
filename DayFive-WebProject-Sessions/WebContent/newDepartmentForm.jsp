<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/insertDepartment">
		
		<input type="text" name="deptName" placeholder="Department Name" />
		<input type="text" name="deptLocation" placeholder="Department Location" />
		<input type="Submit" value="Department" />
	</form>

</body>
</html>