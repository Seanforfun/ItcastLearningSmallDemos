package ca.mcmaster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 29, 2017 8:58:09 PM
 */
public class UserDao extends JdbcDaoSupport {
	public void add(User user) {
		String sql = "insert into user values (null, ?)";
		getJdbcTemplate().update(sql, user.getUsername());
	}

	public void update(User user) {
		String sql = "update user set name = ? where id = ?";
		this.getJdbcTemplate().update(sql, user.getUsername(), user.getId());
	}

	public void delete(User user) {
		String sql = "delete from user where id = ?";
		this.getJdbcTemplate().update(sql, user.getId());
	}
	
	public User getUserById(int id){
		String sql = "select * from user where id=?";
		User user = (User) this.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("name"));
				return user;
			}
		}, id);
		
		return user;
	}
	
	public List<User> findAll(){
		String sql = "select * from user";
		List<User> list = this.getJdbcTemplate().query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("name"));
				return user;
			}
		});
		return list;
	}
}
