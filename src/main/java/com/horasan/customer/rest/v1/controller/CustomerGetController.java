package com.horasan.customer.rest.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horasan.customer.model.CustomerEntity;
import com.horasan.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerGetController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/{customerNo}")
	public ResponseEntity<CustomerEntity> getCustomer(@PathVariable("customerNo") String customerNo) {
		CustomerEntity customer = customerService.getCustomerByCustomerNo(customerNo);
		return new ResponseEntity<CustomerEntity>(customer, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
		return new ResponseEntity<List<CustomerEntity>>(customerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CustomerEntity>> getCustomersByFirstName(@RequestParam("firstName") String firstName) {
		return new ResponseEntity<List<CustomerEntity>>(customerService.findByFirstNameWithLike(firstName), HttpStatus.OK);
	}
	
}
