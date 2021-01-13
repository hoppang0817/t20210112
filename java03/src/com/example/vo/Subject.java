package com.example.vo;

public class Subject {
	private String name;    //과목명
	private int scorePoint; //점수
	
	//생성자
	public Subject() {
		
	}


	public Subject(String name, int scorePoint) {
		super();
		this.name = name;
		this.scorePoint = scorePoint;
	}


	//getter / setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScorePoint() {
		return scorePoint;
	}


	public void setScorePoint(int scorePoint) {
		this.scorePoint = scorePoint;
	}

 
	//toString()
	@Override
	public String toString() {
		return "Subject [name=" + name + ", scorePoint=" + scorePoint + "]";
	}
	
	
	

	
}
