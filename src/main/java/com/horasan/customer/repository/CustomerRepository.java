package com.horasan.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horasan.customer.model.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
	
	public CustomerEntity findByCustomerOId(String customerOId);
	public CustomerEntity findByCustomerNo(String customerNo);
	public CustomerEntity findByCustomerOIdOrCustomerNo(String customerOId, String customerNo);
	public List<CustomerEntity> findByFirstNameLike(String firstName);
	public List<CustomerEntity> findByFirstNameStartsWith(String firstName);

}