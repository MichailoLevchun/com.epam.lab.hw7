package com.epam.lab.hw7.entity;

import java.sql.Date;

public class RecordBook {
	private int recordBookId;
	private Date universityDate;
	private String studingForm;
	private Date examDate;
	private int mark;

	public RecordBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordBook(Date universityDate, String studingForm, Date examDate, int mark) {
		this.universityDate = universityDate;
		this.studingForm = studingForm;
		this.examDate = examDate;
		this.mark = mark;
	}

	public int getRecordBookId() {
		return recordBookId;
	}

	public void setRecordBookId(int recordBookId) {
		this.recordBookId = recordBookId;
	}

	public Date getUniversityDate() {
		return universityDate;
	}

	public void setUniversityDate(Date universityDate) {
		this.universityDate = universityDate;
	}

	public String getStudingForm() {
		return studingForm;
	}

	public void setStudingForm(String studingForm) {
		this.studingForm = studingForm;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

}
