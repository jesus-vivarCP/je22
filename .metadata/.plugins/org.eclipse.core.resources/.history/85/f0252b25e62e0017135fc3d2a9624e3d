package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Branch;

public class BranchDAO extends BaseDAO {

	public BranchDAO(Connection conn) {
		super(conn);
	}

	public void addBranch(Branch branch) throws ClassNotFoundException, SQLException{
		save("insert into tbl_library_branch (branchName,branchAddress) values (?,?)", new Object[] {branch.getBranchName(),branch.getBranchAddress()});
	}
	
	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException{
		save("update tbl_library_branch set branchName = ? where branchId = ?", new Object[]{branch.getBranchName(), branch.getBranchId()});
	}
	
	public void deleteBranch(Branch branch) throws ClassNotFoundException, SQLException{
		save("delete from tbl_library_branch where branchId = ?", new Object[] {branch.getBranchId()});
	}
	
	public List<Branch> readAllBranchs(Integer pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return read("select * from tbl_library_branch", null);
	}
	
	public List<Branch> readAllBranchs() throws ClassNotFoundException, SQLException{
		return readAll("select * from tbl_library_branch", null);
	}
	
	public Branch readBranchByID(Integer branchID) throws ClassNotFoundException, SQLException{
		List<Branch> branchs = read("select * from tbl_library_branch where branchId = ?", new Object[]{branchID});
		if(branchs!=null && !branchs.isEmpty()){
			return branchs.get(0);
		}
		return null;
	}
	
	public List<Branch> readBranchsByName(String  branchName) throws ClassNotFoundException, SQLException{
		branchName = "%"+branchName+"%";
		return read("select * from tbl_library_branch where branchName like ?", new Object[]{branchName});
	}
	
	public Integer getBranchCount() throws ClassNotFoundException, SQLException{
		return readCount("select count(*) as COUNT from tbl_library_branch", null);
	}

	@Override
	public List<Branch> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		BookDAO bdao = new BookDAO(conn);
		List<Branch> branchs = new ArrayList<>();
		while(rs.next()){
			Branch a = new Branch();
			a.setBranchId(rs.getInt("branchId"));
			a.setBranchName(rs.getString("branchName"));
			a.setBooks(bdao.readFirstLevel("select * from tbl_book where bookId IN (Select bookId from tbl_book_loans where branchId = ?)", new Object[]{a.getBranchId()}));
			branchs.add(a);
		}
		return branchs;
	}

	@Override
	public List extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Branch> branchs = new ArrayList<>();
		while(rs.next()){
			Branch a = new Branch();
			a.setBranchId(rs.getInt("BranchId"));
			a.setBranchName(rs.getString("BranchName"));
			branchs.add(a);
		}
		return branchs;
	}

}
