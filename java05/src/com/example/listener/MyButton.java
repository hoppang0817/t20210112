package com.example.listener;
//                            무한반복
public class MyButton extends Thread{
	private MyActionListener actionListener = null;
	public MyButton() {
		
	}

	public void addMyActionListener(MyActionListener action) {
		this.actionListener = action;
		this.start();
	}

	@Override
	public void run() {
		super.run();
		int n=1;
		while(true) {
			try {
				if(n % 5 ==0) {
					if(actionListener!= null) {
						actionListener.actionPerformed("이벤트발생됨");
					}
				}
				Thread.sleep(1000);
				n++;
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
		}
	}

}
