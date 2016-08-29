<%@page import="com.ideas.Employee"%>
<%@page import="java.security.Principal"%>
<%@page import="waffle.windows.auth.WindowsAccount"%>
<%@page import="waffle.servlet.WindowsPrincipal"%>
<%@page import="com.sun.jna.platform.win32.Secur32"%>
<%@page import="com.sun.jna.platform.win32.Secur32Util"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%	
		if (request.getRemoteUser() != null) {
			session.setAttribute("userName", request.getRemoteUser().substring(4));
			session.setAttribute("browser",request.getHeader("user-agent") );
			response.sendRedirect("Welcome");
		}
	%>
</body>
</html>
