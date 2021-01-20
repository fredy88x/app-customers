package com.alianza.customers.services;

import java.util.List;

import com.alianza.customers.dto.CustomerDTO;
import com.alianza.customers.exceptions.DataNotFoundException;

public interface CustomerServiceI {

	List<CustomerDTO> findAllCustomers() throws DataNotFoundException;
	
	CustomerDTO createCustomer(CustomerDTO customerDTO);
	
	List<CustomerDTO> findCustomersBySharedKey(String sharedKey)throws DataNotFoundException;
}
