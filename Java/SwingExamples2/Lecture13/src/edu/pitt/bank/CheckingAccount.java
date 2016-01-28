package edu.pitt.bank;

public class CheckingAccount extends Account{
	public CheckingAccount(String accountNumber, String accountType, double balance, Customer customer){
		super(accountNumber, accountType, balance, customer);
		
	}
	
	@Override
	public double withdraw(double withdrawalAmount){
		double balance = super.withdraw(withdrawalAmount);
		final double PENALTY = 30.0;
		if(balance < 0){
			balance = super.withdraw(PENALTY);
		}
		return balance;
	} 
}
