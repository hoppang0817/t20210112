package com.example.junit;

import java.sql.Connection;
import java.sql.DriverManager;

public class Calc {

	//변수
	private int a = 0;
	private int b = 0;
	
	//생성자
	public Calc(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	//메소드
	public int  sum() {
		return this.a + this.b;
	}
	
	public int sum(int a , int b) {
		return a + b;
	}
	
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@1.234.5.158:11521:xe", "id13", "pw13");
			
			conn.setAutoCommit(false);
			return conn;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
