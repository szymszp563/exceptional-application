package pl.us.exceptionalapplication.controller.standardexceptions;

import java.io.FileNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.us.exceptionalapplication.service.StandardExceptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"Standard Exceptions"})
@Controller
@RequestMapping("/standard-exception")
@RequiredArgsConstructor
public class StandardExceptionsController {

	private final StandardExceptionService standardExceptionService;

	@ApiOperation(value = "Rethrowing exception - throws FileNotFoundException, if doThrow == true")
	@GetMapping("/rethrow")
	public ResponseEntity<String> rethrow(@RequestParam boolean doThrow) throws FileNotFoundException {
		return ResponseEntity.ok(standardExceptionService.rethrow(doThrow));
	}

	@ApiOperation(value = "Try-Catch - Throws and catches exception, if doThrow == true")
	@GetMapping("/try-catch")
	public ResponseEntity<String> tryCatch(@RequestParam boolean doThrow) {
		if(doThrow)
			return ResponseEntity.status(500).body(standardExceptionService.tryCatch(doThrow));
		return ResponseEntity.ok(standardExceptionService.tryCatch(doThrow));
	}

	@ApiOperation(value = "Try-Catch-Finally - Throws, catches exception and executing finally block, if doThrow == true")
	@GetMapping("/try-catch-finally")
	public ResponseEntity<String> tryCatchFinally(@RequestParam boolean doThrow) {
		if(doThrow)
			return ResponseEntity.status(500).body(standardExceptionService.tryCatchFinally(doThrow));
		return ResponseEntity.ok(standardExceptionService.tryCatchFinally(doThrow));
	}

	@ApiOperation(value = "Try-Finally - Throws exception and executes finally block exception, if doThrow == true")
	@GetMapping("/try-finally")
	public ResponseEntity<String> tryFinally(@RequestParam boolean doThrow) {
		if(doThrow)
			return ResponseEntity.status(500).body(standardExceptionService.tryFinally(doThrow));
		return ResponseEntity.ok(standardExceptionService.tryFinally(doThrow));
	}

	@ApiOperation(value = "Try-With-Resources - Throws FileNotFoundException but before that file is close (works for every AutoCloseable Objects), if doThrow == true")
	@GetMapping("/try-with-resources")
	public ResponseEntity<String> tryWithResources(@RequestParam boolean doThrow) throws FileNotFoundException {
		return ResponseEntity.ok(standardExceptionService.tryWithResources(doThrow));
	}

	@ApiOperation(value = "Try-With-Multi-Catch - Throws choosen excetpion, if doThrow == true")
	@GetMapping("/try-with-multi-catch")
	public ResponseEntity<String> tryWithMultiCatch(@RequestParam(required = false) boolean exception1, @RequestParam(required = false) boolean exception2,
			@RequestParam(required = false) boolean exception3, @RequestParam(required = false) boolean exception4) {
		if(exception1||exception2||exception3||exception4)
			return ResponseEntity.status(500).body(standardExceptionService.tryWithMultiCatch(exception1, exception2, exception3, exception4));
		return ResponseEntity.ok(standardExceptionService.tryWithMultiCatch(exception1, exception2, exception3, exception4));
	}
}
