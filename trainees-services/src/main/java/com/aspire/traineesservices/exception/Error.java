package com.aspire.traineesservices.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Error {
	
	private static final Logger logger = Logger.getLogger(Error.class.getName()); 
	private String errorMessage = "";
	private String errorField;
	public Error() {

	}

	public Error(String storageError) {
		logger.log(Level.WARNING, "Error"+storageError);
		this.errorMessage = storageError;
	}

	public Error(String defaultMessage, String field) {
		logger.log(Level.WARNING, "Error on the fields are"+defaultMessage+"-"+field);
		this.errorField = field;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorField() {
		return errorField;
	}

	public void setErrorField(String errorField) {
		this.errorField = errorField;
	}

}
