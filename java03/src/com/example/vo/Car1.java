package com.example.vo;

public class Car1 {
	private String num = null;  //차량번호
	private Customer owner= null; //소유자
	private String color = null; //색상
	private Corporation make =null; //제조사
	private String model = null;  //모델
	private int price = 0;  //가격
	
	
	public Car1() {
		super();
	}


	public Car1(String num, Customer owner, String color, Corporation make, String model, int price) {
		super();
		this.num = num;
		this.owner = owner;
		this.color = color;
		this.make = make;
		this.model = model;
		this.price = price;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public Customer getOwner() {
		return owner;
	}


	public void setOwner(Customer owner) {
		this.owner = owner;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Corporation getMake() {
		return make;
	}


	public void setMake(Corporation make) {
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


	@Override
	public String toString() {
		return "Car1 [num=" + num + ", owner=" + owner + ", color=" + color + ", make=" + make + ", model=" + model
				+ ", price=" + price + "]";
	}


	
}
