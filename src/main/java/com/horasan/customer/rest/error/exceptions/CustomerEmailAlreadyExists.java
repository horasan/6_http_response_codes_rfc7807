package com.horasan.customer.rest.error.exceptions;

import lombok.Data;

@Data
public class CustomerEmailAlreadyExists extends RuntimeException {

	private String title;
	private String email;
	
	public CustomerEmailAlreadyExists(String emailAddress) {
		super("CustomerEmailAlreadyExists: " + emailAddress);
		this.title = "Customer Errors";
		this.email = emailAddress;
	}

}
