package com.example.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private Connection connection = null;
	
	//생성자 : DB연결 정보 connection 객체를 받음
	public MemberDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	//회원목록
	public ArrayList<String[]> selectMember(){
		try {
			String sql = "SELECT * FROM MEMBERTBL";
			//PreparedStatement = 프리컴파일 된 SQL 문을 나타내는 객체입니다
			PreparedStatement ps = connection.prepareStatement(sql);
			
			//결과값이 rs에보관됨.
			ResultSet rs = ps.executeQuery();//1. 수행결과로 ResultSet 객체의 값을 반환합니다.
			                                 //2. SELECT 구문을 수행할 때 사용되는 함수입니다.
			
			ArrayList<String[]> memberList = new ArrayList<String[]>();
			
			while(rs.next()) {//한줄씩 가져옴
				//문자열배열 생성
				String[]memberStr = {
				rs.getString("USER_ID"),
				rs.getString("USER_NAME"),
				String.valueOf(rs.getInt("USER_AGE")),//String 형태로만 저장가능하기때문에 변형시켜줌
				rs.getString("USER_TEL")
				};
				memberList.add(memberStr);
			}
		return memberList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	    //회원가입 INSERT INTO 
		public int insertMember(Member member) throws SQLException {
			try {
				String sql ="INSERT INTO MEMBERTBL(USER_ID,USER_PW,USER_AGE,USER_TEL,USER_DATE,USER_ADDR,USER_NAME)"
						   +" VALUES(?, ?, ?, '', CURRENT_DATE, '', ?)";
				//SQL문 사용을 위해 적용
				PreparedStatement ps =connection.prepareStatement(sql);
				
				//?안 내용물 적어주기
				ps.setString(1, member.getId());
				ps.setString(2, member.getPw());
				ps.setShort(3, member.getAge());
				ps.setString(4, member.getName());
				
				int result = ps.executeUpdate(); //INSERT UPDATA DELETE 일경우에 사용(개수가 넘어옴)
				connection.commit();
				return result;
			}
			catch(Exception e){
				e.printStackTrace();
				connection.rollback();
				return 0;
			}
		};
	 
		//회원수정
		public int updateMember(Member member) throws SQLException {
			try {
				String sql = "UPDATE MEMBERTBL SET USER_NAME = ?,USER_AGE =?,USER_PW=? WHERE USER_ID=? ";
				PreparedStatement ps =connection.prepareStatement(sql);
				
				//sql문 순서에 맞쳐서
				ps.setString(1, member.getName());
				ps.setShort(2, member.getAge());
				ps.setString(3, member.getPw());
				ps.setString(4, member.getId());
			
				int result = ps.executeUpdate();
				connection.commit();
				return result;
				
			}
			catch(Exception e){
				e.printStackTrace();
				connection.rollback();
				return 0;
			}
		};
		
		//회원삭제
		public int deleteMember(Member member) throws SQLException {
			try {
				String sql = "DELETE FROM MEMBERTBL WHERE USER_ID = ?";
				PreparedStatement ps =connection.prepareStatement(sql);
				
				ps.setString(1, member.getId());
				
				int result = ps.executeUpdate();
				connection.commit();
				return result;
			}
			catch(Exception e){
				e.printStackTrace();
				connection.rollback();
				return 0;
			}
		};
		
		//로그인
		public Member selectMenberLogin(Member member) {
			try {
				String sql = "SELECT * FROM MEMBERTBL WHERE USER_ID = ? AND USER_PW = ? ";
				PreparedStatement ps =connection.prepareStatement(sql);
				
				ps.setString(1, member.getId());
				ps.setString(2, member.getPw());
				
				ResultSet rs = ps.executeQuery();
				if( rs.next() ) {//1개인 경우 if문으로처리

					Member obj = new Member();
					obj.setId(rs.getString("USER_ID"));
					obj.setPw(rs.getString("USER_PW"));
					obj.setName(rs.getString("USER_NAME"));
					obj.setAge(Short.parseShort(rs.getString("USER_AGE")));
					obj.setTel(rs.getString("USER_TEL"));
					return member;
				}
			return null;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		//회원정보 가져오기
		public Member selectMemberOne(Member member) {
			try {
				String sql = "SELECT * FROM MEMBERTBL WHERE USER_ID =?";
                PreparedStatement ps =connection.prepareStatement(sql);
				
				ps.setString(1, member.getId());
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Member obj = new Member();
				    obj.setId(rs.getString("USER_ID"));
				    obj.setPw(rs.getString("USER_PW"));
				    obj.setName(rs.getString("USER_NAME"));
		        	obj.setAge(Short.parseShort(rs.getString("USER_AGE")));
			        obj.setTel(rs.getString("USER_TEL"));
					return member;
				}
				return null;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
