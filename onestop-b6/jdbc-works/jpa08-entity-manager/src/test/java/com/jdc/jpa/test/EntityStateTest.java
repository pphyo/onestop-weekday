package com.jdc.jpa.test;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.em.entity.Ledger;
import com.jdc.em.entity.Ledger.LedgerType;
import com.jdc.em.entity.Transaction;

@TestMethodOrder(OrderAnnotation.class)
public class EntityStateTest extends AbstractTest {
	
	@DisplayName("Test for cascade operations")
	@Order(1)
	@ParameterizedTest
	@CsvSource(value = {
			"Refund	Credit	2023-02-22	Pyae Phyo",
			"Beauty	Debit	2023-05-10	Cherry",
			"Health	Debit	2023-07-20	Min Khant Thu",
			"Rental	Credit	2022-08-10	Min Lwin"
	}, delimiter = '\t'
	)
	void test1(String name, LedgerType type, LocalDate issuedDate, String issuedUser) {
		
		var ledger = new Ledger(name, type);
		
		var tran = new Transaction();
		tran.setIssuedDate(issuedDate);
		tran.setIssuedUser(issuedUser);
		
		ledger.addTransaction(tran);
		
		em.getTransaction().begin();
		em.persist(ledger);
		em.getTransaction().commit();
		
	}
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 3)
	void test_for_remove(int id) {
		var ledger3 = em.find(Ledger.class, id);
		
		var tx = em.getTransaction();
		
		tx.begin();
		
		ledger3.getTransactions().stream().forEach(t -> t.setLedger(null));
		
		em.remove(ledger3);
		
		tx.commit();
		
	}

}






