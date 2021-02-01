package com.project;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainPanel2 extends JPanel{
	private StudentDAOImpl studentDAO = null;
	private JFrame frame = null;
	
	
	public MainPanel2(JFrame frame) {
		super();
		this.frame= frame;
		this.studentDAO =new StudentDAOImpl(DBConnection.getConnection());
		this.setLayout(new BorderLayout());
		addComponnent();
	}
		public void addComponnent() {
		try {
		

		
		JLabel lblNorth = new JLabel("학생관리");
		this.add(lblNorth, BorderLayout.NORTH);


		
		String[] column = {"학번","이름","학년","연락처","전공"};
		List<Student> list = studentDAO.selectStudentList();
		String[][] data= new String[list.size()][column.length];
		for(int i =0; i<list.size();i++) {
			Student obj = list.get(i);
			data[i][0] = obj.getStudent_id();
			data[i][1] = obj.getStudent_name();
			data[i][2] = String.valueOf(obj.getstudent_grade());
			data[i][3] = obj.getstudent_phone();
			data[i][4] = obj.getstudent_major();
		
		}
		JTable table = new JTable(data,column) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
	
			}
		};

		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll, BorderLayout.CENTER);
		
				
	
				
				

		JLabel lblSouth = new JLabel("아래쪽-SOUTH");
		this.add(lblSouth, BorderLayout.SOUTH);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
