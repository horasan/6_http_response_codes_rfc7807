package com.horasan.customer.rest.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horasan.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerDeleteController {
	
	@Autowired
	private CustomerService customerService;
	
	@DeleteMapping("/{customerNo}")
	public ResponseEntity<String> updateCustomer(@PathVariable("customerNo") String customerNo) {
		customerService.delete(customerNo);
		return new ResponseEntity<String>("Customer is deleted.", HttpStatus.OK);
		
	}
}
