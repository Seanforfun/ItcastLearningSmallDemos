package ca.mcmaster.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 5:28:36 PM
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void out(String from, Double amount) {
		String sql = "update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(sql, amount, from);
	}

	@Override
	public void in(String to, Double amount) {
		String sql = "update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql, amount, to);
	}
}
