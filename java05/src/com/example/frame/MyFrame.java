package com.example.frame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.example.db.DBconn;
import com.example.member.Member;
import com.example.member.MemberDAO;
import com.example.shop.CustomerDAOImpl;
import com.example.shop.Item;
import com.example.shop.ItemDAOImpl;
import com.example.shop.OrderDAOImpl;
                    //부모 생성               인터페이스
public class MyFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
   
	//여기에 만든 변수는 아무 생성자/메소드에서 사용가능함
	//상수 = 수정불가
	final String[] COLUMN = {"아이디","이름","나이","전화번호"};
	
	//변수
	Connection conn = null;
	
	JMenuBar menuBar = null;
	JMenu menu1 = null;         //회원
	JMenuItem menuItem1 = null; //DB연결
	JMenuItem menuItem2 = null; //로그인
	JMenuItem menuItem3 = null; //회원가입
	JMenuItem menuItem4 = null; //종료
	JMenuItem menuItem5 = null;//회원목록
	 
	
	
	JMenu menu2 = null;          //물품
	JMenuItem menuItme11 = null; //물품등록
	JMenuItem menuItme12 = null; //물품삭제
	JMenuItem menuItme13 = null; //물품수정
	JMenuItem menuItme14 = null; //물품목록
	
	
	JPanel panel = new JPanel();
	ArrayList<String[]> memberList = null;//회원목록을 저장할 변수

	//회원가입 - 액션에 사용하기 위해 밖으로 뺐음
	JTextField userText = null;
	JTextField userText1 = null;
	JTextField userText2 = null;
	JPasswordField passwordText = null;
	JButton registerButton = null;
	
	
	 
    JTextField itemText =null;
    JTextField itemText1=null;
    JTextField itemText2=null;
    JTextField itemText3=null;
    JButton registerButton1 = null;
	
		
	
	CustomerDAOImpl customerDAO = new CustomerDAOImpl(DBconn.getConnection());
	ItemDAOImpl itemDAO = new ItemDAOImpl(DBconn.getConnection());
	OrderDAOImpl orderDAO = new OrderDAOImpl();
	
	
	// 생성자
	public MyFrame(String title) throws HeadlessException {
		//super = JFrame의 생성자public JFrame(String title){    } 호출함
		super(title);
		
	    //여기가 적합 
		//conn = DBconn.getConnection();
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
		
		
		//화면에 만들어지는 순서 *회원
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem5);
		menu1.addSeparator();  //구분선---------
		menu1.add(menuItem4);
		
	//-------------------------------------------------------
		
		menu2 = new JMenu("물품");
		menuItme11 = new JMenuItem("물품등록");
		menuItme11.addActionListener(this);

		menuItme12 = new JMenuItem("물품삭제");
		menuItme12.addActionListener(this);
		
		menuItme13 = new JMenuItem("물품수정");
		menuItme13.addActionListener(this);
		
		menuItme14 = new JMenuItem("물품목록");
		menuItme14.addActionListener(this);
		
		
		//화면에 만들어지는 순서 *물품
	    menu2.add(menuItme11);
	    menu2.add(menuItme12);
	    menu2.add(menuItme13);
	    menu2.addSeparator();
	    menu2.add(menuItme14);
	    
	    
	   
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		panel.setLayout(null);//좌표를 이용한 절대 위치 배치
		//this는 Frame
		this.setJMenuBar(menuBar);
		this.add(panel);
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
				memberList = memberDAO.selectMember();
				
				createMemberListPanel();
				
			} else {
				JOptionPane.showMessageDialog(this, "DB접속 먼저하세요", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == menuItem3) {//회원가입
			if(conn !=null) {
				createMemberJoinPanel();
			}
		else {
			JOptionPane.showMessageDialog(this, "DB접속 먼저하세요", "경고", JOptionPane.WARNING_MESSAGE);
		}
			
	}
		else if (e.getSource() == menuItem4) {// 종료
			this.setVisible(false); // 없어도 창닫김
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(1);
		}
		else if(e.getSource() == registerButton) {//회원가입 버튼을 눌렀을 경우
			String s1 = userText.getText();
			String s2 = userText1.getText();
			short s3 = Short.parseShort(userText2.getText());//나이는 int임으로 int를 String으로 변경.
			String s4 =String.valueOf(passwordText.getPassword());//char[] 배열임
			
			//member 객체를 생성후 입력한 값을 넣으시오.
			Member member = new Member(s1,s2,s3,null,null,null,s4);
			MemberDAO memberDAO = new MemberDAO(conn);
			
			int result;
			try {
				result = memberDAO.insertMember(member);
				if(result > 0) {//회원추가
					 JOptionPane.showMessageDialog(this, "회원가입 성공", "성공", JOptionPane.INFORMATION_MESSAGE);
				 userText1.setText("");
				 userText2.setText("");
				 userText.setText("");
				 passwordText.setText("");
				 }
				 else {
					 JOptionPane.showMessageDialog(this, "회원가입 실패", "실패", JOptionPane.WARNING_MESSAGE);
				 }
				
			}
			 catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == menuItme11) {//물품등록
			
			if(conn !=null) {
				createItemJoinPanel();
			}
			
		}
		else if(e.getSource() == menuItme12) {//물품삭제
			
		}
		else if(e.getSource() == menuItme13) {//물품수정
			
		}
		else if(e.getSource() == menuItme14) {//물품목록
			
			//물품목록 받기
			List<Item> itemList = itemDAO.selectItem();
			
			//패널지우기
			panel.removeAll();
			
			//라벨넣기
		    JLabel lbl = new JLabel("회원목록");
			lbl.setBounds(4, 4, 100, 30);

			// 컬럼생성 및 데이터 배열 생성
			String[] column = { "물품번호", "물품명", "물품가격", "물품수량", "등록일" };
			String[][] data = new String[itemList.size()][column.length];
			
			// List<Item> => String[][]
			for (int i = 0; i < itemList.size(); i++) {
				data[i][0] = String.valueOf(itemList.get(i).getItm_no());
				data[i][1] = itemList.get(i).getItm_name();
				data[i][2] = String.valueOf(itemList.get(i).getItm_price());
				data[i][3] = String.valueOf(itemList.get(i).getItm_cnt());
				data[i][4] = itemList.get(i).getItm_date();
			}
			// table에 데이터와 컬럼값 추가
			JTable table = new JTable(data, column);
			
			// 스크롤 패널에 table추가
			JScrollPane scroll = new JScrollPane(table);
			scroll.setBounds(4, 34, 340, 140);
            //패널에 스크롤패널,라벨추가
			panel.add(lbl);
			panel.add(scroll);
            //패널 새로그리기
			panel.revalidate();
			panel.repaint();
		}
	}
	

	private void createMemberListPanel() {
		   //앞에 생성된 화면 모두 지움
		   panel.removeAll();
		   
		   JLabel lbl = new JLabel("회원목록");
		   lbl.setBounds(4, 4, 100, 30);
		   
		   //실습 memberList의 값을 String[][] 으로 변경해서  data변수에 넣기
		   String[][]data = new String[memberList.size()][4];
		   for(int i =0;i<memberList.size();i++) {
			   data[i] = memberList.get(i);
		   }
		   
		   JTable table = new JTable(data,COLUMN);
		   JScrollPane scroll = new JScrollPane(table);
		   scroll.setBounds(4, 34, 340, 140);
		   
		   
		   panel.add(scroll);
		   panel.add(lbl);
		   
		   panel.revalidate();
		   panel.repaint();
		   }
		
		private void createMemberJoinPanel() {
			   //앞에 생성된 화면 모두 지움
			   panel.removeAll();	
			   
			   JLabel lbl = new JLabel("회원가입");
			   lbl.setBounds(4, 4, 100, 30);
			   
			   JLabel userLabel = new JLabel("아이디");
			   userLabel.setBounds(10, 50, 80, 25);
			   
			   userText = new JTextField(20);
			   userText.setBounds(100, 50, 160, 25);
			   
			   JLabel passwordLabel = new JLabel("암호");
			   passwordLabel.setBounds(10, 80, 80, 25);
			   
			   passwordText = new JPasswordField(20);
			   passwordText.setBounds(100, 80, 160, 25);
			   
			   JLabel userLabel1 = new JLabel("이름");
			   userLabel1.setBounds(10, 110, 80, 25);
			   
			   userText1 = new JTextField(20);
			   userText1.setBounds(100, 110, 160, 25);
			   
			   JLabel userLabel2 = new JLabel("나이");
			   userLabel2.setBounds(10, 140, 80, 25);
			   
			   userText2 = new JTextField(20);
			   userText2.setBounds(100, 140, 160, 25);
			   
			   registerButton = new JButton("회원가입");
			   registerButton.setBounds(10, 180, 100, 30);
			   //버튼효과를 여기로  
			   registerButton.addActionListener(this);
			   
			   
			  
			   panel.add(lbl);
			   panel.add(userLabel);
			   panel.add(userText);
			   panel.add(passwordLabel);
			   panel.add(passwordText);
			   panel.add(userLabel1);
			   panel.add(userText1);
			   panel.add(userLabel2);
			   panel.add(userText2);
			   panel.add(registerButton);
			   
			   panel.revalidate();
			   panel.repaint();
			}
		
		private void createItemJoinPanel() {
			panel.removeAll();	
			   
			   JLabel lbl = new JLabel("물품등록");
			   lbl.setBounds(4, 4, 100, 30);
			   
			   JLabel itemLabel = new JLabel("물품이름");
			   itemLabel.setBounds(10, 50, 80, 25);
			   
			   itemText = new JTextField(20);
			   itemText.setBounds(100, 50, 160, 25);
			   
			   JLabel itemLabel3 = new JLabel("물품내용");
			   itemLabel3.setBounds(10, 80, 80, 25);
			   
			   itemText1 = new JPasswordField(20);
			   itemText1.setBounds(100, 80, 160, 25);
			   
			   JLabel  itemLabel1 = new JLabel("물품금액");
			   itemLabel1.setBounds(10, 110, 80, 25);
			   
			   itemText2 = new JTextField(20);
			   itemText2.setBounds(100, 110, 160, 25);
			   
			   JLabel  itemLabel2 = new JLabel("물품수량");
			   itemLabel2.setBounds(10, 140, 80, 25);
			   
			   itemText3 = new JTextField(20);
			   itemText3.setBounds(100, 140, 160, 25);
			   
			   registerButton1 = new JButton("등록");
			   registerButton1.setBounds(10, 180, 100, 30);
			   //버튼효과를 여기로  
			   registerButton1.addActionListener(this);
			   
			   panel.add(lbl);
			   panel.add( itemLabel);
			   panel.add( itemText);
			   panel.add( itemLabel1);
			   panel.add( itemText1);
			   panel.add( itemLabel2);
			   panel.add( itemText2);
			   panel.add( itemLabel3);
			   panel.add( itemText3);
			   panel.add( registerButton1);
			   
			   
			   panel.revalidate();
			   panel.repaint();
		}
	
}
