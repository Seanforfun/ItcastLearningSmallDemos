package ca.mcmaster.vo;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 28, 2017 7:09:16 PM
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void add() {
		System.out.println("customer add");
	}

	@Override
	public void delete() {
		System.out.println("customer delete");
	}

	@Override
	public void update() {
		System.out.println("customer update");
	}

	@Override
	public void search() {
		System.out.println("customer search");
	}

}
