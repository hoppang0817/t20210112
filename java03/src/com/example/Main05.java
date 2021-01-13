package com.example;
//실습
//CustormerVO 객체 3개생성
//CustormerList
//CustormerPrint
import com.example.vo.CustomerVO;

public class Main05 {

	public static void main(String[] args) {
		
		CustomerList customer1 = new CustomerList();
		customer1.addCustomerVO("A", "Lee", 25, null);
		
		CustomerList customer2 = new CustomerList();
		customer2.addCustomerVO("B", "Kim", 52, null);
		
		CustomerList customer3 = new CustomerList();
		customer3.addCustomerVO("C", "Yun", 30, null);

	
		
		CustomerPrint obj = new CustomerPrint(customer1);
		obj.PrintCustomer();
		new CustomerPrint(customer2).PrintCustomer();
	}
}