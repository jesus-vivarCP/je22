package com.gcit.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCDemo {
	
	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost/library";
	public static String username = "root"; 
	public static String password = "root";

	public static void main(String[] args) throws SQLException {
		Connection  conn = null;
		Statement stmt = null;
		String query = "";
		PreparedStatement pstmt = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new Author: ");
		String authorName = scan.nextLine();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(Boolean.FALSE);
			stmt = conn.createStatement();
//			query = "INSERT INTO tbl_author (authorName) values('"+authorName+"')";
//			stmt.executeUpdate(query);
//			query = "select * from tbl_author where authorName like '%"+authorName+"%'";
//			query = "select * from tbl_author where authorName like ?";
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, authorName);
////			ResultSet rs = stmt.executeQuery(query);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()){
//				System.out.println("Author ID: "+rs.getInt("authorId"));
//				System.out.println("Author Name: "+rs.getString("authorName"));
//			}
			
			query = "update tbl_author set authorName = ? where authorId = ?";
			query = "INSERT INTO tbl_author (authorName) values(?)";
//			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			pstmt.setInt(2, 322);
			pstmt.executeUpdate();
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			scan.close();
		}

	}

}
