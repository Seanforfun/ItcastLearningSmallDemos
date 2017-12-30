package ca.mcmaster.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.mcmaster.dao.UserDao;
import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 29, 2017 7:30:12 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJDBCDemo2 {
	@Resource(name="userDao")
	private UserDao userDao;
	@Test
	public void demo1() {
		User user = new User();
		user.setUsername("1");
		userDao.add(user);
	}

	@Test
	public void demo2() {
		User user = new User();
		user.setId(5);
		userDao.delete(user);
	}
	
	@Test
	public void  demo3() {
		User user = new User();
		user.setId(4);
		user.setUsername("new name");
		userDao.update(user);
	}
	
	@Test
	public void demo4(){
		User user = userDao.getUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void demo5(){
		List<User> list = userDao.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
