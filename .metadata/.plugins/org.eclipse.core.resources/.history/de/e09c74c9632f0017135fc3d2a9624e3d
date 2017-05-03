<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%AdminService service = new AdminService();
	Integer bookId = Integer.parseInt(request.getParameter("bookId"));
	Book book = service.getBookByPk(bookId);
%>
<div>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">Update Author Details</h4>
	</div>
	<form action="editBook" method="post">
		<div class="modal-body">
			<p>Enter the details of your Author:</p>
			<input type="text" name="title" value="<%=book.getTitle()%>"> <br />
			<input type="hidden" name="bookId" value="<%=book.getBookId()%>">
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Save changes</button>
		</div>
	</form>
</div>