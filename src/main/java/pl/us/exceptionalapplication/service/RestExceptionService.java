package pl.us.exceptionalapplication.service;

import org.springframework.stereotype.Service;

import pl.us.exceptionalapplication.exceptions.CustomException1;
import pl.us.exceptionalapplication.exceptions.CustomExceptionCaughtByControllerAdvice1;
import pl.us.exceptionalapplication.exceptions.CustomExceptionCaughtByControllerAdvice2;
import pl.us.exceptionalapplication.exceptions.CustomExceptionWithResponseStatus;

@Service
public class RestExceptionService {
	public String exceptionHandler(boolean doThrow) {
		if(doThrow)
			throw new CustomException1();
		return "Did nothing";
	}

	public String exceptionWithResponseStatusExceptionResolver(boolean doThrow) {
		if (doThrow)
			throw new CustomExceptionWithResponseStatus();
		return "Did nothing";
	}

	public String exceptionWithRestControllerAdvice(boolean exception1, boolean exception2) {
		if(exception1) {
			throw new CustomExceptionCaughtByControllerAdvice1();
		} else if(exception2){
			throw new CustomExceptionCaughtByControllerAdvice2();
		}
		return "Did nothing";
	}
}
