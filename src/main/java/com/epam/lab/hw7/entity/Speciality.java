package com.epam.lab.hw7.entity;

public class Speciality {

	private int specialityId;
	private String specialityName;
	private String specialityDeclaration;
	

	public Speciality() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Speciality(String specialityName, String specialityDeclaration) {
		super();

		this.specialityName = specialityName;
		this.specialityDeclaration = specialityDeclaration;

	}

	public int getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(int specialityId) {
		this.specialityId = specialityId;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

	public String getSpecialityDeclaration() {
		return specialityDeclaration;
	}

	public void setSpecialityDeclaration(String specialityDeclaration) {
		this.specialityDeclaration = specialityDeclaration;
	}

}
