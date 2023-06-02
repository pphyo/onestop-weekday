package com.jdc.balance.api.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.ErrorResult;
import com.jdc.balance.model.dto.ErrorResult.ErrorType;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class BalanceApiExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	ErrorResult handle(BalanceApiException exception) {
		return new ErrorResult(exception.getType(), exception.getMessages());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	ErrorResult handle(ConstraintViolationException exception) {
		var messages = exception.getConstraintViolations()
								.stream()
								.map(c -> c.getMessage())
								.toList();
		return new ErrorResult(ErrorType.Validation, messages);
	}
	
}





