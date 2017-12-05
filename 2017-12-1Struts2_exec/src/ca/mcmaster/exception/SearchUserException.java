package ca.mcmaster.exception;

public class SearchUserException extends Exception {

	public SearchUserException() {
		super();
	}

	public SearchUserException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public SearchUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SearchUserException(String arg0) {
		super(arg0);
	}

	public SearchUserException(Throwable arg0) {
		super(arg0);
	}
	
}
