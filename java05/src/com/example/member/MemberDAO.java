package com.example.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	private Connection connection = null;
	
	//생성자 : DB연결 정보 connection 객체를 받음
	public MemberDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	//회원목록
	public ArrayList<String[]>selectMember(){
		try {
			String sql = "SELECT * FROM MEMBERTBL";
			//PreparedStatement = 프리컴파일 된 SQL 문을 나타내는 객체입니다
			PreparedStatement ps = connection.prepareStatement(sql);
			
			//결과값이 rs에보관됨.
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String[]> memberList = new ArrayList<String[]>();
			
			while(rs.next()) {//한줄씩 가져옴
				//문자열배열 생성
				String[]memberStr = {
				rs.getString("USER_ID"),
				rs.getString("USER_PW"),
				String.valueOf(rs.getInt("USER_AGE")),//String 형태로만 저장가능하기때문에 변형시켜줌
				rs.getString("USER_TEL"),
				rs.getString("USER_DATE"),
				rs.getString("USER_ADDR"),
				rs.getString("USER_NAME")
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
	
	    //회원가입 INSTERT INTO 
		public void insertMember() {};
	 
		//회원수정
		public void updateMember() {};
		
		//회원삭제
		public void deleteMember() {};
}
