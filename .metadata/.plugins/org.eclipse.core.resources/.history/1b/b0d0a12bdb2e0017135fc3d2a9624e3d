<%@include file="include.html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Branch"%>
<%@page import="com.gcit.lms.service.AdminService"%>


<%
	AdminService service = new AdminService();
	Integer BranchsCount = service.getBranchsCount();
	Integer numOfPages = 0;
	if (BranchsCount % 10 > 0) {
		numOfPages = BranchsCount / 10 + 1;
	} else {
		numOfPages = BranchsCount / 10;
	}
	List<Branch> branchs = new ArrayList<>();
	if (request.getAttribute("branchs") != null) {
		branchs = (List<Branch>) request.getAttribute("branchs");
	} else {
		branchs = service.getAllBranchs(1);
	}
%>
${message}
<script>
	function searchBranchs(){
		$.ajax({
			url: "searchBranchs",
			data:{
				searchString: $('#searchString').val()
			}
		}).done(function (data){
			$('#branchsTable').html(data)
		})
	}
</script>
<div>
	<div class="page-header">
		<h1>List of Branch in LMS</h1>
	</div>
	<div class="input-group">
      
      <form action="searchBranchs">
	     <input type="text" class="form-control" name="searchString" id="searchString" placeholder="Search for..." oninput="searchBranchs()">
      </form>
    </div>
	<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<%
				for (int i = 1; i <= numOfPages; i++) {
			%>
			<li><a href="pageBranchs?pageNo=<%=i%>"><%=i%></a></li>
			<%
				}
			%>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<table class="table" id="branchsTable">
		<thead>
			<tr>
				<th>#</th>
				<th>Branch Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Branch a : branchs) {
			%>
			<tr>
				<td><%=branchs.indexOf(a) + 1%></td>
				<td><%=a.getBranchName()%></td>
				<td><button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#editBranchModal"
						href="editbranch.jsp?branchId=<%=a.getBranchId()%>">Update</button></td>
				<td><button type="button" class="btn btn-danger">
						<a href="deleteBranch?branchId=<%=a.getBranchId()%>">Delete</a></button></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<hr>
	<button type="button" class="btn btn-success"
						data-toggle="modal" data-target="#editBranchModal"
						href="addbranch.jsp">Add Branch</button>
</div>

<div class="modal fade bs-example-modal-lg" id="editBranchModal"
	tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">....</div>
	</div>
</div>
<script>
$(document).ready(function()
{
    $('.modal').on('hidden.bs.modal', function(e)
    { 
        $(this).removeData();
    }) ;
});
</script>