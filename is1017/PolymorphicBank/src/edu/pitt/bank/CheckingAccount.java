package edu.pitt.bank;

public class CheckingAccount extends Account{
	
	public CheckingAccount(long accountNumber, double initialDeposit) {
		super(accountNumber, initialDeposit);
		super.setWithdrawalBehavior(new NormalWithdrawal());
	}
	
	

}
