package edu.tamu.jcabelloc.springaopsample;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.tamu.jcabelloc.springaopsample.dao.BankAccountDAO;
import edu.tamu.jcabelloc.springaopsample.dao.SavingAccountDAO;

public class MainSampleApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
		
		BankAccountDAO myBankAccount = context.getBean("bankAccountDAO", BankAccountDAO.class);
		
		SavingAccountDAO mySavingAccount = context.getBean("savingAccountDAO", SavingAccountDAO.class);
		
		myBankAccount.deposit(100.0);
		
		mySavingAccount.deposit(new BigDecimal(100.0), "direct");
		
		myBankAccount.toString();
		
		
		myBankAccount.setAccountNumber("123456");
		myBankAccount.setBalance(new BigDecimal(1000.0));
		
		myBankAccount.getAccountNumber();
		myBankAccount.getBalance();
		
		context.close();
	}

}
