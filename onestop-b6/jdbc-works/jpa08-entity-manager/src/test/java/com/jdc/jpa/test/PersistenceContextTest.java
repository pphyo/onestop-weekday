package com.jdc.jpa.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.em.entity.Account;

public class PersistenceContextTest extends AbstractTest {
	
	@Test
	void test_for_callback() {
		var acc = em.find(Account.class, 1);
		assertAll(() -> {
			assertNotNull(acc);
			assertEquals("Pyae Phyo", acc.getName());
			assertEquals(100000, acc.getAmount());
		});
		
		acc.setName("Zaw Gyi");
		acc.setAmount(300000);
		
		var newAccount = new Account();
		newAccount.setName("Ko Min Lwin");
		newAccount.setAmount(150000);
		
		em.getTransaction().begin();
		em.persist(newAccount);
		
		em.merge(acc);
		em.getTransaction().commit();
	}
	
	@Test
	@Disabled
	void test() {
		
		var opeOne = getOperationOne();
		
		var opeTwo = getOperationTwo();
		
		opeOne.start();
		opeTwo.start();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private Thread getOperationOne() {
		return new Thread(() -> {
			// find account 1
			var acc = em.find(Account.class, 1);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			em.getTransaction().begin();
			System.out.println(
					"Before opertaion 1: amount of %s is %d."
					.formatted(acc.getName(), acc.getAmount()));
			
			// plus amount 30000
			acc.setAmount(acc.getAmount() + 30000);
			em.flush();
			
			System.out.println(
					"After opertaion 1: amount of %s is %d."
					.formatted(acc.getName(), acc.getAmount()));

			em.getTransaction().commit();
		});
	}
	
	private Thread getOperationTwo() {
		return new Thread(() -> {
			// find account 1
			var acc = em.find(Account.class, 1);
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			em.getTransaction().begin();
			System.out.println(
					"Before opertaion 2: amount of %s is %d."
					.formatted(acc.getName(), acc.getAmount()));

			em.refresh(acc);
			// minus amount 50000
			acc.setAmount(acc.getAmount() - 50000);
			
			System.out.println(
					"After opertaion 2: amount of %s is %d."
					.formatted(acc.getName(), acc.getAmount()));
			
			em.getTransaction().commit();
		});
	}

}
