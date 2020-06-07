package pl.us.exceptionalapplication.exceptions;

public class CustomExceptionCaughtByControllerAdvice1 extends RuntimeException {
	public CustomExceptionCaughtByControllerAdvice1() {
		super("Thrown exception 1 and resolved by RestControllerAdvice");
	}}
