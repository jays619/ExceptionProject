package com.csis.giron.exceptions;

public class InvalidMeetDayException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidMeetDayException() {}
	
	public InvalidMeetDayException(String message) {
		super(message);
	}

}