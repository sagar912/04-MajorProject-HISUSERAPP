package com.sagar.admin_module.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	//===================  Global Exception Handlers=======================================//
	@ExceptionHandler(value=NoUserFoundException.class)
	public String handleNoSSNException() {
		
	
	//	ErrorDetails errorDetails =new ErrorDetails(404,"NoSSNFoundException",new Date());
		String msg="NO SSN Found";
		
		return  msg;
	}
}
