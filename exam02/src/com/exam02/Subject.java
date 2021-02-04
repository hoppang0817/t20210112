package com.exam02;

public class Subject {
	
	private String subject_code = null;
	private String subject_name = null;
	private String subject_class = null;
	private String subject_professor = null;
	private String subject_time = null;
	private String subject_date = null;
	
	
	public Subject() {

	}


	public Subject(String subject_code, String subject_name, String subject_class, String subject_professor, String subject_time, String subject_date) {
		super();
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.subject_class = subject_class;
		this.subject_professor = subject_professor;
		this.subject_time = subject_time;
		this.subject_date = subject_date;
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


	public String getsubject_professor() {
		return subject_professor;
	}


	public void setsubject_professor(String subject_professor) {
		this.subject_professor = subject_professor;
	}


	public String getsubject_time() {
		return subject_time;
	}


	public void setsubject_time(String subject_time) {
		this.subject_time = subject_time;
	}


	public String getsubject_date() {
		return subject_date;
	}


	public void setsubject_date(String subject_date) {
		this.subject_date = subject_date;
	}

	
	public String getSubject_class() {
		return subject_class;
	}


	public void setSubject_class(String subject_class) {
		this.subject_class = subject_class;
	}


	@Override
	public String toString() {
		return "Subject [subject_code=" + subject_code + ", subject_name=" + subject_name + ", subject_class="
				+ subject_class + ", subject_professor=" + subject_professor + ", subject_time=" + subject_time + ", subject_date=" + subject_date + "]";
	}


	
	

}
