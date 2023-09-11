package com.jdc.location.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.location.model.LocationBusinessException;
import com.jdc.location.model.LocationValidationException;
import com.jdc.location.model.dto.ErrorResponse;

@RestControllerAdvice
public class LocationApiExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationException(LocationValidationException e) {
		return ErrorResponse.validation(e);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleBusinessException(LocationBusinessException e) {
		return ErrorResponse.business(e);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handlePlatformException(Exception e) {
		e.printStackTrace();
		return ErrorResponse.platform(e);
	}
	
}
