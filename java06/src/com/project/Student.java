package com.project;

public class Student {

	private String student_id = null;
	private String student_name = null;
	private int grade = 0;
	private String phone = null;
	private String major = null;
	private String date = null;
	
	
	public Student() {
		
	}


	public Student(String student_id, String student_name, int grade, String phone, String major, String date) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.grade = grade;
		this.phone = phone;
		this.major = major;
		this.date = date;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", grade=" + grade + ", phone="
				+ phone + ", major=" + major + ", date=" + date + "]";
	}
	
	
	
	
	
}
