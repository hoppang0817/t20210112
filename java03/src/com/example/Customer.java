package com.example;

public class Customer {
	private int customerID =0;               //고객번호
	private String customerName = null;     //고객이름
	private String customerGrade = null;    //고객등급
	private int bonusPoint = 0;             //포인트
	
	
	public Customer() {
		super();
	}


	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "SILVER";
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerGrade() {
		return customerGrade;
	}


	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}


	public int getBonusPoint() {
		return bonusPoint;
	}


	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + "]";
	}
	
	//메소드 : 포인트 적립  (기존포인트 + 추가포인트)
	public void addBonusPoint(int bonusPoint) {
		this.bonusPoint += bonusPoint;
	}
	
	
	
	
	


}
