package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.app.entity.Category;
import com.jdc.app.entity.Movie;
import com.jdc.app.entity.MovieType;
import com.jdc.app.entity.MovieType.Type;

class RelationshipTest {
	
	static EntityManagerFactory emf;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("rsm");
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

//	@Test
	void test() {
		em.getTransaction().begin();
		
		Category c1 = new Category();
		c1.setName("Animation");
		
		Category c2 = new Category();
		c2.setName("Adventure");
		
		Category c3 = new Category();
		c3.setName("Action");
		
		Movie m1 = new Movie();
		m1.setName("Tarzan 2003");
		m1.setDuration(LocalTime.of(1, 45, 32));
		m1.setRating(9);
		m1.setCategory(c1);
		
		MovieType mt = new MovieType();
		mt.setType(Type.International);
		mt.setMovie(m1);
		
		em.persist(c1);
		em.persist(c2);
				
		em.persist(mt);
		
		em.persist(m1);

		
		
		Category resultCat = em.find(Category.class, 1);
		
		assertNotNull(resultCat);
		assertEquals("Animation", resultCat.getName());
		
		em.getTransaction().commit();
	}
	
	@Test
	void test_for_cascade() {
		
		em.getTransaction().begin();
		
		Movie mov1 = new Movie();
		mov1.setName("Moana");
		mov1.setDuration(LocalTime.of(1, 50, 47));
		mov1.setRating(8);
		
		Movie mov2 = new Movie();
		mov2.setName("Fight Club");
		mov2.setDuration(LocalTime.of(2, 30, 33));
		mov2.setRating(10);
		
		//movie1 => MovieType1
		MovieType mt1 = new MovieType();
		mt1.setMovie(mov1);
		mt1.setType(Type.International);
		
		// movie2 => MovieType2
		MovieType mt2 = new MovieType();
		mt2.setMovie(mov2);
		mt2.setType(Type.International);
		
		em.persist(mov1);
		em.persist(mov2);
		em.persist(mt1);
		em.persist(mt2);
		
		em.getTransaction().commit();
		
	}
	
//	@Test
	void test_for_primary_join_column() {
		
		em.getTransaction().begin();
		
		Category c1 = new Category();
		c1.setName("Animation");
		
		Category c2 = new Category();
		c2.setName("Adventure");
		
		Movie m1 = new Movie();
		m1.setName("Tarzan 2003");
		m1.setDuration(LocalTime.of(1, 45, 32));
		m1.setRating(9);
		m1.setCategory(c1);
//		m1.setCategory(c2);
		
		MovieType mt = new MovieType();
		mt.setType(Type.International);
		mt.setMovie(m1);
		
		em.persist(c1);
		em.persist(c2);
				
		em.persist(mt);
		
		em.persist(m1);
		
		em.getTransaction().commit();
		
	}

}







