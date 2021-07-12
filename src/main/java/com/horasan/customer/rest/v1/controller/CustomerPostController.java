package com.horasan.customer.rest.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horasan.customer.model.CustomerEntity;
import com.horasan.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerPostController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("")
	public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
		return new ResponseEntity<CustomerEntity>(customerService.save(customer), HttpStatus.CREATED);
	}
	
	@PostMapping("/endofyear")
	public ResponseEntity<String> processCustomerEndOfYearOperations(@PathVariable("customerNo") String customerNo) {
		customerService.processEndOfYearOperations(customerNo);
		return new ResponseEntity<>("End of year operations are started for the customer: " + customerNo, HttpStatus.ACCEPTED);
	}
	
}
