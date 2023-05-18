package com.jdc.nest;

public class NestedApp {

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		outer.setOutData(10);
		
		Outer.InnerStatic innerStat = new Outer.InnerStatic();
		innerStat.setInnerStatData(20);
		System.out.println(innerStat.getInnerStatData());
		
		Outer.InnerInstance innerInst = outer.new InnerInstance();
		innerInst.setInnerInstData(30);
		System.out.println(innerInst.getInnerInstData());
		
//		Outer.InnerInstance.MoreInner moreInner = innerInst.new MoreInner();
		
//		local inner class
//		class A {}

	}

}
