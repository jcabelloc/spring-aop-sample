package edu.tamu.jcabelloc.springaopsample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.tamu.jcabelloc.springaopsample.dao.BankAccountDAO;

public class AfterReturningSampleApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
		
		BankAccountDAO myBankAccount = context.getBean("bankAccountDAO", BankAccountDAO.class);
		
		System.out.println(myBankAccount.findBankAccounts());
		
		context.close();

	}

}
