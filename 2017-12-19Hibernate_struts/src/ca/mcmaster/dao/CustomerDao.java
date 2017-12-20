package ca.mcmaster.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ca.mcmaster.utils.HibernateUtils;
import ca.mcmaster.vo.Customer;
import ca.mcmaster.vo.Order;

public class CustomerDao {
	private static CustomerDao dao = new CustomerDao();
	
	public static CustomerDao getCustomerDao(){
		return dao;
	}

	public List<Customer> findAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		tx.commit();
		return list;
	}

	public void delete(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer ret = (Customer) session.get(Customer.class, customer.getCid());
		session.delete(ret);
		tx.commit();
	}

	public List<Order> getOrders(Integer cid) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Order o where o.customer.cid = ?");
		query.setParameter(0, cid);
		List<Order> list = query.list();
		tx.commit();
		return list;
	}
}
