package com.project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainPanel3 extends JPanel implements ActionListener{
	private CourseDAOImpl courseDAO = null;
	private JTable table = null;
	private JFrame frame = null;
	private final String[] column = {"수강번호","점수","등록일","학생 번호","학생이름","학년","과목코드","과목이름","강의실","교수"};
	private JButton button =null;
	private JButton button1 =null;
	private JButton button2 =null;
	
	
	public MainPanel3() {
		super();
		this.frame = frame;
		this.courseDAO = new CourseDAOImpl();
		this.setLayout(new BorderLayout());
		addComponent();
	}
	
	public void addComponent() {
		try {
			//위쪽
			JLabel lblWest = new JLabel("수강관리");
			this.add(lblWest, BorderLayout.NORTH);
			
			//중앙
			createTable();
			
			//아래
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());
			button = new JButton("등록");
			button.addActionListener(this);
			button1 = new JButton("삭제");
			button1.addActionListener(this);
			button2 = new JButton("수정");
			button2.addActionListener(this);
			
			panel.add(button);
			panel.add(button1);
			panel.add(button2);
			
			this.add(panel, BorderLayout.SOUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		
	}
	
	
	//중앙에 생길 테이블
	private void createTable() {
		try {
			
			table = new JTable(){
				private static final long serialVersionUID = 1L;
				
				//테이블을 직접 수정할수없게 막아두는 부분
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
			
			List<Course> list = courseDAO.selectCourseListe();
			String[][] data = new String[list.size()][column.length];
			for(int i=0; i<list.size(); i++) {
				Course obj = list.get(i);
				data[i][0] = String.valueOf(obj.getCode());
				data[i][1] = String.valueOf(obj.getScore());
				data[i][2] = obj.getRegdate();
				data[i][3] = obj.getStudent_id().getStudent_id();
				data[i][4] = obj.getStudent_id().getStudent_name();
				data[i][5] = String.valueOf(obj.getStudent_id().getstudent_grade());
				data[i][6] = obj.getSubject_code().getSubject_code();
				data[i][7] = obj.getSubject_code().getSubject_name();
				data[i][8] = obj.getSubject_code().getSubject_class();
				data[i][9] = obj.getSubject_code().getsubject_professor();
			}
			DefaultTableModel model = new DefaultTableModel(data,column);
			table.setModel(model);
			
			JScrollPane scroll = new JScrollPane(table);
			this.add(scroll,BorderLayout.CENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void udateTable() throws Exception{
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(model.getRowCount() >0) {
			for(int i= model.getRowCount()-1;i>=0;i--) {
				model.removeRow(i);
			}
		}
		List<Course> list = courseDAO.selectCourseListe();
		String[] data = new String[column.length];
		for(int i =0; i<list.size();i++) {
			Course obj = list.get(i);
			data[0] = String.valueOf(obj.getCode());
			data[1] = String.valueOf(obj.getScore());
			data[2] = obj.getRegdate();
			data[3] = obj.getStudent_id().getStudent_id();
			data[4] = obj.getStudent_id().getStudent_name();
			data[5] = String.valueOf(obj.getStudent_id().getstudent_grade());
			data[6] = obj.getSubject_code().getSubject_code();
			data[7] = obj.getSubject_code().getSubject_name();
			data[8] = obj.getSubject_code().getSubject_class();
			data[9] = obj.getSubject_code().getsubject_professor();
			model.addRow(data);
			table.setModel(model);
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			createButton();
		} else if(e.getSource() ==button1) {
			createButton1();
		}else if(e.getSource() == button2) {
			createButton2();
		}
	}

	private void createButton() {
		JDialog dialog = new JDialog(frame,"다이럴로그",Dialog.ModalityType.DOCUMENT_MODAL);
		dialog.setBounds(1, 10, 300, 300);
		Container container = dialog.getContentPane();
		container.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lable = new JLabel("점수");
		lable.setBounds(10, 10, 100, 20);
		JTextField field = new JTextField();
		field.setBounds(100, 10, 100, 20);

		
		JLabel lable1 = new JLabel("과목코드");
		lable1.setBounds(10, 40, 100, 20);
		JTextField field1 = new JTextField();
		field1.setBounds(100, 40, 100, 20);
	
		
		JLabel lable2 = new JLabel("학번");
		lable2.setBounds(10, 70, 100, 20);
		JTextField field2 = new JTextField();
		field2.setBounds(100, 70, 100, 20);
		
		JButton btnInsert = new JButton("등록");
		btnInsert.setBounds(20, 190, 80, 20);
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int score = Integer.valueOf(field.getText());
				String code = field1.getText();
				String id = field2.getText();
				
				Course c1 = new Course();
				Subject s1 = new Subject();
				Student st1 = new Student();
				s1.setSubject_code(code);
				st1.setStudent_id(id);
				
				c1.setScore(score);
				c1.setSubject_code(s1);
				c1.setStudent_id(st1);
				
				try {
					int result = courseDAO.insertCourse(c1);
					if(result >0) {
						udateTable();
						JOptionPane.showMessageDialog(null, "등록완료", "메세지", JOptionPane.INFORMATION_MESSAGE);
						dialog.setVisible(false);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	
		JButton btnClose = new JButton("닫기");
		btnClose.setBounds(150, 190, 80, 20);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		
		panel.add(btnInsert);
		panel.add(btnClose);
		panel.add(lable);
		panel.add(field);
		panel.add(lable1);
		panel.add(field1);
		panel.add(lable2);
		panel.add(field2);
		container.add(panel, BorderLayout.CENTER);
		dialog.setVisible(true);
	}
	
	
	public void createButton1() {
		try {
			int row = table.getSelectedRow();
			if(row >=0) {
				int ret =0;
				ret = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","삭제",JOptionPane.OK_CANCEL_OPTION,
													JOptionPane.INFORMATION_MESSAGE);
				if(ret == 0) {
					String value = table.getModel().getValueAt(row, 0).toString();
					
					Course c1 = new Course();
					c1.setCode(Integer.valueOf(value));
					
					int result = courseDAO.deleteCourse(c1);
					if(result > 0) {
						udateTable();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "선택된 항목이 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void createButton2() {
		int row = table.getSelectedRow();
		if(row >=0) {
			try {
				//학번 들고오기
				String value = table.getModel().getValueAt(row, 3).toString();
				
				//과목 코드 들고오기
				String value1 = table.getModel().getValueAt(row, 6).toString();

				Course c1 = new Course();
				Student st1 = new Student();
				Subject s1 = new Subject();
				
				st1.setStudent_id(value);
				s1.setSubject_code(value1);
				
				c1.setSubject_code(s1);
				c1.setStudent_id(st1);
				
				Course course= courseDAO.selectCourseOne(c1);
				
				JDialog dialog = new JDialog(frame,"수정",Dialog.ModalityType.DOCUMENT_MODAL);
				
				dialog.setBounds(1, 10, 300, 300);
				Container container = dialog.getContentPane();
				container.setLayout(new BorderLayout());
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				
				JLabel lable = new JLabel("수강번호");
				lable.setBounds(10, 10, 100, 20);
				JTextField field = new JTextField();
				field.setBounds(100, 10, 100, 20);
				field.setText(String.valueOf(course.getCode()));
				
				JLabel lable1 = new JLabel("점수");
				lable1.setBounds(10, 40, 100, 20);
				JTextField field1 = new JTextField();
				field1.setBounds(100, 40, 100, 20);
				field1.setText(String.valueOf(course.getScore()));
				
				JLabel lable2 = new JLabel("학번");
				lable2.setBounds(10, 70, 100, 20);
				JTextField field2 = new JTextField();
				field2.setBounds(100, 70, 100, 20);
				field2.setText(course.getStudent_id().getStudent_id());
	
				JLabel lable3 = new JLabel("과목코드");
				lable3.setBounds(10, 100, 100, 20);
				JTextField field3 = new JTextField();
				field3.setBounds(100, 100, 100, 20);
				field3.setText(course.getSubject_code().getSubject_code());
				
				JButton btnupdate = new JButton("수정");
				btnupdate.setBounds(20, 130, 80, 20);
				btnupdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String code = field.getText();
						String score = field1.getText();
						String id = field2.getText();
						String s_code = field3.getText();
						
						Course c1 = new Course();
						Student st1 = new Student();
						Subject s1 = new Subject();

						st1.setStudent_id(id);
						s1.setSubject_code(s_code);
						
						c1.setCode(Integer.valueOf(code));
						c1.setScore(Integer.valueOf(score));
						c1.setStudent_id(st1);
						c1.setSubject_code(s1);
						
						try {
							int result = courseDAO.updateCourse(c1);
							
							if(result > 0) {
								udateTable();
								JOptionPane.showMessageDialog(null, "수정완료", "메세지", JOptionPane.INFORMATION_MESSAGE);
								dialog.setVisible(false);
								
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				});
				
				JButton btnclose = new JButton("닫기");
				btnclose.setBounds(120, 130, 80, 20);
				btnclose.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
					}
				});
				
				panel.add(btnupdate);
				panel.add(btnclose);
				panel.add(lable);
				panel.add(field);
				panel.add(lable1);
				panel.add(field1);
				panel.add(lable2);
				panel.add(field2);
				panel.add(lable3);
				panel.add(field3);
				
				container.add(panel,BorderLayout.CENTER);
				dialog.setVisible(true);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
