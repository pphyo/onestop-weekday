package com.jdc.location.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class ValidationResultAspect {

	@Pointcut("within(com.jdc.location.api.*Api)")
	public void apiClass() {}
	
	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void restController() {}
	
	@Pointcut("apiClass() && restController()")
	public void restControllerApi() {}
	
	@Before(value = "restControllerApi() && args(.., result)", argNames = "result")
	public void checkBindingResult(BindingResult result) {
		if(result.hasErrors()) {
			var errors = result.getFieldErrors().stream()
					.map(a -> a.getDefaultMessage()).toList();
			throw new LocationValidationException(errors);
		}
	}
}
