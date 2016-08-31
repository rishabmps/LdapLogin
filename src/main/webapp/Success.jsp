<%@page import="org.eclipse.jetty.server.Response"%>
<%@page import="com.ideas.Form1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jspdf.debug.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
<%
Form1 form1 = (Form1)request.getAttribute("data");
%>
<%
if (request.getAttribute("balance") == null) {
	response.sendRedirect("./Welcome");
}
else {
	%>
	function demoFromHTML() {
		
	    var pdf = new jsPDF('p', 'pt', 'letter');
	    // source can be HTML-formatted string, or a reference
	    // to an actual DOM element from which the text will be scraped.
	    source = $('#form')[0];

	    // we support special element handlers. Register them with jQuery-style 
	    // ID selector for either ID or node name. ("#iAmID", "div", "span" etc.)
	    // There is no support for any other type of selectors 
	    // (class, of compound) at this time.
	    specialElementHandlers = {
	        // element with id of "bypass" - jQuery style selector
	        '#bypassme': function (element, renderer) {
	            // true = "handled elsewhere, bypass text extraction"
	            return true
	        }
	    };
	    margins = {
	        top: 80,
	        bottom: 60,
	        left: 40,
	        width: 522
	    };
	    // all coords and widths are in jsPDF instance's declared units
	    // 'inches' in this case
	    pdf.fromHTML(
	    source, // HTML string or DOM elem ref.
	    margins.left, // x coord
	    margins.top, { // y coord
	        'width': margins.width, // max width of content on PDF
	        'elementHandlers': specialElementHandlers
	    },

	    function (dispose) {
	        // dispose: object with X, Y of the last line add to the PDF 
	        //          this allow the insertion of new lines after html
	        pdf.save('<%= form1.getEmployee().getName()%>.pdf');
	    }, margins);
	}

	</script>
	</head>
	<body>
		<h3 >
			

			You have successfully submitted the form. Your balance Now is
			<%
				out.println(request.getAttribute("balance"));
			%><br> <button onclick="javascript:demoFromHTML();">PDF</button>
		</h3>
		
		<br>
		<a href="./Welcome"> <input type="button" value="Home"></a>
		<div id="form" style="visibility:hidden;">
		<h2 >Ideas </h2>
		
		
		
		<pre><%out.print("Name: "+form1.getEmployee().getName()+"\n"); %></pre>
		<pre><%out.print("Date : "+form1.getDate()); %></pre>
		<pre><%out.print("Department: "+form1.getEmployee().getDepartment()); %></pre>
		<pre><%out.print("Designation: "+form1.getEmployee().getDesignation()); %></pre>
		<pre><%out.print("Hospital: "+form1.getHospital()); %></pre>
		<pre><%out.print("Description: "+form1.getDescription()); %></pre>
		<pre><%out.print("Amount: "+form1.getAmount()); %><br></pre>
		<br>
		<br>
		
		</div>
		
	</body>
	</html>
	<%
}
%>
