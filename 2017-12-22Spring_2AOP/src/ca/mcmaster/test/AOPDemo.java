package ca.mcmaster.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.mcmaster.vo.CustomerDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 7:27:57 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPDemo {
	
	@Resource(name="custoemrDaoProxy")
	private CustomerDao customerDao;
	
	@Test
	public void demo1(){
		customerDao.add();
		customerDao.delete();
	}
}
