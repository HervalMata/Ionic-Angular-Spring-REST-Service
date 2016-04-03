package com.app.api.common;


/**
 * 
 * @author Rommel A. Suarez
 * This interface contains the constant variables shared within the project.
 *
 */
public interface Constants {
	
	public static  String successCode ="1"; // Code that indicates a success response
	public static  String failureCode ="0"; // Code that indicates a failure response
	public static  String recordNotFoundCode ="2"; // Code that indicates a failure response
	
	
	// message that indicates a success response
	public static  String successMessage ="Sucess"; 
	
	// message that indicates an internal error in the system
	public static  String exceptionErrorMessage ="An error was encountered in the system.";
	
	// message that indicates a validation error in the system
	public static  String validationErrorMessage ="Some of the field values you entered are invalid or empty.";
	
	// message that indicates that a  record is not found in the system
	public static  String recordNotFoundMessage ="Record not found";
	
	// message that indicates an update failure in the system
	public static  String updateFailure ="Update of record not successful";
	
	// message that indicates a creation of record failure in the system
	public static  String createFailure ="Saving of record not successful";
	
	// message that indicates a creation of record failure in the system
	public static  String deleteFailure ="Deletion of record not successful";
		

}
