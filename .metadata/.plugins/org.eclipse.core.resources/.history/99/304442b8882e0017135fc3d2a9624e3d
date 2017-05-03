<%@include file="include.html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Borrower"%>
<%@page import="com.gcit.lms.service.AdminService"%>


<%
	AdminService service = new AdminService();
	Integer borrowersCount = service.getBorrowersCount();
	Integer numOfPages = 0;
	if (borrowersCount % 10 > 0) {
		numOfPages = borrowersCount / 10 + 1;
	} else {
		numOfPages = borrowersCount / 10;
	}
	List<Borrower> borrowers = new ArrayList<>();
	if (request.getAttribute("borrowers") != null) {
		borrowers = (List<Borrower>) request.getAttribute("borrowers");
	} else {
		borrowers = service.getAllBorrowers(1);
	}
%>
${message}
<script>
	function searchBorrowers(){
		$.ajax({
			url: "searchBorrowers",
			data:{
				searchString: $('#searchString').val()
			}
		}).done(function (data){
			$('#borrowersTable').html(data)
		})
	}
</script>
<div>
	<div class="page-header">
		<h1>List of Borrowers in LMS</h1>
	</div>
	<div class="input-group">
      
      <form action="searchBorrowers">
	     <input type="text" class="form-control" name="searchString" id="searchString" placeholder="Search for..." oninput="searchBorrowers()">
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
			<li><a href="pageborrowers?pageNo=<%=i%>"><%=i%></a></li>
			<%
				}
			%>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<table class="table" id="borrowersTable">
		<thead>
			<tr>
				<th>#</th>
				<th>Borrower Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Borrower a : borrowers) {
			%>
			<tr>
				<td><%=borrowers.indexOf(a) + 1%></td>
				<td><%=a.getName()%></td>
				<td><button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#editBorrowerModal"
						href="editborrower.jsp?cardNo=<%=a.getCardNo()%>">Update</button></td>
				<td><button type="button" class="btn btn-danger">
						<a href="deleteBorrower?cardNo=<%=a.getCardNo()%>">Delete</a></button></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<hr>
	<div align="center">
	<table>
		<tbody>
			<tr> 
				<td> 
					<button type="button" class="btn btn-success"
						data-toggle="modal" data-target="#editBorrowerModal"
						href="#">Add Borrower</button>
				</td>
				<td> 
					<button type="button" class="btn btn-success"
						data-toggle="modal" data-target="#editBorrowerModal"
						href="#">Add Borrower</button>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</div>

<div class="modal fade bs-example-modal-lg" id="editBorrowerModal"
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