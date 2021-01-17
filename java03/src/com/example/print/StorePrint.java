package com.example.print;

import com.example.StoreMap;
import com.example.vo.Customer;

public class StorePrint {
	private StoreMap store1;

	public StorePrint(StoreMap store1) {
		super();
		this.store1 = store1;
	}
	
	
	public StoreMap getStore1() {
		return store1;
	}


	public void setStore1(StoreMap store1) {
		this.store1 = store1;
	}

	@Override
	public String toString() {
		return "StorePrint [store1=" + store1 + "]";
	}


	public void printStoreInfo() {
		System.out.println("=====================================");
		System.out.println("상점명 : " + store1.getName());
		System.out.println("연락처 : " + store1.getPhone());
		for(int key : store1.getCustomerMap().keySet()) {
			Customer tmp = store1.getCustomerMap().get(key);
			System.out.println("---------------------------------");
			System.out.println("고객번호 :" + tmp.getCustomerID());
			System.out.println("고객이름 :" + tmp.getCustomerName());
			System.out.println("고객등급 :" + tmp.getCustomerGrade());
			System.out.println("고객포인트 :" + tmp.getBonusPoint());
			System.out.println("----------------------------------");
		}
		System.out.println("====================================");
	}


	
}
