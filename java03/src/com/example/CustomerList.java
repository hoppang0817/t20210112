package com.example;

import java.util.ArrayList;

import com.example.vo.CustomerVO;

public class CustomerList {
	
	ArrayList<CustomerVO> customerList = null;

	public CustomerList() {
		super();
		 customerList = new ArrayList<CustomerVO>();
	}
	

	
	public ArrayList<CustomerVO> getCustomerList() {
		return customerList;
	}




	public void setCustomerList(ArrayList<CustomerVO> customerList) {
		this.customerList = customerList;
	}




	//메소드 : 고객 1명씩추가
	public int addCustomerVO(String id, String name, int age, String date) {
		try {
			CustomerVO obj = new CustomerVO(id,name,age,date);
			customerList.add(obj);
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
