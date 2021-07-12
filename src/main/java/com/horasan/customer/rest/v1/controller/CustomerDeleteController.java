package com.horasan.customer.rest.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horasan.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerDeleteController {
	
	@Autowired
	private CustomerService customerService;
}
