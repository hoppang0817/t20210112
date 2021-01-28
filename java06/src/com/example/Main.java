package com.example;

import java.sql.Connection;
import java.util.List;

import com.project.DBConnection;
import com.project.Subject;
import com.project.SubjectDAOImpl;

public class Main {

	public static void main(String[] args) {
		
		try {
		//DB연결 객체
		Connection conn = DBConnection.getConnection();
		//DB연결안할시 오류 
		SubjectDAOImpl SubjectDAO = new SubjectDAOImpl(conn);
		

		//추가
		Subject s1 = new Subject("10007","SQL","A-2","홍길동","09:30",null);
	    int result = SubjectDAO.insertSubject(s1);
		//System.out.println(result);
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		//1개 조회하기
		Subject s2 = new Subject();
		s2.setSubject_code("10003");
		Subject result1 = SubjectDAO.selectSubjectOne(s2);
		
		if(result1 != null) {
			System.out.println(result1.toString());
		}else {
			System.out.println("찾는자료가 없습니다.");
		}
		
		System.out.println("-------------------------------------");
		
		//전체조회
        List<Subject>subjectList = SubjectDAO.selectSubject();
		for(Subject tmp : subjectList) {
			System.out.println(tmp.toString());
		}
		
		System.out.println("---------------------------------------");
		
		Subject s3 = new Subject();
		s3.setSubject_name("자바");
		List<Subject> list = SubjectDAO.selectSubjectList(s3);
		for(Subject tmp : list) {
			System.out.println(tmp.toString());
		}
		
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
	
		
		
		
		
	/*	Scanner in = new Scanner(System.in);
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
		*/
	
	}

}
