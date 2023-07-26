package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MapProperties {
	
	static Properties prop;
	
	@BeforeAll
	static void setUpBeforeClass() {
		prop = new Properties();
		
		try {
			prop.load(new FileInputStream("app.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test() {
//		Properties prop = System.getProperties();
//		prop.list(System.out);
		
		assertEquals("JDBC App", prop.getProperty("app.name"));
		assertEquals("1.0", prop.getProperty("app.version"));
		assertEquals("Development", prop.getProperty("app.env"));
		
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("java.version"));
	}

}
