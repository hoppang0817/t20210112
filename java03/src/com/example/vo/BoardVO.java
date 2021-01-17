package com.example.vo;





public class BoardVO {
	
	
	public int brd_No=0;
	public String brd_Title = null;
	public String brd_Contret = null;
	public String brd_Writer = null;
	public int brd_Hit = 0;
	public String brd_Date = null;
	
	

	public int getBrd_No() {
		return brd_No;
	}


	public void setBrd_No(int brd_No) {
		this.brd_No = brd_No;
	}


	public String getBrd_Title() {
		return brd_Title;
	}


	public void setBrd_Title(String brd_Title) {
		this.brd_Title = brd_Title;
	}


	public String getBrd_Contret() {
		return brd_Contret;
	}


	public void setBrd_Contret(String brd_Contret) {
		this.brd_Contret = brd_Contret;
	}


	public String getBrd_Writer() {
		return brd_Writer;
	}


	public void setBrd_Writer(String brd_Writer) {
		this.brd_Writer = brd_Writer;
	}


	public int getBrd_Hit() {
		return brd_Hit;
	}


	public void setBrd_Hit(int brd_Hit) {
		this.brd_Hit = brd_Hit;
	}


	public String getBrd_Date() {
		return brd_Date;
	}


	public void setBrd_Date(String brd_Date) {
		this.brd_Date = brd_Date;
	}


	
	
	@Override
	public String toString() {
		return "BoardVO [brd_No=" + brd_No + ", brd_Title=" + brd_Title + ", brd_Contret=" + brd_Contret
				+ ", brd_Writer=" + brd_Writer + ", brd_Hit=" + brd_Hit + ", brd_Date=" + brd_Date + "]";
	}
	

}
