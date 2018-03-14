package edu.tamu.jcabelloc.springaopsample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingAspect {
	
	
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
