package ca.mcmaster.ssm.exception;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 4, 2018 3:46:28 PM
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CustomException extends RuntimeException {
	String message = null;
	public CustomException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
