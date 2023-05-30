package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.app.entity.Address;
import com.jdc.app.entity.Student;
import com.jdc.app.entity.Student.Gender;

@TestMethodOrder(MethodOrderer.class)
public class FindEntityTest extends Base {

	EntityManager em = emf.createEntityManager();
	
	@ParameterizedTest
	@CsvSource("John Wick,Male,Love Lane,Washintong")
	@Order(1)
	void insert(String name, Gender gender, String street, String address) {
		
		var add = new Address(street, address);
		var stu = new Student(name, gender);
		stu.setAddress(add);
		
		em.getTransaction().begin();
		
		em.persist(stu);
		
		em.getTransaction().commit();
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(2)
	void test_for_find(int id) {
		em.getTransaction().begin();

		var student = em.find(Address.class, id);
		
		assertTrue(em.contains(student));
		assertEquals(id, student.getId());
			
		em.detach(student);

		em.getTransaction().commit();
		
		assertNotNull(student);

	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(3)
	void test_for_reference(int id) {
		var result = em.getReference(Address.class, 1);
		
		em.getTransaction().begin();
		
		em.detach(result);
		
		System.out.println(result.getAddress());
		
		em.getTransaction().commit();
	}

}









