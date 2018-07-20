package com.epam.lab.hw7.controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.epam.lab.hw7.dao.StudentDao;
import com.epam.lab.hw7.entity.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main {

	final static Logger LOG = Logger.getLogger(Main.class);
	static final String URL = "jdbc:mysql://localhost/university";
	static final String USER = "root";
	static final String PASSWORD = "123456";
	static Connection connection;
	static Statement statement = null;

	@SuppressWarnings("unused")
	private static void createDatabase() throws SQLException {
		String sql_stmt = "CREATE DATABASE IF NOT EXISTS  `university`;";
		statement = (Statement) connection.createStatement();
		statement.executeUpdate(sql_stmt);
		LOG.info("university has successfully been created");
	}

	public static void main(String[] args) throws SQLException {
		connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		String sqlSt = "CREATE TABLE if not exists university.student "
				+ "(stId int primary key unique auto_increment, fname VARCHAR(255), lname VARCHAR(255), pname VARCHAR(255),"
				+ "stGender VARCHAR(255), stBirthday VARCHAR(255), stAddress VARCHAR(255), stTelephon int, passportNumber int )";
		statement = (Statement) connection.createStatement();
		statement.executeUpdate(sqlSt);
		String sqlSub = "create table if not exists university.subject(subId int primary key unique auto_increment,subName VARCHAR(255))";
		statement = (Statement) connection.createStatement();
		statement.execute(sqlSub);
		String sqlSpec = "create table if not exists university.speciality(specialityId int primary key unique auto_increment,"
				+ "specialityName VARCHAR(255),specialityDeclaration VARCHAR(255))";
		statement = (Statement) connection.createStatement();
		statement.execute(sqlSpec);
		String sqlRecbook = "create table if not exists university.recordBook(recordBookId int primary key unique auto_increment,"
				+ "universityDate Date,studingForm VARCHAR(255),examDate Date,mark int)";
		statement = (Statement) connection.createStatement();
		statement.execute(sqlRecbook);
		
		StudentDao stDao = new StudentDao(connection);

		Student st = new Student("ira", "princess", "dsd", "dffd", null, null, 0, 0);

		stDao.addStudent(st);

		for (Student stud : stDao.getAllStudents()) {
			LOG.debug(stud);
		}


	}
}
