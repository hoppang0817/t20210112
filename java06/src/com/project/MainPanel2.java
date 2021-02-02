package com.project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.mybatis.MyBatisStudentDAOImpl;

public class MainPanel2 extends JPanel implements ActionListener {
	private MyBatisStudentDAOImpl studentDAO = null;
	private JTable table = null;
	private JFrame frame = null;
	private final String[] column = { "학번", "이름", "학년", "연락처", "전공", "등록일" };
	private JButton button = null;
	private JButton button1 = null;
	private JButton button2 = null;

	public MainPanel2(JFrame frame) {
		super();
		this.frame = frame;
		this.studentDAO = new MyBatisStudentDAOImpl();
		this.setLayout(new BorderLayout());
		addComponnent();
	}

	public void addComponnent() {
		try {
			// 위
			JLabel lblNorth = new JLabel("학생관리");
			this.add(lblNorth, BorderLayout.NORTH);

			// 중앙
			createTable();

			// 아래
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

	private void createTable() {
		try {

			table = new JTable() {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
			List<Student> list = studentDAO.selectStudentList();
			String[][] data = new String[list.size()][column.length];
			for (int i = 0; i < list.size(); i++) {
				Student obj = list.get(i);
				data[i][0] = obj.getStudent_id();
				data[i][1] = obj.getStudent_name();
				data[i][2] = String.valueOf(obj.getstudent_grade());
				data[i][3] = obj.getstudent_phone();
				data[i][4] = obj.getstudent_major();
				data[i][5] = obj.getstudent_date();

			}
			DefaultTableModel model = new DefaultTableModel(data, column);
			table.setModel(model);

			JScrollPane scroll = new JScrollPane(table);
			this.add(scroll, BorderLayout.CENTER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTable() throws Exception {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (model.getRowCount() > 0) { // 데이터가 있다면 기존데이터 다 지우기
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
		}
		List<Student> list = studentDAO.selectStudentList();
		String[] data = new String[column.length];
		for (int i = 0; i < list.size(); i++) {
			Student obj = list.get(i);
			data[0] = obj.getStudent_id();
			data[1] = obj.getStudent_name();
			data[2] = String.valueOf(obj.getstudent_grade());
			data[3] = obj.getstudent_phone();
			data[4] = obj.getstudent_major();
			data[5] = obj.getstudent_date();
			model.addRow(data);
			table.setModel(model);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			createButton();

		} else if (e.getSource() == button1) {

		} else if (e.getSource() == button2) {
			createButton2();
		}

	}

	public void createButton() {
		JDialog dialog = new JDialog(frame, "다이럴로그", Dialog.ModalityType.DOCUMENT_MODAL);
		dialog.setBounds(1, 10, 300, 300);
		Container container = dialog.getContentPane();
		container.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel lable = new JLabel("학번");
		lable.setBounds(10, 10, 100, 20);
		JTextField field = new JTextField();
		field.setBounds(100, 10, 100, 20);

		JLabel lable1 = new JLabel("이름");
		lable1.setBounds(10, 40, 100, 20);
		JTextField field1 = new JTextField();
		field1.setBounds(100, 40, 100, 20);

		JLabel lable2 = new JLabel("학년");
		lable2.setBounds(10, 70, 100, 20);
		JTextField field2 = new JTextField();
		field2.setBounds(100, 70, 100, 20);

		JLabel lable3 = new JLabel("연락처");
		lable3.setBounds(10, 100, 100, 20);
		JTextField field3 = new JTextField();
		field3.setBounds(100, 100, 100, 20);

		JLabel lable4 = new JLabel("전공");
		lable4.setBounds(10, 130, 100, 20);
		JTextField field4 = new JTextField();
		field4.setBounds(100, 130, 100, 20);

		JButton btnInsert = new JButton("등록");
		btnInsert.setBounds(20, 190, 80, 20);
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = field.getText();
				String name = field1.getText();
				int grade = Integer.parseInt(field2.getText());
				String phone = field3.getText();
				String major = field4.getText();

				Student s1 = new Student(id, name, grade, phone, major, null);
				try {
					int result = studentDAO.insertStudent(s1);
					if (result > 0) {
						updateTable();
						dialog.setVisible(false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
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

		panel.add(btnClose);
		panel.add(btnInsert);
		panel.add(lable4);
		panel.add(field4);
		panel.add(lable3);
		panel.add(field3);
		panel.add(lable1);
		panel.add(field1);
		panel.add(lable2);
		panel.add(field2);
		panel.add(field);
		panel.add(lable);
		container.add(panel, BorderLayout.CENTER);
		dialog.setVisible(true);

	}
	
	public void createButton1() {

		int row = table.getSelectedRow();
		if (row >= 0) {

		}

	}

	

	public void createButton2() {

		int row = table.getSelectedRow();
		if (row >= 0) {
			try {
				// 학생아이디 들고오기
				String value = table.getModel().getValueAt(row, 0).toString();

				Student s1 = new Student();
				s1.setStudent_id(value);

				Student student = studentDAO.selectStudentOne(s1);

				JDialog dialog = new JDialog(frame, "수정", Dialog.ModalityType.DOCUMENT_MODAL);
				dialog.setBounds(1, 10, 300, 300);
				Container container = dialog.getContentPane();
				container.setLayout(new BorderLayout());

				JPanel panel = new JPanel();
				panel.setLayout(null);

				JLabel lable = new JLabel("학번");
				lable.setBounds(10, 10, 100, 20);
				JTextField field = new JTextField();
				field.setBounds(100, 10, 100, 20);

				JLabel lable1 = new JLabel("이름");
				lable1.setBounds(10, 40, 100, 20);
				JTextField field1 = new JTextField();
				field1.setBounds(100, 40, 100, 20);

				JLabel lable2 = new JLabel("학년");
				lable2.setBounds(10, 70, 100, 20);
				JTextField field2 = new JTextField();
				field2.setBounds(100, 70, 100, 20);

				JLabel lable3 = new JLabel("연락처");
				lable3.setBounds(10, 100, 100, 20);
				JTextField field3 = new JTextField();
				field3.setBounds(100, 100, 100, 20);

				JLabel lable4 = new JLabel("전공");
				lable4.setBounds(10, 130, 100, 20);
				JTextField field4 = new JTextField();
				field4.setBounds(100, 130, 100, 20);

				panel.add(lable4);
				panel.add(field4);
				panel.add(lable3);
				panel.add(field3);
				panel.add(lable1);
				panel.add(field1);
				panel.add(lable2);
				panel.add(field2);
				panel.add(field);
				panel.add(lable);
				container.add(panel, BorderLayout.CENTER);
				dialog.setVisible(true);

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
