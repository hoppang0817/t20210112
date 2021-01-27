package com.project;

public class Subject {
	
	private String subject_code = null;
	private String subject_name = null;
	private String subject_class = null;
	private String professor = null;
	private String time = null;
	private String date = null;
	
	
	public Subject() {

	}


	public Subject(String subject_code, String subject_name, String subject_class, String professor, String time, String date) {
		super();
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.subject_class = subject_class;
		this.professor = professor;
		this.time = time;
		this.date = date;
	}


	public String getSubject_code() {
		return subject_code;
	}


	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}


	public String getSubject_name() {
		return subject_name;
	}


	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}


	public String getProfessor() {
		return professor;
	}


	public void setProfessor(String professor) {
		this.professor = professor;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	
	public String getSubject_class() {
		return subject_class;
	}


	public void setSubject_class(String subject_class) {
		this.subject_class = subject_class;
	}


	@Override
	public String toString() {
		return "Subject [subject_code=" + subject_code + ", subject_name=" + subject_name + ", professor=" + professor + ", time="
				+ time + ", date=" + date + "]";
	}
	
	

}
