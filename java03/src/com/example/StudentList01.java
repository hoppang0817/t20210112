package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.vo.Subject;

public class StudentList01 {

	private int studentID = 0; // 학번
	private String studentName = null; // 학생이름
	private List<Subject> subjectList = new ArrayList<Subject>();
	
	
	public StudentList01() {

	}

	


	public StudentList01(int studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
	}

	
	
	//교과목추가
	public void addSubject(String name, int scorePoint) {
		
		Subject subject = new Subject(name,scorePoint);
		subjectList.add(subject);
	}
	
	//목록출력
	public void PrintSubject() {
		for(Subject tmp : subjectList) {
			System.out.println(tmp.getName()+tmp.getScorePoint());
		}
	}
	
	

	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public List<Subject> getSubjectList() {
		return subjectList;
	}


	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}


}
