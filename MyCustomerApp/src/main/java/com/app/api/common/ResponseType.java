package com.app.api.common;


/**
 * 
 * @author Rommel A. Suarez
 * Represents the different response type
 */
public enum ResponseType {
	
	// Success
	SUCCESS(Constants.successCode,Constants.successMessage),
	// Record not found
	RECORD_NOT_FOUND(Constants.recordNotFoundCode,Constants.recordNotFoundMessage),
	// Internal error
	EXCEPTION_ERROR(Constants.failureCode,Constants.exceptionErrorMessage),
	// Validation Error
	VALIDATION_ERROR(Constants.failureCode,Constants.validationErrorMessage),
	// Update failure
	UPDATE_FAILURE(Constants.failureCode,Constants.updateFailure),
	// Create failure
	CREATE_FAILURE(Constants.failureCode,Constants.createFailure),
	// Delete failure
	DELETE_FAILURE(Constants.failureCode,Constants.deleteFailure);
	

	private String code; // Indicates the success/failure response
	private String message; // Message of the response 
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	// Constructor
	ResponseType(String code,String message) {
		this.code = code;
		this.message = message;
	}
	
	
}
