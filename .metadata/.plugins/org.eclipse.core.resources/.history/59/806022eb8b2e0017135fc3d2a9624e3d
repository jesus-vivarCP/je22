package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Borrower;

public class BorrowerDAO extends BaseDAO{

	public BorrowerDAO(Connection conn) {
		super(conn);
	}

	public void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("insert into tbl_borrower (name) values (?)", new Object[] {borrower.getName()});
	}
	
	public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?", 
				new Object[]{borrower.getName(),borrower.getAddress(),borrower.getPhone(), borrower.getCardNo()});
	}
	
	public void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("delete from tbl_borrower where cardNo = ?", new Object[] {borrower.getCardNo()});
	}
	
	public List<Borrower> readAllBorrowers(Integer pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return read("select * from tbl_borrower", null);
	}
	
	public List<Borrower> readAllBorrowers() throws ClassNotFoundException, SQLException{
		return readAll("select * from tbl_borrower", null);
	}
	
	public Borrower readBorrowerByID(Integer cardNo) throws ClassNotFoundException, SQLException{
		List<Borrower> borrowers = read("select * from tbl_borrower where cardNo = ?", new Object[]{cardNo});
		if(borrowers!=null && !borrowers.isEmpty()){
			return borrowers.get(0);
		}
		return null;
	}
	
	public List<Borrower> readBorrowersByName(String  borrowerName) throws ClassNotFoundException, SQLException{
		borrowerName = "%"+borrowerName+"%";
		return read("select * from tbl_borrower where name like ?", new Object[]{borrowerName});
	}
	
	public Integer getBorrowersCount() throws ClassNotFoundException, SQLException{
		return readCount("select count(*) as COUNT from tbl_borrower", null);
	}

	@Override
	public List<Borrower> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		BookDAO bdao = new BookDAO(conn);
		List<Borrower> borrowers = new ArrayList<>();
		while(rs.next()){
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setName(rs.getString("name"));
			a.setAddress(rs.getString("address"));
			a.setPhone(rs.getString("phone"));
			a.setBooks(bdao.readFirstLevel("select * from tbl_book where bookId IN (Select bookId from tbl_book_loans where cardNo = ?)", new Object[]{a.getCardNo()}));
			borrowers.add(a);
		}
		return borrowers;
	}

	@Override
	public List extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Borrower> Borrowers = new ArrayList<>();
		while(rs.next()){
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setName(rs.getString("name"));
			a.setAddress(rs.getString("address"));
			a.setPhone(rs.getString("phone"));
			Borrowers.add(a);
		}
		return Borrowers;
	}

}
