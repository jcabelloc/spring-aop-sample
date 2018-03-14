package edu.tamu.jcabelloc.springaopsample;

public class BankAccount {
	private String accountNumber;
	private String product;
	
	public BankAccount() {
		
	}

	public BankAccount(String accountNumber, String product) {
		this.accountNumber = accountNumber;
		this.product = product;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", product=" + product + "]";
	}
	
}
