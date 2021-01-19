package com.example;

import com.example.frame.MyFrame;
import com.example.thread.MyThread1;
import com.example.thread.MyThread2;

public class Main {

	public static void main(String[] args) {
		//System.out.println("hello world");
		new MyFrame("java");
		
		/*
		//3개가 동시에 무한반복 출력
		try { 
		//인터페이스로 받아 출력
	    Thread obj = new Thread( new MyThread2(1) );
	    obj.start();
		
		Thread obj2 = new Thread (new MyThread2(2));
		obj2.start();
		
		//상속으로 받아 출력
		MyThread1 obj3 = new MyThread1(3);
        obj3.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        */
	}

}
