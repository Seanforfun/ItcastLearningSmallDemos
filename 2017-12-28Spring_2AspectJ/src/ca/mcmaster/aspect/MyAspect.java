package ca.mcmaster.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 10:15:13 PM
 */
@Aspect
public class MyAspect {
	@Before("execution(* ca.mcmaster.vo.UserDao.add(..))")
	public void before(JoinPoint joinPoint){
		System.out.println("Before " + joinPoint);
	}
	
	@AfterReturning(value="execution(* ca.mcmaster.vo.UserDao.update(..))", returning="ret")
	public void afterReturning(Object ret){
		System.out.println("AfterReturning" + "return is : " + ret);
	}
	
	@Around(value="execution(* ca.mcmaster.vo.UserDao.delete(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable{
		System.out.println("before execution");
		Object proceed = point.proceed();
		System.out.println("after execution");
		return proceed;
//		return null;
	}
	
	@AfterThrowing(value="execution(* ca.mcmaster.vo.UserDao.search(..))",throwing="e")
	public void afterThrowing(Throwable e){
		System.out.println(e.getMessage());
//		e.getMessage();
	}
	
	@After(value="execution(* ca.mcmaster.vo.UserDao.search(..))")
	public void after(){
		System.out.println("after");
	}
}
