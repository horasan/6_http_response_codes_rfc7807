package com.horasan.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="customers")
@Data
public class CustomerEntity {
	
	@Id
	@Column(unique=true)
	private String customerOId;
	
	@Column(unique=true)
	private String customerNo;
	private String firstName;
	private String lastName;
	private Integer dateOfBirth;
	private String emailAddress;
}