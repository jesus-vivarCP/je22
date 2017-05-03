<%@include file="include.html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.service.AdminService"%>


<%
	AdminService service = new AdminService();
	Integer booksCount = service.getBookCount();
	Integer numOfPages = 0;
	if (booksCount % 10 > 0) {
		numOfPages = booksCount / 10 + 1;
	} else {
		numOfPages = booksCount / 10;
	}
	List<Book> books = new ArrayList<>();
	if (request.getAttribute("books") != null) {
		books = (List<Book>) request.getAttribute("books");
	} else {
		books = service.getAllBooks(1);
	}
%>
${message}
<script>
	function searchBooks(){
		$.ajax({
			url: "searchBooks",
			data:{
				searchString: $('#searchString').val()
			}
		}).done(function (data){
			$('#booksTable').html(data)
		})
	}
</script>
<div>
	<div class="page-header">
		<h1>List of Books in LMS</h1>
	</div>
	<div class="input-group">
      
      <form action="searchBooks">
	     <input type="text" class="form-control" name="searchString" id="searchString" placeholder="Search for..." oninput="searchBooks()">
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
			<li><a href="pageBooks?pageNo=<%=i%>"><%=i%></a></li>
			<%
				}
			%>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<table class="table" id="booksTable">
		<thead>
			<tr>
				<th>#</th>
				<th>Book Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Book a : books) {
			%>
			<tr>
				<td><%=books.indexOf(a) + 1%></td>
				<td><%=a.getTitle()%></td>
				<td><button type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#editBookModal"
						href="editbook.jsp?bookId=<%=a.getBookId()%>">Update</button></td>
				<td><button type="button" class="btn btn-danger">
						<a href="deleteBook?bookId=<%=a.getBookId()%>">Delete</a></button></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>

<div class="modal fade bs-example-modal-lg" id="editBookModal"
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