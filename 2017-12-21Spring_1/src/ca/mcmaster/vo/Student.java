package ca.mcmaster.vo;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 21, 2017 1:45:01 PM
 */
public class Student {
	private static Student student = new Student();
	public static Student newStudentInstance(){
		return student;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
}
