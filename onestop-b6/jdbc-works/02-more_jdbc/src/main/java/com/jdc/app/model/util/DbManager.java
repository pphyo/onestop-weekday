package com.jdc.app.model.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
	
	private static Properties props;
	
	static {
		props = new Properties();
		
		try {
			props.load(DbManager.class.getResourceAsStream("/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				props.getProperty("app.db.url"), 
				props.getProperty("app.db.usr"), 
				props.getProperty("app.db.pwd"));
	}

}
