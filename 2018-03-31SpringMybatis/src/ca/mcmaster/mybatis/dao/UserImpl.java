package ca.mcmaster.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import ca.mcmaster.mybatis.po.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 27, 2018 9:36:38 PM
 */
public class UserImpl extends SqlSessionDaoSupport implements UserDao {
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("ca.mcmaster.mybatis.mapper.UserMapper.findUserById", id);
		return user;
	}
	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("ca.mcmaster.mybatis.mapper.UserMapper.insertUser", user);
		sqlSession.commit();
	}
	@Override
	public List<User> findUserByUsername(String username) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		List<User> userList = sqlSession.selectList("ca.mcmaster.mybatis.mapper.UserMapper.findUserByUsername", "ะกร๗");
		return userList;
	}
}
