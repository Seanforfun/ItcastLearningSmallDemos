package ca.mcmaster.mybatis.mapper;

import java.util.List;

import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 27, 2018 9:35:38 PM
 */
public interface UserMapper {
	public User findUserById(int id) throws Exception;
	public List<User> findUserByName(String username) throws Exception;
	public void insertUser(User user) throws Exception;
}
