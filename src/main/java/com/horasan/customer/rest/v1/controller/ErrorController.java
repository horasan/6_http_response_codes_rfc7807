package com.horasan.customer.rest.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horasan.customer.rest.error.ErrorConstants;

@RestController
@RequestMapping("/api/v1/errors")
public class ErrorController {

	
	@GetMapping("/" + ErrorConstants.UNKNOWN_INTERNAL_ERROR)
	public String getUnkownInternalErrorDescription() {
		return "Detailded description for " + ErrorConstants.UNKNOWN_INTERNAL_ERROR + " exception";
	}
	
	@GetMapping("/" + ErrorConstants.CUSTOMER_NOT_FOUND_EXCEPTION)
	public String getCustomerNorFoundErrorDescription() {
		return "Detailded description for " + ErrorConstants.CUSTOMER_NOT_FOUND_EXCEPTION + " exception";
	}
	
	@GetMapping("/" + ErrorConstants.CUSTOMER_ALREADY_EXISTS)
	public String getCustomerAlreadyExistsErrorDescription() {
		return "Detailded description for " + ErrorConstants.CUSTOMER_ALREADY_EXISTS + " exception";
	}

	@GetMapping("/" + ErrorConstants.CUSTOMER_EMAIL_ALREADY_EXISTS)
	public String getCustomerEmailAlreadyExistsErrorDescription() {
		return "Detailded description for " + ErrorConstants.CUSTOMER_EMAIL_ALREADY_EXISTS + " exception";
	}

	@GetMapping("/" + ErrorConstants.CUSTOMER_MUST_BE_OLDER_THAN_16)
	public String getCustomerMustBeOlderThan16ErrorDescription() {
		return "Detailded description for " + ErrorConstants.CUSTOMER_MUST_BE_OLDER_THAN_16 + " exception";
	}
	
	@GetMapping("/" + ErrorConstants.EMAIL_ADDRESS_IS_NOT_IN_CORRECT_FORMAT)
	public String getEmailAddressIsNotInCorrectFormatErrorDescription() {
		return "Detailded description for " + ErrorConstants.EMAIL_ADDRESS_IS_NOT_IN_CORRECT_FORMAT + " exception";
	}
	
	@GetMapping("/" + ErrorConstants.FIRST_NAME_IS_NOT_IN_EXPECTED_FORMAT)
	public String getFirstNameIsNotInExpectedFormatExceptionErrorDescription() {
		return "Detailded description for " + ErrorConstants.FIRST_NAME_IS_NOT_IN_EXPECTED_FORMAT + " exception";
	}
}
