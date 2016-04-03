package com.app.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.AbstractTest;
import com.app.api.Service.ICustomerService;
import com.app.api.models.Customer;


@Transactional
public class CustomerServiceTest extends AbstractTest {
	
	@Autowired
	ICustomerService customerService;
	
	@Before
	public void setup(){
		
	}
	
	@After
	public void teardown(){
		
	}
	
	@Test
	public void testcreateCustomer(){
		
		// create a customer
		Customer customer =  new Customer();
		customer.setName("Test Name");
		customer.setAddress("Test Address");
		customer.setPhoneNumber("123456");
		// persist the new customer
		Customer persistedCustomer = customerService.saveCustomer(customer);
		
		// Assert if successful
		Assert.assertTrue("Creation of new customer failed", persistedCustomer.getId() != null);
		//Retrieve the record back
		Customer foundCustomers = customerService.getCustomer(persistedCustomer.getId());
		
		Assert.assertTrue("Creation of new customer failed", foundCustomers != null);
		Assert.assertTrue("Creation of new customer failed", foundCustomers.getName().equals(customer.getName()));
		Assert.assertTrue("Creation of new customer failed", foundCustomers.getAddress().equals(customer.getAddress()));
		Assert.assertTrue("Creation of new customer failed", foundCustomers.getPhoneNumber().equals(customer.getPhoneNumber()));
		
	}
	
	@Test
	public void testupdateCustomer(){
		
		// create a customer
		Customer customer =  new Customer();
		customer.setName("Test Name");
		customer.setAddress("Test Address");
		customer.setPhoneNumber("123456");
		
		// persist the new customer
		Customer persistedCustomer = customerService.saveCustomer(customer);
		// Assert if successful
		Assert.assertTrue("Creation of new customer failed", persistedCustomer.getId() != null);
		//Retrieve the record back
		Customer foundCustomers = customerService.getCustomer(persistedCustomer.getId());
		// Modify the record
		foundCustomers.setAddress("Day St. Auckland");
		foundCustomers.setName("Rommel A. Suarez");
		foundCustomers.setPhoneNumber("0220378443");
		// Save the changes
		Customer updatedCustomer = customerService.saveCustomer(foundCustomers);
		//Retrieve the record back again
		Customer foundUpdatedCustomers = customerService.getCustomer(updatedCustomer.getId());
		Assert.assertTrue("Update of customer failed", updatedCustomer != null);
		Assert.assertTrue("Update of customer failed", foundCustomers.getName().equals(foundUpdatedCustomers.getName()));
		Assert.assertTrue("Update of customer failed", foundCustomers.getAddress().equals(foundUpdatedCustomers.getAddress()));
		Assert.assertTrue("Update of customer failed", foundCustomers.getPhoneNumber().equals(foundUpdatedCustomers.getPhoneNumber()));
		
	}
	
	@Test
	public void testDeleteCustomer(){
		
		// create a customer
		Customer customer =  new Customer();
		customer.setName("Test Name");
		customer.setAddress("Test Address");
		customer.setPhoneNumber("123456");
		
		// persist the new customer
		Customer persistedCustomer = customerService.saveCustomer(customer);
		// Assert if successful
		Assert.assertTrue("Creation of new customer failed", persistedCustomer.getId() != null);
		//Retrieve the record back
		Customer foundCustomers = customerService.getCustomer(persistedCustomer.getId());
		
		// delete record
		customerService.deleteCustomer(foundCustomers.getId());
		
		//Retrieve the record back again
		Customer foundDeletedCustomer = customerService.getCustomer(foundCustomers.getId());
		Assert.assertTrue("Delete of customer failed", foundDeletedCustomer == null);
		
	}
	
	
	@Test
	public void testGetCustomer(){
		
		// create a customer
		Customer customer =  new Customer();
		customer.setName("Test Name");
		customer.setAddress("Test Address");
		customer.setPhoneNumber("123456");
		
		// persist the new customer
		Customer persistedCustomer = customerService.saveCustomer(customer);
		// Assert if successful
		Assert.assertTrue("Creation of new customer failed", persistedCustomer.getId() != null);
		//Retrieve the record back
		Customer foundCustomers = customerService.getCustomer(persistedCustomer.getId());
		
		Assert.assertTrue("Update of customer failed", foundCustomers != null);
		Assert.assertTrue("Update of customer failed", foundCustomers.getName().equals(customer.getName()));
		Assert.assertTrue("Update of customer failed", foundCustomers.getAddress().equals(customer.getAddress()));
		Assert.assertTrue("Update of customer failed", foundCustomers.getPhoneNumber().equals(customer.getPhoneNumber()));
		
		
	}
	
	@Test
	public void testGetAllCustomer(){
		
		// create a customer
		Customer customer =  new Customer();
		customer.setName("Test Name");
		customer.setAddress("Test Address");
		customer.setPhoneNumber("123456");
		
		// persist the new customer
		Customer persistedCustomer = customerService.saveCustomer(customer);
		// Assert if successful
		Assert.assertTrue("Creation of new customer failed", persistedCustomer.getId() != null);
		//Retrieve the record back
		List<Customer> foundCustomers = customerService.getAllCustomer();
		
		Assert.assertTrue("Update of customer failed", foundCustomers.size() > 0);
		Assert.assertTrue("Update of customer failed", !foundCustomers.isEmpty());
		
		
		
	}
	

}
