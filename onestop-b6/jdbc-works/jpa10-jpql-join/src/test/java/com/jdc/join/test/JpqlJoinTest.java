package com.jdc.join.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.join.entity.Category;
import com.jdc.join.entity.NamesDto;
import com.jdc.join.entity.Product;
import com.jdc.join.entity.SupplierWithProductDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpqlJoinTest {
	
	static EntityManagerFactory emf;
	EntityManager em;
	
	@Test
	@Disabled
	void test_for_to_one_join() {
		String jqpl = """
				select p from Product p where p.category.name = 'Drinks'""";
		
		var query = em.createQuery(jqpl, Product.class);
		
		query.getResultStream().map(Product::getName).forEach(System.out::println);
		
	}
	
	@Test
	@Disabled
	void test_for_to_many_join() {
		String jpql = """
				select p from Product p join p.suppliers s
				where s.name = '196 Store'
				""";
		
		var query = em.createQuery(jpql, Product.class);
		
		query.getResultStream()
				.map(Product::getName)
				.forEach(System.out::println);
	}
	
	@Test
	@Disabled
	void test_for_all_join() {
		String jpql = """
				select c from Supplier s join s.products p 
				join p.category c group by c.id
				""";
		var query = em.createQuery(jpql, Category.class);
		
		query.getResultStream().map(Category::getName)
				.forEach(System.out::println);
	}
	
	@Test
	void test_for_projection() {
		String jpql = """
				select NEW com.jdc.join.entity.NamesDto(s.name, c.name, p.name) from Supplier s join s.products p 
				join p.category c 
				""";
		
		var query = em.createQuery(jpql, NamesDto.class);
		
		query.getResultStream().forEach(System.out::println);
	}
	
	@Test
	void test_for_supplier_with_product() {
		String jpql = """
				select NEW com.jdc.join.entity.SupplierWithProductDto(s.name, s.email, s.phone, p.name)
				from Supplier s join s.products p where lower(s.name) like lower(:supName)
				""";
		
		var query = em.createQuery(jpql, SupplierWithProductDto.class);
		query.setParameter("supName", "%star%");
		
		query.getResultStream().forEach(System.out::println);
	}
	
	@BeforeAll
	static void setUpBeforeClass() {
		emf = Persistence.createEntityManagerFactory("jpql-join");
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
