package ca.mcmaster.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import ca.mcmaster.domain.User;
import ca.mcmaster.utils.DataSourceUtils;

public class UserDao {

	public User findUser(User user) throws SQLException {
		String sql = "select * from user where LOGINNAME=? and LOGINPWD=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		User ret = runner.query(sql, new BeanHandler<User>(User.class),
				user.getLoginName(), user.getLoginPwd());
		return ret;
	}

	public List<User> getUserList() throws SQLException {
		String sql = "select * from user";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<User> list = runner.query(sql, new BeanListHandler<User>(
				User.class));
		return list;
	}

	public void addUser(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(null,?,?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql, user.getUsername(), user.getLoginName(),
				user.getLoginPwd(), user.getSex(), user.getBirthday(),
				user.getEducation(), user.getTelephone(), user.getInterest(),
				user.getPath(), user.getFilename(), user.getRemark());
		return;
	}
}
