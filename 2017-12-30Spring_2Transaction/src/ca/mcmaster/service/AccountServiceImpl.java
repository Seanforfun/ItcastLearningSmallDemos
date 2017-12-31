package ca.mcmaster.service;

import javax.annotation.Resource;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import ca.mcmaster.dao.AccountDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 5:26:46 PM
 */
public class AccountServiceImpl implements AccountService {
	@Resource(name="accountDao")
	private AccountDao accountDao;
	@Resource(name="transactionTemplate")
	private TransactionTemplate transactionTemplate;
	@Override
	public void transfer(final String from, final String to, final Double amount) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				accountDao.out(from, amount);
				int d=1/0;
				accountDao.in(to, amount);
			}
		});
	}
}
