package com.jdc.jpa.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.em.entity.Ledger;
import com.jdc.em.entity.Ledger.LedgerType;

@TestMethodOrder(OrderAnnotation.class)
public class ManagingEntityTest extends AbstractTest {

	
	@Order(1)
	@ParameterizedTest
	@CsvSource(value = {
			"Shopping, Debit",
			"Phone Bill, Debit",
			"Lottery, Credit",
			"Salary, Credit"
	})
	void test1(String name, LedgerType type) {
		// Transient or new state
		var ledger = new Ledger(name, type);

		em.getTransaction().begin();
		
		// Managed state
		em.persist(ledger);
		em.detach(ledger);
		
//		ledger.setName("Tax"); // In managed state, update statement is made by set state with mutation
				
		assertFalse(em.contains(ledger));
		
		var result = em.merge(ledger);
		
		assertTrue(em.contains(result));
		
		em.getTransaction().commit();

	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource(value = "1, Shopping, Debit")
	void test2(int id, String name, LedgerType type) {

		var result = em.find(Ledger.class, id);

		assertAll(() -> {
			assertEquals(id, result.getId());
			assertEquals(name, result.getName());
			assertEquals(type, result.getType());
		});
		
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource(value = {
			"1, Tax, Debit",
			"3, Award, Credit"
	})
	void test3(int id, String name, LedgerType type) {
		var ledger = new Ledger();
		ledger.setId(id);
		ledger.setName(name);
		ledger.setType(type);
		
		em.getTransaction().begin();
		var result = em.merge(ledger);
		assertTrue(em.contains(result));
		em.getTransaction().commit();
	}
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(ints = {1, 3})
	void test4(int id) {
		// managed state
		var ledger = em.find(Ledger.class, id);
		assertTrue(em.contains(ledger));
		
		em.getTransaction().begin();
		// remove state
		em.remove(ledger);
		em.getTransaction().commit();
	}
	
	@DisplayName("Test for find method")
	@Order(5)
	@ParameterizedTest
	@ValueSource(ints = 2)
	void test5(int id) {
		var ledger = em.find(Ledger.class, id);
		assertTrue(em.contains(ledger));
		assertNotNull(ledger);
//		assertAll(() -> {
//			assertEquals("Phone Bill", ledger.getName());
//			assertEquals("Debit", ledger.getType().name());
//		});
		
		em.detach(ledger);
		assertThrows(
				LazyInitializationException.class, 
				() -> ledger.getTags().size());
	}
	
	@Disabled
	@DisplayName("Test for get referenece")
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = 2)
	void test6(int id) {
		var ledger = em.getReference(Ledger.class, id);
		
		assertNotNull(ledger);
		
		em.detach(ledger);
		
		assertThrows(LazyInitializationException.class, 
				() -> ledger.getName());
//		assertAll(() -> {
//			assertEquals(id, ledger.getId());
//			assertEquals("Phone Bill", ledger.getName());
//			assertEquals("Debit", ledger.getType().name());
//		});
	}
	
}
