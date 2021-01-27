package com.example.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class BookStore implements BookWork{
	
	private String name = null;   //������
	private String phone = null;  //����ó
	private Connection conn = null; //DB������ü
	private List<Book>booklist = new ArrayList<Book>();//��ϵ�å���
	
	//������
	public BookStore() {
		super();
	}

	
	public BookStore(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	
	public void addBook(String title, int price, String writer) {
		Book book = new Book(title,price,writer);
		booklist.add(book);
		
	}

	@Override
	public Connection getConnDB() {
		//DB�����ϱ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@1.234.5.158:11521:xe", "id13", "pw13");
			conn.setAutoCommit(false);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//��ü ��ϵ� å�� �Ѱ���
	@Override
	public int sumPrice() {
		int sum = 0;
		for(Book tmp: booklist) {
			sum +=tmp.getPrice();
		}
		
		return sum;
		//return (float)sum/(float)3;
	}

	//��ü ��� ����ϱ�
	@Override
	public void printBooks() {
		
		for(Book book : booklist) {
			System.out.println(book.getTitle()+book.getPrice()+book.getWriter());
		}
		
	}


	
	
	//getter/setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}


	public List<Book> getBooklist() {
		return booklist;
	}


	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	
	
	

	
}
