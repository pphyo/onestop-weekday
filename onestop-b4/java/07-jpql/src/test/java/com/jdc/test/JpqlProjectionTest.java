package com.jdc.test;

import org.junit.jupiter.api.Test;

import com.jdc.app.model.dto.SaleOrderCountbyProduct;

public class JpqlProjectionTest extends AbstractTest {

	@Test
	void test() {
		String jpql = """
				select new com.jdc.app.model.dto.SaleOrderCountbyProduct(s.name, so.product.name, sum(so))
				from SALE_ORDER so join so.product.suppliers s
				group by s.name, so.product.name order by so.product.name desc
				""";
		
		var query = em.createQuery(jpql, SaleOrderCountbyProduct.class);
		
		query.getResultList().stream().forEach(System.out::println);
	}
	
}
