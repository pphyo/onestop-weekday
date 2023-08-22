package com.jdc.jpa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.jpql.Course;
import com.jdc.jpql.Course.Level;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpqlTest {

	EntityManagerFactory emf;
	EntityManager em;

	@Test
	void test_for_jpql() {

		String jpql = """
				select c from Course c where c.id = 1
				""";

		var query = em.createQuery(jpql, Course.class);

		var result = query.getSingleResult();

		assertEquals("Java Basic", result.getName());
		assertEquals(300000, result.getFees());
		assertEquals(4, result.getDuration());
		assertEquals(Level.Basic, result.getLevel());

	}

	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("jpql");
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() {
		em.close();
		emf.close();
	}

}
