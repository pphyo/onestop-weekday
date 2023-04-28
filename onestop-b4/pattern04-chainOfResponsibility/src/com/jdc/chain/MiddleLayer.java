package com.jdc.chain;

public class MiddleLayer implements ContentHelper {

	private static final int LAYER = 2;
	private ContentHelper helper;
	
	public MiddleLayer(ContentHelper helper) {
		super();
		this.helper = helper;
	}
	
	@Override
	public void help(int i) {
		if(i == LAYER) {
			System.out.println("This is middle layer");
		} else {
			helper.help(i);
		}
	}
	
}
