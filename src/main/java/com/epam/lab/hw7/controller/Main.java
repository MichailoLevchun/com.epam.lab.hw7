package com.epam.lab.hw7.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.epam.lab.hw7.dao.StudentDao;
import com.epam.lab.hw7.entity.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main {
	final static Logger LOG = Logger.getLogger(Main.class);
	static Connection connection;
	static Statement statement = null;

	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException {
		final String confPath = "/configuration.properties";
		InputStream input = null;
		String URL = " ";
		String USER = " ";
		String PASSWORD = " ";
		Properties prop = new Properties();
		try {
			prop.load(Main.class.getResourceAsStream(confPath));
			URL = prop.getProperty("URL");
			USER = prop.getProperty("USER");
			PASSWORD = prop.getProperty("PASSWORD");
		} catch (IOException ex) {
			LOG.error("Error occurs during reading configuration properties");
		} finally {
			if (!Objects.isNull(input)) {
				try {
					input.close();
				} catch (IOException e) {
					LOG.error(e.getStackTrace());
				}
			}
		}
		connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		String sql_stmt = "create database if not exists university";
		statement = (Statement) connection.createStatement();
		statement.execute(sql_stmt);
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
