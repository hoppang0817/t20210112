package com.project;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame{

	public MainFrame(String title) throws HeadlessException {
		super(title);
		
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.add("과목리스트", new MainPanel1(this));
		tabbedPane.add("학생리스트", new MainPanel2(this));
		tabbedPane.add("수강리스트", new MainPanel3());
		
		this.add(tabbedPane);
		this.setSize(600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	
	
	

}
