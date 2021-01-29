package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
	
	Connection conn = DBConnection.getConnection();

	@Override
	public int insertCourse(Course course) throws Exception {
		String sql="INSERT INTO COURSE (CODE,SCORE,REGDATE,SUBJECT_CODE,STUDENT_ID)"
				+ "VALUES(SEQ_COURSE_CODE.NEXTVAL,?,CURRENT_DATE,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, course.getScore());
		ps.setString(2, course.getSubject_code().getSubject_code());
		ps.setString(3, course.getStudent_id().getStudent_id());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int updateCourse(Course course) throws Exception {
		String sql = "UPDATE COURSE SET SCORE=?,SUBJECT_CODE=?,STUDENT_ID=? WHERE CODE =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, course.getScore());
		ps.setString(2, course.getSubject_code().getSubject_code());
		ps.setString(3, course.getStudent_id().getStudent_id());
		ps.setInt(4, course.getCode());
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int deleteCourse(Course course) throws Exception {
		String sql = "DELETE FROM COURSE WHERE CODE=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, course.getCode());

		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public Course selectCourseOne(Course course) throws Exception {
		String sql = "SELECT * FROM ("
				+ "      SELECT "
				+ "           TABLE1.CODE, TABLE1.SCORE, TABLE1.REGDATE, TABLE1.STUDENT_ID,TABLE1.STUDENT_NAME,TABLE1.STUDENT_GRADE,"
				+ "           SUBJECT.SUBJECT_CODE, SUBJECT.SUBJECT_NAME, SUBJECT.SUBJECT_CLASS, SUBJECT.SUBJECT_PROFESSOR \r\n"
				+ "    FROM ("
				+ "       SELECT COURSE.CODE,COURSE.SCORE, COURSE.REGDATE, COURSE.SUBJECT_CODE, "
				+ "         STUDENT.STUDENT_ID, STUDENT.STUDENT_NAME,STUDENT.STUDENT_GRADE"
				+ "     FROM COURSE,STUDENT WHERE COURSE.STUDENT_ID = STUDENT.STUDENT_ID)TABLE1, SUBJECT"
				+ "     WHERE TABLE1.SUBJECT_CODE = SUBJECT.SUBJECT_CODE)WHERE STUDENT_ID=? AND SUBJECT_CODE=? ";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, course.getStudent_id().getStudent_id());
		ps.setString(2, course.getSubject_code().getSubject_code());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Course course2 = new Course();
			course2.setCode(rs.getInt("CODE"));
			course2.setScore(rs.getInt("SCORE"));
			course2.setRegdate(rs.getString("REGDATE"));

			Student student2 = new Student();
			student2.setstudent_date(rs.getString("STUDENT_ID"));
			student2.setStudent_name(rs.getString("STUDENT_NAME"));
			student2.setstudent_grade(rs.getInt("STUDENT_GRADE"));
			course2.setStudent_id(student2);
			
			Subject subject2 = new Subject();
			subject2.setSubject_code(rs.getString("SUBJECT_CODE"));
			subject2.setSubject_name(rs.getString("SUBJECT_NAME"));
			subject2.setSubject_class(rs.getString("SUBJECT_CLASS"));
			subject2.setsubject_professor(rs.getString("SUBJECT_PROFESSOR"));
			course2.setSubject_code(subject2);
			
			return course2;
		}
		
		return null;
	}

	@Override
	public List<Course> selectCourseListe() throws Exception {
		String sql = "SELECT"
				+ "       TABLE1.CODE, TABLE1.SCORE, TABLE1.REGDATE, TABLE1.STUDENT_ID,TABLE1.STUDENT_NAME,TABLE1.STUDENT_GRADE,"
				+ "       SUBJECT.SUBJECT_CODE, SUBJECT.SUBJECT_NAME, SUBJECT.SUBJECT_CLASS, SUBJECT.SUBJECT_PROFESSOR"
				+ " FROM("
				+ "       SELECT "
				+ "               COURSE.CODE,COURSE.SCORE, COURSE.REGDATE, COURSE.SUBJECT_CODE, "
				+ "               STUDENT.STUDENT_ID, STUDENT.STUDENT_NAME,STUDENT.STUDENT_GRADE"
				+ "       FROM "
				+ "              COURSE,STUDENT "
				+ "       WHERE "
				+ "             COURSE.STUDENT_ID = STUDENT.STUDENT_ID"
				+ "       )TABLE1, SUBJECT"
				+ " WHERE TABLE1.SUBJECT_CODE = SUBJECT.SUBJECT_CODE";
    
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Course> courseList = new ArrayList<Course>();
		while(rs.next()) {
			Course course = new Course();
			course.setCode(rs.getInt("CODE"));
			course.setScore(rs.getInt("SCORE"));
			course.setRegdate(rs.getString("REGDATE"));

			Student student = new Student();
			student.setstudent_date(rs.getString("STUDENT_ID"));
			student.setStudent_name(rs.getString("STUDENT_NAME"));
			student.setstudent_grade(rs.getInt("STUDENT_GRADE"));
			course.setStudent_id(student);
			
			Subject subject = new Subject();
			subject.setSubject_code(rs.getString("SUBJECT_CODE"));
			subject.setSubject_name(rs.getString("SUBJECT_NAME"));
			subject.setSubject_class(rs.getString("SUBJECT_CLASS"));
			subject.setsubject_professor(rs.getString("SUBJECT_PROFESSOR"));
			course.setSubject_code(subject);
			
			courseList.add(course);
			
		}
		return courseList;
	}

	@Override
	public List<Course> selectCourseListeWhere(Course course) throws Exception {
		String sql = "SELECT * FROM "
				+ "     (SELECT"
				+ "        TABLE1.CODE, TABLE1.SCORE, TABLE1.REGDATE, TABLE1.STUDENT_ID,TABLE1.STUDENT_NAME,TABLE1.STUDENT_GRADE,"
				+ "        SUBJECT.SUBJECT_CODE, SUBJECT.SUBJECT_NAME, SUBJECT.SUBJECT_CLASS, SUBJECT.SUBJECT_PROFESSOR"
				+ "      FROM ("
				+ "         SELECT"
				+ "         COURSE.CODE,COURSE.SCORE, COURSE.REGDATE, COURSE.SUBJECT_CODE, "
				+ "         STUDENT.STUDENT_ID, STUDENT.STUDENT_NAME,STUDENT.STUDENT_GRADE "
				+ "     FROM"
				+ "        COURSE,STUDENT WHERE COURSE.STUDENT_ID = STUDENT.STUDENT_ID)TABLE1, SUBJECT "
				+ "     WHERE TABLE1.SUBJECT_CODE = SUBJECT.SUBJECT_CODE)WHERE STUDENT_ID =? ORDER BY SCORE DESC";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, course.getStudent_id().getStudent_id());
		ResultSet rs = ps.executeQuery();
		List<Course> courseList = new ArrayList<Course>();
		while(rs.next()) {
			Course course1 = new Course();
			course1.setCode(rs.getInt("CODE"));
			course1.setScore(rs.getInt("SCORE"));
			course1.setRegdate(rs.getString("REGDATE"));
			
			Student student1 = new Student();
			student1.setStudent_id(rs.getString("STUDENT_ID"));
			student1.setStudent_name(rs.getString("STUDENT_NAME"));
			student1.setstudent_grade(rs.getInt("STUDENT_GRADE"));
			course1.setStudent_id(student1);
			
			
			Subject subject1 = new Subject();
			subject1.setSubject_code(rs.getString("SUBJECT_CODE"));
			subject1.setSubject_name(rs.getString("SUBJECT_NAME"));
			subject1.setSubject_class(rs.getString("SUBJECT_CLASS"));
			subject1.setsubject_professor(rs.getString("SUBJECT_PROFESSOR"));
			course1.setSubject_code(subject1);
			
			courseList.add(course1);
			
		}
	
		return courseList;
	}

}
