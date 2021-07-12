package com.horasan.customer.rest.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horasan.customer.model.CustomerEntity;
import com.horasan.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerPutController {
	
	@Autowired
	private CustomerService customerService;
	
	@PutMapping("/{customerNo}")
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable("customerNo") String customerNo, @RequestBody CustomerEntity customer) {
		return new ResponseEntity<CustomerEntity>(customerService.update(customerNo, customer), HttpStatus.OK);
		
	}


}
