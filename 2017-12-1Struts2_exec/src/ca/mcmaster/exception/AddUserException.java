package ca.mcmaster.exception;

public class AddUserException extends Exception {

	public AddUserException() {
		super();
	}

	public AddUserException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AddUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AddUserException(String arg0) {
		super(arg0);
	}

	public AddUserException(Throwable arg0) {
		super(arg0);
	}

}
