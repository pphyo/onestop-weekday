package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.jdc.app.model.util.DbManager;

public class LibraryCrudTest {
	
	@Test
	void test() {
		try {
			assertNotNull(DbManager.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
