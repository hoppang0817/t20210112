package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO{
	private Connection conn = null;
	
	public SubjectDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
//throws Exception : 사용하는곳에서 예외처리하겠다.
	@Override
	public int insertSubject(Subject subject) throws Exception {
		String sql = "INSERT INTO SUBJECT (SUBJECT_CODE, SUBJECT_NAME,SUBJECT_CLASS,SUBJECT_PROFESSOR, SUBJECT_TIME,SUBJECT_DATE)"
				   + "VALUES(?, ?, ?, ?, ?,CURRENT_DATE)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, subject.getSubject_code());
		ps.setString(2, subject.getSubject_name());
		ps.setString(3, subject.getSubject_class());
		ps.setString(4, subject.getsubject_professor());
		ps.setString(5, subject.getsubject_time());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int deleteSubject(Subject subject) throws Exception {
		String sql = "DELETE FROM SUBJECT WHERE SUBJECT_CODE=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, subject.getSubject_code());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int updateSubject(Subject subject) throws Exception {
		String sql = "UPDATE SUBJECT SET SUBJECT_NAME = ?,SUBJECT_CLASS =?,SUBJECT_PROFESSOR =?,SUBJECT_TIME =?"
			     	+ "WHERE SUBJECT_CODE =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, subject.getSubject_name());
		ps.setString(2, subject.getSubject_class());
		ps.setString(3, subject.getsubject_professor());
		ps.setString(4, subject.getsubject_time());
		ps.setString(5, subject.getSubject_code());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public List<Subject> selectSubject() throws Exception {
		String sql = "SELECT * FROM SUBJECT ORDER BY SUBJECT_CODE ASC";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Subject> subjectList = new ArrayList<Subject>();//전체 목록을 보관할 변수
		while(rs.next()) {//한줄씩가져옴
			//subject 객체 생성
			Subject subject = new Subject(
					rs.getString("SUBJECT_CODE"),
					rs.getString("SUBJECT_NAME"),
					rs.getString("SUBJECT_CLASS"),
					rs.getString("SUBJECT_PROFESSOR"),
					rs.getString("SUBJECT_TIME"),
					rs.getString("SUBJECT_DATE")
					);
			//리스트 변수에 추가
					subjectList.add(subject);
			
		}
		return subjectList;
	}

	@Override
	public List<Subject> selectSubjectList(Subject subject) throws Exception {
		String sql = "SELECT * FROM SUBJECT WHERE SUBJECT_NAME LIKE '%'|| ? ||'%'";
		PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, subject.getSubject_name());
		ResultSet rs = ps.executeQuery();
		
		List<Subject> list = new ArrayList<Subject>();
		while(rs.next()) {
			Subject subject1 = new Subject(
					rs.getString("SUBJECT_CODE"),
					rs.getString("SUBJECT_NAME"),
					rs.getString("SUBJECT_CLASS"),
					rs.getString("SUBJECT_PROFESSOR"),
					rs.getString("SUBJECT_TIME"),
					rs.getString("SUBJECT_DATE")
					);
			   list.add(subject1);
		}
		
		return list;
	}

	
	@Override
	public Subject selectSubjectOne(Subject subject) throws Exception {
		String sql = "SELECT * FROM SUBJECT WHERE SUBJECT_CODE=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, subject.getSubject_code());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Subject obj = new Subject(
					rs.getString("SUBJECT_CODE"),
					rs.getString("SUBJECT_NAME"),
					rs.getString("SUBJECT_CLASS"),
					rs.getString("SUBJECT_PROFESSOR"),
					rs.getString("SUBJECT_TIME"),
					rs.getString("SUBJECT_DATE")
					);
			return obj;
			
		}
		
		return null;//해당항목 없음
	}

}
