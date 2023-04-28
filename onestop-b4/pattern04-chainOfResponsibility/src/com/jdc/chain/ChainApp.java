package com.jdc.chain;

public class ChainApp {

	public static void main(String[] args) {
		
		BackEndLayer back = new BackEndLayer();
		MiddleLayer middle = new MiddleLayer(back);
		FrontLayer front = new FrontLayer(middle);
		
		front.help(3);
		
	}

}
