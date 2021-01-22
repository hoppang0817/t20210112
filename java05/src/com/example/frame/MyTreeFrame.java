package com.example.frame;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.example.db.DBconn;
import com.example.shop.Customer;
import com.example.shop.CustomerDAOImpl;
import com.example.shop.Item;
import com.example.shop.ItemDAOImpl;
import com.example.shop.Order;
import com.example.shop.OrderDAOImpl;

public class MyTreeFrame extends JFrame{
	
	JPanel panel = new JPanel();

	public MyTreeFrame(String title) throws HeadlessException {
		super(title);
		
		panel.setLayout(new BorderLayout());
		
		//메뉴바
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("메뉴1");
		
		JMenuItem item1 = new JMenuItem("목록");
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//목록메뉴가 클릭될때 수행할 소스구현
				System.out.println("목록클릭됨");
				
			}
			
		});
		menu1.add(item1);
		
		JMenu menu2 = new JMenu("메뉴2");
		JMenu menu3 = new JMenu("메뉴3");
		
		
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		//여기서 this는 JFrame을 말함
		this.setJMenuBar(menuBar);

		
		
		//왼쪽 : tree 생성
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		
		
		DefaultMutableTreeNode aaa = new DefaultMutableTreeNode("목록s");
		    DefaultMutableTreeNode aaa1 = new DefaultMutableTreeNode("고객목록");
		    DefaultMutableTreeNode aaa2 = new DefaultMutableTreeNode("물품목록");
		    DefaultMutableTreeNode aaa3 = new DefaultMutableTreeNode("주문목록");
		aaa.add(aaa1);
		aaa.add(aaa2);
		aaa.add(aaa3);
		
		
		
		DefaultMutableTreeNode bbb = new DefaultMutableTreeNode("폴더2");
		     DefaultMutableTreeNode bbb1 = new DefaultMutableTreeNode("폴더2_1");
		     DefaultMutableTreeNode bbb2 = new DefaultMutableTreeNode("폴더2_2");
		bbb.add(bbb1);
		bbb.add(bbb2);
		
		
		root.add(aaa);
		root.add(bbb);
		
		
		JTree tree = new JTree(root);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			//tree가 클릭될때 수행
			@Override
			public void valueChanged(TreeSelectionEvent e) {
		  try {               //위치정보알려줌
				String str = e.getPath().getLastPathComponent().toString();
				System.out.println(str);
				
				//DB에있는 목록들 정보를 가져옴
				
				String[] column = null;
				String[][]data = null;
				
				
				
				if(str.equals("고객목록")) {
					CustomerDAOImpl obj = new CustomerDAOImpl(DBconn.getConnection());
					List<Customer> list = obj.selectCustomer(); 
					column = new String[]{"아이디","이름","나이","등록일"};
					//ArrayList를 String[][]으로
					data = new String[list.size()][4];
					for(int i=0;i<list.size();i++) {
						data[i][0] = String.valueOf(list.get(i).getCst_id());
						data[i][1] = list.get(i).getCst_name();
						data[i][2] = String.valueOf(list.get(i).getCst_age());
						data[i][3] = list.get(i).getCst_date();
						
					}
					
				}
				else if(str.equals("물품목록")) {
					ItemDAOImpl obj = new ItemDAOImpl(DBconn.getConnection());
					List<Item> list = obj.selectItem();
					column = new String[] {"물품번호", "물품명", "물품가격", "물품수량", "등록일"};
					
					data = new String[list.size()][5];
					for(int i =0;i<list.size();i++) {
						Item tmp = list.get(i);
						data[i][0] = String.valueOf(tmp.getItm_no());
						data[i][1] = tmp.getItm_name();
						data[i][2] = String.valueOf(tmp.getItm_price());
						data[i][3] = String.valueOf(tmp.getItm_cnt());
						data[i][4] = tmp.getItm_date();
					}
					
				}
				else if(str.equals("주문목록")) {
					OrderDAOImpl obj = new OrderDAOImpl();
					Customer customer = new Customer();
					customer.setCst_id(10);
					List<Order>list = obj.selectOrder(customer);
					
					column = new String[] {"주문번호","주문수량","주문일자","물품명","물품가격"};
					data = new String[list.size()][5];
					for(int i =0;i<list.size();i++) {
					Order tmp = list.get(i);
					data[i][0] = String.valueOf(tmp.getOrd_no());
					data[i][1] = String.valueOf(tmp.getOrd_cnt());
					data[i][2] = tmp.getOrd_date();
					data[i][3] = tmp.getItm_no().getItm_name();
					data[i][4] = String.valueOf(tmp.getItm_no().getItm_price());
					}
					
				}
				print(column,data);
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		  
		    
			}
		});
		
		
		                                            //위치설정
		this.getContentPane().add(tree, BorderLayout.WEST);
		
		
		JLabel lbl2 = new JLabel("SOUTH");
		JLabel lbl3 = new JLabel("NORTH");
		JLabel lbl4 = new JLabel("EAST");
		
		
	                     
		this.getContentPane().add(lbl2, BorderLayout.SOUTH);
		this.getContentPane().add(lbl3, BorderLayout.NORTH);
		this.getContentPane().add(lbl4, BorderLayout.EAST);
		
		
		
		
		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void print(String[] column, String[][] data) {
		JTable table = new JTable(data, column);
		JScrollPane scroll = new JScrollPane(table);
		
		panel.removeAll();
		panel.add(scroll);
		panel.revalidate();
		panel.repaint();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();

	}
	

}
