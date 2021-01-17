package com.example.vo;

public class MemberVO {

	public String user_Id = null;
	public String user_Pw = null;
	public int user_Age = 0;
	public String user_Tel = null;
	public String user_Date = null;
	public String user_Addr = null;
	public String user_Name = null;
	
	
	@Override
	public String toString() {
		return "MemberVO [user_Id=" + user_Id + ", user_Pw=" + user_Pw + ", user_Age=" + user_Age + ", user_Tel="
				+ user_Tel + ", user_Date=" + user_Date + ", user_Addr=" + user_Addr + ", user_Name=" + user_Name + "]";
	}
	
	

}
