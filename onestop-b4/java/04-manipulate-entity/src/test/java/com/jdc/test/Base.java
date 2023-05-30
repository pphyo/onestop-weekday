package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Base {
	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("man-en");
	}
	
	@AfterAll
	static void shutdown() {
		if(null != emf && emf.isOpen())
			emf.close();
	}

}
