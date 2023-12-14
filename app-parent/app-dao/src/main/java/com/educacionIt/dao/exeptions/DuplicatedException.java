package com.educacionIt.dao.exeptions;

public class DuplicatedException extends Exception{
	public DuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}
}
