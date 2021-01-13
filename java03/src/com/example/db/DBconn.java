package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.vo.CustomerVO;

public class DBconn {

	private Connection conn = null;// DB접속 객체

	public DBconn() {

		try {
			// 1.드라이브 로드(lassNotFoundException)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB접속(SQLException)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@1.234.5.158:11521:xe", "id13", "pw13");
			
			//3.autocommit 설정해제
			conn.setAutoCommit(false);

			// 4.오류가 발생되지 않으면 21라인이 수행됨
			System.out.println("db에 접속되었습니다.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//고객등록
	//int는Main으로 내보내는 값의 자료형 Main에서 int형으로보임  ()안은 Main에서 불러오는 값의 자료형
	public int inserCustomer(CustomerVO obj) throws SQLException {
		try {
			//insert into 수행
			//INSERT INTO 테이블명(컬럼명)VALUES(추가할값..);
			String sql = "INSERT INTO CUSTOMERTBL(CST_ID, CST_NAME, CST_AGE, CST_DATE) "
					+ " VALUES(?, ?, ?, CURRENT_DATE)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getId() ); //첫번째  ?
			pstmt.setString(2, obj.getName()); //두번째 ?
			pstmt.setInt(3, obj.getAge());    //세번째 ?
			
		//INSERT,UPDATE,DELETE(세개다 같은 명령어 executeUpdate사용)SQL문에서 사용함. 리턴 type은 int형 0또는1이상의숫자
			int result = pstmt.executeUpdate();
			conn.commit();
			
			return result;//추가했던 개수를 리턴
		}
		catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
			return 0;
			
		}
	}
	//고객수정(고객아이디[변경불가],고객이름,나이,가입일자[변경불가])
	public int updateCustomer(CustomerVO obj) throws SQLException {
		try {
			//UPDATE 수행
			//UPDATE 테이블명 SET 컬럼명=바꿀값 WHERE 컬럼명;
			String sql = "UPDATE CUSTOMERTBL SET CST_NAME=?, CST_AGE=? WHERE CST_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getName() );
			pstmt.setInt(2, obj.getAge() );
			pstmt.setNString(3, obj.getId() );
			
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
			return 0;
			
		}
	}
	//고객 삭제(고객아이디가 일치하는것 삭제)
	public int deleteCustomer(CustomerVO obj) throws SQLException {
		try {
			//DELETE 수행
			//DELETE FROM 테이블명 WHERE 조건 ;
			String sql = "DELETE FROM CUSTOMERTBL WHERE CST_ID =? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, obj.getId());
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
			
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
			return 0;
		}
	}
	//고객목록
	//int[]a ={1,2,3,4....}
	public ArrayList<CustomerVO> selectCustomer() {
		try {
			String sql = "SELECT * FROM CUSTOMERTBL";
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			ResultSet rs = pstmt.executeQuery();    // SELECT

			//고객 정보를 리스트로 보관할 변수
			ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();
			
			while(rs.next()) { 
				 //rs에 가져온 값을 customervo객체로 만듬
				 CustomerVO obj = new CustomerVO(rs.getString("CST_ID"), 
						 rs.getString("CST_NAME"),
						 rs.getInt("CST_AGE"), 
						 rs.getString("CST_DATE"));

				 //배열에 추가함
				 customerList.add(obj);
			}
			return customerList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
