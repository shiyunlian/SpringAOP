package org.shiyun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// covert a standard class to aspect, use @Aspect
@Aspect
public class LoggingAspect {
	
//	//@Before("execution()") makes the advice method run before the target method
//	// the LoggingAdvice will runs before the execution of public String getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Advice1 run in all classes that have getName() method.");
//	}
//
//	// the LoggingAdvice2 will runs before the execution of public String getName() of the Circle class
//	@Before("execution(public String org.shiyun.model.Circle.getName())")
//	public void LoggingAdvice2() {
//		System.out.println("Advice2 run in Circle class.");
//	}
//	
//	// use a wildcard*, the method can be applied to any methods starting with 'get' and return a String
//	// get*(..) means any arguments(0 or any number of arguments)
//	// get*(*) means 1 or more arguments
//	// get*() means 0 argument
//	@Before("execution(public String get*(..))")
//	public void LoggingAdvice3() {
//		System.out.println("Advice3 run in all classes that have get method and return a String.");
//	}
//
//	// use a wildcard*, the method can be applied to any methods starting with 'get' and regardless of the return type
//	@Before("execution(public * get*(..))")
//	public void LoggingAdvice4() {
//		System.out.println("Advice4 run in all classes that have get method regardless of any return types.");
//	}
//	
//	// use a wildcard*, the method can be applied to any methods starting with 'get' in all classes in model package and return a String	
//	@Before("execution(public String org.shiyun.model.*.get*())")
//	public void LoggingAdvice5() {
//		System.out.println("Advice5 run in all classes in model package.");
//	}
//	
//	// any return types of methods that start with 'get' in all classes regardless of public or private method
//	@Before("execution(* get*())")
//	public void LoggingAdvice6() {
//		System.out.println("Advice6 run in all classes that have get method regardless of any return types and methods.");
//	}
//	
	// use Pointcut annotation, annotate a dummy method, use this dummy method as a reference for the Before annotation
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
//	@Before("allGetters()")
//	public void runAllGetters() {
//		System.out.println("all Getters run.");
//	}	
//	
//	@Before("allCircleMethods()")
//	public void runCircleMethods(JoinPoint joinPoint) {
//		System.out.println(joinPoint.toString());
//		System.out.println(joinPoint.getTarget());
//	}	
//	
//	@Before("allGetters() && allCircleMethods()")
//	public void runGetters() {
//		System.out.println("all Getters run.");
//	}
//	
//	// this pointcut applies all the method in model packages
//	@Pointcut("within(org.shiyun.model.*)")
//	public void allMethodsInModel() {};
//
//	// this pointcut applies all the method in model packages or sub packages
//	@Pointcut("within(org.shiyun.model..*)")
//	public void allMethods() {};
//	
//	// this pointcut applies all the method in the Circle class
//	@Pointcut("within(org.shiyun.model.Circle)")
//	public void allCircleMethods() {};
	
//	// apply the advice to all methods that take a single string argument
//	@Before("args(String)")
//	public void stringArgumentMethods() {
//		System.out.println("A method that takes String arguments has been called.");
//	}
//	
//	@Before("args(name)")
//	public void stringArgumentMethods1(String name) {
//		System.out.println("A method that takes String argument "+name+" has been called.");
//	}
//	
//	@After("args(name)")
//	public void stringArgumentMethods2(String name) {
//		System.out.println("A method that takes String argument "+name+" has been called.");
//	}
	
//	// the method runs only after there is a successful return
//	@AfterReturning("args(name)")
//	public void stringArgumentMethods3(String name) {
//		System.out.println("A method that takes String argument "+name+" has been called.");
//	}
//	
//	@AfterReturning(pointcut="args(name)", returning = "returnString")
//	public void stringArgumentMethods3(String name, Object returnString) {
//		System.out.println("A method that takes String argument: "+name+" and return "+returnString);
//	}
//
//	@AfterThrowing("args(name)")
//	public void exceptionAdvice(String name) {
//		System.out.println("An exception has been thrown");
//	}
//	
//	@AfterThrowing(pointcut="args(name)", throwing="ex")
//	public void exceptionAdvice(String name, Exception ex) {
//		System.out.println("An exception "+ex+" has been thrown");
//	}
	
	// apply the advice to all the methods that have @annotation(org.shiyun.aspect.Loggable)
	@Around("@annotation(org.shiyun.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		
		try {
			System.out.println("Before advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After returning");
		} catch (Throwable e) {
			System.out.println("After throwing");
			e.printStackTrace();
		}
		System.out.println("After finally");
		return returnValue;
	}
	
	public void loggingAdvice() {
		System.out.println("Logging from the advice");
	}
}
