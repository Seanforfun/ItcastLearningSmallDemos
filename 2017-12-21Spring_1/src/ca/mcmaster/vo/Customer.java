package ca.mcmaster.vo;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 21, 2017 12:05:24 PM
 */
public class Customer {
	private String name;
	private Car car;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
//	@Override
//	public String toString() {
//		return "Customer [name=" + name + ", car=" + car + "]";
//	}
}
