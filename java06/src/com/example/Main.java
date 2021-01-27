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
			System.out.println("1.�������");
			System.out.println("2.å���");
			System.out.println("3.�������");
			System.out.println("4.å���");
			System.out.println("0.����");
			int menu = in.nextInt();
			if(menu == 0) {
				break;
			}
			if(menu == 1) {
				System.out.println("������,����ó�� �Է��ϼ���.");
				String name =in.next();
				String phone = in.next();
				BookStore bookStore1 = new BookStore(name,phone);
				map.put(bookStore1.getPhone(), bookStore1);
			}
			if(menu == 2) {
				System.out.println("��������ó,����,����,���ڸ� �Է��ϼ���.");
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
				System.out.println("��������ó(������ �⺻Ű)�� �Է��ϼ���");
				String tel = in.next();
				BookStore tmp1 = map.get(tel);
				tmp1.printBooks();
				
			
			}
		}
		
		Student a = new Student("ȫ�浿",12,"�İ�");
	    a.show();
	    Person b =new Student("ȫ�浿",12,"�İ�");
	    b.show();
		
	
	}

}
