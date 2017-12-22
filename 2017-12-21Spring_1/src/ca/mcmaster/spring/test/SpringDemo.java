package ca.mcmaster.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.mcmaster.vo.BeanDemo;
import ca.mcmaster.vo.BeanDemoImpl;
import ca.mcmaster.vo.Customer;
import ca.mcmaster.vo.Student;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Dec 21, 2017 12:08:14 PM
 */
public class SpringDemo {
	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer = (Customer) applicationContext.getBean("customer");
		Customer customer1 = (Customer) applicationContext.getBean("customer");
		System.out.println(customer);
		System.out.println(customer1);
	}
	
	@Test
	public void demo2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = (Student) applicationContext.getBean("student");
		System.out.println(student);
	}
	
	/**
	 * @Description Test the life cycle of a bean
	 */
	@Test
	public void demo3(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanDemo bean =  (BeanDemo) applicationContext.getBean("beanDemo");
		bean.say();
		applicationContext.close();
	}
}
