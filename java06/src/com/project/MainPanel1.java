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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainPanel1 extends JPanel {

	private SubjectDAOImpl subjectDAO = null;
	private JFrame frame = null;

	public MainPanel1(JFrame frame) {
		super();

		this.frame = frame;
		subjectDAO = new SubjectDAOImpl(DBConnection.getConnection());

		this.setLayout(new BorderLayout());// BorderLayout 동서남북중앙으로 배치하는거
		addComponent();

	}
	

	public void addComponent() {
		try {

			// 윗쪽
			JLabel lblNorth = new JLabel("과목관리");
			this.add(lblNorth, BorderLayout.NORTH);

			// 중앙
			String[] column = { "교과목코드", "교과목명", "강의실", "교수", "시간", "등록일" };
			List<Subject> subjectList = subjectDAO.selectSubject();

			String[][] data = new String[subjectList.size()][column.length];
			for (int i = 0; i < subjectList.size(); i++) {
				Subject obj = subjectList.get(i);
				data[i][0] = obj.getSubject_code();
				data[i][1] = obj.getSubject_name();
				data[i][2] = obj.getSubject_class();
				data[i][3] = obj.getsubject_professor();
				data[i][4] = obj.getsubject_time();
				data[i][5] = obj.getsubject_date();
			}

			// 객체를 생성할때 특정 메소드를 오브라이드 해서 기능을 제거함.
			JTable table = new JTable() {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
		
				}
			};
			//JTable 객체를 생성하고난후 데이터와 컬럼을 추가하는 방법
			DefaultTableModel model = new DefaultTableModel(data,column);
			table.setModel(model);
			

			JScrollPane scroll = new JScrollPane(table);
			this.add(scroll, BorderLayout.CENTER);

			// 아래쪽
			// 한구역에는 한종류만 들어갈수있음
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());
			JButton btnInsert = new JButton("등록");
			btnInsert.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 모달 : 새로운 창수행이 끝날때까지 다른작업 못함
					JDialog modalDialog = new JDialog(frame, "다이얼로그", Dialog.ModalityType.DOCUMENT_MODAL);

					modalDialog.setBounds(1, 10, 300, 300);
					Container dialogContainer = modalDialog.getContentPane();
					dialogContainer.setLayout(new BorderLayout());

					// 교과목코드,교과목명,교수자,강의실 =>등록
					JPanel panel = new JPanel();
					panel.setLayout(null);// 레이아웃 설정을 null 절대경로
					JLabel label = new JLabel("과목코드");
					label.setBounds(1, 10, 100, 30);
					JTextField field = new JTextField();
					field.setBounds(120, 10, 100, 20);

					JLabel label1 = new JLabel("과목명");
					label1.setBounds(1, 40, 100, 30);
					JTextField field1 = new JTextField();
					field1.setBounds(120, 40, 100, 20);

					JLabel label2 = new JLabel("강의실");
					label2.setBounds(1, 70, 100, 30);
					JTextField field2 = new JTextField();
					field2.setBounds(120, 70, 100, 20);

					JLabel label3 = new JLabel("교수명");
					label3.setBounds(1, 100, 100, 30);
					JTextField field3 = new JTextField();
					field3.setBounds(120, 100, 100, 20);

					JLabel label4 = new JLabel("시간");
					label4.setBounds(1, 130, 100, 30);
					JTextField field4 = new JTextField();
					field4.setBounds(120, 130, 100, 20);

					JButton btnInsert = new JButton("등록");
					btnInsert.setBounds(20, 190, 80, 20);
					btnInsert.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							String code = field.getText();
							String name = field1.getText();
							String classr = field2.getText();
							String professor = field3.getText();
							String time = field4.getText();

							Subject subject = new Subject(code, name, classr, professor, time, null);
							try {
								int result = subjectDAO.insertSubject(subject);
								if (result > 0) {//JTable객체에서 기존 데이터와 컬럼의 값 가져오기
									//목록창에 갱신하기 : 
									//db에서 다시 교과목목록 가져오기
									//JTable 에 데이터 지우고 새로 추가하기
									//JTable 객체를 생성하고난후 데이터와 컬럼을 추가하는 방법
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									if(model.getRowCount()>0) {//데이터가 있으면 기존데이터 다 지우기
										for(int i = model.getRowCount()-1;i>=0;i--) {
											model.removeRow(i);
										}
									}
									//DB에서 값을 가져와서 갱신하기
									List<Subject> subjectList = subjectDAO.selectSubject();
									
									for (int i = 0; i < subjectList.size(); i++) {
										String[] data = new String[column.length];
										//리스트에서 1개 꺼내기
										Subject obj = subjectList.get(i);
										data[0] = obj.getSubject_code();
										data[1] = obj.getSubject_name();
										data[2] = obj.getSubject_class();
										data[3] = obj.getsubject_professor();
										data[4] = obj.getsubject_time();
										data[5] = obj.getsubject_date();
										model.addRow(data);
									
									}
									table.setModel(model);
									JOptionPane.showMessageDialog(null, "등록완료", "메세지", JOptionPane.INFORMATION_MESSAGE);
									modalDialog.setVisible(false);
								}
							} catch (Exception e1) {

								e1.printStackTrace();
							}

						}
					});

					JButton btnClose = new JButton("나가기");
					btnClose.setBounds(120, 190, 80, 20);
					btnClose.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							modalDialog.setVisible(false);

						}
					});

					panel.add(btnClose);
					panel.add(btnInsert);
					panel.add(field4);
					panel.add(label4);
					panel.add(field3);
					panel.add(label3);
					panel.add(field2);
					panel.add(label2);
					panel.add(field1);
					panel.add(label1);
					panel.add(field);
					panel.add(label);

					dialogContainer.add(panel, BorderLayout.CENTER);
					modalDialog.setVisible(true);

				}
			});

			JButton btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

				}
			});

			JButton btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

				}
			});
			panel.add(btnInsert);
			panel.add(btnDelete);
			panel.add(btnUpdate);
			this.add(panel, BorderLayout.SOUTH);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
