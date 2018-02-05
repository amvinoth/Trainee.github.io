package com.aspire.traineesservices.exception;

import com.aspire.traineesservices.exception.Error;

public class ErrorMessage {

	private String errorMessage;
	public String getError() {
		// TODO Auto-generated method stub
		return this.errorMessage;
	}

	public void addError(Error error) {
		
		this.errorMessage=error.getErrorMessage();
	}

}
