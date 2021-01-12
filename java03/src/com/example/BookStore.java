package com.example;

public class BookStore {
	private String name = null; // 서점명
	private String tel = null; // 연락처
	private Book[] books = new Book[100]; // 최대 보유 가능책
	private int bookCnt = 0; // 보유하고 있는 책 수량

	// 생성자
	public BookStore() {

	}

	// getter / setter
	public BookStore(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	// 메소드
	// 책을 등록한다.
	public void registerBook(Book book) {
		book.setPosition("위치1");

		// books라는 배열에 bookCnt위치에 1권 추가
		books[bookCnt] = book;
		// 위치를 1증가시킴: 다음에 등록할 배열의 인덱스
		bookCnt++;
	}

	// 등록된 책 출력하기
	// 반복문을 등록한 개수만큼 회전하고 한개를 꺼내서 임시변수 tmp보관 후 getter을 이용하여 출력
	// private Book[] books 에서 Book[]는 임의의 자료형임으로 tmp로 보관후
	// System.out.println(books[i}); 이건 출력 안됨

	public void printBooks() throws Exception {
		// 실습- 책이 없는 경우에 오류를 발생기켜 던짐.
		if (bookCnt < 1) {
			throw new Exception("printBooks error");
		}

		for (int i = 0; i < bookCnt; i++) {
			Book tmp = books[i];
			// System.out.println(tmp.getTitle()+","+tmp.getPrice()+","+tmp.getAuthor());
			// 위에 표현써도 되지만 Book클래스에 toString 생성후 사용하면 더 편함
			System.out.println(tmp.toString());
		}
	}

}
