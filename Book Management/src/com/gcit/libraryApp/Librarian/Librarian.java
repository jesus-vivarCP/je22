package com.gcit.libraryApp.Librarian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface Librarian {
	public ArrayList<String> getLibraryBranch(Connection conn,int id);
	public void updateBranchName(Connection conn, String name, int id);
	public void updateBranchAddress(Connection conn, String address, int id);
	public int displayBooks(Connection conn, String table);
	public int numberOfCopies(Connection conn, int bookId, int branchId);
	public void updateNoOfCopies(Connection conn, int bookId, int branchId, int noOfCopies);
	public void insertBookCopies(Connection conn, int bookId, int branchId, int noOfCopies);
}
