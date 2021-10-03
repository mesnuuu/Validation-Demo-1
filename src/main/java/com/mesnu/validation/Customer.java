package com.mesnu.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	@NotNull( message = " is required")
	@Size(min = 5, message = "minimum 5 characters")
	private String firstName;

	@NotNull( message = " is required")
	@Size(min = 3, message = "minimum 3 characters")
	private String lastName;

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

}