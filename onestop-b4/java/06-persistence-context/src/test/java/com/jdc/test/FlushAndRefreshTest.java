package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.app.dto.Account;

@TestMethodOrder(OrderAnnotation.class)
class FlushAndRefreshTest {
	
	static EntityManagerFactory emf;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("pc");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}
	
	@ParameterizedTest
	@CsvSource({
		"Pyae Phyo,20000",
		"Min Khant,10000",
		"Cherry,30000"
	})
	@Order(1)
	void createAccount(String name, int amount) {
		var em = emf.createEntityManager();
		
		var account = new Account();
		account.setName(name);
		account.setAmount(amount);
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Test
	@Order(2)
	void test() {
		var t1 = new Thread(() -> {
			var em = emf.createEntityManager();
			var account = em.find(Account.class, 2);
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			em.getTransaction().begin();
			
			System.out.println("Before update t1");
			System.out.println("Balance of %s is %d.".formatted(account.getName(), account.getAmount()));
			
			account.setAmount(account.getAmount() - 5000);
			em.flush();
			
			assertTrue(em.contains(account));
			
			System.out.println("After update t1");
			System.out.println("Balance of %s is %d.".formatted(account.getName(), account.getAmount()));
			
			em.getTransaction().commit();
		});
		
		var t2 = new Thread(() -> {
			var em = emf.createEntityManager();
			var account = em.find(Account.class, 1);
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			em.getTransaction().begin();
			
			System.out.println("Before update t2");
			System.out.println("Balance of %s is %d.".formatted(account.getName(), account.getAmount()));
			
			em.refresh(account);
			
			account.setAmount(account.getAmount() + 15000);
			System.out.println("After update t2");
			System.out.println("Balance of %s is %d.".formatted(account.getName(), account.getAmount()));
			
			em.getTransaction().commit();
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

}
