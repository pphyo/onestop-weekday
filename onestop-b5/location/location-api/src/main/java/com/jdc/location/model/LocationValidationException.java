package com.jdc.location.model;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final List<String> errors;
	
	public List<String> getErrors() {
		return errors;
	}
}
