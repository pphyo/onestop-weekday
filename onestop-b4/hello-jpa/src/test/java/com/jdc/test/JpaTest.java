package com.jdc.test;

import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.jdc.app.entity.Authority;
import com.jdc.app.entity.User;
import com.jdc.app.entity.User.Gender;

class JpaTest {

	@Test
	void test() {
		var emf = Persistence.createEntityManagerFactory("hello-jpa");
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		User user = new User();
		user.setGender(Gender.Male);
		
		em.persist(user);
		System.out.println("User id is %d.".formatted(user.getId()));
		
		Authority auth = new Authority();
		auth.setAccessLevel("Admin");
		
		em.persist(auth);
		
		User user2 = new User();
		user2.setGender(Gender.Female);
		
		em.persist(user2);
		
		Authority auth2 = new Authority();
		auth2.setAccessLevel("Manager");
		
		em.persist(auth2);
		
		System.out.println("Authority id is %d.".formatted(auth.getId()));
		System.out.println("User 2 id is %d.".formatted(user2.getId()));
		System.out.println("Authority 2 id is %d.".formatted(auth2.getId()));
		
		em.getTransaction().commit();

	
		em.close();
		emf.close();
	}

}
