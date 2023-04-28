package com.jdc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class AbstractTest {
	
	static EntityManagerFactory emf;
	EntityManager em;

	@BeforeAll
	static void init() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpql");		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@AfterAll
	static void shutdown() throws Exception {
		emf.close();
	}

}
