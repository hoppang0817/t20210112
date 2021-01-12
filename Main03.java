package com.example;

import java.util.Scanner;

import com.example.db.DBconn;
import com.example.vo.CustomerVO;

public class Main03 {

	public static void main(String[] args) {
		try {
			
			DBconn db = new DBconn(); // CTAL + shitf + o
			
			// 키보드로 부터 값을 읽음 //ctrl+shift+o
			Scanner scanner = new Scanner(System.in);
			int menu = 0;
			
			// 무한반복
			while (true) {

				System.out.print("1. INSERT, 2. UPDATE, 3. DELETE, 4. SELECT,0. EXIT??");
				menu = scanner.nextInt();
				if (menu == 0) {
					System.out.println("종료되었습니다.");
					break;
				} else if (menu == 1) {
					
					//고객id를 키보드 스캐너로 받아 추가
					System.out.print("고객아이디,이름,나이를 입력하세요.");
					String id = scanner.next();
					String name = scanner.next();
					int age = scanner.nextInt();
					CustomerVO obj = new CustomerVO(  id , name, age, null);
					
					int result = db.inserCustomer(obj);
					
					if (result > 0) {
						System.out.println("고객등록 성공");
					} else {
						System.out.println("고객등록 실패");
					}
				}
				else if(menu == 2) {
					System.out.println("변경할 고객아이디,이름,나이순으로 입력하세요");
					String id = scanner.next();
					String name = scanner.next();
					int age = scanner.nextInt();
					db.updateCustomer(new CustomerVO(id, name, age, null));
				}
				else if(menu == 3) {
					System.out.println("삭제할 고객아이디를 입력하세요");
					String id = scanner.next();
					db.deleteCustomer(new CustomerVO(id ,null,0,null));
				}
				else if(menu == 4) {
					CustomerVO[] arr = db.selectCustomer();	
					System.out.println("배열의 개수 : " + arr.length);
				}

			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		
		
		
		/*
		 * int[]a = {3,4,6,7,23}; //메소드 사용종류
		 * 
		 * //한개로 정해지지않고 여러개가 필요할때 Util obj = new Util(); obj.sum(a);
		 * 
		 * //static(정적) 메소드를 호출하는 방법 //한가지 정해진 기능을 static으로 묶어놓고 필요할때 클래스명만 이용하여 사용
		 * Util.sum(a);
		 * 
		 * //문자를 숫자로 변경 int b = Integer.parseInt("13"); //숫자를 문자로 변경 String c =
		 * String.valueOf(13);
		 */

		
		/*
		 * 
		 * 실습 : student 클래스 생성 변수 : 학번(문자),이름(문자), 국어점수, 수학점수,영어점수 (int) 생성자 getter/
		 * setter public float avg(){ if(a==0 || a==1) 메소드 평균구하기, 국어, 영어, 수학점수중 한개라도 없으면
		 * 오류발생 Main에서 2명의 학생을 등록하고, 평균을 포함하여 출력
		 * 
		 * //첫번째 학생 Student a1 = new Student("1001","홍길동"); a1.setScore_kor(56);
		 * a1.setScore_eng(80); a1.setScore_math(-1);
		 * 
		 * try { System.out.println(a1.avg()); } catch (Exception e) {
		 * System.out.println(e.getMessage()); e.printStackTrace(); } //두번째 학생 Student
		 * a2 = new Student("b","김연아",0,78,85);
		 * 
		 * try { System.out.println(a2.avg()); } catch (Exception e) {
		 * System.out.println(e.getMessage()); e.printStackTrace(); }
		 * 
		 */

		
		/*
		 * //BookStore클래스에서 오류예외처리 BookStore bs = new BookStore("서점이름","051-000-1234");
		 * 
		 * try { bs.printBooks(); } catch (Exception e) {
		 * System.out.println(e.getMessage()); e.printStackTrace(); }
		 * 
		 */

		
		/*
		 * //Book 클래스에서 오류예외 //첫번째경우 Book b1 = new Book(); b1.setTitle("오라클");
		 * b1.setPrice(23000); b1.setAuthor("홍길동"); b1.setDiscountRate(-0.2f);//오류
		 * //할인적용 후 판매가격 System.out.println(b1.sellingPrice());
		 * 
		 * //두번째경우 //오류발생시 Main에서 직접처리 try { System.out.println(b1.sellingPrice1()); }
		 * catch (Exception e) { System.out.println(e.getMessage());
		 * e.printStackTrace(); }
		 */

		
		/*
		 * // 첫번째 책 Book b1 = new Book(); b1.setTitle("오라클"); b1.setPrice(23000);
		 * b1.setAuthor("홍길동"); b1.setDiscountRate(0.2f); // 두번째 책 Book b2 = new
		 * Book("자바", 10000, "가나다", 0.1f, null);
		 * 
		 * // 서점 생성 BookStore bs = new BookStore("서점이름", "051-000-1234");
		 * 
		 * // 책 등록 bs.registerBook(b1); bs.registerBook(b2);
		 * 
		 * // 등록된 책 출력 try { bs.printBooks(); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

}
