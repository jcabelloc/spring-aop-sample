package edu.tamu.jcabelloc.springaopsample.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	// New @AfterReturning annotation 
	@AfterReturning(
			pointcut="execution(* edu.tamu.jcabelloc.springaopsample.dao.BankAccountDAO.findBankAccounts(..))",
			returning="resultData")
	public void afterReturningFindBankAccounts(JoinPoint myJoinPoint, List<BankAccount> resultData) {
		
		String method = myJoinPoint.getSignature().toString();
		System.out.println("\n\n----- Executing @AfterReturning on Method: " + method);
		
		System.out.println("\n\n----- The result data is: " + resultData);
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
