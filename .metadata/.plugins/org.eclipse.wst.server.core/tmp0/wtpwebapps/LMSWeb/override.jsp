<%@include file="include.html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Borrower"%>
<%@page import="com.gcit.lms.entity.BookLoans"%>
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
	List<BookLoans> loans = new ArrayList<>();

	if (request.getAttribute("borrowers") != null) {
		borrowers = (List<Borrower>) request.getAttribute("borrowers");
	} else {
		borrowers = service.getAllBorrowers(1);
	}

	Integer card;
	if (request.getAttribute("cardNo") != null) {
		card = (Integer) request.getAttribute("cardNo");
	} else {
		card = borrowers.get(0).getCardNo();
	}

	loans = service.getBookLoans(card);
	if (loans == null)
		System.out.println("loans is null");
%>
${message}
<script>
	function searchBorrowers(cardNo){
		$.ajax({
			url: "getLoans",
			data:{
				cardNo: cardNo,
			}
		}).done(function (data){
			$('#loansTable').html(data)
		})
	}
</script>
<div class="container">
	<div>
		<div class="page-header" align="center">
			<h1>List of Borrowers in LMS</h1>
		</div>
		<!--<div class="input-group">
      
      <form action="searchBorrowers">
	     <input type="text" class="form-control" name="searchString" id="searchString" placeholder="Search for..." oninput="searchBorrowers()">
      </form> -->
	</div>
	<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<%
				for (int i = 1; i <= numOfPages; i++) {
			%>
			<li><a href="pageOverride?pageNo=<%=i%>"><%=i%></a></li>
			<%
				}
			%>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<div>
		<table class="table" id="borrowersTable">
			<thead>
				<tr>
					<th>cardNo</th>
					<th>Borrower Name</th>
					<th>Edit</th>
					<th>Delete</th>
					<th>View Loans</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Borrower a : borrowers) {
				%>
				<tr>
					<!-- borrowers.indexOf(a) + 1 -->
					<td><%=a.getCardNo()%></td>
					<td><%=a.getName()%></td>
					<td><button type="button" class="btn btn-primary"
							data-toggle="modal" data-target="#editBorrowerModal"
							href="editborrower.jsp?cardNo=<%=a.getCardNo()%>">Update</button></td>
					<td><button type="button" class="btn btn-danger">
							<a href="deleteBorrower?cardNo=<%=a.getCardNo()%>">Delete</a>
						</button></td>
					<td>
						<form action="searchBorrowers">
							<button type="button" class="btn btn-success"
								onclick="searchBorrowers(<%=a.getCardNo()%>)">View
								Loans</button>
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<table class="table" id="loansTable">
			<thead>
				<tr>
					<th>cardNo</th>
					<th>bookId</th>
					<th>branchId</th>
					<th>dateOut</th>
					<th>dateIn</th>
					<th>dueDate</th>
					<th>Extend due date</th>
				</tr>
			</thead>
			<tbody>
				<%
					int idx = 0;
					for (BookLoans loan : loans) {
				%>
				<tr>
					<td><%=loan.getCardNo()%></td>
					<td><%=loan.getBookId()%></td>
					<td><%=loan.getBranchId()%></td>
					<td><%=loan.getDateOut()%></td>
					<td><%=loan.getDateIn()%></td>
					<td><%=loan.getDueDate()%></td>
					<td><button type="button" class="btn btn-success">
							<a href="extendLoan?cardNo=<%=loan.getCardNo()%>&loc=<%=idx%>">Extend
								due date</a>
						</button></td>
				</tr>
				<%
					idx++;
					}
				%>
			</tbody>
		</table>
	</div>
	<hr>
	<div align="center">
		<table>
			<tbody>
				<tr>
					<td>
						<button type="button" class="btn btn-success" data-toggle="modal"
							data-target="#editBorrowerModal" href="addborrower.jsp">Add
							Borrower</button>
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