package com.epam.lab.hw7.entity;




public class Student {

	private int stId;
	private String fname;
	private String lname;
	private String pname;
	private String stGender;
	private String stBirthday;
	private String stAddress;
	private int stTelephon;
	private int passportNumber;

	public Student() {
	}

	public Student(String fname, String lname, String pname, String stGender, String stBirthday,
			String stAddress, int stTelephon, int passportNumber) {
		super();

		this.fname = fname;
		this.lname = lname;
		this.pname = pname;
		this.stGender = stGender;
		this.stBirthday = stBirthday;
		this.stAddress = stAddress;
		this.stTelephon = stTelephon;
		this.passportNumber = passportNumber;

	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getStGender() {
		return stGender;
	}

	public void setStGender(String stGender) {
		this.stGender = stGender;
	}

	public String getStBirthday() {
		return stBirthday;
	}

	public void setStBirthday(String stBirthday) {
		this.stBirthday = stBirthday;
	}

	public String getStAddress() {
		return stAddress;
	}

	public void setStAddress(String stAddress) {
		this.stAddress = stAddress;
	}

	public int getStTelephon() {
		return stTelephon;
	}

	public void setStTelephon(int stTelephon) {
		this.stTelephon = stTelephon;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}



	@Override
	public String toString() {
		return "Student [stId=" + stId + ", fname=" + fname + ", lname=" + lname + ", pname=" + pname + ", stGender="
				+ stGender + ", stBirthday=" + stBirthday + ", stAddress=" + stAddress + ", stTelephon=" + stTelephon
				+ ", passportNumber=" + passportNumber + "]";
	}
	

}
