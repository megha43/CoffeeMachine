package main.exceptions;

public class InsuficientException extends RuntimeException {

	/*
	 * Brief example of custom exception
	 */
	public InsuficientException(String string) {
		super(string);
	}	
}
