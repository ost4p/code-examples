package edu.pitt.bank;

import java.util.Date;

public class Customer {
	private String firstName;
	private String lastName;
	private String ssn;
	
	public Customer(String fName, String lName, String ssn){
		this.firstName = fName;
		this.lastName = lName;
		this.ssn = ssn;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public String getSsn() {
		return ssn;
	}
	
}
