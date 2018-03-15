package edu.tamu.jcabelloc.springaopsample.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.tamu.jcabelloc.springaopsample.BankAccount;

@Aspect
@Component
@Order(3)
public class LoggingAspect {
	
	
	@Around("execution(* edu.tamu.jcabelloc.springaopsample.service.*.getRate(..))")
	public Object aroundGetRate(ProceedingJoinPoint myProceedingJoinPoint) throws Throwable{
		
		String method = myProceedingJoinPoint.getSignature().toString();
		System.out.println("\n\n----- Executing @Around on Method: " + method);
		
		long start = System.currentTimeMillis();
		
		Object result = myProceedingJoinPoint.proceed();
		
		long finish = System.currentTimeMillis();
		
		long duration = finish - start;
		
		System.out.println("\n\n------------- Duration: " + duration/1000 + " seconds");
		
		return result;
	}
	
	// Adding @After annotation 
	@After("execution(* edu.tamu.jcabelloc.springaopsample.dao.BankAccountDAO.findBankAccounts(..))")
	public void afterFinallyFindBankAccounts(JoinPoint myJoinPoint) {
		
		String method = myJoinPoint.getSignature().toString();
		System.out.println("\n\n----- Executing @After on Method: " + method);
	}
	
	// New @AfterThrowing annotation 
	@AfterThrowing(
			pointcut="execution(* edu.tamu.jcabelloc.springaopsample.dao.BankAccountDAO.findBankAccounts(..))",
			throwing="finderException")
	public void afterThrowingFindBankAccounts(JoinPoint myJoinPoint, Throwable finderException) {
		
		String method = myJoinPoint.getSignature().toString();
		
		System.out.println("\n\n----- Executing @AfterThrowing on Method: " + method);
		
		System.out.println("\n\n----- The Advice Exception is: " + finderException);
	}
	
	
	// New @AfterReturning annotation 
	@AfterReturning(
			pointcut="execution(* edu.tamu.jcabelloc.springaopsample.dao.BankAccountDAO.findBankAccounts(..))",
			returning="resultData")
	public void afterReturningFindBankAccounts(JoinPoint myJoinPoint, List<BankAccount> resultData) {
		
		String method = myJoinPoint.getSignature().toString();
		System.out.println("\n\n----- Executing @AfterReturning on Method: " + method);
		
		System.out.println("\n\n----- The result data is: " + resultData);
		
		// Modifying the data before delivering to the calling program
		convertProductNamesToUpperCase(resultData);

		System.out.println("\n\n----- The NEW result data is: " + resultData);

	}
	
	private void convertProductNamesToUpperCase(List<BankAccount> resultData) {
		for (BankAccount anAccount: resultData) {
			String productUpperName = anAccount.getProduct().toUpperCase();
			anAccount.setProduct(productUpperName);
		}
	}


	@Before("edu.tamu.jcabelloc.springaopsample.aspect.UtilAOPExpressions.forDAOPackageNoGetterNoSetter()")
	public void beforeMethodsInDAOPackageAdvice(JoinPoint myJoinPoint) {
		System.out.println("\n\n Executing @Before advice on method");
		
		//Displaying Method's Signature and Arguments
		
		MethodSignature signature = (MethodSignature)myJoinPoint.getSignature();
		System.out.println("Method Signature: " + signature);
		
		Object[] args = myJoinPoint.getArgs();
		for (Object anArg: args) {
			System.out.println(anArg);
		}
	}

	/*
	@Before("pointcutForDAOPackage()")
	public void beforeMethodsInDAOPackageAdvice() {
		System.out.println("\n\n Executing @Before advice on method");
	}
	
	@Before("pointcutForDAOPackage()")
	public void performAuditLogging() {
		System.out.println("\n\n Performing Audit Logging ");
	}
	*/
	
	/*@Before("execution(* edu.tamu.jcabelloc.springaopsample.dao.*.*(..))")
	public void beforeDeposit() {
		System.out.println("\n\n Executing @Before advice on method");
	}*/
}
