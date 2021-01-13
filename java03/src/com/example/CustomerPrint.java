package com.example;

import com.example.vo.CustomerVO;

public class CustomerPrint {
	
	private CustomerList customerA = null;

	public CustomerPrint(CustomerList customerA) {
		this.customerA = customerA;
	}
	
	public void PrintCustomer() {
		
		for(CustomerVO tmp : customerA.customerList) {
			System.out.println("아이디 :"+tmp.getId()+" 이름 :"+tmp.getName()+" 나이 :"+tmp.getAge()+" 등록일 :"+tmp.getDate());
		}
	
		
	}

}
