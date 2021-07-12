package com.horasan.customer.rest.error.exceptions;

import lombok.Data;

@Data
public class FirstNameIsNotInExpectedFormat extends RuntimeException {

	private String title;
	private String firstName;

	public FirstNameIsNotInExpectedFormat(String firstName) {
		super("First name is not in expected format: " + firstName);
		this.title = "Customer Errors";
		this.firstName = firstName;
	}
}
