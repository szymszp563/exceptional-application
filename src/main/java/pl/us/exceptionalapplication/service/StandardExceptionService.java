package pl.us.exceptionalapplication.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import pl.us.exceptionalapplication.exceptions.CustomException1;
import pl.us.exceptionalapplication.exceptions.CustomException2;
import pl.us.exceptionalapplication.exceptions.CustomException3;
import pl.us.exceptionalapplication.exceptions.CustomException4;

@Service
public class StandardExceptionService {

	public String rethrow(boolean doThrow) throws FileNotFoundException {
		if (doThrow) {
			Scanner contents = new Scanner(new File("not existing path"));
		}
		return "Did nothing";
	}

	public String tryCatch(boolean doThrow) {
		String message = "";
		try {
			message = "Exception is: ";
			if (doThrow) {
				throw new RuntimeException("Thrown!");
			}
		} catch (RuntimeException ex) {
			message += ex.getMessage() + " and Caught!";
		}

		return doThrow ? message : message + "Not thrown";
	}

	public String tryCatchFinally(boolean doThrow) {
		String message = "";
		try {
			message = "Exception is: ";
			if (doThrow) {
				throw new RuntimeException("Thrown!");
			}
		} catch (RuntimeException ex) {
			message += ex.getMessage() + " and Caught!";
		} finally {
			message += " (now I'm in finally block) ";
		}

		return doThrow ? message : message + "Not thrown";
	}

	public String tryFinally(boolean doThrow) {
		try {
			if (doThrow) {
				throw new RuntimeException("Thrown!");
			}
		} finally {
			return "Exception omitted using finally block (never do that!)";
		}
	}

	public String tryWithResources(boolean doThrow) throws FileNotFoundException {
		if(doThrow) {
			try (Scanner scanner = new Scanner(new File("not existing path"))){//closing AutoCloseable object
				//sth happens here
			}
		}
		return "Did nothing";
	}

	public String tryWithMultiCatch(boolean exception1, boolean exception2, boolean exception3, boolean exception4) {
		try {
			if(exception1) {
				throw new CustomException1();
			} else if (exception2) {
				throw new CustomException2();
			} else if (exception3) {
				throw new CustomException3();
			} else if (exception4) {
				throw new CustomException4();
			}
		} catch (CustomException1 ex14) { //catches Exception 1 or Exception 4 because 4 inherits from 1!
			return ex14.getMessage();
		} catch (CustomException2 | CustomException3 ex23) { //Union catch block.
			return ex23.getMessage();
		}
		return "No exception chosen";
	}
}
