package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityNotFoundException;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.app.entity.Category;
import com.jdc.app.entity.Product;

@TestMethodOrder(OrderAnnotation.class)
public class EntityManagerTest extends BaseTest {
	
	@Test
	@Order(7)
	void test_for_remove() {
		var em = emf.createEntityManager();
		
		var category = em.find(Category.class, 1);
		
		em.getTransaction().begin();
		em.remove(category);
		
		assertNotNull(category);
		
		assertFalse(em.contains(category));
		
//		em.persist(category);
//		assertTrue(em.contains(category));
		em.getTransaction().commit();
		
		em.close();
	}
	
	@Test
	@Order(6)
	void test_for_single_fetch_mode() {
		var em = emf.createEntityManager();
		
		var product = em.find(Product.class, 1);
		assertNotNull(product);
		assertTrue(em.contains(product));

//		em.detach(product);
		em.close();
		
		assertDoesNotThrow(() -> System.out.println(product.getId()));
//		System.out.println(product.getCategory());
		
//		assertAll(
//				() -> assertDoesNotThrow(() -> System.out.println(product.getId())),
//				() -> assertThrows(LazyInitializationException.class, product::getName),
//				() -> assertDoesNotThrow(() -> System.out.println(product.getPrice())),
//				() -> assertDoesNotThrow(() -> System.out.println(product.getSize())),
//				() -> assertDoesNotThrow(() -> System.out.println(product.getStock())),
//				() -> assertThrows(LazyInitializationException.class, product::getCategory)
//				);
		
	}
	
	@Test
	@Order(6)
	void test_for_collection_fetch_mode() {
		var em = emf.createEntityManager();
		
		var product = em.find(Product.class, 1);
		
		assertNotNull(product);
		assertTrue(em.contains(product));
		
		em.detach(product);
		
		assertThrows(LazyInitializationException.class,
				() -> product.getRemarks().forEach(System.out::println));
		
		em.close();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 10)
	@Order(5)
	void test_for_getReference_if_not_found(int id) {
		var em = emf.createEntityManager();
		
		var category = em.getReference(Category.class, id);
		
		assertNotNull(category);
		assertTrue(em.contains(category));
		
		assertAll(
					() -> assertEquals(10, category.getId()),
					() -> assertThrows(EntityNotFoundException.class, category::getName)
				);
			
		em.close();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 10)
	@Order(4)
	void test_for_find_if_not_found(int id) {
		var em = emf.createEntityManager();
		
		var category = em.find(Category.class, id);
		assertNull(category);
		assertFalse(em.contains(category));
			
		em.close();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(3)
	void test_for_getReference(int id) {
		var em = emf.createEntityManager();
		
		var category = em.getReference(Category.class, id);
		assertNotNull(category);
		assertTrue(em.contains(category));
		
		em.detach(category);
		
		assertNotNull(category);
		
		assertAll(
					() -> assertEquals(1, category.getId()),
					() -> assertThrows(LazyInitializationException.class, category::getName)
				);
		
		em.close();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(2)
	void test_for_find(int id) {
		var em = emf.createEntityManager();
		
		var category = em.find(Category.class, id);
		assertNotNull(category);
		assertTrue(em.contains(category));
		
		em.detach(category);

		assertAll(
					() -> assertEquals(1, category.getId()),
					() -> assertEquals("Foods", category.getName())
				);

		em.close();
	}
	
	@ParameterizedTest
	@ValueSource(strings = "Cosmetics")
	@Order(1)
	void test_for_persit_and_merge(String name) {
		
		var em = emf.createEntityManager();
		
		// transient or new state
		var category = new Category();
		category.setName(name);
		
		em.getTransaction().begin();
		
		assertFalse(em.contains(category));
		// manage state
		em.persist(category);
		assertTrue(em.contains(category));
		
		// detach state
		em.detach(category);
		assertFalse(em.contains(category));
		
		// manage state again
		category = em.merge(category);
		assertTrue(em.contains(category));
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
