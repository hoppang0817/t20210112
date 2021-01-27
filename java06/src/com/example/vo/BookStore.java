package com.example.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class BookStore implements BookWork{
	
	private String name = null;   //서점명
	private String phone = null;  //연락처
	private Connection conn = null; //DB연동객체
	private List<Book>booklist = new ArrayList<Book>();//등록된책목록
	
	//생성자
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
		//DB연동하기
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

	//전체 등록된 책의 총가격
	@Override
	public int sumPrice() {
		int sum = 0;
		for(Book tmp: booklist) {
			sum +=tmp.getPrice();
		}
		
		return sum;
		//return (float)sum/(float)3;
	}

	//전체 목록 출력하기
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
