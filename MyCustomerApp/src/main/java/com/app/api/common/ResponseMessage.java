package com.app.api.common;

import java.util.List;

import com.app.api.models.Customer;

/**
 * 
 * @author Rommel A. Suarez
 * This class will hold the response object back to the client
 * The information contains the Customer object and the success/failure message.
 *
 */
public class ResponseMessage {

	private List<Customer> data; //Customer object
	private String message;		 // Message response

	private String messageCode;  // Message code that indicates a failure or success

	
	/**
	 * Getter method for the customer data
	 * @return List of Customer objects
	 */
	public List<Customer> getData() {
		return data;
	}

	/**
	 * 
	 * @param List of Customer objects
	 */
	public void setData(List<Customer> data) {
		this.data = data;
	}

	/**
	 * 
	 * @return String message of the response
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param String message of the response
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return Message code that indicates if success/failure
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * 
	 * @param Set the message Code
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
	
	/**
	 * 
	 * @param ResponseMessage Object
	 * @param Response Type Enum
	 * @return populated ResponseMessage with the correct code and message based on the response type.
	 */
	public static ResponseMessage setResponseMessage(ResponseMessage message, ResponseType responseType) {
		ResponseMessage retMessage = message;
		retMessage.setMessageCode(responseType.getCode());
		retMessage.setMessage(responseType.getMessage());
		
		return retMessage;
		
	}

}
