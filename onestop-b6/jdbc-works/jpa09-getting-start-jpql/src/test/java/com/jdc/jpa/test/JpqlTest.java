package com.jdc.jpa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.jpql.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
public class JpqlTest {

	EntityManagerFactory emf;
	EntityManager em;

	@Test
	@Order(1)
	void test_for_jpql() {

		var query = em.createNamedQuery("Course.findById", Course.class);

		query.setParameter("id", Integer.valueOf(1));
		
		var result = query.getSingleResult();

		assertNotNull(result);

	}
	
	@Test
	@Order(2)
	void test_for_update() {
		var tx = em.getTransaction();
		
		String jpql = "update Course c set c.name = :name, c.fees = :fees where c.id = :id";
		
		var query = em.createQuery(jpql);
		query.setParameter("name", "Android Development");
		query.setParameter("fees", 350000);
		query.setParameter("id", 5);
		
		tx.begin();
		int updateCount = query.executeUpdate();
		System.out.println(updateCount);
		tx.commit();
		
	}
	
	@Test
	@Order(3)
	void test_for_delete() {
		String jpql = "delete from Course c where c.id = :id";
		
		var query = em.createQuery(jpql);
		query.setParameter("id", 3);
		
		em.getTransaction().begin();
		System.out.println(query.executeUpdate());
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@Order(4)
	@CsvSource()
	void test_for_member_of(int id, long result) {
		String jpql = "select c from Course c where c member of c.objectives";
		
		var query = em.createQuery(jpql, Course.class);
//		query.setParameter("obj", id);
		
		var queryResult = query.getSingleResult();
		
		System.out.println(queryResult);
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
