package ca.mcmaster.exception;

public class FindUserException extends Exception {

	public FindUserException() {
		super();
	}

	public FindUserException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public FindUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FindUserException(String arg0) {
		super(arg0);
	}

	public FindUserException(Throwable arg0) {
		super(arg0);
	}

}
