package edu.tamu.jcabelloc.springaopsample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.tamu.jcabelloc.springaopsample.dao.BankAccountDAO;

public class AfterThrowingSampleApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
		
		BankAccountDAO myBankAccount = context.getBean("bankAccountDAO", BankAccountDAO.class);
		
		List<BankAccount> bankAccounts = new ArrayList<>();
		
		try {
			boolean flagException = true;
			bankAccounts = myBankAccount.findBankAccounts(flagException);
		}
		catch(Exception e){
			System.out.println("\n Exception Caught in the Main Program: " + e);
		}
		
		System.out.println(bankAccounts);
		
		context.close();

	}

}
