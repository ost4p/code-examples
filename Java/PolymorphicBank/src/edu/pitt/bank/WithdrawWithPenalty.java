package edu.pitt.bank;

public class WithdrawWithPenalty implements WithdrawalBehavior {
	
	@Override
    public String toString() {
        return "Withdrawal with penalty";
    }
	
	public double withdraw(double balance, double amount){
		balance -= amount;
		if(balance < 500){
			balance -= 35;
			System.out.println("Your balance is less then $500 - you'll be charged a 35-dollar penalty for each withdrawal");
		}
		return balance;
	}
}
