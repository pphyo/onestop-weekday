package com.jdc.balance.model;

import java.util.List;

import org.springframework.validation.FieldError;

import com.jdc.balance.model.dto.ErrorResult.ErrorType;

public class BalanceApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorType type;
	public List<String> messages;
	
	public BalanceApiException(List<FieldError> errors) {
		type = ErrorType.Validation;
		messages = errors.stream().map(FieldError::getDefaultMessage).toList();
	}
	
	public BalanceApiException(String message) {
		type = ErrorType.Business;
		messages = List.of(message);
	}

	public BalanceApiException(ErrorType type, List<String> messages) {
		super();
		this.type = type;
		this.messages = messages;
	}

	public ErrorType getType() {
		return type;
	}

	public List<String> getMessages() {
		return messages;
	}

}
