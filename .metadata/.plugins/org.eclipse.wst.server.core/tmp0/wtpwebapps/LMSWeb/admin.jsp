<%@include file="include.html"%>

<%
	String service = request.getParameter("service");

	switch (service) {
	case "books":
%>
<div class="jumbotron" align="center">

	<h2>Admin Book and Author options</h2>

	<h3>
		<a href="bookmodal.jsp">Add Book & Author</a><br />
	</h3>
	<h3>
		<a href="viewbooks.jsp">Update/Remove Books</a><br />
	</h3>
	<h3>
		<a href="viewauthors.jsp">Update/Remove Authors</a><br />
	</h3>
</div>
<%
	break;
	default:
%>
<div class="jumbotron" align="center">
	<h1>Page not available</h1>

	<h3>
		<a href="#">Error</a>
		<h3>
</div>
<%
	break;
	}
%>