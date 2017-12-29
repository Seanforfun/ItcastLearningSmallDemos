package ca.mcmaster.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 8:00:47 PM
 */
public class MyArroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("BRFORE");
		Object proceed = methodInvocation.proceed();
		System.out.println("AFTER");
		return proceed;
	}

}
