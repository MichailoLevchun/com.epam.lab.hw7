package com.epam.lab.hw7.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.hw7.entity.Subject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SubjectDao {
	private Connection connection;

	public SubjectDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void addSubject(Subject subject) {
		try {
			String sql = "insert into subject(subName) values (?)";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, subject.getSubName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSubject(int subId) {
		try {
			String sql = "delete from subject where subId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, subId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSubject(Subject subject) {
		try {
			String sql = "update subject set subName=? where subId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, subject.getSubName());
			preparedStatement.setInt(2, subject.getSubId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Subject> getAllSubject() {
		List<Subject> subjects = new ArrayList<Subject>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from subject");
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSubId(rs.getInt("subId"));
				subject.setSubName(rs.getString("subName"));
				subjects.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subjects;
	}

	public Subject getSubjectById(int subId) {
		Subject subject = new Subject();
		try {
			String sql = "select * from subject where subId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, subId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				subject.setSubId(rs.getInt("subId"));
				subject.setSubName(rs.getString("subName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subject;
	}

}
