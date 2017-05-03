<%@include file="include.html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Author"%>
<%@page import="com.gcit.lms.service.AdminService"%>


<%
	AdminService service = new AdminService();
	Integer authorsCount = service.getAuthorsCount();
	Integer numOfPages = 0;
	if (authorsCount % 10 > 0) {
		numOfPages = authorsCount / 10 + 1;
	} else {
		numOfPages = authorsCount / 10;
	}
	List<Author> authors = new ArrayList<>();
	if (request.getAttribute("authors") != null) {
		authors = (List<Author>) request.getAttribute("authors");
	} else {
		authors = service.getAllAuthors(1);
	}
%>
${message}
<script>
	function searchAuthors(){
		$.ajax({
			url: "searchAuthors",
			data:{
				searchString: $('#searchString').val()
			}
		}).done(function (data){
			$('#authorsTable').html(data)
		})
	}
</script>
<div>
	<div class="page-header">
		<h1>List of Authors in LMS</h1>
	</div>
	<div class="input-group">
      
      <form action="searchAuthors">
	     <input type="text" class="form-control" name="searchString" id="searchString" placeholder="Search for..." oninput="searchAuthors()">
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
			<li><a href="pageAuthors?pageNo=<%=i%>"><%=i%></a></li>
			<%
				}
			%>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<table class="table" id="authorsTable">
		<thead>
			<tr>
				<th>#</th>
				<th>Author Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Author a : authors) {
			%>
			<tr>
				<td><%=authors.indexOf(a) + 1%></td>
				<td><%=a.getAuthorName()%></td>
				<td><button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#editAuthorModal"
						href="editauthor.jsp?authorId=<%=a.getAuthorId()%>">Update</button></td>
				<td><button type="button" class="btn btn-danger">
						<a href="deleteAuthor?authorId=<%=a.getAuthorId()%>">Delete</a></button></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>

<div class="modal fade bs-example-modal-lg" id="editAuthorModal"
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