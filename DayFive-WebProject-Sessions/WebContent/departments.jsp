<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		session = request.getSession(false);
	if (session.getAttribute("uname") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<%@ include file="header.jsp"%>

	<br/><br/><br/>
	
	<a href="<%=request.getContextPath()%>/newDepartment">Add New Department</a>

	<br />
	<h2>Department List</h2>

	<table border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>Department Id</th>
				<th>Department Name</th>
				<th>Department Location</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${departments}">
				<tr>
					<td><c:out value="${dept.deptId}" /></td>
					<td><c:out value="${dept.deptName}" /></td>
					<td><c:out value="${dept.deptLocation}" /></td>
					<td>
					<%
						request.setAttribute("deptId", 1);
					%>
						<a href="<%=request.getContextPath()%>/deleteDepartment/<c:out value="${dept.deptId}" />">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>