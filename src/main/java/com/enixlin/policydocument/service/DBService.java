package com.enixlin.policydocument.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ResultsetRows;
import com.mysql.cj.xdevapi.Statement;





public class DBService {
	private Connection conn;
	
	public DBService(String sqlstring,String userName,String password) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		// 建立连接
//		String URL = "jdbc:mysql://localhost:3306/jmrc?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
//		String USER = "linzhenhuan";
//		String PASSWORD = "aAbc123456!";
		//2. 获得数据库连接
        Connection conn = null;
		try {
			conn = DriverManager.getConnection(sqlstring, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.setConn(conn);
		
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<LinkedHashMap<String, String>> query(String sql, ArrayList<Object> params) throws SQLException {
		System.out.println(params.toString());
		PreparedStatement  pst = this.conn.prepareStatement(sql);
			for(int n=0,len=params.size();n<len;n++) {
				System.out.println(params.get(n).toString());
				pst.setString(n+1, params.get(n));
			}
			ResultSet rs = pst.executeQuery();
			
	        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();  
	        int count = rsmd.getColumnCount(); 
	        ArrayList<LinkedHashMap<String, String>> result_array=new ArrayList<>();
	        while(rs.next()) {
	        	LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();  
	            for (int i = 1; i <= count; i++) {  
	                String key = rsmd.getColumnName(i);  
	                String value = rs.getString(i);  
	                hm.put(key, value);  
	            }  
	            result_array.add(hm);
	        }
	       return result_array;

	}

}
