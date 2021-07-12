package com.horasan.customer.rest.error.exceptions;

import lombok.Data;

@Data
public class CustomerMustBeOlderThan16 extends RuntimeException {

	private String title;
	private Integer dateOfBirth;
	public CustomerMustBeOlderThan16(Integer dateOfBirth) {
		super("Customer must be older than 16");
		this.title = "Customer Errors";
		this.dateOfBirth = dateOfBirth;
	}

}
