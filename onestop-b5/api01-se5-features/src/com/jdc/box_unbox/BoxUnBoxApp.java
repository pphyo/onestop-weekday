package com.jdc.box_unbox;

public class BoxUnBoxApp {

	@SuppressWarnings({"unused", "removal"})
	public static void main(String[] args) {
		
		Byte wrapperByte = new Byte("0");
		byte priByte = 0;
		
		Short wrapperShort = new Short("0");
		short priShort = 0;
		
		Integer wrapperInt = new Integer("0");
		int priInt = 0;
		
		Long wrapperLong = new Long("0");
		long priLong = 0;
		
//		wrapperInt = priShort; // error
		
		priInt = wrapperInt;

	}

}
