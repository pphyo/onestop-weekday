package com.jdc.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class GettingStart {
	
	@Test
	void test() {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("jpa01-getting-start");
		
		emf.close();
		
	}

}
