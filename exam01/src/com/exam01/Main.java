package com.exam01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Student>map = new HashMap<String,Student>();
		
		while(true) {
			System.out.println("1.학생추가");
			System.out.println("2.과목추가");
			System.out.println("3.학생평균점수");
			System.out.println("4.전체학생목록");
			System.out.println("5.종료");
			int menu = in.nextInt();
			if(menu == 5) {
			
				System.out.println("종료");
				break;
			}
			if(menu == 1 ) {
				try {
					System.out.println("학번,이름을 입력하세요.");
					String ID = in.next();
					String name = in.next();
					Student student = new Student(ID,name);
					map.put(student.getStudentID(), student);
					System.out.println("성공");
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("실패");
					
				}
				
			}
			if(menu == 2) {
				try {
					System.out.println("학번,과목코드,과목명,점수를 입력하세요");
					String ID = in.next();
					String code = in.next();
					String name = in.next();
					float score = in.nextFloat();
					
					Student obj = map.get(ID);
					obj.addSubject(code, name, score);
					System.out.println("성공");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("실패");
				}
				
			}
			if(menu == 3) {
				System.out.println("학번을 입력하세요");
				String ID = in.next();
				Student tmp = map.get(ID);
				System.out.println(tmp.getStudentID()+","+tmp.getName()+","+tmp.getAverage());
				
			}
			if(menu == 4) {
				for(String key : map.keySet()) {
					System.out.println(map.get(key).getStudentID()+map.get(key).getName()+map.get(key).getAverage());
				}
			}
		}

	}

}
