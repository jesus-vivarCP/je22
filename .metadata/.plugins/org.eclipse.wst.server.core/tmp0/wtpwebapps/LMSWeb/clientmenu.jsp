<%@include file="include.html"%>
<%
	Integer cardNo = (Integer) request.getAttribute("cardNo");
%>
<div class="jumbotron" align="center">
	<h1>Welcome Back!</h1>

	<h3>
		<a href="mybooks.jsp?cardNo=<%=cardNo%>">Check out a book</a>
		<h3>
			<h3>
				<a href="mybookreturns.jsp?cardNo=<%=cardNo%>">Return a book</a>
			</h3>
</div>