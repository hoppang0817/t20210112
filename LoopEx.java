package com.example;

public class LoopEx {
	int n;
	
	//생성자 : 클래스 명과 같음
	public LoopEx() {
	this.n = 5;	
	}
	//숫자 1개를 입력받는 생성자
	public LoopEx(int n) {
		this.n = n;
	}
	
	//메소드,함수
	public void print() {
		int i =0;
		//for(초기값;조건;증가값){
	 	for (i = 1; i<=n;i++) {
			System.out.print(i + " ");
		}
	 	//여기서 i의 값은?6
	 	System.out.println();
	}
	
	public void print1() {
		int i =0;
		for (i = n; i>=1; i--) {
			System.out.print(i + " ");
		}
		//i의 값은?0
		System.out.println();
	}
	//1 부터 n까지 짝수를 구하시오.
	public void print2() {
		int i =0;
		for (i=1; i<=n; i++) {//1.2.3.4....10출력
			if (i % 2 == 0) {
			System.out.print(i +" ");	
			}
		}
		   System.out.println();
		   
		   for (i=2;i<=n;i+=2) {
				System.out.println(i + " ");
			}
			 System.out.println();
	}
	//3의 배수인 경우만 1아니면 0
	public void print3() {
		int i =0;
		for(i=1;i<=n;i++) {
			if(i % 3 == 0 ) {
				System.out.print("1 ");
			}
			else {
				System.out.print("0 ");
			}
		}
	}
	// break : loop 강제 종료
	public void print4() {
		for (int i =1;i<=n;i++) {
			if(i >= 5) {
				break;
			}
			System.out.print(i+" ");
		}
		//i가 5일때 break에 의해 강제로 이동됨.
		System.out.println();
	}
	// continue : 
	public void print5() {
		for(int i=1;i<=n;i++) {// 1 2 3 4...10
			if(i % 2 == 1) {//1 3 5 7 9일 경우
				continue;// 아래 소스를 수행하지 않고 다음값으로 반복
			}
			System.out.print(i+" ");//2 4 6 8 10
		}
		System.out.println();
	}
	
	
}
