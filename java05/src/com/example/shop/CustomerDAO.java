package com.example.shop;

import java.util.ArrayList;

//인터페이스 : 구현부가 없음 정의만 가능!!!!
public interface CustomerDAO {
	//고객등록 메소드명
	public int insertCustomer(Customer customer) throws Exception; 

	//고객삭제 메소드명
	public int deleteCustomer(Customer customer)throws Exception;
	
	//고객수정 메소드명
	public int updateCustomer(Customer customer)throws Exception;
	
	//고객목록 메소드명
	public ArrayList<Customer> selectCustomer()throws Exception;
}
