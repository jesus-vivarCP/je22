<%@include file="include.html"%>

<%
	String menu = request.getParameter("option");

	switch (menu) {
		case "Admin" :
%>
<div class="jumbotron" align="center">
	<h1>Welcome Administrator</h1>

	<h3>
		<a href="admin.jsp?service=books">Book & Author Services</a>
		<h3>
			<h3>
				<a href="servicebranch.jsp">Library Branch Services</a>
			</h3>
			<h3>
				<a href="override.jsp">Borrowed books Services</a>
			</h3>
</div>
<%
	break;
		case "Librarian" :
%>
<div class="jumbotron" align="center">
	<h1>Library Branch Management</h1>

	<h3>
		<a href="viewlibraries.jsp">View Libraries</a>
		<h3>
</div>
<%
	break;
		case "Borrower" :
%>
<Style>
.button5 {
	background-color: white;
	color: black;
	border: 2px solid #555555;
}

.button5:hover {
	background-color: #555555;
	color: white;
}
</Style>
<div class="jumbotron" align="center">
	<h1>Borrowed Book Services</h1>
	<h3>
		<button type="button" class="button button5" data-toggle="modal"
			data-target="#borrowerLogin" href="varifylogin.jsp">Manage
			Your Book Loans</button>
		<h3>

			<div class="modal fade bs-example-modal-lg" id="borrowerLogin"
				tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">....</div>
				</div>
			</div>
			<script>
				$(document).ready(function() {
					$('.modal').on('hidden.bs.modal', function(e) {
						$(this).removeData();
					});
				});
			</script>
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
