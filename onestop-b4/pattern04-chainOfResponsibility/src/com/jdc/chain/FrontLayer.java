package com.jdc.chain;

public class FrontLayer implements ContentHelper {

	private static final int LAYER = 1;
	private ContentHelper helper;

	public FrontLayer(ContentHelper helper) {
		super();
		this.helper = helper;
	}
	
	@Override
	public void help(int i) {
		if(i == LAYER) {
			System.out.println("This is Front Layer.");
		} else {
			helper.help(i);
		}
	}

}
