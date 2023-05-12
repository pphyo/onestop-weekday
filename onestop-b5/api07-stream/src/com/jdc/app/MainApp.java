package com.jdc.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		
		List<Student> over400Students = new ArrayList<>();
		
		for(Student stu : getStudentList()) {
			if(stu.getMarks() >= 400)
				over400Students.add(stu);
		}
		
		Collections.sort(over400Students, new StudentByMarks());
		
		List<String> names = new ArrayList<>();
		for(Student stu : over400Students) {
			names.add(stu.getName());
		}
		
		System.out.println(names);

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
