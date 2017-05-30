package org.kizilay.yusuf.BeanValidationApp.model;

import java.util.Date;

import javax.validation.constraints.*;

import org.kizilay.yusuf.BeanValidationApp.constraints.EmailConstraint;

public class Customer {

	@NotNull // Built-in constraint , first name can not be null
	@Size(min = 2) // Built-in constraint , first name has two character at
					// least
	private String firstName;

	private String lastName;

	@EmailConstraint // Not built-in constraint , developer must implement
	private String email;

	private String phoneNumber;

	@Past // built-in constraint, date of birth must be before today
	private Date dateOfBirth;

	private Address deliveryAddress;

	public Customer(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth,
			Address deliveryAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.deliveryAddress = deliveryAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}
