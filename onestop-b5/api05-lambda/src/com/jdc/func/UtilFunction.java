package com.jdc.func;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UtilFunction {

	public static void main(String[] args) {
		// () -> {} ==> lambda or anonymous method
		Consumer<String> strCon = System.out::println;
		
		strCon.accept("Hello Consumer");
		
		Function<Integer, String> func = i -> String.valueOf(i);
		String str = func.apply(1000);
		System.out.println(str + 10);
		
		double num1 = 100;
		double num2 = 200;
		
		Supplier<Double> sup = () -> num1 + num2;
		double result = sup.get();
		System.out.println(result);
		
		Predicate<String> pred = data -> data.contains("jam");
		System.out.println(pred.test("Strawberry ja"));
		
		BiFunction<Integer, Integer, Double> biFunc = (a, b) -> {
			Integer i = a * b;
			return i.doubleValue();
		};
		System.out.println(biFunc.apply(10, 20));

	}

}






