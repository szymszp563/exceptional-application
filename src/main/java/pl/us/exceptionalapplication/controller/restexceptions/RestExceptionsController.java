package pl.us.exceptionalapplication.controller.restexceptions;

import java.io.FileNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.us.exceptionalapplication.exceptions.CustomException1;
import pl.us.exceptionalapplication.service.RestExceptionService;
import pl.us.exceptionalapplication.service.StandardExceptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"Rest Exceptions"})
@Controller
@RequestMapping("/rest-exception")
@RequiredArgsConstructor
public class RestExceptionsController {

	private final RestExceptionService restExceptionService;

	@ApiOperation(value = "Handling exception with exception handler, if doThrow == true")
	@GetMapping("/exception-handler")
	public ResponseEntity<String> exceptionHandler(@RequestParam boolean doThrow) {
		return ResponseEntity.ok(restExceptionService.exceptionHandler(doThrow));
	}

	@ApiOperation(value = "Handling exception with ResponseStatusExceptionResolver, if doThrow == true")
	@GetMapping("/response-status-exception-resolver")
	public ResponseEntity<String> resolvedByResponseStatusExceptionResolver(@RequestParam boolean doThrow) {
		return ResponseEntity.ok(restExceptionService.exceptionWithResponseStatusExceptionResolver(doThrow));
	}

	@ApiOperation(value = "Handling chosen exceptions with exception handler using rest controller advice")
	@GetMapping("/rest-controller-advice")
	public ResponseEntity<String> restControllerAdvice(@RequestParam(required = false) boolean exception1, @RequestParam(required = false) boolean exception2) {
		return ResponseEntity.ok(restExceptionService.exceptionWithRestControllerAdvice(exception1, exception2));
	}

	@ExceptionHandler(CustomException1.class)
	public ResponseEntity<String> handleException(RuntimeException ex){
		return ResponseEntity.status(500).body("handled exception, with message: " + ex.getMessage());
	}
}
