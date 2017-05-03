package com.gcit.libraryApp.GenericFunction;

import java.sql.Connection;

public interface Generic {
	public void print(String x);
	public void println(String x);
	public int integerCondition();
	public String stringCondition();
	public int viewTable(Connection conn, String table);
	public int viewTable(Connection conn, String table, int id, String nameId);
	public int getTableByIndex(Connection conn, String table, int option);
}
