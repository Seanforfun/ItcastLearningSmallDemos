package ca.mcmaster.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 7:14:38 PM
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("advice before....");
	}


}
