package com.revature.training.project.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	private int customerId;
	private int accountNumber;
	private String customerName;
	private String customerPassword;
	private int dateOfBirth;
	private String address;
	private int currentBalance;
	
	public Customer() {
		
	}

	public Customer(int customerId, int accountNumber,String customerName, String customerPassword, int dateOfBirth, String address,
			int currentBalance) {
		super();
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.currentBalance = currentBalance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "\n Customer [customerId=" + customerId + ", accountNumber=" + accountNumber + ", customerName="
				+ customerName + ", customerPassword=" + customerPassword + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", currentBalance=" + currentBalance + "]";
	}

}
