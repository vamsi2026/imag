package com.imag.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Represents an exception to be thrown when there is an error related to
 * employee operations, with an optional message describing the error.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeException extends RuntimeException {
	/**
	 * A unique identifier for the exception class, required for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance of EmployeeException with the specified error message.
	 * 
	 * @param message
	 */
	public EmployeeException(String message) {
		super(message);
	}
}
