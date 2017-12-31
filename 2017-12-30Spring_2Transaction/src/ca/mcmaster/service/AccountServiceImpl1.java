package ca.mcmaster.service;

import javax.annotation.Resource;

import ca.mcmaster.dao.AccountDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 6:50:58 PM
 */
public class AccountServiceImpl1 implements AccountService {

	@Resource(name="accountDao")
	private AccountDao accountDao;
	@Override
	public void transfer(String from, String to, Double amount) {
		accountDao.out(from, amount);
		int e = 1/0;
		accountDao.in(to, amount);
	}
}
