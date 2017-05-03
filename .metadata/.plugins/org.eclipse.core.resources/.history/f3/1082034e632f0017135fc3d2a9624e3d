<%@include file="include.html"%>
<%@page import="com.gcit.lms.entity.Author"%>
<%@page import="com.gcit.lms.entity.Genre"%>
<%@page import="com.gcit.lms.entity.Publisher"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%
	AdminService service = new AdminService();
	List<Author> authors;
	List<Genre> genres;
	List<Publisher> publishers;

	authors = service.getAllAuthors();
	genres = service.getAllGenres();
	publishers = service.getAllPublishers();
%>
<div>
	<div class="page-header">
		<h1>Book and Author Information</h1>
	</div>
	<h4>Enter book details</h4>
	<form action="addBook" method="post">
		<table class="table" id="bookTable">
			<thead>
				<tr>
					<th>info</th>
					<th>select</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>title</td>
					<td><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<td>publisher</td>
					<td>
						<select name="publisher">
							<option>Select</option>
							<%for(Publisher pub: publishers) {%>
							  		<option><%=pub.getPublisherId()+" "+pub.getPublisherName()%></option>
							 <%} %>
						 </select>
					</td>
				</tr>
				<tr>
					<td>author/author</td>
					<td>
						<div>
						  <select multiple="multiple" size="5" name="authors">
						  	<%for(Author author: authors) {%>
						  		<option><%=author.getAuthorId()+" "+author.getAuthorName()%></option>
						  		<%} %>
						  </select>
					   </div>
					</td>
				</tr>
				<tr>
					<td>genre/genres</td>
					<td>
						<div>
						  <select multiple size="5" name="genres">
						  	<%for(Genre genre: genres) {%>
						  		<option><%=genre.getGenreId()+" "+genre.getGenreName()%></option>
						  		<%} %>
						  </select>
					   </div>
					</td>
				</tr>
			</tbody>
		</table>
	<hr>
	<input type="submit" class="btn btn-primary">
	</form>
</div>