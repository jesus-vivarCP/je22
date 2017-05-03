<%@include file="include.html"%>
<%@page import="com.gcit.lms.entity.Branch"%>
<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%@page import="com.gcit.lms.service.LibrarianService"%>

<%
	AdminService service = new AdminService();
	LibrarianService iservice = new LibrarianService();

	Integer branchId = Integer.parseInt(request.getParameter("branchId"));
	Integer bookId = Integer.parseInt(request.getParameter("bookId"));

	Integer noOfCopies = iservice.getBranchBookCopies(branchId, bookId);
	Branch branch = service.getBranchByPk(branchId);
	Book book = service.getBookByPk(bookId);

%>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<div>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">Update Branch Details</h4>
	</div>
	<form action="updateNoOfCopies" method="post">
		<div class="modal-body">
			<p>Enter the amount of copies to add:</p>
			<div>
				<table>
					<thead>
						<tr>
							<th>Branch Id
							<th>Branch Name</th>
							<th>Book Title</th>
							<th>Number of Copies</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%=branchId%></td>
							<td><%=branch.getBranchName()%></td>
							<td><%=book.getTitle()%></td>
							<td><%=noOfCopies%></td>
						</tr>
					</tbody>
				</table>
			</div>
			<input type="text" name="noOfCopies" value=""><br /> <input
				type="hidden" name="bookId" value="<%=bookId%>"> <input
				type="hidden" name="branchId" value="<%=branchId%>"> <input
				type="hidden" name="add" value="<%=noOfCopies%>">
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Update Number
				of Copies</button>
		</div>
	</form>
</div>