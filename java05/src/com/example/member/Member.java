package com.example.member;

public class Member {
//	protected : 상속한 클래스에 접근가능
//	private : 접근 불가
//	public :아나무 변수 접근 가능
	
	private String id = null;
	private String pw = null ;
	private  short age = 0;
	private String tel= null ;
	private String date = null;
	private String addr = null;
	private String name = null;
	
	public Member() {
		super();
	}

	public Member(String id, String pw, short age, String tel, String date, String addr, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.tel = tel;
		this.date = date;
		this.addr = addr;
		this.name = name;
	}

	public Member(String id, String pw, short age, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", age=" + age + ", tel=" + tel + ", date=" + date + ", addr=" + addr
				+ ", name=" + name + "]";
	}

	
}
