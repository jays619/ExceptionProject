package com.csis.giron.exceptions;

public class InvalidRoomNumberException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidRoomNumberException() {}
	
	public InvalidRoomNumberException(String message) {
		super(message);
	}

}