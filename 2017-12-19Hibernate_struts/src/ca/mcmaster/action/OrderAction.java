package ca.mcmaster.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import ca.mcmaster.service.CustomerService;
import ca.mcmaster.vo.Order;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private Integer cid;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getOrdersById() throws IOException {
		CustomerService service = CustomerService.getService();
		List<Order> ret = service.getOrders(cid);
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"customer"});
		JSONArray jsonArray = JSONArray.fromObject(ret , jsonConfig);
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		
		return NONE;
	}
}
