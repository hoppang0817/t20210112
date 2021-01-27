package com.example.vo;

public class Student extends Person {
	
	String major;

	
	//Person의 이름, 나이정보 변경
	public Student(String name, int age) {
		super(name, age);
		
	}

	//이름,나이+학과
	public Student(String name, int age,String major) {
		super(name, age);
		this.major = major;
		
	}

	@Override
	public void show() {
		super.show();
		System.out.println(major);
	}

}
