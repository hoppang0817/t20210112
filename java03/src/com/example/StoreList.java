package com.example;

import java.util.ArrayList;

public class StoreList {
	private String name = null;;
	private String phone = null;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	
	public StoreList() {
		super();
	}


	public StoreList(String name, String phone) {
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


	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}


	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}


	@Override
	public String toString() {
		return "StoreList [name=" + name + ", phone=" + phone + ", customerList=" + customerList + "]";
	}
	
	//메소드 : 고객등록
	public void addCustomer(int customerID, String customerName) {
		Customer costomer = new Customer(customerID,customerName);
		customerList.add(costomer);
	}
	//실습 : 고객번호를 이용해서 고객을 삭제 후 리턴하기

	public int removeCustomer(int customerID) {
		for(Customer tmp : customerList) {
			if(tmp.getCustomerID() == customerID) {
				customerList.remove(tmp);
				return 1;
				
			}
		}
		return 0;
	
	}
	//메소드 : 고객검색 (고객번호가 전달되면 고객리스트에 검색후 고객정보를 리턴)
	public Customer searchCustomer(int customerID) {
		for(Customer tmp : customerList) {
			if(tmp.getCustomerID() == customerID) {
				return tmp;
			}
		}
		return null;
	}

	// 메소드 : 상점 정보출력
		public void printStoreList() {
			System.out.println("=====================================");
			System.out.println("상점명 : " + this.name);
			System.out.println("연락처 : " + this.phone);
			for (Customer tmp : customerList) {
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
