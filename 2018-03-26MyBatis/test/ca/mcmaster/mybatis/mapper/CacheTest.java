package ca.mcmaster.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Mar 31, 2018 5:29:27 PM
 * @version 1.0
 */
public class CacheTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	@Test
	public void testCache1() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user1 = mapper.findUserById(1);
		user1.setUsername("testtest");
		mapper.updateUser(user1);
		sqlSession.commit();
		User user2 = mapper.findUserById(1);
		sqlSession.close();
		System.out.println(user2);
	}
	
	@Test
	public void testCache2() throws Exception{
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		User user1 = mapper1.findUserById(1);
		System.out.println(user1);
		sqlSession1.close();
		user1.setUsername("1111");
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
		mapper3.updateUser(user1);
		sqlSession3.commit();
		sqlSession3.close();
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = mapper2.findUserById(1);
		sqlSession2.close();
		System.out.println(user2);
	}
}
