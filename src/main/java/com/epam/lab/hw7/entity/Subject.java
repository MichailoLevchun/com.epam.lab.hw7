package com.epam.lab.hw7.entity;

public class Subject {

	private int subId;
	private String subName;

	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String subName) {

		this.subName = subName;

	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

}
