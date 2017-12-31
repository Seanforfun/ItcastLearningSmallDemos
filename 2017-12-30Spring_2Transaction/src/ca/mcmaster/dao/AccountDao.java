package ca.mcmaster.dao;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 5:27:13 PM
 */
public interface AccountDao {
	public void out(String from, Double amount);
	public void in(String to, Double amount);
}
