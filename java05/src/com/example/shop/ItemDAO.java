package com.example.shop;

import java.util.List;

//클래스를 인터페이스화 = 추상클래스
public abstract class ItemDAO {
	
	//추상클래스는 abstract 사용
	
	//목록추가
	public abstract int insertItem(Item item);

	
	//목록삭제
	public abstract int deletetItem(Item item);
	
	
	//목록수정
	public abstract int updateItem(Item item);
	
	
	//전체물품목록
	public abstract List<Item> selectItem();
	
	
	//검색어를 이용한 목록
	public abstract List<Item> selectItem(String searchText);
	
	
	//전체물품(시작,끝)
	public abstract List<Item> selectItem(int start, int end);

	
	public void print() {
		System.out.println("추상클래스는 메소드 구현도 가능");
	}
}
