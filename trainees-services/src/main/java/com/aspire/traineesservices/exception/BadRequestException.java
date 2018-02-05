package com.aspire.traineesservices.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BadRequestException(ErrorMessage errorMessage){
		super(errorMessage==null?"Bad Request":(errorMessage.getError()));
	}
}
