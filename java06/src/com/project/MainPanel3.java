package com.project;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel3 extends JPanel{
	
	public MainPanel3() {
		super();
		
		this.setLayout(new BorderLayout());
		
		JLabel lblWest = new JLabel("왼쪽-WEST");
		this.add(lblWest, BorderLayout.WEST);

		JLabel lblSouth = new JLabel("아래쪽-SOUTH");
		this.add(lblSouth, BorderLayout.SOUTH);

		JLabel lblNorth = new JLabel("위쪽-NORTH");
		this.add(lblNorth, BorderLayout.NORTH);

		JLabel lblEast = new JLabel("오른쪽-EAST");
		this.add(lblEast, BorderLayout.EAST);

		JLabel lblCenter = new JLabel("중간-CENTER");
		this.add(lblCenter, BorderLayout.CENTER);
		
	}
	
	
	

}
