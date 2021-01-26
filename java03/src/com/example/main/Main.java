package com.example.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.StudentList01;

//주석문

// syso+ ctrl + space
// ctrl + shift + f = 자동정렬
// ctrl + / => 주석설정 및 해제
// ctrl + z => 되돌리기
public class Main {

	public static void main(String[] args) {
		//키보드로 숫자2개를 입력받아서 합을 구하시오.
//		Scanner obj = new Scanner(System.in);      //System.out 의 반대
//		System.out.println("첫번째 숫자를 입력하시요?");
//		int a = obj.nextInt();                     //int를 입력 받을 때는 nextInt 메서드를 이용한다.
//		System.out.println("두번째 숫자를 입력하시요?");
//		int b = obj.nextInt();
//      
		
		
//		int c = a + b;
//		System.out.println("두수의 합은 :"+ c);
//		
//		if(c >=90 && c<=95) {
//			System.out.println("A");
//		}
//		else if (c>=80) {
//			System.out.println("B");
//		}
//		else {
//			System.out.println("c");
//		}
		
		//문제) 숫자 1개를 입력받아서 5의 배수이면 A 아니면B를 출력하시오.
		
//		Scanner obj = new Scanner(System.in); 
//	    System.out.println("첫번째 숫자를 입력하시요?");
//	    int a = obj.nextInt();
//	
//		if (a % 5 == 0) {
//			System.out.println("A");
//		}
//		else {
//			System.out.println("B");
//		}
		//문제) 숫자 2개를 입력받아서 평균이 90이사은 A,80이상은B,나머지는 C
		
//		Scanner obj = new Scanner(System.in);
//	    System.out.println("첫번째 숫자를 입력하시요?");
//		int a = obj.nextInt();
//	    System.out.println("두번째 숫자를 입력하시요?");
//	    int b = obj.nextInt();
//		
//        int c = a + b;
//		if(c/2>=90) {
//			System.out.println("A");
//		}
//		else if(c/2>=80) {
//			System.out.println("B");
//		}
//		else {
//			System.out.println("C");
//		}
//		
		//문제) 숫자1개를 입력 받아서 가장 마지막 숫자를 구하시오.
		Scanner obj = new Scanner(System.in); 
	    System.out.println("첫번째 숫자를 입력하시요?");
	    int a = obj.nextInt();
	    System.out.println(a % 10);
		obj.close();
		
	/*	
		  Calc obj2 = new Calc(10, 20);
          Calc obj3 = new Calc();
           
          //obj2.setNum1(10); // obj2.num1 = 10;
          // obj2.setNum2(20); // obj2.num2 = 20;
          
          int ret = obj2.sum();
          System.out.println(ret);
          
		
		
		
		
		실습- boardtbl의 첫번째 항목에 대해 보관하기 위한 변수정의
		날짜는 String으로
		출력
		BoardVO obj = new BoardVO();
		obj.brd_No = 7;
		obj.brd_Title = "제목";
		obj.brd_Contret = "내용";
		obj.brd_Writer = "c";
		obj.brd_Hit = 1;
		obj.brd_Date = "2021/01/04";
	    System.out.println(obj.toString() );
		
	    
	    MemberVO obj1 = new MemberVO();
	    obj1.user_Id = "A";
	    obj1.user_Pw = "abc";
	    obj1.user_Age = 25;
	    obj1.user_Tel = "010-0000-0001";
	    obj1.user_Date = "2021/01/05";
	    obj1.user_Addr = "부산";
	    obj1.user_Name = "가나다";
	    System.out.println(obj1.toString());
	
	   
		
		1. 변수 설정
		2. 변수에 값을 넣음 . 주의 사항: 타입을 맞춰야 됨.
		3. 형변환등 기타..
		4. 반복문 ,조건문 을 이용한 처리
		5. 출력 또는 다른 곳을 전달
		String userId = "ABC";
		String userAge = "13";
		String userTel = "010-0000-0001";
		
		// 문자를 숫자로 변경
		int userAge1 = Integer.parseInt(userAge);
		System.out.println(userAge1 + 1);
		
		
		float a = 24;
		float b = 13;
		
		System.out.println("a"+ b);
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		
		
		int a =13;            //정수  byte, short, int, long
		float b = 3.45f;      //실수  float, double
		char c = 'a';         //문자1개  ''사용
		String d = "hello";   //문자열, 문자여러개 ""사용
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		

		System.out.println("hello world");
        // 변수- 데이터 보관을 위해 필요
		int a = 13; // 숫자 32비트를 보관할수 있는 변수 a  <=int는 오라클에 number역활
		int b = 23;

		System.out.println(a);
		System.out.println("a");
		System.out.println("a 변수의 값은 " + a);
		System.out.println("b 변수의 값은 " + b);
*/
		Scanner in = new Scanner(System.in);
		Map<String,StudentList01>map = new HashMap<String,StudentList01>();
		while(true) {
			System.out.println("1.학생등록");
			System.out.println("2.과목등록");
			System.out.println("0.종료");
			int menu = in.nextInt();
			if(menu == 0) {
				break;
			}
			
			
		}
	}

}
