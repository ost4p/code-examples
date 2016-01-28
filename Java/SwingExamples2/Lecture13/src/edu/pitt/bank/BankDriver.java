package edu.pitt.bank;

public class BankDriver {

	public static void main(String[] args) {
		Bank bank = new Bank();
		/*
		for(Customer c : bank.getCustomerList()){
			System.out.println(c.getLastName());
		}
		*/
		/*
		for(Account a : bank.getAccountList()){
			System.out.println(a.getAccountOwner().getLastName() + ": " + a.getAccountNumber() + ": " + a.getBalance());
		}
		*/
		
		// bank.recordTransactions();
		Customer cust = new Customer("Dmitriy", "Babichenko", "111-11-1111");
		CheckingAccount ca = new CheckingAccount("ABCDE123", "checking", 2000, cust);
		double balance = ca.withdraw(2500);
		// System.out.println(balance);
		System.out.println(ca);
		
		
		
	}
	

}
