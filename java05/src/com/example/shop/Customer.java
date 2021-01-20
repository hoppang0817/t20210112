package com.example.shop;

public class Customer {
	
	private long cst_id=0;     
	private String cst_name=null;
	private int cst_age=0;
	private String cst_date=null;
	
	
	public Customer() {
		super();
	}


	public Customer(long cst_id, String cst_name, int cst_age, String cst_date) {
		super();
		this.cst_id = cst_id;
		this.cst_name = cst_name;
		this.cst_age = cst_age;
		this.cst_date = cst_date;
	}


	public long getCst_id() {
		return cst_id;
	}


	public void setCst_id(long cst_id) {
		this.cst_id = cst_id;
	}


	public String getCst_name() {
		return cst_name;
	}


	public void setCst_name(String cst_name) {
		this.cst_name = cst_name;
	}


	public int getCst_age() {
		return cst_age;
	}


	public void setCst_age(int cst_age) {
		this.cst_age = cst_age;
	}


	public String getCst_date() {
		return cst_date;
	}


	public void setCst_date(String cst_date) {
		this.cst_date = cst_date;
	}


	@Override
	public String toString() {
		return "Customer [cst_id=" + cst_id + ", cst_name=" + cst_name + ", cst_age=" + cst_age + ", cst_date="
				+ cst_date + "]";
	}

	
}
