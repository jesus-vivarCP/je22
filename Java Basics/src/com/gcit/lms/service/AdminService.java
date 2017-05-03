package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

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
	
	public void addBook(Book book) throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			Integer bookId = bdao.addBookWithID(book);
			if(book.getAuthors()!=null && !book.getAuthors().isEmpty()){
				for(Author a: book.getAuthors()){
					bdao.addBookAuthors(book.getBookId(), a.getAuthorId());
				}
			}
			//repeat for Genres
			//repeat for Publisher
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

}
