package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;

public class AdminService {
	
	public void addAuthor(Author author) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			adao.addAuthor(author);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void addBranch(Branch author) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO adao = new BranchDAO(conn);
			adao.addBranch(author);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Adding branch failed");
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void editAuthor(Author author) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			adao.updateAuthor(author);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void editBorrower(Borrower borrower) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BorrowerDAO adao = new BorrowerDAO(conn);
			adao.updateBorrower(borrower);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void editBranch(Branch branch) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO adao = new BranchDAO(conn);
			adao.updateBranch(branch);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}

	public void deleteAuthor(Author author) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			adao.deleteAuthor(author);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Delete author failed.");
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteBook(Book book) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			bdao.deleteBook(book);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Delete book failed.");
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteBranch(Branch branch) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO bdao = new BranchDAO(conn);
			bdao.deleteBranch(branch);
			System.out.println("Deleted successfully");
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Delete branch failed.");
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void editBook(Book book) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO adao = new BookDAO(conn);
			adao.updateBook(book);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void addBook(Book book) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			Integer bookId = bdao.addBookWithID(book);
			
			
			if(book.getAuthors()!=null && !book.getAuthors().isEmpty()){
				for(Author a: book.getAuthors()){
					bdao.addBookAuthors(bookId, a.getAuthorId());
				}
			}
			
			if(book.getGenres()!=null && !book.getGenres().isEmpty()){
				for(Genre a: book.getGenres()){
					bdao.addBookGenres(bookId, a.getGenreId());
				}
			}
			
			if(book.getPublisher()!=null) {
				System.out.println("Pub Id: "+ book.getPublisher().getPublisherId());
				bdao.updateBookPublisher(bookId,book.getPublisher().getPublisherId());
			}
			
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Adding book failed.");
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
			System.out.println("Success Adding book.");
		}
	}
	
	public List<Author> getAllAuthors(Integer pageNo) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAllAuthors(pageNo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Borrower> getAllBorrowers(Integer pageNo) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BorrowerDAO adao = new BorrowerDAO(conn);
			return adao.readAllBorrowers(pageNo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Branch> getAllBranchs(Integer pageNo) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO adao = new BranchDAO(conn);
			return adao.readAllBranchs(pageNo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Book> getAllBooks(Integer pageNo) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO adao = new BookDAO(conn);
			return adao.readAllBooks(pageNo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Author getAuthorByPk(Integer authorId) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAuthorByID(authorId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Borrower getBorrowerByPk(Integer cardNo) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BorrowerDAO adao = new BorrowerDAO(conn);
			return adao.readBorrowerByID(cardNo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Branch getBranchByPk(Integer branchId) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO adao = new BranchDAO(conn);
			return adao.readBranchByID(branchId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Genre getGenreByPk(Integer genreId) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			return gdao.readGenreByID(genreId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Publisher getPublisherByPk(Integer genreId) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			PublisherDAO gdao = new PublisherDAO(conn);
			return gdao.readPublisherByID(genreId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Book getBookByPk(Integer bookId) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			return bdao.readBookByID(bookId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Integer getAuthorsCount() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.getAuthorsCount();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Integer getBorrowersCount() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BorrowerDAO adao = new BorrowerDAO(conn);
			return adao.getBorrowersCount();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Integer getBranchsCount() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO bdao = new BranchDAO(conn);
			return bdao.getBranchCount();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public Integer getBookCount() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO adao = new BookDAO(conn);
			return adao.getBooksCount();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Author> getAuthorsByName(Integer pageNo, String authorName) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAuthorsByName(authorName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Branch> getBranchsByName(Integer pageNo, String branchName) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO adao = new BranchDAO(conn);
			return adao.readBranchsByName(branchName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Book> getBooksByName(Integer pageNo, String bookName) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			return bdao.readBooksByName(bookName);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Get books by name failed!");
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Genre> getAllGenres() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			return gdao.readAllGenres();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	
	public List<Author> getAllAuthors() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAllAuthors();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Publisher> getAllPublishers() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			return pdao.readAllPublishers();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
}


