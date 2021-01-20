package com.example.shop;

public class Item {
    private long itm_no =0;
    private String itm_name=null;
	private String itm_content= null;
	private long itm_price= 0;
	private int itm_cnt=0;
	private String itm_date=null;
	
	
	public Item() {
		super();
	}
	
	


	public Item(long itm_no) {
		super();
		this.itm_no = itm_no;
	}




	public Item(long itm_no, String itm_name, String itm_content, long itm_price, int itm_cnt, String itm_date) {
		super();
		this.itm_no = itm_no;
		this.itm_name = itm_name;
		this.itm_content = itm_content;
		this.itm_price = itm_price;
		this.itm_cnt = itm_cnt;
		this.itm_date = itm_date;
	}


	public long getItm_no() {
		return itm_no;
	}


	public void setItm_no(long itm_no) {
		this.itm_no = itm_no;
	}


	public String getItm_name() {
		return itm_name;
	}


	public void setItm_name(String itm_name) {
		this.itm_name = itm_name;
	}


	public String getItm_content() {
		return itm_content;
	}


	public void setItm_content(String itm_content) {
		this.itm_content = itm_content;
	}


	public long getItm_price() {
		return itm_price;
	}


	public void setItm_price(long itm_price) {
		this.itm_price = itm_price;
	}


	public int getItm_cnt() {
		return itm_cnt;
	}


	public void setItm_cnt(int itm_cnt) {
		this.itm_cnt = itm_cnt;
	}


	public String getItm_date() {
		return itm_date;
	}


	public void setItm_date(String itm_date) {
		this.itm_date = itm_date;
	}


	@Override
	public String toString() {
		return "Item [itm_no=" + itm_no + ", itm_name=" + itm_name + ", itm_content=" + itm_content + ", itm_price="
				+ itm_price + ", itm_cnt=" + itm_cnt + ", itm_date=" + itm_date + "]";
	}
	
	
	
	

}
