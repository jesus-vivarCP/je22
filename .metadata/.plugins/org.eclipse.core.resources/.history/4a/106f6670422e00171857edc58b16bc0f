package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet({"/addAuthor","/addBranch", "/editAuthor","/addBook","/editBook","/pageAuthors","/pageBooks","/pageBranchs","/deleteAuthor","/deleteBook",
	"/searchAuthors","/searchBooks","/searchBranchs","/editBranch","/deleteBranch","/pageborrowers","editBorrower"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(), request.getRequestURI().length());
		String forwardPath = "/welcome.jsp";
		Boolean isAjax = Boolean.FALSE;
		switch (reqUrl) {
		case "/pageAuthors":
			pageAuthors(request);
			forwardPath = "/viewauthors.jsp";
			break;
		case "/pageBooks":
			pageBooks(request);
			forwardPath = "/viewbooks.jsp";
			break;
		case "/pageBranchs":
			pageBranch(request);
			forwardPath = "/servicebranch.jsp";
			break;
		case "/pageborrowers":
			pageBorrowers(request);
			forwardPath = "/viewborrowers.jsp";
			break;
		case "/deleteAuthor":
			deleteAuthor(request);
			forwardPath = "/viewauthors.jsp";
			break;
		case "/deleteBook":
			deleteBook(request);
			forwardPath = "/viewbooks.jsp";
			break;
		case "/deleteBranch":
			deleteBranch(request);
			forwardPath = "/servicebranch.jsp";
			break;
		case "/searchAuthors":
			String data = searchAuthors(request);
			response.getWriter().write(data);
			isAjax = Boolean.TRUE;
			break;
		case "/searchBooks":
			String booksData = searchBooks(request);
			response.getWriter().write(booksData);
			isAjax = Boolean.TRUE;
			break;
		case "/searchBranchs":
			String branchsData = searchBranchs(request);
			response.getWriter().write(branchsData);
			isAjax = Boolean.TRUE;
			break;
		default:
			break;
		}
		
		if (!isAjax) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(), request.getRequestURI().length());
		String forwardPath = "/welcome.jsp";
		switch (reqUrl) {
		
		case "/addAuthor":
			addAuthor(request);
			forwardPath = "/viewauthors.jsp";
			break;
		case "/editAuthor":
			editAuthor(request);
			forwardPath = "/viewauthors.jsp";
			break;
		case "/editBorrower":
			editBorrower(request);
			forwardPath = "/viewborrowers.jsp";
			break;
		case "/addBook":
			addBook(request);
			forwardPath = "/bookmodal.jsp";
			break;
		case "/editBook":
			editBook(request);
			forwardPath = "/viewbooks.jsp";
			break;
		case "/addBranch":
			addBranch(request);
			forwardPath = "/servicebranch.jsp";
			break;
		case "/editBranch":
			editBranch(request);
			forwardPath = "/servicebranch.jsp";
			break;
		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
		
	}

	private void addAuthor(HttpServletRequest request) {
		Author author = new Author();
		author.setAuthorName(request.getParameter("authorName"));
		AdminService service = new AdminService();
		try {
			service.addAuthor(author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addBranch(HttpServletRequest request) {
		Branch branch = new Branch();
		branch.setBranchName(request.getParameter("branchName"));
		branch.setBranchAddress(request.getParameter("branchAddress"));
		AdminService service = new AdminService();
		try {
			service.addBranch(branch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editAuthor(HttpServletRequest request) {
		Author author = new Author();
		author.setAuthorName(request.getParameter("authorName"));
		author.setAuthorId(Integer.parseInt(request.getParameter("authorId")));
		AdminService service = new AdminService();
		try {
			service.editAuthor(author);
			request.setAttribute("message", "Edit Successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void editBorrower(HttpServletRequest request) {
		Borrower borrower = new Borrower();
		borrower.setName(request.getParameter("borrowerName"));
		borrower.setCardNo(Integer.parseInt(request.getParameter("cardNo")));
		borrower.setPhone(request.getParameter("borrowerPhone"));
		borrower.setAddress(request.getParameter("borrowerAddress"));
		AdminService service = new AdminService();
		try {
			service.editBorrower(borrower);
			request.setAttribute("message", "Edit Successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void editBranch(HttpServletRequest request) {
		Branch branch = new Branch();
		branch.setBranchName(request.getParameter("branchName"));
		branch.setBranchAddress(request.getParameter("branchAddress"));
		branch.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		AdminService service = new AdminService();
		try {
			service.editBranch(branch);
			request.setAttribute("message", "Edit Successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void pageAuthors(HttpServletRequest request) {
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		AdminService service = new AdminService();
		try {
			request.setAttribute("authors", service.getAllAuthors(pageNo));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteAuthor(HttpServletRequest request) {
		Integer authorId = Integer.parseInt(request.getParameter("authorId"));
		AdminService service = new AdminService();
		Author author = new Author();
		author.setAuthorId(authorId);
		try {
			service.deleteAuthor(author);
			request.setAttribute("message", "Delete Successfull");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteBook(HttpServletRequest request) {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		AdminService service = new AdminService();
		Book book = new Book();
		book.setBookId(bookId);
		try {
			service.deleteBook(book);
			request.setAttribute("message", "Delete Successfull");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteBranch(HttpServletRequest request) {
		Integer branchId = Integer.parseInt(request.getParameter("branchId"));
		AdminService service = new AdminService();
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		try {
			service.deleteBranch(branch);
			request.setAttribute("message", "Delete Successfull");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void addBook(HttpServletRequest request) {
		Book book = new Book();
		String[] authors, genres,publisher;
		String title, publisherData;
		
		try{
			title = request.getParameter("title");
		}catch (NullPointerException e){
			return ;
		}
		
		try {
			authors = request.getParameterValues("authors");
			genres = request.getParameterValues("genres");
			publisherData = request.getParameter("publisher");
			publisher = publisherData.split(" ");
		}catch(NullPointerException e){
			return;
		}
	
		AdminService service = new AdminService();
		List<Author> authorList = new ArrayList<>();
		List<Genre> genreList = new ArrayList<>();
		Publisher pub;
		
		try {
			for(String author: authors) {
				String[] temp = author.split(" ");
				Author a = service.getAuthorByPk(Integer.parseInt(temp[0]));
				authorList.add(a);
			}
			for(String genre: genres) {
				String[] temp = genre.split(" ");
				Genre g = service.getGenreByPk(Integer.parseInt(temp[0]));
				genreList.add(g);
			}
			book.setAuthors(authorList);
			book.setGenres(genreList);
			book.setTitle(title);
			if(!publisherData.equals("Select")) {
				pub = service.getPublisherByPk(Integer.parseInt(publisher[0]));
				book.setPublisher(pub);
			}else
				book.setPublisher(null);
			
			service.addBook(book);
		} catch (SQLException e) {
			System.out.println("Adding book failed.");
			e.printStackTrace();
		}
	}

	private void editBook(HttpServletRequest request) {
		Book book = new Book();
		book.setTitle(request.getParameter("title"));
		book.setBookId(Integer.parseInt(request.getParameter("bookId")));
		AdminService service = new AdminService();
		try {
			service.editBook(book);
			request.setAttribute("message", "Edit Successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void pageBooks(HttpServletRequest request) {
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		AdminService service = new AdminService();
		try {
			request.setAttribute("books", service.getAllBooks(pageNo));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void pageBorrowers(HttpServletRequest request) {
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		AdminService service = new AdminService();
		try {
			request.setAttribute("borrowers", service.getAllBorrowers(pageNo));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void pageBranch(HttpServletRequest request) {
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		AdminService service = new AdminService();
		try {
			request.setAttribute("branchs", service.getAllBranchs(pageNo));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String searchAuthors(HttpServletRequest request) {
		String searchString = request.getParameter("searchString");
		AdminService service = new AdminService();
		StringBuffer strBuf = new StringBuffer();
		try {
			// request.setAttribute("authors", service.getAuthorsByName(1,
			// searchString));
			List<Author> authors = service.getAuthorsByName(1, searchString);
			strBuf.append("<thead><tr><th>#</th><th>Author Name</th><th>Edit</th><th>Delete</th></tr></thead><tbody>");
			for (Author a : authors) {
				strBuf.append("<tr><td>" + authors.indexOf(a) + 1 + "</td><td>" + a.getAuthorName() + "</td>");
				strBuf.append(
						"<td><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#editAuthorModal'href='editauthor.jsp?authorId="
								+ a.getAuthorId() + "'>Update</button></td>");
				strBuf.append("<td><button type='button' class='btn btn-danger' href='deleteAuthor?authorId="
						+ a.getAuthorId() + "'>Delete</button></td></tr>");
			}
			strBuf.append("</tbody>");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
	
	private String searchBooks(HttpServletRequest request) {
		String searchString = request.getParameter("searchString");
		AdminService service = new AdminService();
		StringBuffer strBuf = new StringBuffer();
		try {
			// request.setAttribute("authors", service.getAuthorsByName(1,
			// searchString));
			List<Book> books = service.getBooksByName(1, searchString);
			strBuf.append("<thead><tr><th>#</th><th>Book Name</th><th>Edit</th><th>Delete</th></tr></thead><tbody>");
			for (Book a : books) {
				strBuf.append("<tr><td>" + books.indexOf(a) + 1 + "</td><td>" + a.getTitle() + "</td>");
				strBuf.append(
						"<td><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#editBookModal'href='editbook.jsp?bookId="
								+ a.getBookId() + "'>Update</button></td>");
				strBuf.append("<td><button type='button' class='btn btn-danger' href='deleteBook?bookId="
						+ a.getBookId() + "'>Delete</button></td></tr>");
			}
			strBuf.append("</tbody>");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
	
	private String searchBranchs(HttpServletRequest request) {
		String searchString = request.getParameter("searchString");
		AdminService service = new AdminService();
		StringBuffer strBuf = new StringBuffer();
		try {
			// request.setAttribute("authors", service.getAuthorsByName(1,
			// searchString));
			List<Branch> branchs = service.getBranchsByName(1, searchString);
			strBuf.append("<thead><tr><th>#</th><th>Branch Name</th><th>Edit</th><th>Delete</th></tr></thead><tbody>");
			for (Branch a : branchs) {
				strBuf.append("<tr><td>" + branchs.indexOf(a) + 1 + "</td><td>" + a.getBranchName() + "</td>");
				strBuf.append(
						"<td><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#editBranchModal'href='servicebranch.jsp?branchId="
								+ a.getBranchId() + "'>Update</button></td>");
				strBuf.append("<td><button type='button' class='btn btn-danger' href='deleteBranch?branchId="
						+ a.getBranchId() + "'>Delete</button></td></tr>");
			}
			strBuf.append("</tbody>");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
}

