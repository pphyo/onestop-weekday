package com.jdc.jdbc.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/os6_db";
	private static final String USR = "root";
	private static final String PWD = "pyaephyo";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USR, PWD);
	}

}
