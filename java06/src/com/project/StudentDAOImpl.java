package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

	private Connection conn = null;
	
	public StudentDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public int insertStudent(Student student) throws Exception {
		String sql = "INSERT INTO STUDENT(STUDENT_ID,STUDENT_NAME,STUDENT_GRADE,STUDENT_PHONE,STUDENT_MAJOR,STUDENT_DATE)"
				     +"VALUES(?, ?, ?, ?, ?,CURRENT_DATE)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, student.getStudent_id());
		ps.setString(2, student.getStudent_name());
		ps.setInt(3, student.getstudent_grade());
		ps.setString(4, student.getstudent_phone());
		ps.setString(5, student.getstudent_major());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int deleteStudent(Student student) throws Exception {
		String sql = "DELETE FROM STUDENT WHERE STUDENT_ID =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStudent_id());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int updateStudent(Student student) throws Exception {
		String sql = "UPDATE FROM STUDENT SET STUDENT_NAME =?,STUDENT_GRADE=?,STUDENT_PHONE=?,STUDENT_MAJOR =? WHERE STUDENT_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStudent_name());
		ps.setInt(2, student.getstudent_grade());
		ps.setString(3, student.getstudent_phone());
		ps.setString(4, student.getstudent_major());
		ps.setString(5, student.getStudent_id());
		int result = ps.executeUpdate();
		conn.commit();
		
		return result;
	}

	@Override
	public List<Student> selectStudentList() throws Exception {
		String sql = "SELECT * FROM STUDENT  ORDER BY STUDENT_ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Student> studentList = new ArrayList<Student>();
		while(rs.next()) {
			Student student = new Student(
					rs.getString("STUDENT_ID"),
					rs.getString("STUDENT_NAME"),
					rs.getInt("STUDENT_GRADE"),
					rs.getString("STUDENT_PHONE"),
					rs.getString("STUDENT_MAJOR"),
					rs.getString("STUDENT_DATE")
					);
			studentList.add(student);
			
		}
		return studentList;
	}

	@Override
	public List<Student> selectStudentList(Student student) throws Exception {
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_MAJOR LIKE '%' || ? || '%'  ORDER BY STUDENT_GRADE DESC";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Student> StudentList = new ArrayList<Student>();
		while(rs.next()) {
			Student obj = new Student(
					rs.getString("STUDENT_ID"),
					rs.getString("STUDENT_NAME"),
					rs.getInt("STUDENT_GRADE"),
					rs.getString("STUDENT_PHONE"),
					rs.getString("STUDENT_MAJOR"),
					rs.getString("STUDENT_DATE")
					);
			StudentList.add(obj);
		}
		return StudentList;
	}

	@Override
	public Student selectStudentOne(Student student) throws Exception {
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStudent_id());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Student obj = new Student(
					rs.getString("STUDENT_ID"),
					rs.getString("STUDENT_NAME"),
					rs.getInt("STUDENT_GRADE"),
					rs.getString("STUDENT_PHONE"),
					rs.getString("STUDENT_MAJOR"),
					rs.getString("STUDENT_DATE")
					);
			return obj;
		}
		return null;
	}
	
	
}
