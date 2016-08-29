<%@page import="com.ideas.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<h2>
		Welcome
		<%!String page = "";%>
		<%
			Employee employee = (Employee) request.getSession().getAttribute("user");
			if (employee == null) {
				response.sendRedirect("Welcome");
			} else {
				out.println(employee.getName() + "!\n");
		%>
		<br>
		<br>
		<%
			out.println(employee.getAuthorized() + "\n");
				if (!employee.getAuthorized().equalsIgnoreCase("Authorized")) {
		%>
		<div>
			<a href="healthCare.jsp">healthCare Form</a>
		</div>
		<%
			}
			}
		%>
	</h2>
</body>
</html>