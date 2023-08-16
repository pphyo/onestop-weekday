package com.jdc.jpa.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.rm.Contact;
import com.jdc.rm.Customer;
import com.jdc.rm.Customer.Gender;
import com.jdc.rm.Item;
import com.jdc.rm.Sale;
import com.jdc.rm.SaleItem;

public class RelationshipMappingTest {
	
	static EntityManagerFactory emf;
	EntityManager em;
	
	@Test
	@Disabled
	void test_for_many_to_many() {
		var s1 = new Sale(LocalDate.now(), 20000, null);
		
		var i1 = new Item("Potato Chips", 3000, false);
		var i2 = new Item("Coca Cola", 1200, true);
		var i3 = new Item("Fried Chicken", 10000, false);
		
		// mapping 
		s1.getItems().add(i1);
		s1.getItems().add(i2);
		s1.getItems().add(i3);
		
		em.getTransaction().begin();
		
		em.persist(s1);
		
		em.getTransaction().commit();
	}
	
	@Test
	@Disabled
	void test_for_one_to_many() {
		
		var item = new Item();
		item.setName("Burgur");
		item.setPrice(5500);
		
		var si1 = new SaleItem();
		si1.setQuantity(2);
		si1.setUnitPrice(item.getPrice());
		
		var si2 = new SaleItem();
		si2.setQuantity(1);
		si2.setUnitPrice(item.getPrice());
		
//		var list = new ArrayList<SaleItem>();
//		list.add(si1);
//		list.add(si2);
		
//		var list = item.getSaleItems();
//		list.add(si1);
//		list.add(si2);
//		
//		// one to many;
//		item.setSaleItems(list);
		
		em.getTransaction().begin();
		em.persist(si1);
		em.persist(si2);
		em.persist(item);
		em.getTransaction().commit();
		
	}
	
	@Test
//	@Disabled
	void test_for_one_to_one() {
		
		var cust1 = new Customer();
		cust1.setName("Customer 1");
		cust1.setGender(Gender.Male);
		
//		var cust2 = new Customer();
//		cust2.setName("Customer 2");
//		cust2.setGender(Gender.Female);
		
		var contact = new Contact();
		contact.setEmail("demo@gmail.com");
		contact.setPhone("393383838");
		
		// one to one bi
		cust1.setContact(contact);
		
		em.getTransaction().begin();
		em.persist(cust1);
		em.persist(contact);
		em.getTransaction().commit();

		var rc1 = em.find(Contact.class, 1);
		var resCust = rc1.getCustomer();
				
		assertThat(rc1, allOf(
					hasProperty("id", is(1)),
					hasProperty("email", is("demo@gmail.com")),
					hasProperty("phone", is("393383838"))
				));
		
		assertThat(1, is(resCust.getId()));
		assertThat("Customer 1", is(resCust.getName()));
		assertThat(Gender.Male, is(resCust.getGender()));
		
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
