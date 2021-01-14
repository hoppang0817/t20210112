package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.frame.MyFrame;

public class Main04 {

	public static void main(String[] args) {
		new MyFrame();
	
		
		
		/*상속
		MyFrame frame = new MyFrame();
		frame.setTitle("제목");
		
		//패널 생성
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//라벨 생성
		JLabel userLabel = new JLabel("아이디");
		userLabel.setBounds(10,10,80,25);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("암호");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("로그인");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);

		JButton registerButton = new JButton("회원가입");
		registerButton.setBounds(100, 80, 80, 25);
		panel.add(registerButton);
		
		panel.add(userLabel);
		frame.add(panel);
		
		frame.setSize(400, 500);
		frame.setVisible(true);
		*/
		
		/*ArrayList
		//학생 생성 학번이 1001이고 이름이Lee
		//학생1
		//생성자2사용
		StudentList studentLee = new StudentList(1001,"Lee");
		
		
		//이름을 변경 : 생성자 사용이아니라 setter이용해야함.
		studentLee.setStudentName("Lee1");
		
		
		//위에 생성한 학생 객체를 이용하여 학생이 수강하는 과목 등록
		studentLee.addSubject("오라클", 80);
		studentLee.addSubject("자바", 80);
		studentLee.addSubject("스프링", 87);
		
		
//		//등록한 학생의 정보를 출력
//		sudentLee.showStudentInfo();
//		
		//----------------------------------------------------
	    
		//학생2
		//생성자1사용
		StudentList studentKim = new StudentList();
	    studentKim.setStudentID(1002);
	    studentKim.setStudentName("Kim");
	    
	    //과목등록
	    studentKim.addSubject("oracle", 89);
	    studentKim.addSubject("java", 96);
	    
//	    //학생정보출력
//	    studentKim.showStudentInfo();

	  //실습 : 학생3을 추가 이름과 학변 임의로.....과목은 임의 4개를 추가해서출력
	    //학생3추가
	    StudentList studentYun = new StudentList(1003,"Yun");
	    studentYun.addSubject("kor", 80);
	    studentYun.addSubject("eng", 56);
	    studentYun.addSubject("math", 90);
	    studentYun.addSubject("com", 75);
	    
	    //강의실 생성
	    ClassList classA = new ClassList("508호",25);
		
	    //강의실에 학생추가
	    classA.addStudent(studentLee);
	    classA.addStudent(studentKim);
	    classA.addStudent(studentYun);
	    
	    
	    //강의실 정보출력
	    ClassPrint obj = new ClassPrint(classA);
		obj.printClass();
		*/
	}

}
