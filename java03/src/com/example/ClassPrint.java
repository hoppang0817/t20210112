// 실습 : 학생3을 추가 이름과 학번 임의로 ... 과목은 임의 4개를 추가해서 출력하기

package com.example;

import java.util.ArrayList;
import com.example.vo.Subject;

public class ClassPrint {

	private ClassList classA = null;
	
	public ClassPrint(ClassList classA) {
		this.classA = classA;
	}
	
	public void printClass(){
		System.out.println("====================================");
		System.out.println("강의실 이름 : " + classA.getName());
		System.out.println("수용인원 : " + classA.getCnt());
		
		//학생목록을 반복해서 학생객체를  tmp에 보관
		for(StudentList tmp : classA.getStudentList()) {
			System.out.println("---------------------------");
			System.out.println("학번 : " + tmp.getStudentID() );
			System.out.println("학생이름 : " + tmp.getStudentName() );

			//교과목 리스트 출력하기	
			ArrayList<Subject> subjectList = tmp.getSubjectList();
			for(Subject tmp1 : subjectList) {
				System.out.println("교과목명 : " + tmp1.getName());
				System.out.println("교과목점수 : " + tmp1.getScorePoint());
			}
			System.out.println("---------------------------");			
		}
		System.out.println("====================================");
	}
	
	
}
	

