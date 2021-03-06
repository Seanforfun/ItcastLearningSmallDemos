package ca.mcmaster.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.mcmaster.vo.CustomerDao;
import ca.mcmaster.vo.OrderDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 7:27:57 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class AOPDemo {
	
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	
	@Resource(name="orderDao")
	private OrderDao orderDao;
	@Test
	public void demo1(){
		customerDao.add();
		customerDao.delete();
		orderDao.add();
	}
	
	@Test
	public void demo2(){
		orderDao.add();
		orderDao.delete();
		orderDao.update();
	}
}
