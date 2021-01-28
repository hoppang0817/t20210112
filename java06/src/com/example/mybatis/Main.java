package com.example.mybatis;

import java.util.List;

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
			
			MyBatisStudentDAOImpl mstDAO = new MyBatisStudentDAOImpl();
			Student s2 = new Student("0000000007","손흥민",3,"010-1594-1234","생체",null);
			//int result = mstDAO.insertStudent(s2);
//			if(result >0) {
//				System.out.println("등록완료");
//			}else {
//				System.out.println("등록실패");
//			}
			Student s3 = new Student();
			s3.setstudent_major("물리");
			List<Student> studentList = mstDAO.selectStudentList(s3);
			for(Student tmp : studentList) {
				System.out.println(tmp.toString());
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
