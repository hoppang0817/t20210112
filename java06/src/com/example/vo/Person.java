package com.example.vo;

public class Person {
	
	String name;
	int age;

	//생성자 : 기본값을 설정 정적인것에 해당하는 변수
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//메소드
	//동적인것
	public void show() {
		 System.out.print( name + " " + age + " ");
		 }
}
