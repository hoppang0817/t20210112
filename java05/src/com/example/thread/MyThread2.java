package com.example.thread;


//Thread를 인터페이스로 받음
public class MyThread2 implements Runnable{

	private int type =0;
	
	//생성자
	public MyThread2(int type) {
		 this.type = type;	
		}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(type);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
