package com.example.vo;

public class Person {
	
	String name;
	int age;

	//������ : �⺻���� ���� �����ΰͿ� �ش��ϴ� ����
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//�޼ҵ�
	//�����ΰ�
	public void show() {
		 System.out.print( name + " " + age + " ");
		 }
}
