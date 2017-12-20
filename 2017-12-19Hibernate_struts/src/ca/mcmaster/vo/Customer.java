package ca.mcmaster.vo;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer cid;
	private String cname;
	private Set<Order> orders = new HashSet<Order>();

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
