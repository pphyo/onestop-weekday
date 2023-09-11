package com.jdc.location.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.location.model.LocationBusinessException;
import com.jdc.location.model.LocationValidationException;

public record ErrorResponse(
		Type type,
		List<String> errors,
		@JsonFormat(pattern = "yyyyMMdd HH:mm:ss")
		LocalDateTime time) {
	
	private ErrorResponse(Type type, List<String> errors) {
		this(type, errors, LocalDateTime.now());
	}
	
	public static ErrorResponse business(LocationBusinessException e) {
		return new ErrorResponse(Type.Business, e.getErrors());
	}

	public static ErrorResponse validation(LocationValidationException e) {
		return new ErrorResponse(Type.Validation, e.getErrors());
	}
	
	public static ErrorResponse platform(Exception e) {
		return new ErrorResponse(Type.Platform, List.of(e.getMessage()));
	}
	
	public enum Type {
		Business, Validation, Platform
	}
}
