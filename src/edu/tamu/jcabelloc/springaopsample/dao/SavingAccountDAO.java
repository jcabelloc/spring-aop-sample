package edu.tamu.jcabelloc.springaopsample.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SavingAccountDAO {
	
	public boolean deposit(BigDecimal amount, String type) {
		System.out.println(getClass() + " Doing Deposit to Saving Account");
		return true;
	}
}
