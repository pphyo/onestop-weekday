package com.jdc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UsingStreamApi {

	public static void main(String[] args) {
		
		Stream<Student> stream = getStudentList().stream();
		
		stream.filter(s -> s.getMarks() >= 400)
		 .sorted((a, b) -> Integer.compare(b.getMarks(), a.getMarks()))
		 .map(s -> s.getName()).forEach(System.out::println);
		
		stream.forEach(System.out::println);
		
		
	}

	static List<Student> getStudentList() {

		List<Student> result = new ArrayList<>();

		result.add(new Student("Zack", 18, 420));
		result.add(new Student("Scott", 17, 390));
		result.add(new Student("Bob", 16, 450));
		result.add(new Student("Henery", 20, 270));
		result.add(new Student("Tom", 19, 483));
		result.add(new Student("William", 14, 412));
		result.add(new Student("Baby", 20, 300));

		return result;
	}

}
