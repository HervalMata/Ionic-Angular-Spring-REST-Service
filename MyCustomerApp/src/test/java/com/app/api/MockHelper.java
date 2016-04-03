package com.app.api;

import java.util.ArrayList;
import java.util.List;

import com.app.api.common.ResponseMessage;
import com.app.api.common.ResponseType;
import com.app.api.models.Customer;

public class MockHelper {
		public static List<Customer> getAllCustomerMockData() {

			// create a customer
			Customer customer1 = new Customer();
			customer1.setId(1);
			customer1.setName("Test Name");
			customer1.setAddress("Test Address");
			customer1.setPhoneNumber("123456");

			// create a customer
			Customer customer2 = new Customer();
			customer2.setId(2);
			customer2.setName("Test Name");
			customer2.setAddress("Test Address");
			customer2.setPhoneNumber("123456");

			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customer1);
			customers.add(customer2);

			return customers;

		}

		public static ResponseMessage getResponseMockData(ResponseType responseType) {

			// create a customer
			Customer customer = new Customer();
			customer.setName("Test Name");
			customer.setAddress("Test Address");
			customer.setPhoneNumber("123456");

			// create a responseMessage

			ResponseMessage responseMessage = new ResponseMessage();

			responseMessage = ResponseMessage.setResponseMessage(responseMessage, responseType);

			return responseMessage;

		}

		public static Customer getEntityMockData() {
			// create a customer
			Customer customer = new Customer();
			customer.setId(1);
			customer.setName("Test Name");
			customer.setAddress("Test Address");
			customer.setPhoneNumber("123456");
			return customer;

		}

}
