package edu.pitt.bank;

public class NormalWithdrawal implements WithdrawalBehavior{

	@Override
    public String toString() {
        return "Normal withdrawal";
    }
	
	public double withdraw(double balance, double amount){
		if(balance >= amount){
			balance -= amount;
			System.out.println("Successfully withdrew " + amount + ". Your balance is " + balance);
		}
		else{
			System.out.println("Insufficient balance");
		}
		return balance;
	}

	

}
