package com.jdc.nest;

public class Outer {

	private int outData;

	public int getOutData() {
		return outData;
	}

	public void setOutData(int outData) {
		this.outData = outData;
	}

	public class InnerInstance {
		
		private int innerInstData;
		
		public InnerInstance() {
			System.out.println(outData);
		}

		public int getInnerInstData() {
			return innerInstData;
		}

		public void setInnerInstData(int innerInstData) {
			this.innerInstData = innerInstData;
		}
		
		public class MoreInner {}

	}
	
	public static class InnerStatic {
		
		private int innerStatData;
		
		public int getInnerStatData() {
			return innerStatData;
		}

		public void setInnerStatData(int innerStatData) {
			this.innerStatData = innerStatData;
		}
		
	}

}
