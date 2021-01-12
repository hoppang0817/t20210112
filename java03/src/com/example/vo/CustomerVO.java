package com.example.vo;

//고객테이블에 해당하는객체
public class CustomerVO {
	private String id = null;  //고객아이디
	private String name = null; //고객이름
	private int age = 0;        //고객나이
	private String date = null; //등록일자
	
	//생성자
	public CustomerVO() {
		
	}


	public CustomerVO(String id, String name, int age, String date) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.date = date;
	}
	

	//getter(결과물을 볼수있음)/ setter(값을 적어넣음)
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	//toString
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", age=" + age + ", date=" + date + "]";
	}

	

	
	
}
