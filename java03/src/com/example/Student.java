package com.example;

public class Student {
	
	private String no = null;
	private String name = null;
	private int score_kor = 0;
	private int score_eng = 0;
	private int score_math = 0;
	
	//생성자
	public Student() {
		super();
	}

	public Student(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public Student(String no, String name, int score_kor, int score_eng, int score_math) {
		super();
		this.no = no;
		this.name = name;
		this.score_kor = score_kor;
		this.score_eng = score_eng;
		this.score_math = score_math;
	}
	
	
	//getter / setter
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore_kor() {
		return score_kor;
	}

	public void setScore_kor(int score_kor) {
		this.score_kor = score_kor;
	}

	public int getScore_eng() {
		return score_eng;
	}

	public void setScore_eng(int score_eng) {
		this.score_eng = score_eng;
	}

	public int getScore_math() {
		return score_math;
	}

	public void setScore_math(int score_math) {
		this.score_math = score_math;
	}
	
	//메서드
	public float avg() throws Exception {
		if (score_kor<0 || score_eng<0 || score_math<0) {
			throw new Exception("socor error");
		}
		float tmp = (score_kor+score_eng+score_math)/(float)3f;
		return tmp;
	}
	
}
