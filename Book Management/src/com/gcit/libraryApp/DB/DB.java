package com.gcit.libraryApp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements Database {
	private Connection conn = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/library";
	private String username = "root";
	private String password = "java";

	public Connection connectToDataBase() throws SQLException, ClassNotFoundException {
		if (conn != null)
			return conn;

		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(Boolean.FALSE);

		return conn;
	}
}
