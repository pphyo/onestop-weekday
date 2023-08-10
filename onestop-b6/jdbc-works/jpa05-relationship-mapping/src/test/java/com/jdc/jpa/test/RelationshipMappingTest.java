package com.jdc.jpa.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.rm.Contact;
import com.jdc.rm.Customer;
import com.jdc.rm.Customer.Gender;

public class RelationshipMappingTest {
	
	static EntityManagerFactory emf;
	EntityManager em;
	
	@Test
	void test_for_one_to_one() {
		
		var cust1 = new Customer();
		cust1.setName("Customer 1");
		cust1.setGender(Gender.Male);
		
//		var cust2 = new Customer();
//		cust2.setName("Customer 2");
//		cust2.setGender(Gender.Female);
		
		var contact = new Contact();
		contact.setCustomer(cust1);
		contact.setEmail("demo@gmail.com");
		contact.setPhone("393383838");
		
		em.getTransaction().begin();
		em.persist(cust1);
		em.persist(contact);
		em.getTransaction().commit();

//		var rc1 = em.find(Contact.class, 1);
//		var resCust = rc1.getCustomer();
//				
//		assertThat(rc1, allOf(
//					hasProperty("id", is(1)),
//					hasProperty("email", is("demo@gmail.com")),
//					hasProperty("phone", is("393383838"))
//				));
//		
//		assertThat(1, is(resCust.getId()));
//		assertThat("Customer 1", is(resCust.getName()));
//		assertThat(Gender.Male, is(resCust.getGender()));
//		
//		contact.setCustomer(cust2);
//		
//		em.getTransaction().begin();
//		em.persist(contact);
//		em.getTransaction().commit();
//		
//		var rc2 = em.find(Contact.class, 1);
//		var resCust2 = rc2.getCustomer();
//		
//		assertThat(rc2, allOf(
//				hasProperty("id", is(1)),
//				hasProperty("email", is("demo@gmail.com")),
//				hasProperty("phone", is("393383838"))
//			));
//	
//		assertThat(2, is(resCust2.getId()));
//		assertThat("Customer 2", is(resCust2.getName()));
//		assertThat(Gender.Female, is(resCust2.getGender()));
		
	}
	
	@BeforeAll
	static void setUpBeforeClass() {
		emf = Persistence.createEntityManagerFactory("rm");
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
	
	@AfterAll
	static void tearDownAfterClass() {
		if(null != emf && emf.isOpen())
			emf.close();
	}

}
