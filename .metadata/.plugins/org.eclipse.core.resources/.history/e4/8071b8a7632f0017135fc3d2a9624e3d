<%@page import="com.gcit.lms.entity.Branch"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%AdminService service = new AdminService();

%>

<style >
table {
	border:0px;
	padding: 15px;
	text-align: center;
}
</style>
<div>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">Library Branch Details</h4>
	</div>
	<form action="addBranch" method="post">
		<div class="modal-body">
			<p>Enter details of your branch:</p>
			<div align="center">
				<table>
					<tbody>
						<tr> 
							<td><label>Branch Name:</label></td>
							<td><input type="text" name="branchName" id="branchName" value=""></td>
						</tr>
						<tr>
							<td><label>Branch Address:</label></td>
							<td><input type="text" name="branchAddress" id="branchAddress" value=""></td>
						 </tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Add branch</button>
		</div>
	</form>
</div>