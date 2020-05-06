package com.project.assignment.articleProject.exceptions;

public class BadInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1846809748567292610L;
	private String message;
	
	public BadInputException(String message) {
		super(message);
	}
}
