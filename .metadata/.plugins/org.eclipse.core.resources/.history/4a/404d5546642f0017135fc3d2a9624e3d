package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO {
	
	public static Connection conn = null;
	
	public BaseDAO(Connection conn){
		this.conn = conn;
	}
	
	private Integer pageNo;
	private Integer pageSize = 10;
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void save(String query, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(query);
		if(vals!=null){
			int count = 1;
			for(Object obj: vals){
				pstmt.setObject(count, obj);
				count++;
			}
		}
		pstmt.executeUpdate();
	}
	
	public Integer saveWithID(String query, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		if(vals!=null){
			int count = 1;
			for(Object obj: vals){
				pstmt.setObject(count, obj);
				count++;
			}
		}
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}
	
	public List read(String query, Object[] vals) throws ClassNotFoundException, SQLException{
		Integer index = 0;
		if(getPageNo()!=null){
			index = (getPageNo()-1)*10;
		}
		query = query+" LIMIT "+index+", "+pageSize;
		PreparedStatement pstmt = conn.prepareStatement(query);
		if(vals!=null){
			int count = 1;
			for(Object obj: vals){
				pstmt.setObject(count, obj);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
	public List readAll(String query, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(query);
		if(vals!=null){
			int count = 1;
			for(Object obj: vals){
				pstmt.setObject(count, obj);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
	public Integer readCount(String query, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(query);
		if(vals!=null){
			int count = 1;
			for(Object obj: vals){
				pstmt.setObject(count, obj);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("COUNT");
		}
		return null;
	}
	
	public abstract List extractData(ResultSet rs) throws SQLException, ClassNotFoundException;
	
	public List readFirstLevel(String query, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(query);
		if(vals!=null){
			int count = 1;
			for(Object obj: vals){
				pstmt.setObject(count, obj);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractDataFirstLevel(rs);
	}
	
	public abstract List extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException;

}
