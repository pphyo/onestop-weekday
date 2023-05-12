package com.jdc.lamb;

public class LambdaApp {

	public static void main(String[] args) {
		
		// () -> {}
		
		Flyable objFly = () -> System.out.println("Flying...");
		objFly.fly();
		
		Printable objPrint = data -> System.out.println(data);
		objPrint.print("This is data you want.");
		
		Calculable objCal = (x, y) -> x + y;
		System.out.println(objCal.calculate(21, 9));
		
		int point = 10;
		
		Scalable objScale = (int num) -> {
			System.out.println("Object is scaling at this point %d.".formatted(num + point));
		};
		
		objScale.scale(102);

	}

}
