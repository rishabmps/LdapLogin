<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
<%
if(request.getAttribute("amount")==null){
	response.sendRedirect("./Welcome");
}
%>

You have successfully submitted the form. Your balance Now is <%
out.println(request.getAttribute("amount"));
%><br>

<input type="button" value="Print" onclick="print()">
</h3><br>
<a href="./Welcome">
<input type="button" value="Home" ></a>
</body>
</html>