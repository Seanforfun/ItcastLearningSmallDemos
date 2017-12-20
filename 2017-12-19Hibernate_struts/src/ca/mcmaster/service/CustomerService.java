package ca.mcmaster.service;

import java.util.List;
import java.util.Set;

import ca.mcmaster.dao.CustomerDao;
import ca.mcmaster.vo.Customer;
import ca.mcmaster.vo.Order;

public class CustomerService {
	private static CustomerService service = new CustomerService();
	
	public static CustomerService getService(){
		return service;
	}

	public List<Customer> findAll() {
		CustomerDao dao = CustomerDao.getCustomerDao();
		List<Customer> list = dao.findAll();
		return list;
	}

	public void delete(Customer customer) {
		CustomerDao dao = CustomerDao.getCustomerDao();
		dao.delete(customer);
	}

	public List<Order> getOrders(Integer cid) {
		CustomerDao dao = CustomerDao.getCustomerDao();
		List<Order> orders = dao.getOrders(cid);
		return orders;
	}
}
