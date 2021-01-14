package com.example;

import com.example.frame.MyFrame1;

public class Main05 {

	public static void main(String[] args) {
		//실습
		//storeMap을 이용하여 상점과 연락처를 설정하고,고객을 5명추가하시오.
		
		StoreMap store = new StoreMap("상점1", "051-000-1234");

		store.addCustomer(1001, "길동이");
		store.addCustomer(1002, "김연아");
		store.addCustomer(1005, "박지성");
		store.addCustomer(1004, "손흥민");
		store.addCustomer(1008, "김희진");

		// store를 MyFrame1로 전달해서 출력
		
		
		
		StoreMap store1 = new StoreMap("상점1", "051-000-1234");

		store1.addCustomer(1010, "a");
		store1.addCustomer(1011, "b");
		store1.addCustomer(1018, "d");
		

		StorePrint obj = new StorePrint(store1);
		obj.printStoreInfo();
		
		
		//new MyFrame1("title");

		/*
		
		//상점 생성
		StoreList store = new StoreList("상점1", "051-000-1234");

		생성한변수이름?.set
		
		// 고객등록
		store.addCustomer(1001, "가");
		store.addCustomer(1002, "나");
		store.addCustomer(1005, "마");
		
		
		//고객 수정
		
		
		// 고객검색
		//! = not의미 *customer가null이아닌경우
		Customer customer = store.searchCustomer(1010);
		if(customer != null) {
		System.out.println(customer.toString());
		}
		else {
			System.out.println("고객정보가 없습니다.");
		}

		//고객 삭제
		store.removeCustomer(1005);
		
		//정보출력
		store.printStoreList();
		
	
		
		//정보출력Map
		StoreMap store1 = new StoreMap("상점1", "051-000-1234");
		
		store1.addCustomer(1010, "a");
		store1.addCustomer(1011, "b");
		store1.addCustomer(1018, "d");
		
		System.out.println(store1.removeCustomer(1012));
		
		
		store1.printCustomerMap();
*/
	}

}
