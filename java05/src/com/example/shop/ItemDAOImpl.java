package com.example.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl extends ItemDAO {

	//생성자를 통해 DB연결하는connection 객체를 받음.
	private Connection conn = null;
	
	public ItemDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public int insertItem(Item item) {
		try {
		String sql = "INSERT INTO ITEMTBL (ITM_NO, ITM_NAME, ITM_CONTENT, ITM_PRICE, ITM_CNT, ITM_DATE)"
				     +"VALUES(SEQ_ITEMTABL_ITME_NO.NEXTVAL, ?, ?, ?, ?, CURRENT_DATE)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, item.getItm_name());
		ps.setString(2, item.getItm_content());
		ps.setLong(3, item.getItm_price());
		ps.setInt(4, item.getItm_cnt());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deletetItem(Item item){
		try {
		String sql = "DELETE FROM ITEMTBL WHERE ITM_NO=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setLong(1, item.getItm_no());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateItem(Item item){
		try {
		String sql = "UPDATE FROM ITEMTBL SET ITM_NAME =?, ITM_CONTENT=?, ITM_PRICE=?, ITM_CNT=? WHERE ITM_NO=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, item.getItm_name());
		ps.setString(2, item.getItm_content());
		ps.setLong(3, item.getItm_price());
		ps.setInt(4, item.getItm_cnt());
		ps.setLong(5, item.getItm_no());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Item> selectItem() {
		try {
		String sql = "SELECT * FROM ITEMTBL";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Item> itemList = new ArrayList<Item>();
		while(rs.next()) {
			Item item = new Item(
					rs.getLong("ITM_NO"),
					rs.getString("ITM_NAME"),
					rs.getString("ITM_CONTENT"),
					rs.getLong("ITM_PRICE"),
					rs.getInt("ITM_CNT"),
					rs.getString("ITM_DATE")
					);
			itemList.add(item);
		}
		return itemList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> selectItem(String searchText) {
		try {
			//SELECT * FROM 테이블명 WHERE 조건 LIKE '%'||'가나다'||'%'
			String sql = "SELECT * FROM ITEMTBL WHERE ITM_NAME LIKE '%' || ? ||'%'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, searchText);
			
			
			ResultSet rs = ps.executeQuery();
			
			List<Item> itemList = new ArrayList<Item>();
			while(rs.next()) {
				Item item = new Item(
						rs.getLong("ITM_NO"),
						rs.getString("ITM_NAME"),
						rs.getString("ITM_CONTENT"),
						rs.getLong("ITM_PRICE"),
						rs.getInt("ITM_CNT"),
						rs.getString("ITM_DATE")
						);
				itemList.add(item);
		}
			return itemList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Item> selectItem(int start, int end) {
		try {
			//SELECT * FROM (SELECT 컬럼명들...,ROW_NUBER()OVBER(ORDER BY ITM_NO ASC) ITM_ROWS FROM 테이블명)
			            //    + WHERE ITM_ROWS BETWEEN ? AND ?
			String sql ="SELECT * FROM (SELECT ITM_NO, ITM_NAME, ITM_CONTENT, ITM_PRICE, ITM_CNT, ITM_DATE, "
					                  +"ROW_NUMBER() OVER(ORDER BY ITM_NO ASC)ITM_ROWS FROM ITEMTBL)WHERE ITM_ROWS BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			
			ResultSet rs = ps.executeQuery();
			
			List<Item> itemList = new ArrayList<Item>();
			while(rs.next()) {
				Item item = new Item(
						rs.getLong("ITM_NO"),
						rs.getString("ITM_NAME"),
						rs.getString("ITM_CONTENT"),
						rs.getLong("ITM_PRICE"),
						rs.getInt("ITM_CNT"),
						rs.getString("ITM_DATE")
						);
				itemList.add(item);
			}
		return itemList;
	
	    }catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
   }
}

