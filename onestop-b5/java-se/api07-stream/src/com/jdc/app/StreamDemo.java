package com.jdc.app;

import java.util.Arrays;

public class StreamDemo {
	
	public static void main(String[] args) {
		
		Integer[] arr = {5, 2, 4, 5, 8, 7, 6, 9, 1, 5};
		
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		var result = Arrays.stream(arr)
			  .distinct()
//			  .peek(i -> System.out.println(i))
			  .filter(i -> i > 3)
			  .sorted((a, b) -> Integer.compare(b, a))
//			  .mapToInt((Integer i) -> i.intValue())
			  .mapToInt(i -> i)
			  .skip(2)
			  .limit(3)
			  .summaryStatistics();
		
		System.out.println(result);
		
	}

}
