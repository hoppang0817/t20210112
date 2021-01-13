package com.example.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

//상속은 상속을 받아서 추가하거나 삭제 하는듯 변형을 하기위해 상속받음

//public MyFrame(String title) throws HeadlessException {
//	super(title); //부모의  생성자를 호출해줌
//}
//
//@Override
//public void setTitle(String title) {
//	//부모의 메소드중에 setTitle호출
//	super.setTitle(title+"abc");
//}

public class MyFrame extends JFrame {
	private JPasswordField passwordField;
	private JTextField textField;
	public MyFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(24, 27, 50, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("암호");
		lblNewLabel_1.setBounds(24, 63, 50, 15);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 60, 96, 18);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBounds(35, 105, 91, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(154, 105, 91, 23);
		getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(98, 24, 96, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		this.setTitle("제목");
		this.setSize(400, 500);
		this.setVisible(true);
	}
}
