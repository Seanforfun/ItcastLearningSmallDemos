package ca.mcmaster.vo;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 10:13:16 PM
 */
public class UserDao {
	public void add(){
		System.out.println("add user");
	}
	public void delete(){
		System.out.println("delete user");
	}
	public int update(){
		System.out.println("update user");
		return 1;
	}
	public void search() throws Exception{
		System.out.println("search user");
		throw new Exception("error message");
	}
}
