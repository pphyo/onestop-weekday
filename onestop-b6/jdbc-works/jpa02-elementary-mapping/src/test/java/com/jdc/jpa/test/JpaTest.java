package com.jdc.jpa.test;

import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class JpaTest {
	
	@Test
	void test() {
		
		var emf = Persistence.createEntityManagerFactory("em");
		emf.close();
		
	}

}
