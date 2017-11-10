package ca.mcmaster.service;

import java.sql.SQLException;

import ca.mcmaster.dao.LoginDao;
import ca.mcmaster.vo.Users;

public class LoginService {

	public Users login(String username, String password) throws SQLException {
		return new LoginDao().login(username, password);
	}

}
