package com.jdc.balance.model.dto;

import java.util.List;

public record ErrorResult(
		ErrorType type,
		List<String> message
		) {

	public enum ErrorType {
		Validation, Business, Platform
	}
	
}
