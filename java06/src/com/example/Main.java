package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.vo.BookStore;
import com.example.vo.Person;
import com.example.vo.Student;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, BookStore>map = new HashMap<String,BookStore>();
		
		while(true) {
			System.out.println("1.서점등록");
			System.out.println("2.책등록");
			System.out.println("3.서점목록");
			System.out.println("4.책목록");
			System.out.println("0.종료");
			int menu = in.nextInt();
			if(menu == 0) {
				break;
			}
			if(menu == 1) {
				System.out.println("서점명,연락처를 입력하세요.");
				String name =in.next();
				String phone = in.next();
				BookStore bookStore1 = new BookStore(name,phone);
				map.put(bookStore1.getPhone(), bookStore1);
			}
			if(menu == 2) {
				System.out.println("서점연락처,제목,가격,저자를 입력하세요.");
				String tel = in.next();
				String title = in.next();
				int price = in.nextInt();
				String writer = in.next();
				
				BookStore obj = map.get(tel);
				obj.addBook(title, price, writer);
			}
			if(menu == 3) {
				for(String key : map.keySet()) {
					BookStore tmp1 = map.get(key);
					System.out.println(tmp1.getName()+tmp1.getPhone()+tmp1.sumPrice());
					
				}
			}
			if(menu == 4) {
				System.out.println("서점연락처(서점의 기본키)을 입력하세요");
				String tel = in.next();
				BookStore tmp1 = map.get(tel);
				tmp1.printBooks();
				
			
			}
		}
		
		Student a = new Student("홍길동",12,"컴공");
	    a.show();
	    Person b =new Student("홍길동",12,"컴공");
	    b.show();
		
	
	}

}
