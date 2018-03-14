package edu.tamu.jcabelloc.springaopsample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* edu.tamu.jcabelloc.springaopsample.dao.*.*(..))")
	private void pointcutForDAOPackage() {}
	
	@Pointcut("execution(* edu.tamu.jcabelloc.springaopsample.dao.*.get*(..))")
	private void getters() {}
	
	@Pointcut("execution(* edu.tamu.jcabelloc.springaopsample.dao.*.set*(..))")
	private void setters() {}
	
	@Pointcut("pointcutForDAOPackage() && !(getters() || setters())")
	private void forDAOPackageNoGetterNoSetter() {}
	
	@Before("forDAOPackageNoGetterNoSetter()")
	public void beforeMethodsInDAOPackageAdvice() {
		System.out.println("\n\n Executing @Before advice on method");
	}
	
	@Before("forDAOPackageNoGetterNoSetter()")
	public void performAuditLogging() {
		System.out.println("\n\n Performing Audit Logging ");
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
