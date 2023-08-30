package com.jdc.recap.test;

import java.time.LocalDate;

import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.jdc.recap.Student;
import com.jdc.recap.Teacher;

public class InheritanceRecapTest {
	
	@Test
	void test() {
		var emf = Persistence.createEntityManagerFactory("recap");
		var em = emf.createEntityManager();
		
		var student = new Student();
		student.setUsername("Callenhen");
		student.setEmail("callenhen@gmail.com");
		student.setPassword("callenhen");
		student.setRegistAt(LocalDate.now());
		student.setPhone("0938383838");
		
		var teacher = new Teacher();
		teacher.setUsername("Dumbelldoor");
		teacher.setEmail("dumbelldoor@gmail.com");
		teacher.setPassword("dumbelldoor");
		teacher.setRegistAt(LocalDate.now());
		teacher.setPhone("09292929929");
		
		em.getTransaction().begin();
		em.persist(student);
		em.persist(teacher);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
