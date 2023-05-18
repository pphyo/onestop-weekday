package com.jdc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UsingGenericAndFuncInter {
	
	public static void main(String[] args) {
//		showStudentOver300Marks(getStudentList());
		
		showStudentWithCond(getStudentList(), s -> s.getAge() > 17);
		
	}
	
	static void showStudentWithCond(List<Student> list, Predicate<Student> pred) {
		for(Student s : list) {
			if(pred.test(s))
				System.out.println(s.getName());
		}
	}
	
	static void showStudentOver300Marks(List<Student> list) {
		for(Student s : list) {
			if(s.getMarks() > 300)
				System.out.println(s.getName());
		}
	}
	
	static void showStudentOver400Marks(List<Student> list) {
		
		for(Student s : list) {
			if(s.getMarks() > 400)
				System.out.println(s.getName());
		}
		
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
