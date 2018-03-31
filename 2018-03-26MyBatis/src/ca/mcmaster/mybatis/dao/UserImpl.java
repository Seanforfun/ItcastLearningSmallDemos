package ca.mcmaster.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ca.mcmaster.mybatis.mapper.UserMapper;
import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 27, 2018 9:36:38 PM
 */
public class UserImpl implements UserMapper {
	private SqlSessionFactory sessionFactory;
	public UserImpl(SqlSessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}
	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Override
	public List<User> findUserByName(String username) throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		List<User> userList = sqlSession.selectList("test.findUserByUsername", "ะกร๗");
		sqlSession.close();
		return userList;
	}
	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
