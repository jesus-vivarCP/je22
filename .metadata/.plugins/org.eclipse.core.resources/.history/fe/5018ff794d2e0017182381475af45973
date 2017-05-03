<%@page import="com.gcit.lms.entity.Borrower"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%
	AdminService service = new AdminService();
	Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
	Borrower borrower = service.getBorrowerByPk(cardNo);
%>
<div>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">Update Borrower Details</h4>
	</div>
	<form action="editBorrower" method="post">
		<div class="modal-body">
			<p>Enter the details of your Borrower:</p>
			<input type="text" name="BorrowerName" value="<%=borrower.getName()%>"> <br />
			<input type="text" name="BorrowerAddress" value="<%=borrower.getAddress()%>"> <br />
			<input type="text" name="BorrowerPhone" value="<%=borrower.getPhone()%>"> <br />
			<input type="hidden" name="BorrowerId" value="<%=borrower.getCardNo()%>">
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Save changes</button>
		</div>
	</form>
</div>