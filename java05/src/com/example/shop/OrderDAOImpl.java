package com.example.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.db.DBconn;

public class OrderDAOImpl implements OrderDAO{
	
	
	private Connection conn = DBconn.getConnection();
	

	@Override
	public int insertOrder(Order order) throws Exception {
		String sql = "INSERT INTO ORDERTBL (ORD_NO,ORD_CNT,ORD_DATE,ITM_NO,CST_ID)"
				        +"VALUES(SEQ_ORDERTBL_ORD_NO.NEXTVAL, ? ,CURRENT_DATE, ? , ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, order.getOrd_cnt());
		ps.setLong(2,order.getItm_no().getItm_no() );
		ps.setLong(3, order.getCst_id().getCst_id());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int deleteOrder(Order order) throws Exception {
		String sql = "DELETE FROM ORDERTBL WHERE ORD_NO =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, order.getOrd_no());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public int updateOrder(Order order) throws Exception {
		String sql = "UPDATE ORDERTBL SET ORD_CNT =? WHERE ORD_NO=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, order.getOrd_cnt());
		ps.setInt(2, order.getOrd_no());
		
		int result = ps.executeUpdate();
		conn.commit();
		return result;
	}

	@Override
	public List<Order> selectOrder(Customer customer) throws Exception {
		//JOIN
		//SELECT * FROM 테이블1,테이블2 WHERE 테이블1.컬럼명 = 테이블2.컬럼명2.컬럼  AND 조건
		//주문번호,주문수량,주문일자,물품명,물품가격
		String sql ="SELECT ORDERTBL.ORD_NO,ORDERTBL.ORD_CNT,ORDERTBL.ORD_DATE,ITEMTBL.ITM_NAME,ITEMTBL.ITM_PRICE "
				   + "FROM ORDERTBL,ITEMTBL WHERE ORDERTBL.ITM_NO = ITEMTBL.ITM_NO AND ORDERTBL.CST_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, customer.getCst_id());
		
		ResultSet rs = ps.executeQuery();
		
		List<Order>orderList = new ArrayList<Order>();
		while(rs.next()) {
			//주문번호,주문수량,주문일자,(물품명,물품가격)아이템 테이블에만 있음
			Order order = new Order();
			order.setOrd_no(rs.getInt("ORD_NO"));
			order.setOrd_cnt(rs.getInt("ORD_CNT"));
			order.setOrd_date(rs.getString("ORD_DATE"));
			
			Item item = new Item();
			item.setItm_name(rs.getString("ITM_NAME"));
			item.setItm_price(rs.getLong("ITM_PRICE"));
			order.setItm_no(item);//아이템 테이블에있는 물품명,물품가격을 넣어줌
			
			orderList.add(order);
					
		}
		return orderList;
	}

	@Override
	public List<Order> selectOrder() throws Exception {
		String sql = "SELECT * FROM ORDERTBL ORDER BY CST_ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		
		
		return null;
	}

	@Override
	public List<Order> selectOrderDate() throws Exception {
		String sql = "SELECT * FROM ORDERTBL ORDER BY ORD_DATE";
		return null;
	}

	@Override
	public List<Order> selectOrderCnt() throws Exception {
		String sql = "SELECT * FROM ORDERTBL ";
		return null;
	}

}
