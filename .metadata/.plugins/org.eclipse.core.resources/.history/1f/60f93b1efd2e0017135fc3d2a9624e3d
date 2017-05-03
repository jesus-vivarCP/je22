package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

public class BookDAO extends BaseDAO{
	
	public BookDAO(Connection conn) {
		super(conn);
	}

	public void addBook(Book book) throws ClassNotFoundException, SQLException{
		save("insert into tbl_book (title) values (?)", new Object[] {book.getTitle()});
	}
	
	public Integer addBookWithID(Book book) throws ClassNotFoundException, SQLException{
		return saveWithID("insert into tbl_book (title) values (?)", new Object[] {book.getTitle()});
	}
	
	public void addBookAuthors(Integer bookId, Integer authorId) throws ClassNotFoundException, SQLException{
		save("insert into tbl_book_authors values (?, ?)", new Object[] {bookId, authorId});
	}
	
	public void addBookGenres(Integer bookId, Integer genreId) throws ClassNotFoundException, SQLException{
		save("insert into tbl_book_genres values (?, ?)", new Object[] {genreId,bookId});
	}
	
	public void updateBook(Book book) throws ClassNotFoundException, SQLException{
		save("update tbl_book set title = ? where bookId = ?", new Object[]{book.getTitle(), book.getBookId()});
	}
	
	public void updateBookPublisher(Integer bookId, Integer pubId) throws ClassNotFoundException, SQLException{
		System.out.println("update pub id: "+pubId+" book id: "+bookId);
		save("update tbl_book set pubId = ? where bookId = ?", new Object[]{pubId,bookId});
	}
	
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException{
		save("delete from tbl_book where bookId = ?", new Object[] {book.getBookId()});
	}
	
	public Book readBookByID(Integer bookID) throws ClassNotFoundException, SQLException{
		List<Book> books = read("select * from tbl_book where bookId = ?", new Object[]{bookID});
		if(books!=null && !books.isEmpty()){
			return books.get(0);
		}
		return null;
	}
	
	public Integer getBooksCount() throws ClassNotFoundException, SQLException{
		return readCount("select count(*) as COUNT from tbl_book", null);
	}
	
	public Book readLastBookAdded() throws ClassNotFoundException, SQLException{
		List<Book> books = read("select * from tbl_book group by bookId desc", null); 
		return books.get(0);
	}
	
	public List<Book> readAllBooks(Integer pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return read("select * from tbl_book", null);
	}
	
	public List<Book> readBooksByName(String  title) throws ClassNotFoundException, SQLException{
		title = "%"+title+"%";
		return read("select * from tbl_book where title like ?", new Object[]{title});
	}

	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		AuthorDAO adao = new AuthorDAO(conn);
		while(rs.next()){
			Book b = new Book();
			b.setTitle(rs.getString("title"));
			b.setBookId(rs.getInt("bookId"));
			b.setAuthors(adao.readFirstLevel("select * from tbl_author where authorId IN (Select authorId from tbl_book_authors where bookId = ?)", new Object[]{b.getBookId()}));
			books.add(b);
		}
		return books;
	}
	
	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		while(rs.next()){
			Book b = new Book();
			b.setTitle(rs.getString("title"));
			b.setBookId(rs.getInt("bookId"));
			books.add(b);
		}
		return books;
	}
}
