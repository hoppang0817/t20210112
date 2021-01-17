package com.example.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.print.CarPrint;
import com.example.vo.Car;

public class Main05_Car {

	public static void main(String[] args) {
	
		//클래스안 생성자를 이용하여 car를생성
		//요소의 타입이 다양하다
		Car car10 = new Car("00가 1234","홍길동","흰색","제조사","k1",4);
		Car car11 = new Car("00가 1236","홍길동","흰색","제조사","k1",41);
		Car car12 = new Car("00가 1237","홍길동","흰색","제조사","k1",42);
		
		
		//Car클래스 객체를 N개 추가할 수 있는 동적 배열
		//위에 3개의 차종류를 car1List 안에 넣음
		ArrayList<Car> car1List = new ArrayList<Car>();
		car1List.add(car10);
		car1List.add(car11);
		car1List.add(car12);
		
		
		//CarPrint클래스 형태를 들고와 출력 하기
		new CarPrint().printArrayListCar(car1List);

		
		
		//ArrayList를 다른 클래스에서 리스트를 사용할려면 밑에처럼 사용
		//ArrayList에 개수가 추가되든 삭제되든 선언문은 같음
		//public void method1<ArrayList<Car> recvData){    }
		
		

		
		//배열을 이용해서 car를생성
		//요소의 타입이 동일해야 한다.
		//밑에 예제는 스트링으로 동일하기때문에 마지막 인트를 스트링으로 변경해야함
		String[] car20 = new String[6];
		car20[0] = "00가 1234"; 
		car20[1] = "홍길동";
		car20[2] = "흰색";
		car20[3] ="KIA";
		car20[4] ="K1";
		car20[5] =String.valueOf(4); //숫자를 문자로 변경함.
		String[] car21 = {"00가 1236","홍길동","흰색","제조사","k1",String.valueOf(4)};
		String[] car22 = {"00가 1237","홍길동","흰색","제조사","k1",String.valueOf(4)};
		
		
		//ArrayList 동적배열, 개수가 정해져있지 않는 배열
		//위에 3종류의 차를 car2List안에 저장 ArrayList형식으로
		ArrayList<String[]> car2List = new ArrayList<String[]>();
		car2List.add(car20);
		car2List.add(car21);
		car2List.add(car22);
		
		
		new CarPrint().printArrayList(car2List);
		
		
		//2차배열
		//위에 ArrayList를 다시 배열로 전환
		String[][] car2Array = new String[3][6];
		car2Array[0] = car20;
		car2Array[1] = car21;
		car2Array[2] = car22;
						
		String[][] car2Array1 = {
				{"00가 1234","홍길동","흰색","제조사","k1",String.valueOf(4)},
				{"00가 1236","홍길동","흰색","제조사","k1",String.valueOf(4)},
				{"00가 1237","홍길동","흰색","제조사","k1",String.valueOf(4)}
		};
		
		
		new CarPrint().printStingArray2(car2Array1);
		
		//HashMap을 이용하여 car생성
		//Object로 타입을 설정하면 요소의 타입도 다양하게 추가가능
		HashMap<String, Object> car30 = new HashMap<String, Object>();
		car30.put("num", "00가 1234");
		car30.put("owner","가나다");
		car30.put("color","검정색");
		car30.put("make","제조사");
		car30.put("model","A1");
		car30.put("price", 1111);
		car30.put("date","가나다");
		
		HashMap<String, Object> car31 = new HashMap<String, Object>();
		car31.put("num", "00가 1234");
		car31.put("owner","가나다");
		car31.put("color","검정색");
		car31.put("make","제조사");
		car31.put("model","A1");
		car31.put("price", 1111);
		car31.put("date","가나다");
		
		HashMap<String, Object> car32 = new HashMap<String, Object>();
		car32.put("num", "00가 1234");
		car32.put("owner","가나다");
		car32.put("color","검정색");
		car32.put("make","제조사");
		car32.put("model","A1");
		car32.put("price", 1111);
		car32.put("date","가나다");
		
		
		//위에 3종류의 차를 car3List안에 저장 ArrayList형식으로
		ArrayList< HashMap<String, Object> > car3List = new ArrayList< HashMap<String, Object> >();
		car3List.add(car30);
		car3List.add(car31);
		car3List.add(car32);
		
		new CarPrint().printArrayListHashMap(car3List);
		
		
		//HashMap을 다른 클래스에서 리스트를 사용할려면 밑에처럼 사용
		//car30.get("num");
		
		
		
		// 참고 -------------------------- 위에 만든 3개의 리스트들을 하나로 압축
		//추가하기
		//ArrayList<Car> carList
		//ArrayList<String[]> car2List
		//ArrayList< HashMap<String, Object> > car3List
		
		ArrayList<Object> carObject = new ArrayList<Object> ();
		carObject.add(car1List);
		carObject.add(car2List);
		carObject.add(car3List);
		
		//꺼내기
		ArrayList<Car> car1Ret = (ArrayList<Car>)carObject.get(0);
		ArrayList<String[]> car2Ret = (ArrayList<String[]>)carObject.get(1);
		ArrayList< HashMap<String, Object> > car3Ret = (ArrayList< HashMap<String, Object> >)carObject.get(2);
		
		
		
		
		
		
		
		
		
		
		/*	//실습
		//storeMap을 이용하여 상점과 연락처를 설정하고,고객을 5명추가하시오.
		
		StoreMap store = new StoreMap("상점1", "051-000-1234");

		store.addCustomer(1001, "길동이");
		store.addCustomer(1002, "김연아");
		store.addCustomer(1005, "박지성");
		store.addCustomer(1004, "손흥민");
		store.addCustomer(1008, "김희진");

		// store를 MyFrame1로 전달해서 출력
		
		
		
		StoreMap store1 = new StoreMap("상점1", "051-000-1234");

		store1.addCustomer(1010, "a");
		store1.addCustomer(1011, "b");
		store1.addCustomer(1018, "d");
		

		StorePrint obj = new StorePrint(store1);
		obj.printStoreInfo();
		
		
		//new MyFrame1("title");
*/
		/*
		
		//상점 생성
		StoreList store = new StoreList("상점1", "051-000-1234");

		생성한변수이름?.set
		
		// 고객등록
		store.addCustomer(1001, "가");
		store.addCustomer(1002, "나");
		store.addCustomer(1005, "마");
		
		
		//고객 수정
		
		
		// 고객검색
		//! = not의미 *customer가null이아닌경우
		Customer customer = store.searchCustomer(1010);
		if(customer != null) {
		System.out.println(customer.toString());
		}
		else {
			System.out.println("고객정보가 없습니다.");
		}

		//고객 삭제
		store.removeCustomer(1005);
		
		//정보출력
		store.printStoreList();
		
	
		
		//정보출력Map
		StoreMap store1 = new StoreMap("상점1", "051-000-1234");
		
		store1.addCustomer(1010, "a");
		store1.addCustomer(1011, "b");
		store1.addCustomer(1018, "d");
		
		System.out.println(store1.removeCustomer(1012));
		
		
		store1.printCustomerMap();
*/
	}

}
