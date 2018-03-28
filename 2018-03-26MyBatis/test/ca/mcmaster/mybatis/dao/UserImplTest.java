package ca.mcmaster.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ca.mcmaster.mybatis.mapper.UserMapper;
import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 27, 2018 9:42:44 PM
 */
public class UserImplTest {
	private SqlSessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testFindUserById() throws Exception {
		UserMapper userDao = new UserImpl(sessionFactory);
		User user = userDao.findUserById(29);
		System.out.println(user);
	}

}
