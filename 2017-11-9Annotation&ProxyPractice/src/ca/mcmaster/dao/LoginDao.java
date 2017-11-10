package ca.mcmaster.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import ca.mcmaster.utils.DataSourceUtils;
import ca.mcmaster.vo.Users;

public class LoginDao {

	public Users login(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from users where username = ? and password = ?";
		Users user = runner.query(sql, new BeanHandler<Users>(Users.class), username, password);
		return user;
	}

}
