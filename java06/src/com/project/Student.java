package com.project;

public class Student {

	private String student_id = null;
	private String student_name = null;
	private int student_grade = 0;
	private String student_phone = null;
	private String student_major = null;
	private String student_date = null;
	
	
	public Student() {
		
	}


	public Student(String student_id, String student_name, int student_grade, String student_phone, String student_major, String student_date) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_grade = student_grade;
		this.student_phone = student_phone;
		this.student_major = student_major;
		this.student_date = student_date;
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


	public int getstudent_grade() {
		return student_grade;
	}


	public void setstudent_grade(int student_grade) {
		this.student_grade = student_grade;
	}


	public String getstudent_phone() {
		return student_phone;
	}


	public void setstudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}


	public String getstudent_major() {
		return student_major;
	}


	public void setstudent_major(String student_major) {
		this.student_major = student_major;
	}


	public String getstudent_date() {
		return student_date;
	}


	public void setstudent_date(String student_date) {
		this.student_date = student_date;
	}


	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_grade=" + student_grade + ", student_phone="
				+ student_phone + ", student_major=" + student_major + ", student_date=" + student_date + "]";
	}
	
	
	
	
	
}
