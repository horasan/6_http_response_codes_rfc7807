package com.horasan.customer.rest.error;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import com.horasan.customer.rest.error.exceptions.CustomerAlreadyExists;
import com.horasan.customer.rest.error.exceptions.CustomerEmailAlreadyExists;
import com.horasan.customer.rest.error.exceptions.CustomerMustBeOlderThan16;
import com.horasan.customer.rest.error.exceptions.CustomerNotFound;
import com.horasan.customer.rest.error.exceptions.EmailAddressIsNotInCorrectFormat;
import com.horasan.customer.rest.error.exceptions.FirstNameIsNotInExpectedFormat;


/*
 	https://www.ietf.org/rfc/rfc7807.txt
 */

@RestControllerAdvice
public class CustomerRestExceptionHandler implements ProblemHandling {
	
    @Value("${server.name}")
    private String serverName;
    
    
    @Value("${server.port}")
    private String serverPort;
    
    @Value("${url.errors}")
    private String errorEndPoint;
	
    private String getErrorsURL() {
    	return "http://" + serverName + ":" + serverPort + "/" + errorEndPoint + "/";
    }
    
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<Problem> handleCustomerNotFoundException(CustomerNotFound ex, WebRequest request) {

		CustomerRestErrorResponse errorResponse = 
				CustomerRestErrorResponse.builder()
				.type(URI.create(getErrorsURL() + ErrorConstants.CUSTOMER_NOT_FOUND_EXCEPTION))
				.statusType(Status.NOT_FOUND)
				.title(ex.getTitle())
				.detail(ex.getLocalizedMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	
		return new ResponseEntity<Problem>(getHttpProblem(errorResponse), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerAlreadyExists.class)
	public ResponseEntity<Problem> handleCustomerAlreadyExistsException(CustomerAlreadyExists ex, WebRequest request) {

		CustomerRestErrorResponse errorResponse = 
				CustomerRestErrorResponse.builder()
				.type(URI.create(getErrorsURL() + ErrorConstants.CUSTOMER_ALREADY_EXISTS))
				.statusType(Status.BAD_REQUEST)
				.title(ex.getTitle())
				.detail(ex.getLocalizedMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	
		return new ResponseEntity<Problem>(getHttpProblem(errorResponse), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerEmailAlreadyExists.class)
	public ResponseEntity<Problem> handleCustomerEmailAlreadyExistsException(CustomerEmailAlreadyExists ex, WebRequest request) {

		CustomerRestErrorResponse errorResponse = 
				CustomerRestErrorResponse.builder()
				.type(URI.create(getErrorsURL() + ErrorConstants.CUSTOMER_EMAIL_ALREADY_EXISTS))
				.statusType(Status.BAD_REQUEST)
				.title(ex.getTitle())
				.detail(ex.getLocalizedMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	
		return new ResponseEntity<Problem>(getHttpProblem(errorResponse), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerMustBeOlderThan16.class)
	public ResponseEntity<Problem> handleCustomerMustBeOlderThan16Exception(CustomerMustBeOlderThan16 ex, WebRequest request) {

		CustomerRestErrorResponse errorResponse = 
				CustomerRestErrorResponse.builder()
				.type(URI.create(getErrorsURL() + ErrorConstants.CUSTOMER_MUST_BE_OLDER_THAN_16))
				.statusType(Status.BAD_REQUEST)
				.title(ex.getTitle())
				.detail(ex.getLocalizedMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	
		return new ResponseEntity<Problem>(getHttpProblem(errorResponse), HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(EmailAddressIsNotInCorrectFormat.class)
	public ResponseEntity<Problem> handleEmailAddressIsNotInCorrectFormatException(EmailAddressIsNotInCorrectFormat ex, WebRequest request) {

		CustomerRestErrorResponse errorResponse = 
				CustomerRestErrorResponse.builder()
				.type(URI.create(getErrorsURL() + ErrorConstants.EMAIL_ADDRESS_IS_NOT_IN_CORRECT_FORMAT))
				.statusType(Status.BAD_REQUEST)
				.title(ex.getTitle())
				.detail(ex.getLocalizedMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	
		return new ResponseEntity<Problem>(getHttpProblem(errorResponse), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FirstNameIsNotInExpectedFormat.class)
	public ResponseEntity<Problem> handleFirstNameIsNotInExpectedFormatException(FirstNameIsNotInExpectedFormat ex, WebRequest request) {

		CustomerRestErrorResponse errorResponse = 
				CustomerRestErrorResponse.builder()
				.type(URI.create(getErrorsURL() + ErrorConstants.FIRST_NAME_IS_NOT_IN_EXPECTED_FORMAT))
				.statusType(Status.BAD_REQUEST)
				.title(ex.getTitle())
				.detail(ex.getLocalizedMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	
		return new ResponseEntity<Problem>(getHttpProblem(errorResponse), HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Problem> handleOtherExceptions(Exception ex, WebRequest request) {

		CustomerRestErrorResponse errorResponse = 
				CustomerRestErrorResponse.builder()
				.type(URI.create(getErrorsURL() + ErrorConstants.UNKNOWN_INTERNAL_ERROR))
				.statusType(Status.INTERNAL_SERVER_ERROR)
				.title("Unknown Errors")
				.detail(ex.getLocalizedMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	
		return new ResponseEntity<Problem>(getHttpProblem(errorResponse), HttpStatus.INTERNAL_SERVER_ERROR);
	}	

	
	private Problem getHttpProblem(CustomerRestErrorResponse errorResponse) {
		return 
			        Problem.builder()
			          .withType(errorResponse.getType())
			          .withTitle(errorResponse.getTitle())
			          .withDetail(errorResponse.getDetail())
			          .withStatus(errorResponse.getStatusType())
			          .build();
	}
}
