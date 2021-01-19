package com.example.thread;

//상속으로 Thread 받음
public class MyThread1 extends Thread{
	
	private int type =0;
	
	public MyThread1(int type) {
	 this.type = type;	
	}

	//메소드 run()은 오브라이드 해야됨
	//무한반복, 1초간격으로 type변수값을 출려하는 메소드
	@Override
	public void run() {
		super.run();
		
		while(true) {
			System.out.println(type);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
