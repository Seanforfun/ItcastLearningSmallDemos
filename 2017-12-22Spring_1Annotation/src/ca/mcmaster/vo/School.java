package ca.mcmaster.vo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 22, 2017 4:59:36 PM
 */
@Component
public class School {
	@Value("Mcmaster")
	private String name;
	@Resource(name="student")
	private Student student;
	@Override
	public String toString() {
		return "School [name=" + name + ", student=" + student + "]";
	}
	
	@PostConstruct
	public void start(){
		System.out.println("this is post construct...");
	}
	
	@PreDestroy
	public void teardown(){
		System.out.println("this is pre destroy...");
	}
}
