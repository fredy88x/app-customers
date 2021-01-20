package com.alianza.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.customers.dto.CustomerDTO;
import com.alianza.customers.exceptions.DataNotFoundException;
import com.alianza.customers.services.CustomerServiceI;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
public class CustomerController {

	@Autowired
	private CustomerServiceI customerServiceI;

	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findCustomers() {
		try {
			return ResponseEntity.ok(customerServiceI.findAllCustomers());
		} catch (DataNotFoundException e) {
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}

	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
		try {
			return ResponseEntity.ok(customerServiceI.createCustomer(customer));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}

	@GetMapping("/{sharedKey}")
	public ResponseEntity<List<CustomerDTO>> findCustomerBySharedKey(@PathVariable String sharedKey) {
		try {
			return ResponseEntity.ok(customerServiceI.findCustomersBySharedKey(sharedKey));
		} catch (DataNotFoundException e) {
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}

}
