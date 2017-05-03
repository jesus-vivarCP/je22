<%@page import="com.gcit.lms.entity.Branch"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%AdminService service = new AdminService();
	Integer branchId = Integer.parseInt(request.getParameter("branchId"));
	Branch branch = service.getBranchByPk(branchId);
%>
<div>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">Update Branch Details</h4>
	</div>
	<form action="editBranch" method="post">
		<div class="modal-body">
			<p>Enter the details of your branch:</p>
			<input type="text" name="branchName" value="<%=branch.getBranchName()%>"> <br />
			<input type="hidden" name="branchId" value="<%=branch.getBranchId()%>">
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Save changes</button>
		</div>
	</form>
</div>