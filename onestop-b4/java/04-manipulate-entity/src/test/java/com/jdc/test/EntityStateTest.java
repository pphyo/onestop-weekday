package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.app.entity.Address;
import com.jdc.app.entity.Student;
import com.jdc.app.entity.Student.Gender;

public class EntityStateTest extends Base {
	
	@ParameterizedTest
	@CsvSource(value = {"Morgan Freeman, Male, RedTown Street, New York"}, delimiterString = ", ")
	void test_method_two(String name, Gender gender, String street, String address) {
		
		Student stu = new Student(name, gender);
		Address add = new Address(street, address);
		stu.setAddress(add);
		
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
//		em.persist(add);
		em.persist(stu);		
		em.getTransaction().commit();
		
		var result = em.find(Student.class, 1);
		
		assertNotNull(result);
		
//		em.getTransaction().begin();
//		em.remove(result);
//		em.getTransaction().commit();
		
		em.close();
		
	}

//	@ParameterizedTest
	@CsvSource("Alice,Female")
//	@CsvFileSource(resources = "/resources.csv")
//	@Order(1)
	void tran_manage_and_detach(String name, String gender) {
		
		var em = emf.createEntityManager();
		
		// Transient or New state
		var stu = new Student(name, Gender.valueOf(gender));
		
		em.getTransaction().begin();

		em.persist(stu);
		
		em.detach(stu);
		
		stu.setName("Melissa");
		
		em.getTransaction().commit();
				
		em.close();
		
//		assertThrows(IllegalStateException.class, () -> em.contains(stu));
	}
	
}
