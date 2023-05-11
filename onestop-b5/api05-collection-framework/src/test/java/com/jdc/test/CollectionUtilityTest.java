package com.jdc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.col.Student;
import com.jdc.col.StudentByGrade;

public class CollectionUtilityTest {
	
	@ParameterizedTest
	@ValueSource(ints = 5)
	void test_for_custom_sort(int size) {
		
		var list = Arrays.asList(
						new Student("Zyan", 24, 'C'),
						new Student("Bumble", 18, 'D'),
						new Student("William", 15, 'A'),
						new Student("Scott", 20, 'B'),
						new Student("David", 17, 'D')
					);
		
		list.forEach(System.out::print);
		Collections.sort(list);
		System.out.println();
		list.forEach(System.out::print);

		Collections.sort(list, new StudentByGrade());
		System.out.println();
		list.forEach(System.out::print);
		
		var byAge = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getAge() - o1.getAge();
			}
		};		
		Collections.sort(list, byAge);
		System.out.println();
		list.forEach(System.out::print);
	}
	
	static Stream<Arguments> list() {
		return Stream.of(
					Arguments.of(
							Arrays.asList(
									new Student("Zyan", 24, 'C'),
									new Student("Bumble", 18, 'D'),
									new Student("William", 15, 'A'),
									new Student("Scott", 20, 'B'),
									new Student("David", 17, 'D')
									)
							)
				);
	}
	
	@Test
	@Disabled
	void test_for_sort() {
		var intList = new ArrayList<Integer>();
		Collections.addAll(intList, 2, 4, 6, 8, 10, 9, 7, 5, 3, 1);
		System.out.println(intList);
		Collections.sort(intList);
		System.out.println(intList);
		
		var strList = Arrays.asList("Kaboom", "Dubi", "Asta", "Harper", "Connie", "Brown");
		System.out.println(strList);
		Collections.sort(strList);
		System.out.println(strList);
		
		var charList = Arrays.asList('\u1011', '\u1000', '\u1012', '\u1001');
		System.out.println(charList);
		Collections.sort(charList);
		System.out.println(charList);
		
		var boolList = Arrays.asList(true, true, false, false, true, false);
		System.out.println(boolList);
		Collections.sort(boolList);
		System.out.println(boolList);
	}
	
	@Test
	@Disabled
	void test() {
		
		var list = new ArrayList<Integer>();
		Collections.addAll(list, 2, 4, 6, 8, 10, 9, 7, 5, 3, 1);
		
		System.out.println("Original: " + list);
		 
		Collections.reverse(list);
		
		System.out.println("Reverse: " + list);
		
		var des = new ArrayList<Integer>();
		Collections.addAll(des, null, null, null, null, null, null, null, null, null, null);
		Collections.copy(des, list);
		System.out.println("Copy: " + des);
		
		System.out.println(Collections.disjoint(Arrays.asList(100, 200, 10), list));
		
	}

}
