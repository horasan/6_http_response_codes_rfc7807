package com.horasan.customer.rest.error;

public interface ErrorConstants {
	public static final String CUSTOMER_NOT_FOUND_EXCEPTION = "customer-not-found";
	public static final String CUSTOMER_ALREADY_EXISTS = "customer-already-exists";
	public static final String CUSTOMER_EMAIL_ALREADY_EXISTS = "customer-email-already-exists";
	public static final String UNKNOWN_INTERNAL_ERROR = "unknown-internal-error";
	public static final String CUSTOMER_MUST_BE_OLDER_THAN_16 = "customer-must-be-older-than-16";
	public static final String EMAIL_ADDRESS_IS_NOT_IN_CORRECT_FORMAT = "email-address-is-not-in-correct-format";
	public static final String FIRST_NAME_IS_NOT_IN_EXPECTED_FORMAT = "first-name-is-not-in-expected-format";
}
