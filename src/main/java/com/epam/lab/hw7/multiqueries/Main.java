package com.epam.lab.hw7.multiqueries;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main {
	final static Logger LOG = Logger.getLogger(Main.class);

	@SuppressWarnings("null")
	public static void main(String[] args) {
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

		try (Connection connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD)) {
			connection.setAutoCommit(false);
			try (Statement stmt = (Statement) connection.createStatement()) {
				stmt.executeUpdate("insert into university.subject values('math analys')");
				stmt.executeUpdate("insert into university.speciality values('Applied Math', 'here you can  study math')");
				connection.commit();
			} catch (Exception e) {
				connection.rollback();
				LOG.error(e.getStackTrace());

			}
		} catch (Exception e) {
			LOG.error(e.getStackTrace());
		}

	}

}
