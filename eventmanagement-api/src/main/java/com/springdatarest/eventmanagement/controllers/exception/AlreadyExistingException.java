package com.springdatarest.eventmanagement.controllers.exception;

public class AlreadyExistingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistingException(String email)
	{
		System.out.println("Participant with "+email+" already checkedIn");
	}
	
}
