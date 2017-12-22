package ca.mcmaster.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 22, 2017 4:20:33 PM
 */

@Component
public class Car {
	@Value("bmw")
	private String name;
	public void run(){
		System.out.println("running...");
	}
	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}
}
