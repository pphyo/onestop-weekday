package com.jdc.test;

import java.awt.Color;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.app.entity.Student;

class InheritTest {
	
	static EntityManagerFactory emf;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("inherit-mapping");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(null != emf && emf.isOpen())
			emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		if(null != em && em.isOpen())
			em.close();
	}

	@Test
	void test() {
		em.getTransaction().begin();
		
		var account = new Student("P Phyo", "pphyo", "pyaephyo");
		account.setColor(Color.BLUE);
		em.persist(account);
		
		em.getTransaction().commit();
	}

}






