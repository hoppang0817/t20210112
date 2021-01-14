package com.example.frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.example.Customer;
import com.example.StoreList;
import com.example.StoreMap;

public class MyFrame1 extends JFrame implements ActionListener {
	// JButton 제작시에 이벤트 처리를 위한 인터페이스를 사용해서 구현해놨음
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand() + " 이 클릭되었음");
	}

	public MyFrame1(String title,StoreMap store) throws HeadlessException {
		// 부모 클래스의 생성자 호출
		super(title);

		// 패널생성
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// 버튼생성
		JButton button = new JButton("버튼");
		button.setBounds(50, 4, 80, 20);
		button.addActionListener(this);

		JButton button1 = new JButton("버튼1");
		button1.setBounds(150, 4, 80, 20);
		button1.addActionListener(this);// <- 인터페이스 사용 위치를 여기로라고 표시

		JButton button2 = new JButton("확인");
		button2.setBounds(250, 4, 80, 20);
		button2.addActionListener(this);

		JLabel lbl1 = new JLabel("상점명:  " + store.getName());
		lbl1.setBounds(10, 34, 130, 20);
		JLabel lbl2 = new JLabel("연락처: " + store.getPhone());
		lbl2.setBounds(10, 54, 130, 20);

		HashMap<Integer, Customer> customerMap = store.getCustomerMap();
		String[][]data = new String[customerMap.size()][4];
		int i =0;
		for (int key : customerMap.keySet()) {
			Customer tmp = customerMap.get(key);
			data[i][0] = String.valueOf(tmp.getCustomerID());
			data[i][1] = tmp.getCustomerName();
			data[i][2] = tmp.getCustomerGrade();
			data[i][3] = String.valueOf(tmp.getBonusPoint());
			i++;

		
		
		String[] column = { "고객번호", "고객이름", "고객등급", "포인트" };
//		String[][] data = { { "1001", "홍길동", "SILVER", "0" }, { "1002", "홍길동", "SILVER", "1000" },
//				{ "1005", "홍길동", "SILVER", "1500" } };

		// 실제데이터, 컬럼명
		JTable table = new JTable(data,column);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(300, 160);
		scroll.setBounds(30, 84, 340, 320);

		// 버튼을 패널에추가
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(scroll);
		panel.add(lbl1);
		panel.add(lbl2);

		// 패널을 프레임에추가
		this.add(panel);

		// jframe 뜻함->
		// 크기설정
		this.setSize(430, 400);

		// 표시하기
		this.setVisible(true);

		// 닫기를 눌렀을때 프로그램 종류
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	}
}