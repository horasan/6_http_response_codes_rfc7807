package com.horasan.customer.rest.error.exceptions;

import lombok.Data;

@Data
public class EmailAddressIsNotInCorrectFormat extends RuntimeException {

	private String emailAddress;
	private String title;
	
	public EmailAddressIsNotInCorrectFormat(String emailAddress) {
		super("EmailAddressIsNotInCorrectFormat: " + emailAddress);
		this.emailAddress = emailAddress;
		this.title = "Customer Errors";
	}

}
