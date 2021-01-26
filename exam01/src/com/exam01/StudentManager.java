package com.exam01;

import java.sql.Connection;

public interface StudentManager {

	public Connection getConnection();
	
	public void addSubject(String code,String name,float score);
	
	public float getAverage();
}
