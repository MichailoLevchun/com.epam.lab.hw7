package com.epam.lab.hw7.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.hw7.entity.RecordBook;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class RecordBookDao {
	private Connection connection;

	public RecordBookDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void addRecordBook(RecordBook recordBook) {
		try {
			String sql = "insert into recordBook(universityDate, studingForm, examDate, mark) values (?,?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setDate(1, recordBook.getUniversityDate());
			preparedStatement.setString(2, recordBook.getStudingForm());
			preparedStatement.setDate(3, recordBook.getExamDate());
			preparedStatement.setInt(4, recordBook.getMark());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRecordBook(int recordBookId) {
		try {
			String sql = "delete from recordBook where recordBookId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, recordBookId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRecordBook(RecordBook recordBook) {
		try {
			String sql = "update recordBook set universityDate=?, studingForm=?, examDate=?, mark=? where recordBookId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setDate(1, recordBook.getUniversityDate());
			preparedStatement.setString(2, recordBook.getStudingForm());
			preparedStatement.setDate(3, recordBook.getExamDate());
			preparedStatement.setInt(4, recordBook.getMark());
			preparedStatement.setInt(5, recordBook.getRecordBookId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RecordBook> getAllRecordBook() {
		List<RecordBook> recordBooks = new ArrayList<RecordBook>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from recordBook");
			while (rs.next()) {
				RecordBook recordBook = new RecordBook();
				recordBook.setRecordBookId(rs.getInt("recordBookId"));
				recordBook.setUniversityDate(rs.getDate("universityDate"));
				recordBook.setStudingForm(rs.getString("studingFrom"));
				recordBook.setExamDate(rs.getDate("examDate"));
				recordBook.setMark(rs.getInt("mark"));
				recordBooks.add(recordBook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordBooks;
	}

	public RecordBook getRecordBookById(int recordBookId) {
		RecordBook recordBook = new RecordBook();
		try {
			String sql = "select * from recordBook where recordBookId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, recordBookId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				recordBook.setRecordBookId(rs.getInt("recordBookId"));
				recordBook.setUniversityDate(rs.getDate("universityDate"));
				recordBook.setStudingForm(rs.getString("studingFrom"));
				recordBook.setExamDate(rs.getDate("examDate"));
				recordBook.setMark(rs.getInt("mark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recordBook;
	}


}
