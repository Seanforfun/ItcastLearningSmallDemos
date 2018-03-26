package ca.mcmaster.mybatis;

import java.io.IOException;
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
 * @version Mar 26, 2018 1:35:16 PM
 */
public class MyBatisFirst {
	SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void init() throws IOException{
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	@Test
	public void testFindUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user= null;
		try {
			user = sqlSession.selectOne("test.findUserById", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		System.out.println(user);
	}
	@Test
	public void testFindUserByName(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> user= null;
		try {
			user = sqlSession.selectList("test.findUserByName", "ะกร๗");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		System.out.println(user);
	}
}
