package com.jdc.app;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationDemo {

	public static void main(String[] args) {
		
		var app = new TerminalOperationDemo();
		app.onRun();

	}
	
	void onRun() {
		var stm = Stream.ofNullable(null);
		
		stm.forEach(System.out::println);
	}
	
	void collector() {
		var list = Arrays.asList(5, 2, 4, 5, 8, 7, 6, 9, 1, 5);
		
		var result = list.stream() //.filter(i -> !isEven(i))
					 .sorted()
//					 .map(i -> String.valueOf(i))
					 .collect(Collectors.partitioningBy(this::isEven));
		
		System.out.println(result);
		
	}
	
	private boolean isEven(int num) {
		return num % 2 == 0;
	}
	
	static void iteration() {
		
		var list = Arrays.asList(5, 2, 4, 5, 8, 7, 6, 9, 1, 5);
		
		list.parallelStream().forEachOrdered(i -> System.out.print(i + " "));
		
	}
	
	static void checking() {
		
		var list = Arrays.asList(5, 2, 4, 5, 8, 7, 6, 9, 1, 5);
		
		var result = list.stream()
						 .noneMatch(i -> i < 0);
		
		System.out.println(result);
		
	}
	
	static void getResult() {
		var list = Arrays.asList(5, 2, 4, 5, 8, 7, 6, 9, 1, 5);
		
		list.stream().sorted().takeWhile(i -> i % 2 != 0).forEach(System.out::println);
		
//		System.out.println(result);
	}

}
