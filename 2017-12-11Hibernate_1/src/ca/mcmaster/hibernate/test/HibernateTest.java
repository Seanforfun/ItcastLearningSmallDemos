package ca.mcmaster.hibernate.test;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import ca.mcmaster.hibernate.HibernateUtils;
import ca.mcmaster.hibernate.domain.Customer;

public class HibernateTest {

	@Test
	public void testDemo(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("Sean");
		customer.setAge(24);
		session.save(customer);
		transaction.commit();
		session.close();
	}
}
