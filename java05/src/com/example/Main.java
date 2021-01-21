package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.db.DBconn;
import com.example.frame.MyFrame;
import com.example.shop.Customer;
import com.example.shop.CustomerDAOImpl;
import com.example.shop.Item;
import com.example.shop.ItemDAOImpl;
import com.example.shop.Order;
import com.example.shop.OrderDAOImpl;

public class Main {

	public static void main(String[] args) {
		// System.out.println("hello world");
		 new MyFrame("제목");
		
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