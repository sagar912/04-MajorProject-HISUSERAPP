package com.sagar.admin_module.exceptions;


public class NoUserFoundException extends RuntimeException {

	/*** **************************************Custom Exception *****************************************/
	private static final long serialVersionUID = 1L;

	public NoUserFoundException(String message) {

		super(message);
	}

}
