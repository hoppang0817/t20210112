package com.example.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.project.Course;
import com.project.Student;
import com.project.Subject;

public class Main {

	public static void main(String[] args) {
		try {
			MyBatisDAOImpl msDAO = new MyBatisDAOImpl();
			List<Subject> subjectList = msDAO.selectSubject();
			for(Subject tmp: subjectList) {
				System.out.println(tmp.toString());
			}
			
			System.out.println("-----------------------------------------");
			
			Subject s1 = new Subject();
			s1.setSubject_code("10001");
			Subject result1 = msDAO.selectSubjectOne(s1);
			if(result1 !=null) {
				System.out.println(result1.toString());
			}
			
			System.out.println("-------------------------------------------------");
			
//			MyBatisStudentDAOImpl mstDAO = new MyBatisStudentDAOImpl();
//			Student s2 = new Student("0000000007","손흥민",3,"010-1594-1234","생체",null);
			//int result = mstDAO.insertStudent(s2);
//			if(result >0) {
//				System.out.println("등록완료");
//			}else {
//				System.out.println("등록실패");
//			}
//			Student s3 = new Student();
//			s3.setstudent_major("물리");
//			List<Student> studentList = mstDAO.selectStudentList(s3);
//			for(Student tmp : studentList) {
//				System.out.println(tmp.toString());
//			}
			
			MyBatisCourseDAOImpl mcDAO = new MyBatisCourseDAOImpl();
			
//			Course c1 = new Course();
//			c1.setScore(90);
//			Student st1 = new Student();
//			st1.setStudent_id("0000000005");
//			c1.setStudent_id(st1);
//			Subject su1 = new Subject();
//			su1.setSubject_code("10006");
//			c1.setSubject_code(su1);
//			
//			int result = mcDAO.insertCourse(c1);
//			System.out.println(result);
//			
		
		List<Course> list = mcDAO.selectCourseListe();
		for(Course tmp : list) {
			System.out.println(tmp.toString());
		}
		
		System.out.println("================================================");
		
		Course c1 = new Course();
		Student st1 = new Student();
		st1.setStudent_id("0000000001");
		c1.setStudent_id(st1);
		
		List<Course> courseList = mcDAO.selectCourseListeWhere(c1);
		for(Course tmp : courseList) {
			System.out.println(tmp.toString());
		}
		
		System.out.println("==================================================");
		
		Course c2 = new Course();
		Student st2 = new Student();
		st2.setStudent_id("0000000005");
		c2.setStudent_id(st2);
		Subject su2 = new Subject();
		su2.setSubject_code("10006");
		c2.setSubject_code(su2);
		
		Course result = mcDAO.selectCourseOne(c2);
		
		System.out.println(result.toString());
		
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
