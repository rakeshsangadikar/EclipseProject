package com.cg.exception;

public class EmployeeException extends Exception {
	
	String message;
	
	public EmployeeException(String msg){
		message = msg;
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}

}
