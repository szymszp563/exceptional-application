package pl.us.exceptionalapplication.exceptions;

public class CustomException1 extends RuntimeException {
	public CustomException1() {
		super("EXCEPTION1 thrown!");
	}

	public CustomException1(String message) {
		super(message);
	}
}
