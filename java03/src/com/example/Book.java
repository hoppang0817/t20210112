package com.example;

public class Book {
	private String title = null; // 제목
	private int price = 0; // 가격
	private String author = null; // 저자
	private float discountRate = 0.0f; // 할인율
	private String position = null; // 책위치

	// 생성자
	// source ->using fields 선택

	public Book() {

	}

	public Book(String title, int price, String author, float discountRate, String position) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.discountRate = discountRate;
		this.position = position;
	}

	// getter / setter 만들기
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	// 메소드

	// 판매가격 구하기
	public int sellingPrice() {
		// 예외처리
		try {
			if (discountRate < 0) {
				throw new Exception("discountRate error");

			}
			// price = 10000-(10000*0.1);
			int tmp = price - (int) (price * discountRate);
			return tmp;
			// return price - (int)(price*discountRate);

		} catch (Exception e) {
			// 오류발생에 알림창을 표시
			// 개발자 확인하기 위한 용도
			// try에서 수행후 오류가 나면 여기로
			// e.getMessage() :오류가 발생한 메시지

			System.out.println(e.getMessage());
			return -1;
		} finally {
			// try에서 수행후 무조건 여기로

		}
	}

	// 판매가격 구하기 : 오류를 던진경우에는 메소드에 던진다고 정의
	// 오류 발생시 Main에서 직접 처리
	public int sellingPrice1() throws Exception {
		if (discountRate < 0) { // 오류 발생 시점
			throw new Exception("discountRate error");
		}
		int tmp = price - (int) (price * discountRate);
		return tmp;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + ", discountRate=" + discountRate
				+ ", position=" + position + "]";
	}
	
	
}
