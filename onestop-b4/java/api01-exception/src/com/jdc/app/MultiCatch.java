package com.jdc.app;

public class MultiCatch {

	public static void main(String[] args) {
		
//		var exce = new IllegalArgumentException("Error Occured");
//		
//		try {
////			String str = null;
//			System.out.println(3 / 0);
//			
//		} catch (NullPointerException | ArithmeticException | ClassCastException e) {
//			throw exce;
//		}
		
		try {
			checkConnection(1);
		} catch (AppException e) {
			System.out.println(e.getMessage());
		}

	}
	
	static void checkConnection(int code) {
		if(code == 0)
			throw new AppException("Not connected");
		else if(code == 1)
			throw new AppException("Connecting...");
		else
			throw new AppException("Connected.");
	}

}



