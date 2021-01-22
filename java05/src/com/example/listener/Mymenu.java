//버튼이 포함된 화면
package com.example.listener;

public class Mymenu {

	public Mymenu() {
		MyButton button = new MyButton();
		button.addMyActionListener(al);
	}

//	
//	@Override
//	public void actionPerformed(String e) {
//		//이벤트가 발생했을때 수행할 소스구현
//		//실시간알림
//		System.out.println(e);
//		
//	}
//implements를 하지않은 ActionListener
	MyActionListener al = new MyActionListener() {
		@Override
		public void actionPerformed(String e) {
			//이벤트가 발생했을때 수행할 소스구현
			//실시간알림
			System.out.println(e);
	}
	
	};
}
