package com.example.vo;

import java.sql.Connection;

public interface BookWork {
	
	public Connection getConnDB();//DB연결하기
	
	public int sumPrice();//총 가격구하기
	
	public void printBooks();//책목록 출력
	
}
