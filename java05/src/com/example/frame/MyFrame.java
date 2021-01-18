package com.example.frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.example.db.DBconn;
import com.example.member.MemberDAO;
                    //부모 생성               인터페이스
public class MyFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
    //여기에 만든 변수는 아무 생성자/메소드에서 사용가능함
	
	Connection conn = null;
	
	JMenuBar menuBar = null;
	JMenu menu1 = null;
	JMenuItem menuItem1 = null;
	JMenuItem menuItem2 = null;
	JMenuItem menuItem3 = null;
	JMenuItem menuItem4 = null;
	JMenuItem menuItem5 = null;//회원목록
	
	public MyFrame(String title) throws HeadlessException {
		//super = JFrame의 생성자public JFrame(String title){    } 호출함
		super(title);
		
		createMenu();
		
		this.setSize(500, 600);  //크기설정
		this.setVisible(true);   //화면 표시
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫기를 누르면 java 실행종료
		
	}
	private void createMenu() {
		menuBar = new JMenuBar();
		menu1 = new JMenu("회원");
		
		
		
		menuItem5 = new JMenuItem("회원목록");
		menuItem5.addActionListener(this);
		
		menuItem1 = new JMenuItem("DB연결");
		menuItem1.addActionListener(this);
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		
		menuItem2 = new JMenuItem("로그인");
		menuItem2.addActionListener(this);
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));
		
		menuItem3 = new JMenuItem("회원가입");
		menuItem3.addActionListener(this);
		
		
		menuItem4 = new JMenuItem("종료");
		//단축키 설정하기 CTRL + X
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		menuItem4.addActionListener(this);
		
		//화면에 만들어지는 순서
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem5);
		menu1.addSeparator();  //구분선---------
		menu1.add(menuItem4);
		
		
		menuBar.add(menu1);
		this.setJMenuBar(menuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//메뉴가 클릭되었을때 수행해야할 소스코드 작성 ...
		//System.out.println(e.getSource());
	
		//다른클래스를 호출하는 부분...
		//모든 사용자의 이벤트를 처리하는 부분
		
		if (e.getSource() == menuItem1) { // DB연결
			// DB는 한번만 연결
			conn = DBconn.getConnection();
			if (conn != null) {
				JOptionPane.showMessageDialog(this, "DB접속성공", "성공", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "DB접속실패", "실패", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == menuItem5) {// 회원 목록
			if (conn != null) {
				MemberDAO memberDAO = new MemberDAO(conn);

				ArrayList<String[]> list = memberDAO.selectMember();
				for (String[] member : list) {
					System.out.println(member[0] + "," + member[1] + "," + member[2] + "," + member[3] + "," + member[4]
							+ "," + member[5] + "," + member[6]);

				}
			} else {
				JOptionPane.showMessageDialog(this, "DB접속 먼저하세요", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}

		else if (e.getSource() == menuItem4) {// 종료
			this.setVisible(false); //없어도 창닫김
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(1);
		}
	}
}
