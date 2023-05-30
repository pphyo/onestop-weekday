package com.jdc.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.app.entity.Address;
import com.jdc.app.entity.Course;
import com.jdc.app.entity.Student;
import com.jdc.app.entity.Student.Gender;

public class LifeCycleCallbackTest extends Base {

	
	@ParameterizedTest
	@CsvSource("John Wick,Male,Love Lane,Washintong")
	void test1(String name, Gender gender, String street, String address) {
		
		var add = new Address(street, address);
		var stu = new Student(name, gender);
		stu.setAddress(add);
		
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(stu);
		em.getTransaction().commit();
		
		em.close();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test2(int id) {
		var em = emf.createEntityManager();
		
		var stu = em.find(Student.class, id);
		
		em.getTransaction().begin();
		
		stu.setName("Arkar Mg");
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	@ParameterizedTest
	@CsvSource("One Stop,750000,6")
	void test3(String name, int fees, int duration) {
		var em = emf.createEntityManager();
		
		var course = new Course(name, fees, duration);
		
		em.getTransaction().begin();
		em.persist(course);
		
		course.setDuration(8);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
