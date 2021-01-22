package com.example.test1;

public abstract class Test01 {
	
	//생성자
	public Test01() {
		System.out.println("생성자");
	}
	
	public Test01(int a) {
		System.out.println("생성자1");
	}

	//메소드
	public void print() {
		System.out.println("메소드");
	}
    public void stePrint() {
    	System.out.println("1.단계====================");
    	//2.단계  
    	step2();//사용하고자 하는사람이 반드시 구현 해야함
    	System.out.println("3.단계====================");
    }
    
    public abstract void step2();

}
