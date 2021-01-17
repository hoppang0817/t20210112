package com.example.print;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.vo.Car;

public class CarPrint {
	
	//ArrayList<Car>객체 타입으로 전달되는 데이터 출력
	public void printArrayListCar( ArrayList<Car> carList) {
		System.out.println("============ArrayList<Car>=========");
		
		//for(한개를 꺼냈을때 타입  변수명 : 전체리스트변수)
		for(Car car : carList) {
			System.out.println(car.getNum() + "," +car.getOwner());
			
		}
	}
	
	//ArrayList<String[]>객체 타입으로 전달되는 데이터 출력
	public void printArrayList( ArrayList<String[]> car2List) {
		System.out.println("======ArrayList<String[]> ==========");
		
		//for(한개를 꺼냈을때 타입  변수명 : 전체리스트변수)
		for(String[] car2 : car2List) {
			System.out.println(car2[0] +","+ car2[1]+"," +car2[2]+","+car2[3]);
		}
	}
	
	
	//String[][]
	public void printStingArray2(String[][] car2Array1) {
		System.out.println("===========String[][]============");
		
		int i=0;
		for(i = 0;i<car2Array1.length;i++) {
			System.out.println(car2Array1[i][0]+","+car2Array1[i][1]);
		
			}
	}
		
	//HashMap<String, Object>
	public void printArrayListHashMap
	(ArrayList<HashMap<String, Object>> car3List) {
		System.out.println("=======HashMap<String, Object>========");
		
		for(HashMap<String, Object> car3: car3List) {
			System.out.println(car3.get("num")+
					         ","+car3.get("owner"));
		}
	}
	
}
