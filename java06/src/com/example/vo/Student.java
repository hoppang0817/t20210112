package com.example.vo;

public class Student extends Person {
	
	String major;

	
	//Person�� �̸�, �������� ����
	public Student(String name, int age) {
		super(name, age);
		
	}

	//�̸�,����+�а�
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
