package com.example.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//인터페이스한정의는 변경불가
public class CustomerDAOImpl implements CustomerDAO{

	//db연결 정보를 보관할객체
	private Connection conn = null;
	
	//생성자를 통해db 객체를 받음
	public CustomerDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public int insertCustomer(Customer customer) throws Exception {
		
		String sql ="INSERT INTO CUSTOMERTBL (CST_ID, CST_NAME,CST_AGE,CST_DATE)"
				   +"VALUES(?,?,?,CURRENT_DATE)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1,customer.getCst_id());
		ps.setString(2, customer.getCst_name());
		ps.setInt(3, customer.getCst_age());
		
		int result = ps.executeUpdate(); //INSERT  UPDATE  DELETE
		conn.commit();
		return result;
	}

	@Override
	public int deleteCustomer(Customer customer) throws Exception {
		
		String sql = "DELETE FROM CUSTOMERTBL WHERE CST_ID=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
	
		ps.setLong(1, customer.getCst_id());
		
		int result = ps.executeUpdate(); //INSERT  UPDATE  DELETE
		conn.commit();
		return result;
	}

	@Override
	public int updateCustomer(Customer customer) throws Exception {
		
		String sql= "UPDATE CUSTOMERTBL SET CST_NAME=? ,CST_AGE=? WHERE CST_ID=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, customer.getCst_name());
		ps.setInt(2, customer.getCst_age());
		ps.setLong(3,customer.getCst_id());
		
		
		int result = ps.executeUpdate(); //INSERT  UPDATE  DELETE
		conn.commit();
		return result;
		
	}

	@Override
	public ArrayList<Customer> selectCustomer() throws Exception {
		String sql = "SELECT * FROM CUSTOMERTBL ORDER BY CST_ID ASC";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();  //SELECT
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		while(rs.next()) {//한줄씩가져옴
			Customer customer = new Customer(
					rs.getLong("CST_ID"),
					rs.getString("CST_NAME"),
					rs.getInt("CST_AGE"),
					rs.getString("CST_DATE")
					);
				
			customerList.add(customer);	
		}
		return customerList;
	}
	

}
