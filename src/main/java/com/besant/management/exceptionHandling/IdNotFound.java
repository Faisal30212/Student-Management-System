package com.besant.management.exceptionHandling;

public class IdNotFound extends RuntimeException {
	public IdNotFound(String message) {
		super(message);
	}

}
