package ca.mcmaster.mybatis.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.mcmaster.mybatis.po.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Mar 31, 2018 9:18:32 PM
 * @version 1.0
 */
public class UserMapperTest {
	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserMapper mapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = mapper.findUserById(1);
		System.out.println(user);
	}

}
