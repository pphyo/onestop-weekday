package com.jdc.app;

public class EncapsuleApp {

	public static void main(String[] args) {
		
		Student stu1 = new Student();
		stu1.setName("Bob");
		stu1.setAge(-10);

		System.out.println("Name: " + stu1.getName());
		System.out.println("Age: " + stu1.getAge());
		
		
//		User user = UserFactory.withAge(10);

		
//		Student stu2 = new Student();
//	
//		System.out.println(stu1 + " : " + stu2);
//		stu1 = stu2;
//		System.out.println(stu1 + " : " + stu2);
//		
//		stu2 = null;
//		
//		System.out.println(stu1 + " : " + stu2);

	}

}
