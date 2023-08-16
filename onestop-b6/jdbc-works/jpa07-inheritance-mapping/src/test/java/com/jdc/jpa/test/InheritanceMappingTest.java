package com.jdc.jpa.test;

import java.time.MonthDay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.im.entity.Book;
import com.jdc.im.entity.Electric;
import com.jdc.im.entity.Funiture;
import com.jdc.im.entity.Funiture.MadeType;

public class InheritanceMappingTest {
	
	static EntityManagerFactory emf;
	EntityManager em;
	
	@Test
	void test() {}
	
	@Test
	@Disabled
	void test_for_inhertance() {
		
		var book = new Book();
		book.setName("Three Musketeer");
		book.setIsbn("TM339393");
		book.setPrice(40);
		book.setReleasedDate(MonthDay.of(8, 20));
		
		var mobile = new Electric();
		mobile.setName("Android");
		mobile.setPrice(240);
		mobile.setModel("OA330");
		
		var bench = new Funiture();
		bench.setName("Mini Bench");
		bench.setPrice(59);
		bench.setMadeType(MadeType.Wood);
		
		em.getTransaction().begin();
		
		em.persist(mobile);
		em.persist(book);
		em.persist(bench);
		
		em.getTransaction().commit();
		
	}
	
	@BeforeAll
	static void setUpBeforeClass() {
		emf = Persistence.createEntityManagerFactory("im");
	}
	
	@BeforeEach
	void setUp() {
		em = emf.createEntityManager();
	}
	
	@AfterEach
	void tearDown() {
		if(null != em && em.isOpen())
			em.close();
	}
	
	static void tearDownAfterClass() {
		if(null != emf && emf.isOpen())
			emf.close();
	}

}
