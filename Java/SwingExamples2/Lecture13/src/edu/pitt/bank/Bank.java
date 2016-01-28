package edu.pitt.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accountList;
	private ArrayList<Customer> customerList;
	
	public Bank(){
		accountList = new ArrayList<Account>();
		customerList = new ArrayList<Customer>();
		importBankAccounts();
	}
	
	private void importBankAccounts(){
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader("data/AccountList.txt");
			br = new BufferedReader(fr); 
	        String line = null;
	        while ((line = br.readLine()) != null) {
	            String[] accountInfo = line.split(",");
	            if(accountInfo.length == 11){
	            	Customer customer = new Customer(accountInfo[1], accountInfo[0], accountInfo[6]);
	            	this.customerList.add(customer);
	            	Account account = new Account(accountInfo[7], accountInfo[10], Double.parseDouble(accountInfo[8]), customer);
	            	this.accountList.add(account);
	            }
	            // System.out.println(accountInfo.length);
	        	// System.out.println(line);
	        }
	        br.close();
	        fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Unable to find data file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Unable to access data file");
		} 
		
        
	}
	
	public void recordTransactions(){
		try {
            FileWriter fw = new FileWriter("data/output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(Account a : this.getAccountList()){
            	String logLine = a.getAccountOwner().getLastName() + ": " + a.getAccountNumber() + ": " + a.getBalance();
            	bw.write(logLine);
                bw.newLine();
                
    		}
            
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void addAccount(Account acct){
		this.accountList.add(acct);
	}
	
	public void addCustomer(Customer cust){
		this.customerList.add(cust);
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	
}
