package com.epam.lab.hw7.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.epam.lab.hw7.entity.Speciality;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SpecialityDao {
	private Connection connection;

	public SpecialityDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void addSpeciality(Speciality speciality) {
		try {
			String sql = "insert into speciality(specialityName,specialityDeclaration) values (?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, speciality.getSpecialityName());
			preparedStatement.setString(2, speciality.getSpecialityDeclaration());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSpeciality(int specialityId) {
		try {
			String sql = "delete from speciality where specialityId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, specialityId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSpeciality(Speciality speciality) {
		try {
			String sql = "update speciality set specialityName=?,specialityDeclaration=? where specialityId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, speciality.getSpecialityName());
			preparedStatement.setString(2, speciality.getSpecialityDeclaration());
			preparedStatement.setInt(3, speciality.getSpecialityId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Speciality> getAllSpeciality() {
		List<Speciality> specialitys = new ArrayList<Speciality>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from speciality");
			while (rs.next()) {
				Speciality speciality = new Speciality();
				speciality.setSpecialityId(rs.getInt("specialityId"));
				speciality.setSpecialityName(rs.getString("specialityName"));
				speciality.setSpecialityDeclaration(rs.getString("specialityDeclaration"));
				specialitys.add(speciality);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return specialitys;
	}

	public Speciality getSpecialityById(int specialityId) {
		Speciality speciality = new Speciality();
		try {
			String sql = "select * from speciality where specialityId=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, specialityId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				speciality.setSpecialityId(rs.getInt("specialityId"));
				speciality.setSpecialityName(rs.getString("specialityName"));
				speciality.setSpecialityDeclaration(rs.getString("specialityDeclaration"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return speciality;
	}

}
