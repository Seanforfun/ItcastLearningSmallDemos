package ca.mcmaster.vo;

import java.util.Date;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 26, 2018 1:46:45 PM
 */
public class User {
	private int id;
	private String username;
	private String sex;
	private Date birhday;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirhday() {
		return birhday;
	}
	public void setBirhday(Date birhday) {
		this.birhday = birhday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex
				+ ", birhday=" + birhday + ", address=" + address + "]";
	}
}
