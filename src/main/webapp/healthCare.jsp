<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ideas.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HealthCare Form</title>

<%
Employee employee = (Employee) request.getSession().getAttribute("user");
%>
<link href="resources/css/ui-lightness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
	<script src="resources/javascript/jquery.js"></script>
	<script src="resources/javascript/jquery-ui.custom.js"></script>
	<script src="resources/javascript/modernizr.js"></script>
	<script>
	Modernizr.load({
		test: Modernizr.inputtypes.date,
		nope: "js/jquery-ui.custom.js",
		callback: function() {
		  $("input[type=date]").datepicker();
		}
	  });
	
	</script>
</head>
<body >

	<%
	
		if (employee == null || !employee.getAuthorized().equalsIgnoreCase("Authorized")) {
// 			response.sendRedirect("Welcome");
// 		} else {
	%>
	<div>
		<div></div>
		<h2>
			<p style="align: center; margin-left: 46%;">IDEAS INDIA</p>
			<p style="align: center; margin-left: 37%;">Reimbursement Form
				for Employee Health Care</p>
		</h2>
		<form id="usrform" action="./Welcome" method="post">
			<table border="2" width="30%" cellpadding="2" color="white"
				style="border: burlywood; color: black; margin-left: 35%; margin-top: 3%;">
				

				<tr>
					<td>Name:</td>

					<td><input type="text" value="<%=employee.getName()%>"
						name="name"></td>
				</tr>
<tr>
					<td>Employee No:</td>

					<td><input type="text" name="empNo" value="<%= employee.getEmployeeID() %>"></td>
				</tr>
				<tr>
					<td>Department:</td>

					<td><input type="text" name="department" value="<%=employee.getDepartment() %>"></td>
				</tr>

				<tr>
					<td>Designation:</td>

					<td><input type="text" name="designation" value="<%=employee.getDesignation() %>"></td>
				</tr>

				<tr>
					<td>Name of Hospital:</td>

					<td><input type="text" name="hospital"></td>
				</tr>
				<tr>
					<td>Details of medical test Undertaken:</td>

					<td><textarea name="details" form="usrform">Enter text here...</textarea></td>
				</tr>
				<tr>
					<td>Date:</td>

					<td><input type="date" name="date"></td>
				</tr>
				<tr>
					<td>Amount:</td>

					<td><input type="number" name="amount"></td>
				</tr>

			</table>
			<br> <br> <br>
			<input type="hidden" name="operation"  
			value="healthCare" >
			<input type="button" value="Submit" class="button"  onclick="submit()" style="margin-left:42%; width:15%;">
		</form>
	
	</div>


	<%
		}
	%>
</body>
</html>