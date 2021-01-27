package com.project;

public class Course {

	private int code = 0;
	private int score =0; 
	private String regdate = null;
	private Subject subject_code = null;
	private Student student_id = null;
	
	public Course() {
		
	}

	public Course(int code, int score, String regdate) {
		super();
		this.code = code;
		this.score = score;
		this.regdate = regdate;
	}
	

	public Course(int code, int score, String regdate, Subject subject_code, Student student_id) {
		super();
		this.code = code;
		this.score = score;
		this.regdate = regdate;
		this.subject_code = subject_code;
		this.student_id = student_id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public Subject getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(Subject subject_code) {
		this.subject_code = subject_code;
	}

	public Student getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Student student_id) {
		this.student_id = student_id;
	}

	
	@Override
	public String toString() {
		return "Course [code=" + code + ", score=" + score + ", regdate=" + regdate + ", subject_code=" + subject_code
				+ ", student_id=" + student_id + "]";
	}
	
	
	
	
	
	
	
}
