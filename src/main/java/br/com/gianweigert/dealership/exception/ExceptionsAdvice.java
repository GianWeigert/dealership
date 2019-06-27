package br.com.gianweigert.dealership.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.gianweigert.dealership.error.Error;

@ControllerAdvice
public class ExceptionsAdvice {
	
	@ResponseBody
	@ExceptionHandler(AbstractNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Error brandNotFoundHandler(AbstractNotFoundException ex) {
		return new Error(ex.getMessage());
	}
	
}
