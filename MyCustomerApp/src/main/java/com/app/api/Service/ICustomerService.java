package com.app.api.Service;

import java.util.List;

import com.app.api.models.Customer;

/**
 * 
 * @author Rommel A.Suarez
 * Interface for the service layer. An abstract contract of the service.
 *
 */
public interface ICustomerService {
	
	public Customer saveCustomer(Customer customer);
	
	public boolean  deleteCustomer(Integer id);
	
	public Customer  getCustomer(Integer id);
	
	public List<Customer>  getAllCustomer();
}
