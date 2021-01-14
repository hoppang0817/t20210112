package com.example;

import java.util.HashMap;

//순차적으로 반복해서 값을 출력할땐 ArrayList
//하나의 키로만 값을 출력할땐 Map

public class StoreMap {
	private String name = null; // 가게이름
	private String phone = null;// 연락처
	// 고객목록 Integer - 키 키값을 알면 반복없이 바로 데이터 들고옴
	private HashMap<Integer, Customer> customerMap = new HashMap<Integer, Customer>();

	public StoreMap() {
		super();
	}

	public StoreMap(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public HashMap<Integer, Customer> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(HashMap<Integer, Customer> customerMap) {
		this.customerMap = customerMap;
	}

	@Override
	public String toString() {
		return "StoreMap [name=" + name + ", phone=" + phone + ", customerMap=" + customerMap + "]";
	}

	// 메소드 : 고객등록
	public void addCustomer(int customerID, String customerName) {
		Customer customer = new Customer(customerID, customerName);
		// ArrayList와 차이점 : 키를 가지고 있음
		customerMap.put(customerID, customer);
	}

	// 메소드 : 고객 삭제
	public int removeCustomer(int customerID) {
		Customer customer = customerMap.remove(customerID);
		if (customer == null) {
			return 0;
		}
		return 1;
	}

	// 메소드 : 고객정보출력
	public void printCustomerMap() {
		System.out.println("=====================================");
		System.out.println("상점명 : " + this.name);
		System.out.println("연락처 : " + this.phone);
		for (int key : customerMap.keySet()) {
			Customer tmp = customerMap.get(key);
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
