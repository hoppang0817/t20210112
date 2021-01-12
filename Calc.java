package com.example;

//calc 클래스에 두개의 정수 숫자를 넘겨주면 
//합,차,곱,몫, 나머지를 구하는 것을 만들어
public class Calc {
	//2개의 숫자를 보관
	//public 외부에서 사용가능함을 표시 꼭 적어줘야함.
	//private 사용시 외부에서 값을 변경 불가.
	//대부분은 private로 만들어 져있음.
	private int num1 = 0;
	private int num2 = 0;
	
	
    //생성자 : public 클래스명 (숫자1,숫자2){
	public Calc() {
		
	}
	
	public Calc(int a, int b) {// 생성자 : 전돨된 값을 a,b에 넣음
		num1 = a;
		num2 = b;
	}
	
	//메소드 : 하는 일
	// public 리턴타입 메소드명() {  }
	public int sum() {
	   return num1 + num2;
	}

	public int sub() {
		return num1 - num2;
	}

	public int mul() {
		return num1 * num2;
	}

	public int div() {
		return num1 / num2;
	}

	public int mod() {
		return num1 % num2;
	}

	
	
	//private로 외부에서 값을 변경하지 못할때 추가로 만들어 줘야 외부의 값을 들고올수있음.
	//source - getter and setters 선택
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	
	

	

}
