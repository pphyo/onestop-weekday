package com.jdc.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.app.model.dto.DtoForAll;
import com.jdc.app.model.dto.Product;

@TestMethodOrder(OrderAnnotation.class)
public class JpqlJoinTest extends AbstractTest {
	
	@Test
	@Order(1)
	void test_for_default_join() {
		var product = em.find(Product.class, 1);
		System.out.println(product);
	}
	
	@Test
	@Order(2)
	void test_for_jpql_join_to_one() {
		String jpql = "select p.name from Product p join p.category c";
		
		var query = em.createQuery(jpql, String.class);
		
		var result = query.getResultList();
		
		System.out.println(result);
				
	}

	@Test
	@Order(3)
	void test_for_jpql_join_to_many() {
		String jpql = """
				select count(s.name) from Supplier s join s.products p where lower(s.name) like lower(:name)""";
		
		var query = em.createQuery(jpql, Long.class);
		query.setParameter("name", "196".concat("%"));
		query.getResultStream().forEach(System.out::println);
	}
	
	@Test
	@Order(4)
	void test_for_jpql_projection() {
		String jpql = """
				select new com.jdc.app.model.dto.DtoForAll(s.name, s.phone, s.email, p.name, c.name) 
				from Supplier s join s.products p join p.category c""";
		
		var query = em.createQuery(jpql, DtoForAll.class);
		query.getResultList().stream().forEach(obj -> System.out.println(obj.catName()));
	}

}




