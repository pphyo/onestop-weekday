package com.jdc.jpa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.jdc.pk.Course;
import com.jdc.pk.Registration;
import com.jdc.pk.Student;
import com.jdc.pk.Student.Gender;

public class PkTest {
	
	@Test
	void test() {
		
		var emf = Persistence.createEntityManagerFactory("pk");
		var em = emf.createEntityManager();
		
		var course = new Course();
		course.setName("Java Basic");
		course.setPrice(300_000);
		course.setDuration(4);
		
		var student = new Student();
		student.setName("Abi");
		student.setEmail("abi@gmail.com");
		student.setGender(Gender.Male);
		
		var registration = new Registration();
		registration.setRegDate(LocalDate.now());
		registration.setRegFee(500_00);
		registration.getRegistrationPK().setCourseId(1);
		registration.getRegistrationPK().setStudentId(1);
		
		em.getTransaction().begin();
		em.persist(course);
		em.persist(student);
		em.persist(registration);
		em.getTransaction().commit();

		var cour = em.find(Course.class, 1);
		assertEquals(1, cour.getId());
		
		var stu = em.find(Student.class, 1);
		assertEquals(1, stu.getId());
		
		em.close();
		emf.close();
		
		
	}

}