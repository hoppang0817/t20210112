package com.example.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn1 {
	
     	//정적변수 생성
		private static Connection connection = null;
		
		public DBConn1() {
			try {
			getConnection();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		//정적메소드 생성
		public static Connection getConnection() throws SQLException {
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
				connection.close();
				return null;
			}
			finally {
				
			}
		}
		//프로시저 호출
		public void callProcedure(int a) {
			try {
				//프로시저 호출하기
				CallableStatement cs = connection.prepareCall("{CALL PROC_EX07(?,?)}");
				cs.setInt(1, a);//IN
				cs.registerOutParameter(2, java.sql.Types.NUMERIC);//OUT
			    int result = cs.executeUpdate();//프로시져 실행
			    
			    if(result > 0) {
			    	System.out.println(cs.getInt(2));//5또는10중에서 하나가 출력
			    }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

}
