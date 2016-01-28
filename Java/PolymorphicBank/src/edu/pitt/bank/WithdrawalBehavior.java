package edu.pitt.bank;

public interface WithdrawalBehavior {
	@Override
    public String toString();
	
	public double withdraw(double balance, double amount);
}
