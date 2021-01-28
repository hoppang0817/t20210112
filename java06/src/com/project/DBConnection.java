package com.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection(){
		try {
			Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@1.234.5.158:11521:xe", "id13", "pw13");
			conn.setAutoCommit(false);
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
