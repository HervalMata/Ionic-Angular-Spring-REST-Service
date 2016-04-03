package com.app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 
 * @author Rommel A. Suarez
 * This class launches Spring boot server.
 *
 */
@SpringBootApplication
public class MyCustomerAppApplication {

	
	private static final Logger logger = LoggerFactory
			.getLogger(MyCustomerAppApplication.class);
	
	public static void main(String[] args) {
		logger.debug("MyCustomerAppApplication has Started");
		SpringApplication.run(MyCustomerAppApplication.class, args);
	}
}
