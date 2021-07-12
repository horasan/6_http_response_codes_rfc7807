package com.horasan.customer.rest.error.exceptions;

import lombok.Data;

@Data
public class CustomerAlreadyExists extends RuntimeException {

	private String customerNo;
	private String title;

	public CustomerAlreadyExists(String customerNo) {
		super("Customer already exists (customer no: " + customerNo + ") ");
		this.title = "Customer Errors";
		this.customerNo = customerNo;
	}
}
