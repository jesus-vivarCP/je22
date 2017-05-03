package com.gcit.libraryApp.DB;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {
	public Connection connectToDataBase() throws SQLException, ClassNotFoundException;
}
