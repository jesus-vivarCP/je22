package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Publisher;

public class PublisherDAO extends BaseDAO {

	public PublisherDAO(Connection conn) {
		super(conn);
	}

	public void addPublisher(Publisher pub) throws ClassNotFoundException, SQLException {
		save("insert into tbl_publisher (publisherName,publisherAddress,publisherPhone) values (?,?,?)",
				new Object[] { pub.getPublisherName(), pub.getPublisherAddress(),pub.getPublisherPhone() });
	}

	public void updatePublisher(Publisher pub) throws ClassNotFoundException, SQLException {
		save("update tbl_publisher set publisherName = ?,publisherAddress = ?,publisherPhone + ? where PublisherId = ?",
				new Object[] { pub.getPublisherName(),pub.getPublisherAddress(),pub.getPublisherPhone(), pub.getPublisherId() });
	}

	public void deletePublisher(Publisher pub) throws ClassNotFoundException, SQLException {
		save("delete * from tbl_publisher where publisherId = ?", new Object[] { pub.getPublisherId() });
	}

	public List<Publisher> readAllPublishers() throws ClassNotFoundException, SQLException {
		return readAll("select * from tbl_publisher", null);
	}

	public Publisher readPublisherByID(Integer publisherID) throws ClassNotFoundException, SQLException {
		List<Publisher> pub = read("select * from tbl_publisher where publisherId = ?", new Object[] { publisherID });
		if (pub != null && !pub.isEmpty()) {
			return pub.get(0);
		}
		return null;
	}

	public List<Publisher> readPublishersByName(String publisherName) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher where publisherName like ?", new Object[] { publisherName });
	}

	@Override
	public List<Publisher> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Publisher> publishers = new ArrayList<>();
		BookDAO bdao = new BookDAO(conn);
		while (rs.next()) {
			Publisher a = new Publisher();
			a.setPublisherId(rs.getInt("publisherId"));
			a.setPublisherName(rs.getString("publisherName"));
			a.setPublisherAddress(rs.getString("publisherAddress"));
			a.setPublisherPhone(rs.getString("publisherPhone"));
			a.setBooks(bdao.readFirstLevel(
					"select * from tbl_book where bookId IN (Select bookId from tbl_book where pubId = ?)",
					new Object[] { a.getPublisherId() }));
			publishers.add(a);
		}
		return publishers;
	}

	@Override
	public List extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Publisher> publishers = new ArrayList<>();
		while (rs.next()) {
			Publisher a = new Publisher();
			a.setPublisherId(rs.getInt("publisherId"));
			a.setPublisherName(rs.getString("publisherName"));
			a.setPublisherAddress(rs.getString("publisherAddress"));
			a.setPublisherPhone(rs.getString("publisherPhone"));
			publishers.add(a);
		}
		return publishers;
	}

}
