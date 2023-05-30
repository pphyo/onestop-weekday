package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.Query;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.app.model.dto.Category;

@TestMethodOrder(OrderAnnotation.class)
public class JpqlTest extends AbstractTest {
	
	@Test
	@Order(1)
	void test_for_query() {
		String jpql = "select c from Category c where c.id = 1";
		
		Query query = em.createQuery(jpql);
		
		var result = query.getSingleResult();
		
		assertEquals(1, ((Category)result).getId());
	}
	
	@Test
	@Order(2)
	void test_for_type_query() {
		String jpql = "select c from Category c where id > :id";
		
		var query = em.createQuery(jpql, Category.class);
		query.setParameter("id", 1);
		
		var result = query.getResultList();
		
		assertEquals(2, result.size());
	}
	
	@Test
	@Order(3)
	void test_for_insert_with_query() {
		String jpql = "insert into category (name) values (?)";
		
		var query = em.createNativeQuery(jpql);
		query.setParameter(1, "Fashion");
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		
	}

	@Test
	@Order(4)
	void test_for_delete_with_query() {
		String jpql = "delete from category where id = ?";
		
		var query = em.createNativeQuery(jpql);
		query.setParameter(1, 4);
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(5)
	void test_for_named_query() {
		var query = em.createNamedQuery("Category.getOne", Category.class);
		query.setParameter("id", 3);
		var result = query.getSingleResult();
		
		assertAll(() -> {
			assertNotNull(result);
			assertEquals(3, result.getId());
			assertEquals("Mobiles", result.getName());
		});
	}
	
	@Test
	@Order(6)
	void test_for_required_type() {
		String jpql = "select c.name from Category c";
		var query = em.createQuery(jpql, String.class);
		assertEquals("Mobiles", query.getResultList().get(2));
	}
	
	@Test
	@Order(7)
	void test_for_member_of_operator() {
		String jpql = "select count(p) from Product p where :remark member of p.remarks";
		var query = em.createQuery(jpql, Long.class);
		var result = query.setParameter("remark", "Black");
		assertEquals(1, result.getSingleResult());
	}
}




