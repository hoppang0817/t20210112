package com.example.vo;

import java.util.ArrayList;

public class CarMarket {
	private String name = null;  //매장이름
	private String phone = null; //연락처
	private ArrayList<Car1> carList = new ArrayList<Car1>();//보유차량목록
	
	
	
	//메소드로 차량등록하기
	
	public void addCar1(Car1 car) {
		carList.add(car);
	}

	public void addCar1(String num, Customer owner, String color, Corporation make, String model, int price) {
		Car1 car = new Car1(num, owner, color, make, model, price);
		carList.add(car);
	}
	
	
	//차량 목록 출력
	public void printCar1List() {
		// 차량번호, 소유자아이디, 소유자 이름 ,색상, 제조사회사명, 제조사연락처, 모델, 가격
		for(Car1 car : this.carList ) {
			System.out.println(car.getNum() + ","
					+ car.getOwner().getCustomerID() + ","
					+ car.getOwner().getCustomerName() + ","
					+ car.getColor() + ","
					+ car.getMake().getName() + ","
					+ car.getMake().getPhone() + ","
					+ car.getModel() +","
					+ car.getPrice()
			);
		}
	}
	
	//색상별 차량 조회
	//if(color ==13){ == 표시는 숫자만 가능
	//   color.equals{ 문자열 비교
	public ArrayList<Car1> searchCar1Color(String color){
		
		ArrayList<Car1> retList = new ArrayList<Car1>();
	
		for(Car1 car : this.carList) {
			if(car.getColor().equals(color)) {//색상에 해당하면
				retList.add(car);//위에 설정한 변수에 값을 추가
			}
		}
		//반복문 종료 후 보관되어 있는 내역 리턴
		return retList;
		
	}
	
	
	
	
	
	
	public CarMarket() {
		super();
	}


	public CarMarket(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public ArrayList<Car1> getCarList() {
		return carList;
	}


	public void setCarList(ArrayList<Car1> carList) {
		this.carList = carList;
	}


	@Override
	public String toString() {
		return "CarMarket [name=" + name + ", phone=" + phone + ", carList=" + carList + "]";
	}

	
}
