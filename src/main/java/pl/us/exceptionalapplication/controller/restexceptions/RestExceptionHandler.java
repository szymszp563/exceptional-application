package pl.us.exceptionalapplication.controller.restexceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pl.us.exceptionalapplication.exceptions.CustomExceptionCaughtByControllerAdvice1;
import pl.us.exceptionalapplication.exceptions.CustomExceptionCaughtByControllerAdvice2;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(CustomExceptionCaughtByControllerAdvice1.class)
	public ResponseEntity<String> handleException1(RuntimeException ex){
		return ResponseEntity.status(500).body("handled exception1 in RestControllerAdvice, with message: " + ex.getMessage());
	}

	@ExceptionHandler(CustomExceptionCaughtByControllerAdvice2.class)
	public ResponseEntity<String> handleException2(RuntimeException ex){
		return ResponseEntity.status(500).body("handled exception2 in RestControllerAdvice, with message: " + ex.getMessage());
	}
}
