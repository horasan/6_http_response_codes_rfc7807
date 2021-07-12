package com.horasan.customer.rest.error.exceptions;

import lombok.Data;

@Data
public class CustomerNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String customerNo;
	private String title;
	
	public CustomerNotFound(String customerNo) {
		super("Customer not found for " + customerNo);
		title = "Customer Errors";
		this.customerNo = customerNo;
	}

}
