package com.jdc.single;

public class SingaletonApp {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		System.out.printf("%s%n%s%n%s%n", s1, s2, s3);
		System.out.println("s1 == s2: " + (s1 == s2));
		System.out.println("s1 == s3: " + (s1 == s3));
		System.out.println("s1.equals(s3): " + s1.equals(s3));
		
		Customer c1 = new Customer("Dee", "dee@gmail.com", "093828282", "Yangon");
		Customer c2 = new Customer("Dee", "dee@gmail.com", "093828282", "Yangon");

		System.out.printf("%s%n%s%n", c1, c2);
		System.out.println("c1 == c2: " + (c1 == c2));
		System.out.println("c1.equals(c2): " + c1.equals(c2));
		
		Repository repo1 = Repository.getRepo();
		Repository repo2 = Repository.getRepo();
		Repository repo3 = Repository.getRepo();
		Repository repo4 = Repository.getRepo();
		
		System.out.printf("%s%n%s%n%s%n%s%n", repo1, repo2, repo3, repo4);
		
	}

}








