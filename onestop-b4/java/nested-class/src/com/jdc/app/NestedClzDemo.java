package com.jdc.app;

public class NestedClzDemo {

	public static void main(String[] args) {

		Outer.Nested innerStatic = new Outer.Nested("Hello Inner");
		System.out.println(innerStatic);

		Outer.Inner inner = new Outer().new Inner();
		System.out.println(inner);

//		class LocalInner {
//			
//		}

	}

}
