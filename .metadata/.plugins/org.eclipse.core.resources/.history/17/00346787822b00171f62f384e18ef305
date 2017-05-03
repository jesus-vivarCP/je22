package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Genre;

public class GenreDAO extends BaseDAO{

	public GenreDAO(Connection conn) {
		super(conn);
	}

	public void addGenre(Genre genre) throws ClassNotFoundException, SQLException{
		save("insert into tbl_genre (genre_name) values (?)", new Object[] {genre.getGenreName()});
	}
	
	public Integer addGenreWithID(Genre genre) throws ClassNotFoundException, SQLException{
		return saveWithID("insert into tbl_genre (genre_name) values (?)", new Object[] {genre.getGenreName()});
	}
	
	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException{
		save("update tbl_genre set genre_name = ? where genreId = ?", new Object[]{genre.getGenreName(), genre.getGenreId()});
	}
	
	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException{
		save("delete * from tbl_genre where genreId = ?", new Object[] {genre.getGenreId()});
	}

	@Override
	public List<Genre> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Genre> books = new ArrayList<>();
		AuthorDAO adao = new AuthorDAO(conn);
		while(rs.next()){
			Genre b = new Genre();
			b.setGenreName(rs.getString("genre_name"));
			b.setGenreId(rs.getInt("genreId"));
		//	b.setAuthors(adao.readFirstLevel("select * from tbl_author where authorId IN (Select authorId from tbl_book_authors where bookId = ?)", new Object[]{b.getBookId()}));
		//	books.add(b);
		}
		return books;
	}
	
	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		while(rs.next()){
			Book b = new Book();
			//b.setGenreName(rs.getString("genreName"));
		//	b.setGenreId(rs.getInt("genreId"));
			books.add(b);
		}
		return books;
	}
}
