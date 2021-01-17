package com.example.main;

import com.example.LoopEx;
import com.example.print.BoardPrint;
import com.example.vo.BoardVO;

public class Main02 {

	public static void main(String[] args) {
		LoopEx obj = new LoopEx();
		obj.print();//1~5출력
		
		LoopEx obj1 = new LoopEx(10);
		obj1.print();//1~10출력
		
		LoopEx obj2 = new LoopEx(10);
		obj2.print5();
		
//		int[] a = {23,45,6,7,4,5,43};
//		ArrayEx obj3 = new ArrayEx(a);
//		obj3.print();
//		
//		int[] b = {23,45,6,7,4,5,43};
//		ArrayEx obj4 = new ArrayEx(b);
//		obj4.print1();
//		obj4.print2();
//		
//		ArrayEx obj5 = new ArrayEx(a);
//		obj5.print4();
//		obj5.print6();
//		
		BoardVO b1 = new BoardVO();
		b1.setBrd_No(1);
		b1.setBrd_Title("제목");
		b1.setBrd_Contret("내용");
		b1.setBrd_Writer("작성자");
		b1.setBrd_Hit(2);
		b1.setBrd_Date("2021-01-02");
		
		BoardVO b2 = new BoardVO();
		b2.setBrd_No(2);
		b2.setBrd_Title("제목1");
		b2.setBrd_Contret("내용2");
		b2.setBrd_Writer("작성자2");
		b2.setBrd_Hit(2);
		b2.setBrd_Date("2020-01-14");
		
		//int[] a = new int[5]; - 압축하는거
		BoardVO[] a = new BoardVO[2];
		a[0]=b1;
		a[1]=b2;
		
		BoardPrint obj5 = new BoardPrint(a);
		obj5.print();
		
	}
}
