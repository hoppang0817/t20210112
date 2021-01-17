package com.example.frame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MyMenu() {
		this.setTitle("메뉴");
		createMenu();
		this.setSize(550, 720);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createMenu() {
		//메뉴구성......
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu1 = new JMenu("메뉴1");
		//메뉴1에 하위메뉴 추가
		JMenuItem menuItem1 = new JMenuItem("파일");
		
		//이미지 읽기
		ImageIcon icon = new ImageIcon("images/a.jpg");
		
		//크기변경을 위해서 ImageIcon을 Image로 변경
		Image img = icon.getImage();
		
		//실베 크기 변경
		img = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		//Image를 ImageIcon으로 다시 변경
		icon = new ImageIcon(img);
		
		//변경된 이미지 아이콘으로 적용하기
		menuItem1.setIcon(icon);
		
		JMenuItem menuItem2 = new JMenuItem("저장");
		JMenuItem menuItem3 = new JMenuItem("불러오기");
		
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		
		JMenu menu2 = new JMenu("메뉴2");
		
		
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		this.setJMenuBar(menuBar);
	}
	

}
