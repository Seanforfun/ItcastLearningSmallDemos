package ca.mcmaster.web.service;

import java.sql.SQLException;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import ca.mcmaster.domain.User;
import ca.mcmaster.web.dao.UserDao;

public class UserService {

	public User login(User user) throws SQLException {
		return new UserDao().findUser(user);
	}

	public List<User> getUserList() throws SQLException {
		return new UserDao().getUserList();
	}

	public void addUser(User user) throws SQLException {
		new UserDao().addUser(user);
	}

	public List<User> searchUser(User model, boolean hasResume) throws SQLException {
		return new UserDao().searchUser(model, hasResume); 
	}

	public void deleteUser(int userID) throws SQLException {
		new UserDao().deleteUser(userID);
		return;
	}

	public User findUserById(int userID) throws SQLException {
		return new UserDao().findUserById(userID);
	}

	public void modifyUser(User user) throws SQLException {
		new UserDao().modifyUser(user);
	}
}
