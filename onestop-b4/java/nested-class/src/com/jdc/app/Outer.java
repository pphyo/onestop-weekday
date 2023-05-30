package com.jdc.app;

public class Outer {
	
	public class Inner {
		public Inner() {}
	}
	
	public static class Nested {
		private String data;

		public Nested(String data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return data;
		}
		
	}

}
