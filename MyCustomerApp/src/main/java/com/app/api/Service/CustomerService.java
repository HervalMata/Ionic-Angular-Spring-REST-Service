package com.app.api.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.models.Customer;
import com.app.api.repository.CustomerRepository;

/**
 * 
 * @author Rommel A. Suarez
 *  This class contains the service layer of the application.
 *  The code interacts with the data access layer to maintain/access records 
 */
@Service
public class CustomerService implements ICustomerService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * @param Customer object that holds data to persist
	 * @return Customer object that was persisted together with the generated Id
	 */
	public Customer saveCustomer(Customer customer) {
		
		logger.info("======saveCustomer Started=====");

		Customer persistedObj = null;
		try {
			if (customer != null)
				persistedObj = customerRepository.saveAndFlush(customer);

		} catch (Exception e) {
			logger.info("Exception occured on saveCustomer:" + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			logger.info("======saveCustomer Ended=====");
		}

		return persistedObj;
	}

	/**
	 * @param Id of the customer object to delete
	 * @return void
	 */
	public boolean deleteCustomer(Integer id) {
		logger.info("======deleteCustomer Started=====");
		try {
			if (id != null){
				customerRepository.delete(id);
				return true;
			}
		} catch (Exception e) {
			logger.info("Exception occured on deleteCustomer:" + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			logger.info("======deleteCustomer Ended=====");
		}
		
		return false;

	}

	/**
	 * @param Id of the customer object to find
	 * @return Customer object to find
	 */
	public Customer getCustomer(Integer id) {
		
		logger.info("======getCustomer Started=====");
		Customer customer = null;
		try {
			if (id != null)
				customer = customerRepository.findOne(id);
		} catch (Exception e) {
			logger.info("Exception occured on getCustomer:" + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			logger.info("======getCustomer Ended=====");
		}
		return customer;
	}
	/**
	 * @param none
	 * @return List of all Customer object in the database
	 */
	public List<Customer> getAllCustomer() {
		logger.info("======getAllCustomer Started=====");
		
		List<Customer> customers = null;
		try {
			customers = customerRepository.findAll();
		} catch (Exception e) {
			logger.info("Exception occured on getAllCustomer:" + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			logger.info("======getAllCustomer Ended=====");
		}
		return customers;
	}
}
