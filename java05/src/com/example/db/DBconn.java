package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
	//정적변수 생성
	private static Connection connection = null;

	//정적메소드 생성
	public static Connection getConnection() {
		try {
			//1.드라이브 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DB접속
			connection = DriverManager.getConnection("jdbc:oracle:thin:@1.234.5.158:11521:xe", "id13", "pw13");
		    
			//3.autocommit 설정 해제 
			connection.setAutoCommit(false);
			return connection;
		}
		catch(Exception e) {//1,2,3 수행시 오류가 발생하면....여기로
			e.printStackTrace();
			return null;
		}
	}
}
