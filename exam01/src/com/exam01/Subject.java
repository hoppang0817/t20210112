package com.exam01;

public class Subject {
	private String code = null;
	private String name = null;
	private float score = 0;
	
	public Subject() {
		super();
	}

	public Subject(String code, String name, float score) {
		super();
		this.code = code;
		this.name = name;
		this.score = score;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public float getscore() {
		return score;
	}

	public void setscore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Subject [code=" + code + ", name=" + name + ", score=" + score + "]";
	}

	
	
	
}
