package com.example.vo;

public class Car {
	private String num = null;
	private String owner= null;
	private String colcr = null;
	private String make =null;
	private String model = null;
	private int price = 0;
	
	//생성자
	
	public Car() {
		super();
	}

	public Car(String num, String owner, String colcr, String make, String model, int price) {
		super();
		this.num = num;
		this.owner = owner;
		this.colcr = colcr;
		this.make = make;
		this.model = model;
		this.price = price;
	}

	
	//getter / setter
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getColcr() {
		return colcr;
	}

	public void setColcr(String colcr) {
		this.colcr = colcr;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	//toString
	@Override
	public String toString() {
		return "Car [num=" + num + ", owner=" + owner + ", colcr=" + colcr + ", make=" + make + ", model=" + model
				+ ", price=" + price + "]";
		
		
	}
	
	

}
