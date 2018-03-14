package edu.tamu.jcabelloc.springaopsample.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.tamu.jcabelloc.springaopsample.BankAccount;

@Component
public class BankAccountDAO {
	
	private String accountNumber;
	private BigDecimal balance; 
	
	public void deposit(double amount) {
		System.out.println(getClass() + " Doing deposit to the Bank Account..."); 
	}
	
	public String toString() {
		System.out.println(getClass() + " Doing toString in the Bank Account...");		
		return getClass().toString();
 
	}
	
	public List<BankAccount> findBankAccounts(){
		List<BankAccount> bankAccounts = new ArrayList<>();
		
		BankAccount bankAccount1 = new BankAccount("123","vip");
		BankAccount bankAccount2 = new BankAccount("234","platinum");
		BankAccount bankAccount3 = new BankAccount("345","gold");
		
		bankAccounts.add(bankAccount1);
		bankAccounts.add(bankAccount2);
		bankAccounts.add(bankAccount3);
		
		return bankAccounts;
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
