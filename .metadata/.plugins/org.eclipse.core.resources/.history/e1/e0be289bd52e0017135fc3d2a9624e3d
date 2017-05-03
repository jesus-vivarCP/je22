<%@include file="include.html"%>

<%
	String menu = request.getParameter("option");

	switch(menu) {
	case "Admin":
%>
<div class="jumbotron">
	<h1>Welcome Administrator</h1>
	
	<h3><a href="admin.jsp?service=books">Book & Author Services</a><h3>
	<h3><a href="servicebranch.jsp">Library Branch Services</a></h3>
	<h3><a href="admin.jsp?service=override">Borrowed books Services</a></h3>
</div>
<%
		break;
	case "Librarian":
%> 
<div class="jumbotron">
	<h1>Library Branch Management</h1>
	
	<h3><a href="#">Choose Branch:</a><h3>
</div>
<%
		break;
	case "Borrower":
		
%> 
<div class="jumbotron">
	<h1>Borrowed Book Services</h1>
	<h3><a href="#">Enter card number:</a><h3>
</div>
<%
		break;
		default:
			%>
<div class="jumbotron">
	<h1>Page not available</h1>

	<h3><a href="#">Error</a><h3>
</div>
<%
			break;
	}
%>
