package com.example.main;

import java.util.ArrayList;

import com.example.vo.Car1;
import com.example.vo.CarMarket;
import com.example.vo.Corporation;
import com.example.vo.Customer;

public class Main06_Car1 {

	public static void main(String[] args) {
		// 실습 : Main 에서 고객3명, 제조사 5개를 생성
		// ArrayList에 ownerList, makeList 에 보관

		//고객
		Customer customer1 = new Customer(1001, "김희진");
		Customer customer2 = new Customer(1002, "김수지");
		Customer customer3 = new Customer(1003, "안소휘");

		
		ArrayList<Customer> ownerList = new ArrayList<Customer>();
		ownerList.add(customer1);
		ownerList.add(customer2);
		ownerList.add(customer3);

		
		//제조사
		Corporation cor1 = new Corporation("미니", "서울", "02-000-1234");
		Corporation cor2 = new Corporation("유유", "울산", "053-000-1547");
		Corporation cor3 = new Corporation("벤츠", "대전", "031-000-1954");
		Corporation cor4 = new Corporation("애플", "서울", "02-000-1256");
		Corporation cor5 = new Corporation("삼성", "부산", "051-000-7894");

		ArrayList<Corporation> makeList = new ArrayList<Corporation>();
		makeList.add(cor1);
		makeList.add(cor2);
		makeList.add(cor3);
		makeList.add(cor4);
		makeList.add(cor5);

		
		
		CarMarket market = new CarMarket("중고자동차마켓","051-000-1234");

		//차량등록하기
		market.addCar1(new Car1("00가 1234",customer1,"검정", cor3, "K1", 1200));
		market.addCar1("00가 1235",customer2, "검정", cor2, "K2", 2200);
		
	}
 }
