package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.frame.MyTreeFrame;
import com.example.test1.Test02;

public class Main {

	public static void main(String[] args) {
		Test02 obj = new Test02();
		obj.stePrint();
		obj.print();
		
		//25일 시험
		
//		자료형 : 8개
//		문자형 : char
//		정수형 : byte , short , int,long
//		실수형 : float, double
//		논리형 : boolean
//		
//		변수는 문자로시작하고 특수문자_
//		
//		int x =1;
//		int y =0;
//		
//		y = x++;//y = x; x++; x의 값을 y에 넣고 x를 증가시킴
//		y = ++x;//x++; y=x;  x를 증가시킨후 y에 넣음
//
//		System.out.println(x);
//		System.out.println(y);
//		
//		//변수는 초기화를 해야함.!!
//		
//		int i = 3;
//		while(i>0) {//3 2 1
//			System.out.println(i);
//			i--;
//		}
//		//최대값,최소값
//		
//		int[]a = {3,4,45,23};
//		int b = a[0];
//		for(int i =0; i<a.length;i++) {
//			if(a[i]<b) {
//				b=a[i];
//			}
//			System.out.println(b);
//		}
//		
//		//생성자특징 : 객체 초기화시 변수를 설정, 리턴값없음,클래스명과 일치...
//		
//		private int a1;//접근불가
//		public int a2;//접근가능
//		protected int a3;//상속한 클래스까지만 접근 상속해야지만 접근수있음
//		
//		//추상클래스는 메소드중에 한개라도 정의만 된것이있음.객체생성이 안됨.
//		abstract Calss A{
//			public abstract void ()
//		}
//		
//		//final 상속이 불가능한 클래
//		final Calss B{
//			
//		}
//		
//		//일반클래스
//		Calss C{
//			
//		}
//		
//		//예외처리
//		try {
//			//정상적인 코드
//		}
//		catch{
//			//예외발생
//		}
//		finally {
//			//모두 방문하는곳
//		}
//		
//		//ArrayList랑 HashMap차이점 : key랑같이 넣는야 value만 넣는야
//		
//		
//		//최상위 클래스 java.lang.object
//		
//		//키보드입력하는 클래
//		Scanner in = new Scanner(System in);
//		
//		//자바상속 특징 : 다중상속불가, 상속횟수는 상관없음
//		
//		//객체지향특징 : 다형성 (파라미터 자료형이나 수가다르면 다른 메소드), 상속성extends,정보은닉,캡슐화getter/setter
//		
//		//DB연결
//		
		// System.out.println("hello world");
		 new MyTreeFrame("A");
		 
		 //배열
		 //1.개수를 반드시 설정
		 //2.타입이 동일해야함
		 
		 //4개의 문자열을 보관할 수있는배열, 값은 없음
		 String[]a = new String[4];
		 a[0]="a";
		 a[1]="b";
		 a[2]="c";
		 a[3]="d";
		 
		 //3개의 문자열을 보관할수있는 배열. 값이 3개존재함.
		 String[]b = {"a","b","c"};
		 
		 //1차원 String 배열4개를 3번 보관할 수있는 배열
		 String[][] c = new String[3][4];
		 c[0]=a;
		 c[1]=a;
		 c[2]=a;
		 for(int i =0;i<c.length;i++) {//3개
			 for(int j =0; j<c[i].length;j++) {//4개
				 System.out.print(c[i][j]+" ");
			 }
			 System.out.println();
		 }
		 //List는 동적인 배역, 개수를 설정할 필요가 없다. 타입도 같을 필요없다.
		 //같은것으로는 Vector
		 
		 List< String >list = new ArrayList< String >();
		 //String[]a = new String[N개];
		 
		 list.add("a");
		 list.add("b");
		 list.add("c");
		 
		 //위치정보 필요한경우(인덱스)
		 for(int i=0;i<list.size();i++) {
			 System.out.print(list.get(0));
		 }
		 System.out.println();
		 
		 //위치정보 필요없는경우
		 for(String tmp: list) {
			 System.out.print(tmp);
		 }
		 
		 System.out.println();
		 
		 List< String[] >list1 = new ArrayList< String[] >();
		 //String[][] c = new String[N개][4];
		 
		 String []a1 = {"A","B","C"};
		 list1.add(a1);
		 list1.add(new String[] {"a","b","c"});
		 
		 
		 for(int i = 0; i<list1.size();i++) {//2개
			 
			 String[] tmp = list1.get(i);
			 for(int j = 0; j<tmp.length;j++) {//3개
				 System.out.println(tmp[j]);
			 }
		 }
		 
		List<List< String[] >> list2 = new ArrayList<List< String[] >>();
		
		//map은 key와 value값을 가짐. 순차적이지 않음. 키는 중복될수없음.
		Map<String,String[]> map = new HashMap<String,String[]>();
		
		//추가하기
		//add가아닌 put을 사용함
		map.put("A1", new String[] {"a","b","c"});
		map.put("A2", new String[] {"d","e","f"});
		
		//가져오기
		String[]tmp = map.get("A1");
		String[]tmp1 = map.get("A2");
		
		//           여긴 어떤형태라도 들어볼수있음
		Map<String, List< String[] >> map1 = new HashMap<String,List< String[] >>();
		map1.put("K1",list1);
		
		
		//key를 가지고 불러냄.
		List< String[] > list3 = map1.get("K1");
		
		
	
	
	}
}
		/*
		// 스캐너사용!!!
		// 마지막 in.close를위해 밖으로
		Scanner in = new Scanner(System.in);

		try {
			//모둔if문에 사용해야해서 반복문밖에 선언
			CustomerDAOImpl customerDAO = new CustomerDAOImpl(DBconn.getConnection());
			ItemDAOImpl itemDAO = new ItemDAOImpl(DBconn.getConnection());
			OrderDAOImpl orderDAO = new OrderDAOImpl();
			while (true) {
				System.out.println("------------------------------------------------------");
				System.out.println("0.종료");
				System.out.println("1.고객등록 2.고객삭제 3.고객수정 4.고객목록");
				System.out.println("11.물품등록 12.물품삭제 13.물품수정 14.물품목록(전체) 15.물품목록(검색어) 16.물품목록(범위)");
				System.out.println("21.주문하기 22.주문취소 23.주문수량변경 24.주문목록(고객별)");
				System.out.println("메뉴를 선택하시오>>>");
				int menu = in.nextInt();

				if (menu == 0) {
					break;
				} 
				
				else if (menu == 1) {// 등록
					System.out.println("고객번호, 이름, 나이 순으로 입력하세요. ex)1001,홍길동,12");
					String inputDate = in.next(); // 1001,홍길동,56
					// System.out.println(inputDate); 1001,홍길동,56 이런씩으로 출력만해줌
					
					String[] inputArray = inputDate.split(","); // "," 기준으로 배열로들어감 a[0]

					Customer customer = new Customer(// 위에 String배열 형태로받아서 String을 int타입변경(결과값은 int여서??)
							Long.parseLong(inputArray[0]),   
							inputArray[1], 
							Integer.parseInt(inputArray[2]),// parseInt()는 문자열 String타입의 숫자를 int타입으로 변환해주는 녀석
							null
							);

					
					int result = customerDAO.insertCustomer(customer);
					if (result > 0) {
						System.out.println("고객이 등록되었습니다.");
					}
					else {
						System.out.println("고객 등록 실패했습니다.");
					}

				}

				else if (menu == 2) {// 삭제
					System.out.println("고객번호를 입력하세요. ex)1001");
					long inputDate = in.nextInt(); // 고객아이디만사용 고객아이디long타입
					Customer customer = new Customer(inputDate, null, 0, null);

					int result = customerDAO.deleteCustomer(customer);
					if (result > 0) {
						System.out.println("고객이 삭제되었습니다.");
					} 
					else {
						System.out.println("고객 삭제 실패했습니다.");
					}

				} 
				else if (menu == 3) {//수정은 등록과 같음
					System.out.println("고객번호, 이름, 나이 순으로 입력하세요. ex)1001,홍길동,12");
					String inputDate = in.next(); // 1001,홍길동,56
					// System.out.println(inputDate); 1001,홍길동,56 이런씩으로 출력만해줌
					String[] inputArray = inputDate.split(","); // "," 기준으로 배열로들어감 a[0]

					Customer customer = new Customer(// 위에 String배열 형태로받아서 String을 int타입변경(결과값은 int여서??)
							Long.parseLong(inputArray[0]),
							inputArray[1], 
							Integer.parseInt(inputArray[2]),
							null
							);

					int result = customerDAO.updateCustomer(customer);
					if (result > 0) {
						System.out.println("고객이 수정되었습니다.");
					} 
					else {
						System.out.println("고객 수정 실패했습니다.");
					}
				}
				else if(menu == 4) {//고객목록
					
					ArrayList<Customer> customerList = customerDAO.selectCustomer();
					for(Customer tmp : customerList) {
						System.out.println(tmp.getCst_id()+","+tmp.getCst_name()+","
					                        +tmp.getCst_age()+","+tmp.getCst_date());
					}
				}
				else if(menu == 11) {//물품등록
					System.out.println("물품이름,내용,금액,수량 순으로 입력하세요.");
					String inputDate = in.next();
					String[] inputArray = inputDate.split(","); 
					
					//총4개의 입력값이 다 들어갔는지 확인
					if(inputArray.length==4) {
					Item item = new Item(
							0,
							inputArray[0],
							inputArray[1],
							Long.parseLong(inputArray[2]),
							Integer.parseInt(inputArray[3]),
							null
							);
					
					int result = itemDAO.insertItem(item);
					if(result > 0) {
						System.out.println("물품등록 되었습니다.");
					}
					else {
						System.out.println("물품등록 실패 하였습니다.");
					}
				}
			}
				else if(menu == 12) {//물품삭제
					System.out.println("물품번호를 입력하세요.");
					long inputDate = in.nextInt();
					Item item = new Item(inputDate,null,null,0,0,null);
					//Item클래스에서 물품번호만 있는 생성자를 새로 만들어
					//Item item = new Item(inputDate) 이렇게 작성해도 됨
					//또는 파라미터가 없는 생성자 사용
					//Item item = new Item();
					//item.setItm_no(inputDat) 이렇게도 가능
					
					int result = itemDAO.deletetItem(item);
					if(result > 0 ) {
						System.out.println("물품삭제 되었습니다.");
					}
					else {
						System.out.println("물품삭제 실패 하였습니다.");
					}
				}
				else if(menu == 13) {//물품수정
					System.out.println("물품번호,물품이름,내용,금액,개수 순으로 입력하세요.");
					String inputDate = in.next();
					String[] inputArray = inputDate.split(","); 
					
					if(inputArray.length == 5) {
					Item item = new Item(
							//물품번호는 시퀀스이기때문에 임의의 숫자 아무거나 적어넣은면됨
							Long.parseLong(inputArray[0]),
							inputArray[1],
							inputArray[2],
							Long.parseLong(inputArray[3]),
							Integer.parseInt(inputArray[4]),
							null
							);
					int result = itemDAO.updateItem(item);
					if(result > 0) {
						System.out.println("물품수정 되었습니다.");
					}
					else {
						System.out.println("물품수정 실패 하였습니다.");
					}
				  }
				}
				else if(menu == 14) {//물품목록(전체)
					
					List<Item> itemList = itemDAO.selectItem();
					for(Item tmp : itemList) {
						System.out.println(tmp.getItm_no()+","+tmp.getItm_name()+","+tmp.getItm_content()+","+tmp.getItm_price()
						                     +","+tmp.getItm_cnt()+","+tmp.getItm_date());
					}
				}
				else if(menu == 15) {//물품목록(검색)
					System.out.println("검색어를 작성해 주세요.");
					String inputDate = in.next();
					
					List<Item> itemList = itemDAO.selectItem(inputDate);
					for(Item tmp : itemList) {
						System.out.println(tmp.getItm_no()+","+tmp.getItm_name()+","+tmp.getItm_content()+","+tmp.getItm_price()
						                     +","+tmp.getItm_cnt()+","+tmp.getItm_date());
					
					}
				} 
				else if (menu == 16) {// 물품목록(범위)
					System.out.println("검색 범위를 설정해주세요.");
					int inputDate = in.nextInt();
					int inputDate1 = in.nextInt();
					
					List<Item> itemList = itemDAO.selectItem(inputDate, inputDate1);
					for (Item tmp : itemList) {
						System.out.println(tmp.getItm_no() + "," + tmp.getItm_name() + "," + tmp.getItm_content() + ","
								+ tmp.getItm_price() + "," + tmp.getItm_cnt() + "," + tmp.getItm_date());
						
                    //ex)1,5
					//String inputDate = in.next();
					//String[]inputArray = inputDate.split(",")
					//	List<Item>itemList = itemDAO.selectItem(Integer.parseInt(intputArray[0]), intputArray[1]));
					//	for(Item tmp :itemList) {
					//		System.out.println(tmp.getItm_no()+","+tmp.getItm_name()+","+tmp.getItm_content()+","+tmp.getItm_price()
		            //        +","+tmp.getItm_cnt()+","+tmp.getItm_date());
					//	}
					}
				}
				else if(menu == 21) {
					System.out.println("주문수량,물품번호,고객아이디 순으로 입력하세요.");
					String inputDate = in.next();
					String[] inputArray = inputDate.split(",");
					
					Order order = new Order();
					order.setOrd_cnt(Integer.parseInt(inputArray[0]));
					
					
					Item item = new Item();
					item.setItm_no(Long.parseLong(inputArray[1]));
				    order.setItm_no(item);//item으로 저장해줘야함
					
				    
					Customer customer = new Customer();
					customer.setCst_id(Long.parseLong(inputArray[2]));
					order.setCst_id(customer);
					
					int result = orderDAO.insertOrder(order);
					if(result > 0) {
						System.out.println("주문 되었습니다.");
					}
					else {
						System.out.println("주문 실패했습니다.");
					}
						
				}
				else if(menu == 22) {
					System.out.println("주문번호를 입력하세요.");
					int inputDate = in.nextInt();
					Order order = new Order();
					order.setOrd_no(inputDate);
					
					int result = orderDAO.deleteOrder(order);
					if(result >0) {
						System.out.println("주문취소 되었습니다.");
					}
					else {
						System.out.println("주문취소 실패하였습니다.");
					}
					
				}
				else if(menu == 23) {
					System.out.println("주문개수,주문번호 순으로 입력하세요.");
					String inputDate = in.next();
					String[]inputArray = inputDate.split(",");
					
					Order order = new Order();
					order.setOrd_cnt(Integer.parseInt(inputArray[0]));
					order.setOrd_no(Integer.parseInt(inputArray[1]));
					
					int reusul = orderDAO.updateOrder(order);
					if(reusul >0 ) {
						System.out.println("주문수정 되었습니다.");
					}
					else {
						System.out.println("주문수정 실패하였습니다.");
					}
				}
				else if(menu == 24) {
					System.out.println("고객아이디를 입력하세요.");
					Long inputDate = in.nextLong();
					Customer customer = new Customer();
					customer.setCst_id(inputDate);
					
					//주문번호,주문수량,주문일자,물품명,물품가격
					List<Order>orderList = orderDAO.selectOrder(customer);
					for(Order tmp : orderList) {
						System.out.println(tmp.getOrd_no());
						System.out.println(tmp.getOrd_cnt());
						System.out.println(tmp.getOrd_date());
						System.out.println(tmp.getItm_no().getItm_name());
						System.out.println(tmp.getItm_no().getItm_price());
					}
				}
				else if(menu == 25) {
					
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			in.close();
			System.out.println("정상, 오류와 상관없이 항상 실행됨");
		}

	}

}*/

/*
 * //3개가 동시에 무한반복 출력 try { //인터페이스로 받아 출력 Thread obj = new Thread( new
 * MyThread2(1) ); obj.start();
 * 
 * Thread obj2 = new Thread (new MyThread2(2)); obj2.start();
 * 
 * //상속으로 받아 출력 MyThread1 obj3 = new MyThread1(3); obj3.start(); } catch
 * (Exception e) { e.printStackTrace(); }
 */