package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.app.dao.QueryDao;

@TestMethodOrder(OrderAnnotation.class)
public class DynamicQueryTest {
	
	QueryDao dao = new QueryDao();
	
	@ParameterizedTest
	@Order(2)
	@CsvSource({
		"Java,,0,9",
		"Java,Basic,0,4",
		"Spring,,0,9",
		"OO,Advanced,0,0",
		"Java,,500000,5"
	})
	void test_for_find(String name, String level, int fees, int expected) {
		var list = dao.find(name, level, fees);
		assertEquals(expected, list.size());
	}
	
	@ParameterizedTest
	@CsvSource({
		"Java,2",
		"Java Basic,1",
		"Java EE,1",
		"Java SE,0",
		"OO,1"
	})
	@Order(1)
	void test_for_find_by_name(String name, int expected) {
		var list = dao.findByName(name);
		assertNotNull(list);
		assertEquals(expected, list.size());
	}

}
