package com.jdc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.app.entity.Order;
import com.jdc.app.entity.OrderPK;
import com.jdc.app.entity.Product;
import com.jdc.app.entity.Product.PriceType;

class CollectionMappingTest {
	
	static EntityManagerFactory emf;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("cm");
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

	@Test
	void test() {
		em.getTransaction().begin();
		
		List<String> categories = new ArrayList<>();
		Collections.addAll(categories, "Fashion", "Shirt", "Men Wear");
		
		Map<PriceType, Integer> prices = new HashMap<>();
		prices.put(PriceType.Retial, 25000);
		prices.put(PriceType.Wholesale, 23000);
		prices.put(PriceType.Agent, 20000);
		
		Set<String> tags = new HashSet<>();
		Collections.addAll(tags, "Lines", "Indigo", "Sweater");
		
		Product p = new Product();
		p.setName("D2 Shirt");
		p.setCategories(categories);
		p.setPrices(prices);
		p.setTags(tags);
		
		em.persist(p);
		
		em.getTransaction().commit();
	}

	@Test
	void test_for_composite_primary_key() {
		em.getTransaction().begin();
		
		OrderPK id = new OrderPK();
		id.setOrderDate(new Date());
		
		Order order = new Order();
		order.setId(id);
		order.setSubTotal(20000);
		order.setTax(0.2f);
		order.setDiscount(2000);
		order.setTotal(order.getTotal());
		order.setGrade('A');
		order.setStock(true);
		
		em.persist(order);
		
		em.getTransaction().commit();
	}
	
}







