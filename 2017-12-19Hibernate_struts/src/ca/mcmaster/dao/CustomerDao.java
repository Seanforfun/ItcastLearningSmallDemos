package ca.mcmaster.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ca.mcmaster.utils.HibernateUtils;
import ca.mcmaster.vo.Customer;

public class CustomerDao {
	private static CustomerDao dao = new CustomerDao();
	
	public static CustomerDao getCustomerDao(){
		return dao;
	}

	public List<Customer> findAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		System.out.println("dao");
		for(Customer c : list){
			System.out.println(c.toString());
		}
		tx.commit();
		return list;
	}
}
