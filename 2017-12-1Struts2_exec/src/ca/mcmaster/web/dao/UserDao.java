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

	public List<User> searchUser(User model, boolean hasResume)
			throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = null;
		if (!hasResume) {
			sql = "select * from user where username=? and sex=? and education=? and filename is null";
		} else {
			sql = "select * from user where username=? and sex=? and education=? and filename is not null";
		}

		List<User> list = runner.query(sql, new BeanListHandler<User>(
				User.class), model.getUsername(), model.getSex(), model
				.getEducation());
		return list;
	}

	public void deleteUser(int userID) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from user where userID=?";
		runner.update(sql, userID);
	}

	public User findUserById(int userID) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where userID = ?";
		User result = runner.query(sql, new BeanHandler<User>(User.class),
				userID);
		return result;
	}

	public void modifyUser(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set USERNAME=?,  LOGINNAME=?, LOGINPWD=?, sex=?, birthday=?, education = ?, telephone=?, interest=?, path =?, filename=?, remark=? where userID = ?";
		runner.update(sql, user.getUsername(), user.getLoginName(),
				user.getLoginPwd(), user.getSex(), user.getBirthday(),
				user.getEducation(), user.getTelephone(), user.getInterest(),
				user.getPath(), user.getFilename(), user.getRemark(),
				user.getUserID());
	}
}
