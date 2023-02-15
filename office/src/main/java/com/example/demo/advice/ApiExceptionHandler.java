package com.example.demo.advice;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler
{
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleInvalidArgument(ConstraintViolationException e)
	{
		Map<String, String> errorMap= new HashMap<>();
		e.getConstraintViolations().forEach(error ->{
			errorMap.put(error.getPropertyPath().toString(), error.getMessage());
		} );
		System.out.println(e.getConstraintViolations());
		return errorMap;
	}
		 
	
	
}
