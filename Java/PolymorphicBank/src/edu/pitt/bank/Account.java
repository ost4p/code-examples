package edu.pitt.bank;

/**
 * This class handles all functions related to bank accounts, including
 * withdrawals, deposits, account generation, etc...
 * @author Dmitriy Babichenko
 * @version 1.0.0.0.0.1.1
 */
public abstract class Account {
	private long accountNumber;
	protected double balance = 0;
	
	private WithdrawalBehavior wb;
	
	
	public void setWithdrawalBehavior(WithdrawalBehavior wb){
		this.wb = wb;
	}
	
	
	public Account(long accountNumber, double initialDeposit){
		deposit(initialDeposit);
		this.accountNumber = accountNumber;
	}
	
	public long getAccountNumber(){
		return this.accountNumber;
	}
	
	public double deposit(double depositAmount){
		this.balance += depositAmount;
		return this.balance;
	}
	
	public void withdraw(double amount){
		this.balance = wb.withdraw(this.balance, amount);
		
	}
	
	

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	
	
}
