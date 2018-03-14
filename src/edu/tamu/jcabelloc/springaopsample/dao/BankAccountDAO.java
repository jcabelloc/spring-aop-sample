package edu.tamu.jcabelloc.springaopsample.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BankAccountDAO {
	
	private String accountNumber;
	private BigDecimal balance; 
	
	public void deposit(double amount) {
		System.out.println(getClass() + " Doing deposit to the Bank Account..."); 
	}
	
	public String toString() {
		System.out.println(getClass() + " toString in the Bank Account...");		
		return getClass().toString();
 
	}

	public String getAccountNumber() {
		System.out.println(getClass() + "... inside getAccountNumber()");		
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		System.out.println(getClass() + "... inside setAccountNumber()");
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		System.out.println(getClass() + "... inside getBalance()");				
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		System.out.println(getClass() + "... inside setBalance()");				
		this.balance = balance;
	}
	
	
}
