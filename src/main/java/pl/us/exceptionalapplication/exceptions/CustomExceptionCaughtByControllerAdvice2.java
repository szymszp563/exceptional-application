package pl.us.exceptionalapplication.exceptions;

public class CustomExceptionCaughtByControllerAdvice2 extends RuntimeException {
	public CustomExceptionCaughtByControllerAdvice2() {
		super("Thrown exception 2 and resolved by RestControllerAdvice");
	}}
