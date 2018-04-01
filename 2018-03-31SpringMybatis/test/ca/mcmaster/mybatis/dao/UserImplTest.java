package ca.mcmaster.mybatis.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.mcmaster.mybatis.po.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Mar 31, 2018 8:40:26 PM
 * @version 1.0
 */
public class UserImplTest {
	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
	}

	@Test
	public void testFindUserByName() {
	}
}
