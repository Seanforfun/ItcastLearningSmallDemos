package ca.mcmaster.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 27, 2018 10:15:18 PM
 */
public class UserMapperTest {
	private SqlSessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(29);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testFindUserByName() throws Exception{
		SqlSession sqlSession = sessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.findUserByName("ean");
		System.out.println(userList);
		sqlSession.close();
	}
}
