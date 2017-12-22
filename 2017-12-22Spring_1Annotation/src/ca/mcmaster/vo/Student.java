package ca.mcmaster.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 22, 2017 5:00:24 PM
 */
@Component
public class Student {
	@Value("Sean")
	private String name;
}
