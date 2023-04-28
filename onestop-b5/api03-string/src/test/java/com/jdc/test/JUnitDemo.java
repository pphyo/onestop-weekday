package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class JUnitDemo {
	
	static String s;

	@Disabled
	@Test
	@Order(1)
	@DisplayName("first test method")
	void testZ() {
		s = "Demo";
		assertNotNull(s);
	}
	
	@Test
	@Order(2)
	@DisplayName("second test method")
	void testA() {
		assertNull(s);
		assertTrue(5 < 3, "This is a sample test");
	}

}
