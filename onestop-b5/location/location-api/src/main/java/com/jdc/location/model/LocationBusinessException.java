package com.jdc.location.model;

import java.util.List;

public class LocationBusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public LocationBusinessException(String message) {
		super(message);
	}

	public List<String> getErrors() {
		return List.of(getMessage());
	}
}
