package com.jdc.jpa.test;

import org.junit.jupiter.api.Test;

import com.jdc.em.entity.Ledger;
import com.jdc.em.entity.Transaction;

public class CascadeTest extends AbstractTest {
	
	@Test
	void test_for_cascade() {
		var ledger = em.find(Ledger.class, 1);
		var tran = em.find(Transaction.class, 3);
		
		ledger.getTransactions().remove(tran);
		
		em.getTransaction().begin();
		em.merge(ledger);
		em.getTransaction().commit();
	}

}
