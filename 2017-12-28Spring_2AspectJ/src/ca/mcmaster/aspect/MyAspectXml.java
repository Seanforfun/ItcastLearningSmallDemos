package ca.mcmaster.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 29, 2017 5:39:26 PM
 */
public class MyAspectXml {
	public void before(){
		System.out.println("before advise...");
	}
	
	public void afterReturning(Object returnVal){
		System.out.println("after advise.." + returnVal);
	}
	
	public Object round(ProceedingJoinPoint point) throws Throwable{
		System.out.println("before around");
		Object proceed = point.proceed();
		System.out.println("after around");
		return proceed;
	}
	
	public void afterThrowing(Throwable throwVal) {
		System.out.println("error, msg : " + throwVal.getMessage() );
	}
	
	public void after(){
		System.out.println("final advice...");
	}
}
