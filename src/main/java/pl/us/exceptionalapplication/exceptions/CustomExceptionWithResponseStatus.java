package pl.us.exceptionalapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomExceptionWithResponseStatus extends RuntimeException {
	public CustomExceptionWithResponseStatus() {
		super("Thrown exception and resolved by ResponseStatusExceptionResolver");
	}}
