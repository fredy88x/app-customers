package com.alianza.customers.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.alianza.customers.dto.CustomerDTO;
import com.alianza.customers.exceptions.DataNotFoundException;
import com.alianza.customers.services.CustomerServiceI;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService implements CustomerServiceI {

	private Map<String, CustomerDTO> customersMap = new HashMap<>();
	
	
	@PostConstruct
	public void setup() {
		loadCustomers();
	}
	
	private void loadCustomers() {
		CustomerDTO customerOne = CustomerDTO.builder().sharedKey("jgutierrez").name("juliana gutierrez").phone("3219876443").email("jgutierrez@gmail.com").startDate(new Date()).endDate(new Date()).build();
		customersMap.put(customerOne.getSharedKey(), customerOne);
		CustomerDTO customerTwo = CustomerDTO.builder().sharedKey("mmartinez").name("Manuel Martinez").phone("3219876443").email("mmartinez@gmail.com").startDate(new Date()).endDate(new Date()).build();
		customersMap.put(customerTwo.getSharedKey(), customerTwo);
		CustomerDTO customerThree = CustomerDTO.builder().sharedKey("aruiz").name("Ana Ruiz").phone("3219876443").email("aruiz@gmail.com").startDate(new Date()).endDate(new Date()).build();
		customersMap.put(customerThree.getSharedKey(), customerThree);
		CustomerDTO customerFour = CustomerDTO.builder().sharedKey("ogarcia").name("Oscar Garcia").phone("3219876443").email("ogarcia@gmail.com").startDate(new Date()).endDate(new Date()).build();
		customersMap.put(customerFour.getSharedKey(), customerFour);
		CustomerDTO customerFive = CustomerDTO.builder().sharedKey("tramos").name("Tania ramos").phone("3219876443").email("tramos@gmail.com").startDate(new Date()).endDate(new Date()).build();
		customersMap.put(customerFive.getSharedKey(), customerFive);
	}

	@Override
	public List<CustomerDTO> findAllCustomers() throws DataNotFoundException {
		log.info("######List of the customers#######");
		return new ArrayList<>(customersMap.values());
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDto) {
		log.info("######Create a customer#######");
		customerDto.setStartDate(new Date());
		customerDto.setEndDate(new Date());
		customerDto.setSharedKey(getSharedKey(customerDto.getName()));
		customersMap.put(customerDto.getSharedKey(), customerDto);
		return customerDto;
	}

	@Override
	public List<CustomerDTO> findCustomersBySharedKey(String sharedKey) throws DataNotFoundException {
		log.info("######Get customer by sharedkey#######");
		CustomerDTO customerFind = customersMap.get(sharedKey);
		if(customerFind == null) {
			throw new DataNotFoundException();
		}
		return Arrays.asList(customerFind);
	}
	
	private String getSharedKey(String name) {
		String[] nombres = name.trim().toLowerCase().split(" ");
		StringBuilder sharedKey = new StringBuilder();
		sharedKey.append(nombres[0].charAt(0));
		sharedKey.append(nombres[1]);
		return sharedKey.toString();
	}

}
