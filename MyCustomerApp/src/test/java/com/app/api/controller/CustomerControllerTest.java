package com.app.api.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.api.AbstractControllerTest;
import com.app.api.MockHelper;
import com.app.api.Service.CustomerService;
import com.app.api.common.ResponseMessage;
import com.app.api.common.ResponseType;
import com.app.api.models.Customer;


/**
 * 
 * @author Rommel A. Suarez
 * This class test the CustomerController HTTP response content and status
 */
@Transactional
public class CustomerControllerTest extends AbstractControllerTest {

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private CustomerController customerController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		setup(customerController);

	}

	/**
	 * Test addCustomer API when creation of customer succeeds 
	 * @throws Exception
	 */
	@Test
	public void createCustomer() throws Exception {
		// create test data
		ResponseMessage expectedResponse = MockHelper.getResponseMockData(ResponseType.SUCCESS);

		when(customerService.saveCustomer(any(Customer.class))).thenReturn(MockHelper.getEntityMockData());

		// declare and assign URI of the REST api
		String uri = "/addCustomer";

		// Convert customer entity to JSON as the request
		String input = super.mapToJSON(MockHelper.getEntityMockData());

		// Invoke the request
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(input)).andReturn();

		// Extract the response and status
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// verify that the service call is invoked
		verify(customerService, times(1)).saveCustomer(any(Customer.class));

		// convert the content response to response message object for proper
		// assetion
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);

		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);

		Assert.assertTrue("Failed-- Response message shouls not be null", contentResponse != null);
		Assert.assertTrue("Failed-- Response message code should be successful",
				contentResponse.getMessageCode().equals(expectedResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be successful",
				contentResponse.getMessage().equals(expectedResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should not be empty ", contentResponse.getData().size() > 0);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0) != null);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0).getId() != null);

	}

	
	/**
	 * Test addCustomer API when creation of customer failed 
	 * @throws Exception
	 */
	@Test
	public void createCustomerFailed() throws Exception {
		// create test data
		ResponseMessage expectedResponse = MockHelper.getResponseMockData(ResponseType.CREATE_FAILURE);

		when(customerService.saveCustomer(any(Customer.class))).thenReturn(null);

		// declare and assign URI of the REST api
		String uri = "/addCustomer";

		// Convert customer entity to JSON as the request
		String input = super.mapToJSON(MockHelper.getEntityMockData());

		// Invoke the request
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(input)).andReturn();

		// Extract the response and status
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// verify that the service call is invoked
		verify(customerService, times(1)).saveCustomer(any(Customer.class));

		// convert the content response to response message object for proper
		// assetion
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);

		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);
		Assert.assertTrue("Failed-- Response message shouls not be null", contentResponse != null);
		
		Assert.assertTrue("Failed-- Response message code should be create failure",
				contentResponse.getMessageCode().equals(expectedResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be should be create failure",
				contentResponse.getMessage().equals(expectedResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data be empty ", contentResponse.getData() == null);
		

	}
	
	
	/**
	 * Test editCustomer API when update of customer succeeds 
	 * @throws Exception
	 */
	@Test
	public void upateCustomer() throws Exception {
		// create test data
		ResponseMessage expectedResponse = MockHelper.getResponseMockData(ResponseType.SUCCESS);

		when(customerService.saveCustomer(any(Customer.class))).thenReturn(MockHelper.getEntityMockData());

		// declare and assign URI of the REST api
		String uri = "/editCustomer";

		// Convert customer entity to JSON as the request
		String input = super.mapToJSON(MockHelper.getEntityMockData());

		// Invoke the request
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(input)).andReturn();

		// Extract the response and status
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// verify that the service call is invoked
		verify(customerService, times(1)).saveCustomer(any(Customer.class));

		// convert the content response to response message object for proper
		// assetion
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);

		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);

		Assert.assertTrue("Failed-- Response message shouls not be null", contentResponse != null);
		Assert.assertTrue("Failed-- Response message code should be successful",
				contentResponse.getMessageCode().equals(expectedResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be successful",
				contentResponse.getMessage().equals(expectedResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should not be empty ", contentResponse.getData().size() > 0);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0) != null);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0).getId() != null);
	}

	
	/**
	 * Test editCustomer API when update of customer failed 
	 * @throws Exception
	 */
	@Test
	public void upateCustomerFailed() throws Exception {
		// create test data
		ResponseMessage expectedResponse = MockHelper.getResponseMockData(ResponseType.UPDATE_FAILURE);
		when(customerService.saveCustomer(any(Customer.class))).thenReturn(null);

		// declare and assign URI of the REST api
		String uri = "/editCustomer";

		// Convert customer entity to JSON as the request
		String input = super.mapToJSON(MockHelper.getEntityMockData());

		// Invoke the request
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(input)).andReturn();

		// Extract the response and status
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// verify that the service call is invoked
		verify(customerService, times(1)).saveCustomer(any(Customer.class));

		// convert the content response to response message object for proper
		// assetion
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);

		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);
		Assert.assertTrue("Failed-- Response message shouls not be null", contentResponse != null);
		
		Assert.assertTrue("Failed-- Response message code should be update failure",
				contentResponse.getMessageCode().equals(expectedResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be should be update failure",
				contentResponse.getMessage().equals(expectedResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data be empty ", contentResponse.getData() == null);
		
	}

	
	/**
	 * Test getCustomer API when retrieval of customer succeeds 
	 * @throws Exception
	 */
	@Test
	public void getCustomer() throws Exception {

		// create test data
		ResponseMessage expectdResponse = MockHelper.getResponseMockData(ResponseType.SUCCESS);

		Customer customer = MockHelper.getEntityMockData();
		when(customerService.getCustomer(any(Integer.class))).thenReturn(customer);

		String uri = "/getCustomer/?id=1";
		//String input = super.mapToJSON(new Integer(1));

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		// Extract the response and status

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// convert the content response to response message object for proper
		// assetion
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);

		verify(customerService, times(1)).getCustomer(any(Integer.class));

		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);

		Assert.assertTrue("Failed-- Response message shouls not be null", contentResponse != null);
		Assert.assertTrue("Failed-- Response message code should be successful",
				contentResponse.getMessageCode().equals(expectdResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be successful",
				contentResponse.getMessage().equals(expectdResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should not be empty ", contentResponse.getData().size() > 0);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0) != null);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0).getId() != null);

	}
	
	/**
	 * Test getCustomer API when retrieval of customer failed 
	 * @throws Exception
	 */
	@Test
	public void customerNotFound() throws Exception {
		// create test data
		ResponseMessage expectdResponse = MockHelper.getResponseMockData(ResponseType.RECORD_NOT_FOUND);

		when(customerService.getCustomer(any(Integer.class))).thenReturn(null);

		String uri = "/getCustomer/?id=1";


		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		// Extract the response and status

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// convert the content response to response message object for proper
		// assetion
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);

		verify(customerService, times(1)).getCustomer(any(Integer.class));

		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);

		Assert.assertTrue("Failed-- Response message should not be null", contentResponse != null);
		Assert.assertTrue("Failed-- Response message code should be record not found",
				contentResponse.getMessageCode().equals(expectdResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be record not found",
				contentResponse.getMessage().equals(expectdResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should be empty ", contentResponse.getData() == null);
		

	}


	/**
	 * Test getAllCustomers API when retrieval of customer succeeds 
	 * @throws Exception
	 */
	@Test
	public void getAllCustomers() throws Exception {
		// create test data
		ResponseMessage expectdResponse = MockHelper.getResponseMockData(ResponseType.SUCCESS);
		
		List<Customer> customers = MockHelper.getAllCustomerMockData();
		when(customerService.getAllCustomer()).thenReturn(customers);

		String uri = "/getAllCustomers";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		// Extract the response and status

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		verify(customerService, times(1)).getAllCustomer();

		
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);
		
		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);
		
		Assert.assertTrue("Failed-- Response message code should be successful",
				contentResponse.getMessageCode().equals(expectdResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be successful",
				contentResponse.getMessage().equals(expectdResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should not be empty ", contentResponse.getData().size() > 0);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0) != null);
		Assert.assertTrue("Failed-- Response message data should not be null ",
				contentResponse.getData().get(0).getId() != null);


	}
	
	/**
	 * Test getAllCustomers API when retrieval of customer failed 
	 * @throws Exception
	 */
	@Test
	public void EmptyCustomersFound() throws Exception {
		// create test data
		ResponseMessage expectdResponse = MockHelper.getResponseMockData(ResponseType.RECORD_NOT_FOUND);
		
		when(customerService.getAllCustomer()).thenReturn(null);

		String uri = "/getAllCustomers";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		// Extract the response and status

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		verify(customerService, times(1)).getAllCustomer();

		
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);
		logger.info("content ===>> " + content);
		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);

		Assert.assertTrue("Failed-- Response message should not be null", contentResponse != null);
		Assert.assertTrue("Failed-- Response message code should be record not found",
				contentResponse.getMessageCode().equals(expectdResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be record not found",
				contentResponse.getMessage().equals(expectdResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should be empty ", contentResponse.getData() == null);


	}
	
	
	/**
	 * Test deleteCustomer API when retrieval of customer succeeds 
	 * @throws Exception
	 */
	@Test
	public void deleteCustomer() throws Exception {
		// create test data
		ResponseMessage expectdResponse = MockHelper.getResponseMockData(ResponseType.SUCCESS);
		
		when(customerService.deleteCustomer(any(Integer.class))).thenReturn(true);

		String uri = "/deleteCustomer/?id=1";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		// Extract the response and status

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		verify(customerService, times(1)).deleteCustomer(any(Integer.class));

		
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);
		
		logger.info("content ===>> " + content);
		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);
		
		Assert.assertTrue("Failed-- Response message code should be successful",
				contentResponse.getMessageCode().equals(expectdResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should be successful",
				contentResponse.getMessage().equals(expectdResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should be empty ", contentResponse.getData() == null);
		


	}
	
	/**
	 * Test deleteCustomer API when retrieval of customer failed 
	 * @throws Exception
	 */
	@Test
	public void deleteCustomerFailed() throws Exception {
		// create test data
		ResponseMessage expectdResponse = MockHelper.getResponseMockData(ResponseType.DELETE_FAILURE);
		
		when(customerService.deleteCustomer(any(Integer.class))).thenReturn(false);

		String uri = "/deleteCustomer/?id=1";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		// Extract the response and status

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		verify(customerService, times(1)).deleteCustomer(any(Integer.class));

		
		ResponseMessage contentResponse = super.mapFromJSON(content, ResponseMessage.class);
		
		Assert.assertEquals("Failed-- Expected status is 200", 200, status);
		Assert.assertTrue("Failed-- Content body should not be empty", content.trim().length() > 0);
		
		Assert.assertTrue("Failed-- Response message code should not be successful",
				contentResponse.getMessageCode().equals(expectdResponse.getMessageCode()));
		Assert.assertTrue("Failed-- Response message should not be successful",
				contentResponse.getMessage().equals(expectdResponse.getMessage()));
		Assert.assertTrue("Failed-- Response message data should be empty ", contentResponse.getData() == null);
		


	}

}
