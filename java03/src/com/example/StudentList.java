package com.example;

import java.util.ArrayList;

import com.example.vo.Subject;

public class StudentList {
	private int studentID = 0; // 학번
	private String studentName = null; // 학생이름
	// private Subject[] subjectArray = null; //수강하는 과목들..
	private ArrayList<Subject> subjectList = null; // 수강하는 과목들..

	// 생성자1
	public StudentList() {
		super();
		
		subjectList = new ArrayList<Subject>();//->과목이 들어갈 공간확보 
	}

	// 생성자2 : 학번과 학생이름으로만
	public StudentList(int studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;

		// subjectArray = new Subject[100]; //100개 ->100이상은 등록X(정적,실행속도 빠름)
		subjectList = new ArrayList<Subject>();// 개수가 X ->개수가 정해저있지않음 추가하면 무한대로 늘어남(동적,실행속도가 조금 느림)
	}                                                  //->공간확보
	
	//getter / setter
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

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	
	
	// 메소드 : 과목 1개씩등록
	public int addSubject(String name, int score) {
		try {
			Subject obj = new Subject(name, score);
			subjectList.add(obj);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void showStudentInfo() {
		System.out.println("학번: " + this.studentID);
		System.out.println("이름: " + this.studentName);

		//출력값은 밑에 for문과 같음
		for (Subject tmp : subjectList) {
			System.out.println("교과목 : " + tmp.getName() + "점수 : " + tmp.getScorePoint());
		}
		
		
		for(int i =0;i<subjectList.size();i++) {
			Subject tmp = subjectList.get(i);
			System.out.println("교과목: "+tmp.getName() + "점수: "+tmp.getScorePoint());
		}

	}

}
