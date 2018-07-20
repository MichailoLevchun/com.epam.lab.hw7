package com.epam.lab.hw7.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.epam.lab.hw7.entity.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class StudentDao {
	private Connection connection;
	public StudentDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public void addStudent(Student student) {
		try {
			String sql = "insert into student(fname, lname, pname, stGender, stBirthday, stAddress, stTelephon, "
					+ "passportNumber) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getFname());
			preparedStatement.setString(2, student.getLname());
			preparedStatement.setString(3, student.getPname());
			preparedStatement.setString(4, student.getStGender());
			preparedStatement.setString(5, student.getStBirthday());
			preparedStatement.setString(6, student.getStAddress());
			preparedStatement.setInt(7, student.getStTelephon());;
			preparedStatement.setInt(8, student.getPassportNumber());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int stId) {
		try {
			String sql = "delete from student where stId = ?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, stId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student) {
		try {
			String sql = "update student set fname = ?, lname = ?, pname = ?, stGender= ?, stBirthday= ?, stAddress= ?, stTelephon= ?, "
					+ "passportNumber= ? where stId =  ?" ;
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getFname());
			preparedStatement.setString(2, student.getLname());
			preparedStatement.setString(3, student.getPname());
			preparedStatement.setString(4, student.getStGender());
			preparedStatement.setString(5, student.getStBirthday());
			preparedStatement.setString(6, student.getStAddress());
			preparedStatement.setInt(7, student.getStTelephon());;
			preparedStatement.setInt(8, student.getPassportNumber());
			preparedStatement.setInt(9, student.getStId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from student");
			while (rs.next()) {
				Student student = new Student();
				student.setStId(rs.getInt("stId"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				student.setPname(rs.getString("pname"));
				student.setStGender(rs.getString("stGender"));
				student.setStBirthday(rs.getString("stBirthday"));
				student.setStAddress(rs.getString("stAddress"));
				student.setStTelephon(rs.getInt("stTelephon"));
				student.setPassportNumber(rs.getInt("passportNumber"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public Student getStudentById(int stId) {
		Student student = new Student();
		try {
			String sql = "select * from Students where student_id=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, stId);
			ResultSet rs = preparedStatement.executeQuery();		
			if (rs.next()) {
				student.setStId(rs.getInt("stId"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				student.setPname(rs.getString("pname"));
				student.setStGender(rs.getString("stGender"));
				student.setStBirthday(rs.getString("stBirthday"));
				student.setStAddress(rs.getString("stAddress"));
				student.setStTelephon(rs.getInt("stTelephon"));
				student.setPassportNumber(rs.getInt("passportNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
}
