package com.csis.giron.exceptions;

public class InvalidCollegeClassException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidCollegeClassException() {}
	
	public InvalidCollegeClassException(String message) {
		super(message);
	}
	
}