package com.jdc.inherit;

public class InheritMain {
	
	public static void main(String[] args) {
		
//		Person p = new Person("Elon Musk");
//		p.showName(); // error
		
//		Employee emp = new Employee("David");
//		emp.showName();
//		emp.eat("Meats");
		
//		String name = emp.getName();
//		
//		System.out.println("Name: " + name);
		
//		Student stu = new Student("", 0, "");
//		
//		stu.eat("Salad");
		
		Employee zuker = new Employee("Zuker burg"); // many forms
		
//		zuker = new Student();
//		zuker = new Person("");
//		zuker.eat("Meats");
		
		showData(zuker);
		
		System.out.println(zuker.getCount());
		
//		zuker.showCount();
	}
	
	static void showData(Person per) {
//		per.eat("Meats");
	}

}







