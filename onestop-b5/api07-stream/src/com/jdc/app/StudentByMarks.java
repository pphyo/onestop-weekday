package com.jdc.app;

import java.util.Comparator;

public class StudentByMarks implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return Integer.compare(o2.getMarks(), o1.getMarks());
	}
	
}
