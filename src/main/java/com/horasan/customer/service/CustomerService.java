package com.horasan.customer.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horasan.customer.model.CustomerEntity;
import com.horasan.customer.repository.CustomerRepository;
import com.horasan.customer.rest.error.exceptions.CustomerAlreadyExists;
import com.horasan.customer.rest.error.exceptions.CustomerNotFound;
import com.horasan.customer.rest.error.exceptions.EmailAddressIsNotInCorrectFormat;
import com.horasan.customer.rest.error.exceptions.FirstNameIsNotInExpectedFormat;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerEntity getCustomerByCustomerNo(String customerNo) {
		
		CustomerEntity existingCustomer = customerRepository.findByCustomerNo(customerNo);
		
		if(!Objects.isNull(existingCustomer)) {
			return existingCustomer;
		}
		
		/*
			404 Not Found Entity not found
		*/
		throw new CustomerNotFound(customerNo);
	}
	
	public List<CustomerEntity> findAll() {
		/*
			Always: 200 OK Content was found and returned
		 */
		return customerRepository.findAll();
	}

	public List<CustomerEntity> findByFirstNameWithLike(String firstName) {
		validateFirstNameInput(firstName);
		/*
			Always: 200 OK Content was found and returned
		*/
		return customerRepository.findByFirstNameStartsWith(firstName);
	}
	
	private void validateFirstNameInput(String firstName) {
		/*
		400 Bad Request There was an error validating the parameters sent
		 */
		
		if(Objects.isNull(firstName) || firstName.length() < 3) {
			throw new FirstNameIsNotInExpectedFormat(firstName);
		}
		
	}

	public CustomerEntity save(CustomerEntity customer) {
		
		validateCustomerNoUniqueness(customer.getCustomerNo());
		validateCustomerEmail(customer.getEmailAddress());
	
		customer.setCustomerOId(UUID.randomUUID().toString());
		return customerRepository.save(customer);
	}
	
	public CustomerEntity update(String customerNo, CustomerEntity customer) {
		validateCustomerExistence(customerNo);
		validateCustomerNoUniqueness(customer.getCustomerNo());
		validateCustomerEmail(customer.getEmailAddress());
		
		CustomerEntity existingCustomer = customerRepository.findByCustomerNo(customerNo);
		existingCustomer.setCustomerNo(customer.getCustomerNo());
		existingCustomer.setDateOfBirth(customer.getDateOfBirth());
		existingCustomer.setEmailAddress(customer.getEmailAddress());
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		
		return customerRepository.save(customer);
	}
	
	private void validateCustomerNoUniqueness(String customerNo) {

		if (!Objects.isNull(customerRepository.findByCustomerNo(customerNo))) {
			throw new CustomerAlreadyExists(customerNo);
		}

	}

	private void validateCustomerExistence(String customerNo) {

		if (Objects.isNull(customerRepository.findByCustomerNo(customerNo))) {
			throw new CustomerNotFound(customerNo);
		}

	}
	
	private void validateCustomerEmail(String emailAddress) {

		if (!emailAddress.contains("@")) {
			throw new EmailAddressIsNotInCorrectFormat(emailAddress);
		}

	}

	public void processEndOfYearOperations(String customerNo) {
		validateCustomerExistence(customerNo);
		processALongRunningBatchOperation(customerNo);
	}

	private void processALongRunningBatchOperation(String customerNo) {
		
	}


}
