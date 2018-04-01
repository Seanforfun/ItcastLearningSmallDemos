package ca.mcmaster.mybatis.dao;

import java.util.List;

import ca.mcmaster.mybatis.po.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 27, 2018 9:35:38 PM
 */
public interface UserDao {
	public User findUserById(int id) throws Exception;
	public List<User> findUserByUsername(String username) throws Exception;
	public void insertUser(User user) throws Exception;
}
