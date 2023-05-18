package com.jdc.func;

import java.util.function.Function;

public class DefaultInFuncInter {

	public static void main(String[] args) {
		
		Function<Integer, Integer> twice = i -> i * 2;
		Function<Integer, Integer> square = i -> i * i;

		System.out.println(twice.compose(square).apply(3));
		
	}

}
