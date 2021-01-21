package com.example.shop;

import java.util.List;

public interface OrderDAO {
	
	//주문하기 : 주문내역정보가 오면 DB에 추가한후 리턴하기(0또는1)
	//( )안에 넣은정보가 들어오면 int로 반환해준다
	public int insertOrder(Order order) throws Exception;

	//주문취소
	public int deleteOrder(Order order)throws Exception;
	
	//주문수량변경
	public int updateOrder(Order order)throws Exception;
	
	//주문내역(고객)-물품을 구매한 고객본인이 볼수있는 주문내역 고객정보를 들고와야 확인가능함
	//ArrayList 사용해도 상관없음 정답은 없음
	public List<Order> selectOrder(Customer customer)throws Exception;

	//------------------------------------
	//고객별 주문내역
	public List<Order> selectOrder()throws Exception;
	
	//날짜별 주문내역
	public List<Order> selectOrderDate()throws Exception;

	//100개미만 재고수량 파악
	public List<Order>selectOrderCnt()throws Exception;
}
