package com.example.vo;

public class Book {
	
	private String title = null;
	private int price = 0 ;
	private String writer = null;
	
	//»ý¼ºÀÚ
	public Book() {
		
	}


	public Book(String title, int price, String writer) {
		super();
		this.title = title;
		this.price = price;
		this.writer = writer;
	}


	//getter/setter
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	//toStrign
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", writer=" + writer + "]";
	}

	
	
}
