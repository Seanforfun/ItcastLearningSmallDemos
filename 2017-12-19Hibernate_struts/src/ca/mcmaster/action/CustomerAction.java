package ca.mcmaster.action;

import java.util.List;

import ca.mcmaster.service.CustomerService;
import ca.mcmaster.vo.Customer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class CustomerAction extends ActionSupport {
	public String findAll(){
		CustomerService service = CustomerService.getService();
		List<Customer> list = service.findAll();
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("userInfo", list);
		return "success";
	}
}
