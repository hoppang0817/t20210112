package com.example.vo;

import java.sql.Connection;

public interface BookWork {
	
	public Connection getConnDB();//DB�����ϱ�
	
	public int sumPrice();//�� ���ݱ��ϱ�
	
	public void printBooks();//å��� ���
	
}
