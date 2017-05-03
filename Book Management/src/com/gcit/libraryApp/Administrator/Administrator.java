package com.gcit.libraryApp.Administrator;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

public interface Administrator {
	public void Add(String table, Map<String, ArrayList<String>> values,Map<String, ArrayList<String>> columnTags);
	public int Update(String table,ArrayList<String> columns,ArrayList<String> values);
	public void Delete(String table, ArrayList<String> columns, ArrayList<String> values);
	public void Override(String table, ArrayList<String> ColumnTags,ArrayList<String> args);
	public void getColumnNames(String table, Map<String, ArrayList<String>> args,Map<String, ArrayList<String>> values);
	public ArrayList<String> taskAtTableLocation(Connection conn,String task,ArrayList<String> required,ArrayList<String> ColumnTags);
}
