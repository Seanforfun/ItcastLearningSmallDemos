package ca.mcmaster.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.mcmaster.vo.UserDao;


/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 10:24:24 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AspectDemo {
	@Resource(name="userDao")
	private UserDao userDao;
	@Test
	public void demo1() throws Exception{
		userDao.add();
		userDao.delete();
		userDao.update();
		userDao.search();
	}
}
