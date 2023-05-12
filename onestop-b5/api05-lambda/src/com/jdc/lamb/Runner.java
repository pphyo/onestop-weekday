package com.jdc.lamb;

public class Runner extends SuperRunner {
	
	public Runner(int number) {
		System.out.println("Number is " + number);
	}
	
	public static void main(String[] args) {
		Runner runner = new Runner(0);
		runner.run();
		
		// static method reference
		Calculable c = AppUtil::operate;
		int result = c.calculate(30, 50);
		System.out.println(result);
		
		// constructor method reference 
		Scalable s = Runner::new;
		s.scale(30);
		
//		Printable p = runner::display;
//		p.print("This is data.");
	}
	
	public void run() {
		// instance method reference
		Printable p = super::display;
		p.print("This is data.");
	}
	
	public void display(String data) {
		System.out.println("Runner Start display()");
		System.out.println(data);
		System.out.println("Runner End display()");
	}

}
