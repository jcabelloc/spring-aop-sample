package edu.tamu.jcabelloc.springaopsample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAnalyticsAspect {

	@Before("edu.tamu.jcabelloc.springaopsample.aspect.UtilAOPExpressions.forDAOPackageNoGetterNoSetter()")
	public void logForAnalytics() {
		System.out.println("\n\n Log For Analytics purposes");
	}
}
