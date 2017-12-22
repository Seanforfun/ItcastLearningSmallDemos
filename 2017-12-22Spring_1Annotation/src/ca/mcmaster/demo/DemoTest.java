package ca.mcmaster.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.mcmaster.vo.Car;
import ca.mcmaster.vo.School;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 22, 2017 4:22:18 PM
 */
public class DemoTest {

	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) applicationContext.getBean("car");
		car.run();
		System.out.println(car);
	}
	
	@Test
	public void demo2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		School school = (School)applicationContext.getBean("school");
		System.out.println(school);
	}
	
	@Test
	public void demo3(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		School school = (School)applicationContext.getBean("school");
		applicationContext.close();
	}
}
