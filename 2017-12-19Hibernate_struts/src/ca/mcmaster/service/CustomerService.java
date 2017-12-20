package ca.mcmaster.service;

import java.util.List;

import ca.mcmaster.dao.CustomerDao;
import ca.mcmaster.vo.Customer;

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
}
