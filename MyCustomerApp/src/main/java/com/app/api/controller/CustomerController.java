package com.app.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.api.Service.ICustomerService;
import com.app.api.common.ResponseMessage;
import com.app.api.common.ResponseType;
import com.app.api.models.Customer;

/**
 * 
 * @author Rommel A. Suarez This class contains the controller layer of the
 *         application. The code contains the REST service methods
 */

@CrossOrigin(origins = "http://localhost:8100")
@Controller
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	/**
	 * 
	 * @param HTTP request from the client
	 * @return ResponseMessage object that contains the persisted customer object 
	 *         and a success message if the process is successful. Hence, 
	 *         will return a failure message with a null customer object.
	 *         
	 * 		  	
	 */
	@RequestMapping(method = RequestMethod.POST, value = "addCustomer")
	public @ResponseBody ResponseMessage createCustomer(@RequestBody Customer customer) {
		ResponseMessage responseMessage = new ResponseMessage();
	
		try {
			if (null != customer.getName() && 
					null!= customer.getAddress() && 
					null!= customer.getPhoneNumber()) {
				Customer persitedObj = customerService.saveCustomer(customer);
				
				if(persitedObj != null) {
					List<Customer> data = new ArrayList<Customer>();
					data.add(persitedObj);
					responseMessage.setData(data);
					responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.SUCCESS);
				}else{
					responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.CREATE_FAILURE);
				}
			} else {
				responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.VALIDATION_ERROR);

			}

		} catch (Exception e) {
			responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.EXCEPTION_ERROR);

		} finally {
			
		}
		
		return responseMessage;

	}

	/**
	 * 
	 * @param HTTP
	 *            request from the client
	 * @return ResponseMessage object that contains the updated customer object
	 *         and a success message if the process is successful. Hence, will
	 *         return a failure message with a null customer object.
	 * 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "editCustomer")
	public @ResponseBody ResponseMessage updateCustomer(@RequestBody Customer customer) {

		ResponseMessage responseMessage = new ResponseMessage();

		try {
			if (null!= customer.getId() &&
					null!= customer.getName() && 
					null!= customer.getAddress() && 
					null!= customer.getPhoneNumber()) {

				Customer persitedObj = customerService.saveCustomer(customer);
				
				if(persitedObj != null) {
					List<Customer> data = new ArrayList<Customer>();
					data.add(persitedObj);
					responseMessage.setData(data);
					responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.SUCCESS);
				}else{
					responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.UPDATE_FAILURE);
				}

			} else {
				responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.VALIDATION_ERROR);
			}

		} catch (Exception e) {
			responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.EXCEPTION_ERROR);

		} finally {

		}
		return responseMessage;
	}

	/**
	 * 
	 * @param HTTP
	 *            request from the client
	 * @return ResponseMessage object that contains a success message if the
	 *         process is successful. Hence, will return a failure message.
	 * 
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "deleteCustomer")
	public @ResponseBody ResponseMessage deleteCustomer(HttpServletRequest request) {
		ResponseMessage responseMessage = new ResponseMessage();

			try {
				if (null != request.getParameter("id") && !"".equals(request.getParameter("id").trim())) {
					String param = request.getParameter("id");
					Integer  id = Integer.valueOf(param);
					boolean success = customerService.deleteCustomer(id);
					if(success){
						responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.SUCCESS);
					}else{
						responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.DELETE_FAILURE);
					}
				
			} else {
				responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.VALIDATION_ERROR);
			}
		} catch (Exception e) {
			responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.EXCEPTION_ERROR);

		} finally {

		}

		return responseMessage;

	}

	/**
	 * 
	 * @param HTTP
	 *            request from the client
	 * @return ResponseMessage object that contains the requested customer
	 *         object and a success message if the process is successful. Hence,
	 *         will return a failure message with a null customer object.
	 * 
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "getCustomer")
	public @ResponseBody ResponseMessage getCustomer(HttpServletRequest request) {

		ResponseMessage responseMessage = new ResponseMessage();

		try {
			if (null != request.getParameter("id")) {
				
				String param = request.getParameter("id");
				Integer  id = Integer.valueOf(param);
				Customer customer = customerService.getCustomer(id);
				
				if(customer!=null) {
					List<Customer> data = new ArrayList<Customer>();
					data.add(customer);
					responseMessage.setData(data);
					responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.SUCCESS);
				}else{
					responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.RECORD_NOT_FOUND);
				}
				
			} else {
				responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.VALIDATION_ERROR);
			}
		} catch (Exception e) {
			responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.EXCEPTION_ERROR);

		} finally {

		}

		return responseMessage;

	}

	/**
	 * 
	 * @return ResponseMessage object that contains all the customer object and
	 *         a success message if the process is successful. Hence, will
	 *         return a failure message with a null customer object.
	 * 
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "getAllCustomers")
	public @ResponseBody ResponseMessage getAllCustomer() {

		ResponseMessage responseMessage = new ResponseMessage();
		try {
			List<Customer> customers = customerService.getAllCustomer();
			if(customers!=null && !customers.isEmpty()){
				responseMessage.setData(customers);
				responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.SUCCESS);
			}else{
				responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.RECORD_NOT_FOUND);
			}
			
		} catch (Exception e) {
			responseMessage = ResponseMessage.setResponseMessage(responseMessage, ResponseType.EXCEPTION_ERROR);

		} finally {

		}

		return responseMessage;
	}

}
