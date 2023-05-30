package com.jdc.single;

public class Repository {

	private static Repository REPO;
	
	private Repository() {}
	
	public static Repository getRepo() {
		if(null == REPO)
			REPO = new Repository();
		return REPO;
	}
}
