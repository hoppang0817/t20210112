package com.example.shop;

public class Order {
	
	private int ord_no =0;          //주문번호
	private int ord_cnt =0;         //주문수량
	private String ord_date=null;   //주문일자
	private Item itm_no =null;      //주문한 물품정보
	private Customer cst_id =null;  //주문한 고객정보
	
	
	
	public Order() {
		super();
	}
	public Order(int ord_no, int ord_cnt, String ord_date, Item itm_no, Customer cst_id) {
		super();
		this.ord_no = ord_no;
		this.ord_cnt = ord_cnt;
		this.ord_date = ord_date;
		this.itm_no = itm_no;
		this.cst_id = cst_id;
	}
	public int getOrd_no() {
		return ord_no;
	}
	
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	
	public int getOrd_cnt() {
		return ord_cnt;
	}
	
	public void setOrd_cnt(int ord_cnt) {
		this.ord_cnt = ord_cnt;
	}
	
	public String getOrd_date() {
		return ord_date;
	}
	
	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}
	
	public Item getItm_no() {
		return itm_no;
	}
	
	public void setItm_no(Item itm_no) {
		this.itm_no = itm_no;
	}
	
	public Customer getCst_id() {
		return cst_id;
	}
	
	public void setCst_id(Customer cst_id) {
		this.cst_id = cst_id;
	}
	
	@Override
	public String toString() {
		return "Order [ord_no=" + ord_no + ", ord_cnt=" + ord_cnt + ", ord_date=" + ord_date + ", itm_no=" + itm_no
				+ ", cst_id=" + cst_id + "]";
	}

	
	
	
}
