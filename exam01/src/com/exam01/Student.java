package com.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class Student implements StudentManager{
	private String studentID = null;
	private String name= null;
	private ArrayList<Subject>list = new ArrayList<Subject>();
	private Connection conn = null;

	
	
	public Student() {
		super();
	}

	
	
	public Student(String studentID, String name) {
		super();
		this.studentID = studentID;
		this.name = name;
	}
	
	
	

	public String getStudentID() {
		return studentID;
	}



	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<Subject> getList() {
		return list;
	}



	public void setList(ArrayList<Subject> list) {
		this.list = list;
	}



	public Connection getConn() {
		return conn;
	}



	public void setConn(Connection conn) {
		this.conn = conn;
	}


	

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", list=" + list + ", conn=" + conn + "]";
	}



	@Override
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@1.234.5.158:11521:xe", "id13", "pw13");
			conn.setAutoCommit(false);
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	public void addSubject(String code, String name, float score) {
		
		Subject subject = new Subject(code,name,score);
		list.add(subject);
		
	}

	@Override
	public float getAverage() {
		
		int sum =0;
		for(Subject tmp : list) {

			sum +=tmp.getscore();
		}
		
		return  (float)sum/(float)list.size();
	}
	
	
}
