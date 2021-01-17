package com.example.vo;

public class Corporation {
	private String name = null;  //회사명
	private String addr= null;   //주소
	private String phone = null;//대표전화
	
	
	public Corporation() {
		super();
	}


	public Corporation(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Corporation [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
	
	

}
