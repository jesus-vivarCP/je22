<%@include file="include.html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Branch"%>
<%@page import="com.gcit.lms.entity.Copies"%>
<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.entity.Borrower"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%@page import="com.gcit.lms.service.LibrarianService"%>
<%
	List<Branch> branchs = new ArrayList<>();
	List<Copies> copies;
	List<Book> books;

	String branchName;
	Integer BranchsCount;
	Integer numOfPages;
	Integer branchId;

	AdminService service = new AdminService();
	LibrarianService bservice = new LibrarianService();
	Branch branch;

	BranchsCount = service.getBranchsCount();
	Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));

	numOfPages = 0;
	if (BranchsCount % 10 > 0) {
		numOfPages = BranchsCount / 10 + 1;
	} else {
		numOfPages = BranchsCount / 10;
	}

	Borrower client = bservice.getBorrowerByCardNo(cardNo);

	if (request.getAttribute("branchs") != null) {
		branchs = (List<Branch>) request.getAttribute("branchs");
	} else {
		branchs = service.getAllBranchs(1);
	}
	branch = branchs.get(0);
	books = branch.getBooks();
	branchName = branch.getBranchName();
	branchId = branch.getBranchId();

	if (request.getAttribute("idx") != null) {
		int idx = (Integer) request.getAttribute("idx");
		branch = service.getBranchByPk(idx);
		books = branch.getBooks();
		branchName = branch.getBranchName();
		branchId = branch.getBranchId();
	}

	if (books == null)
		System.out.println("branch has no books. Branch Id" + branchId);
%>
${message}
<script>
	function updateReturnTable(branchId,cardNo){
		$.ajax({
			url: "updateReturnTable",
			data:{
				branchId: branchId,
				cardNo: cardNo,
			}
		}).done(function (data){
			$('#returnTable').html(data)
		})
	}
</script>
<script>
	function searchBranchs() {
		$.ajax({
			url : "searchLibary",
			data : {
				searchString : $('#searchString').val()
			}
		}).done(function(data) {
			$('#branchsTable').html(data)
		})
	}
</script>
<div class="container">
	<div class="page-header" align="center">
		<h1>
			Welcome
			<%=client.getName()%></h1>
	</div>
	<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<%
				for (int i = 1; i <= numOfPages; i++) {
			%>
			<li><a href="bookReturn?pageNo=<%=i%>&cardNo=<%=cardNo%>"><%=i%></a></li>
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
				<th>Branch Address</th>
				<th>Return Book</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Branch a : branchs) {
			%>
			<tr>
				<!-- <td><%=branchs.indexOf(a) + 1%></td> -->
				<td><%=a.getBranchId()%></td>
				<td><%=a.getBranchName()%></td>
				<td><%=a.getBranchAddress()%></td>
				<td>
					<form action="updateReturnTable">
						<button type="button" class="btn btn-primary"
							onclick="updateReturnTable(<%=a.getBranchId()%>,<%=cardNo%>)">Return
							book</button>
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<hr>
	<table class="table" id="returnTable">
	</table>
</div>

<div class="modal fade bs-example-modal-lg" id="returnBookModal"
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
