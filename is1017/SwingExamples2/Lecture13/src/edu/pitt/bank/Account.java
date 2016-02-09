package edu.pitt.bank;

public class Account {
	private String accountNumber;
	private double balance;
	private String accountType;
	
	private Customer accountOwner;
	
	public Account(String accountNumber, String accountType, double balance, Customer customer){
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.accountOwner = customer;
	}
	
	public double withdraw(double withdrawalAmount){
		balance = balance - withdrawalAmount;
		return balance;
	}

	public void deposit(double depositAmount){
		balance = balance + depositAmount;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public Customer getAccountOwner(){
		return this.accountOwner;
	}
	
	@Override
	public String toString(){
		return "Account " + this.accountNumber + " has a balance of " + this.balance;
	}
		
}
