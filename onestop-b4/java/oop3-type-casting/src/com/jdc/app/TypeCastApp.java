package com.jdc.app;

public class TypeCastApp {

	public static void main(String[] args) {
		
//		UniversalStudent person = new UniversalStudent(); // Upcasting or Implicit
//		
//		person.study();
//		
//		Programmer prog = (Programmer)person; // Downcasting or Explicit
//		
//		prog.selfStudy();
		
		castObj(new Programmer());
		
	}
	
	// instanceof
	static void castObj(Person p) {
		
		System.out.println(p instanceof Programmer);
		
		if(p instanceof Programmer prog) {
			prog.selfStudy();
		}
		
//		if(p instanceof Programmer) {
//			Programmer prog = (Programmer)p;
//			prog.selfStudy();
//		}
//		((Programmer)p).selfStudy();
		
	}

}







