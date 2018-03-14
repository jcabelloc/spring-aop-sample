package edu.tamu.jcabelloc.springaopsample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UtilAOPExpressions {

	@Pointcut("execution(* edu.tamu.jcabelloc.springaopsample.dao.*.*(..))")
	public void pointcutForDAOPackage() {}
	
	@Pointcut("execution(* edu.tamu.jcabelloc.springaopsample.dao.*.get*(..))")
	public void getters() {}
	
	@Pointcut("execution(* edu.tamu.jcabelloc.springaopsample.dao.*.set*(..))")
	public void setters() {}
	
	@Pointcut("pointcutForDAOPackage() && !(getters() || setters())")
	public void forDAOPackageNoGetterNoSetter() {}

}
