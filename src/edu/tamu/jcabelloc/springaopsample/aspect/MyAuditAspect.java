package edu.tamu.jcabelloc.springaopsample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAuditAspect {
	
	@Before("edu.tamu.jcabelloc.springaopsample.aspect.UtilAOPExpressions.forDAOPackageNoGetterNoSetter()")
	public void performAuditLogging() {
		System.out.println("\n\n Performing Audit Logging ");
	}

}
