package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;

public class GenreDAO extends BaseDAO {

	public GenreDAO(Connection conn) {
		super(conn);
	}

	public void addGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("insert into tbl_genre (genre_name) values (?)", new Object[] { genre.getGenreName() });
	}

	public Integer addGenreWithID(Genre genre) throws ClassNotFoundException, SQLException {
		return saveWithID("insert into tbl_genre (genre_name) values (?)", new Object[] { genre.getGenreName() });
	}

	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("update tbl_genre set genre_name = ? where genreId = ?",
				new Object[] { genre.getGenreName(), genre.getGenreId() });
	}

	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("delete * from tbl_genre where genreId = ?", new Object[] { genre.getGenreId() });
	}
	
	public List<Genre> readAllGenres(Integer pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return read("select * from tbl_genre", null);
	}
	
	public List<Genre> readAllGenres() throws ClassNotFoundException, SQLException{
		return readAll("select * from tbl_genre", null);
	}
	
	public Genre readGenreByID(Integer genreID) throws ClassNotFoundException, SQLException {
		List<Genre> pub = read("select * from tbl_genre where genre_id = ?", new Object[] { genreID });
		if (pub != null && !pub.isEmpty()) {
			return pub.get(0);
		}
		return null;
	}

	@Override
	public List<Genre> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Genre> genre = new ArrayList<>();
		BookDAO bdao = new BookDAO(conn);
		while (rs.next()) {
			Genre b = new Genre();
			b.setGenreName(rs.getString("genre_name"));
			b.setGenreId(rs.getInt("genre_id"));
			b.setBooks(bdao.readFirstLevel(
					"select * from tbl_book where bookId IN (Select bookId from tbl_book_genres where genre_id = ?)",
					new Object[] { b.getGenreId() }));
			genre.add(b);
		}
		return genre;
	}

	@Override
	public List<Genre> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Genre> genre = new ArrayList<>();
		while (rs.next()) {
			Genre b = new Genre();
			b.setGenreName(rs.getString("genre_name"));
			b.setGenreId(rs.getInt("genre_id"));
			genre.add(b);
		}
		return genre;
	}
}
