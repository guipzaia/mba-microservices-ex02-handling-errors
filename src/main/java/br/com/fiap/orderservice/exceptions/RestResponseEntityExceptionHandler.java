package br.com.fiap.orderservice.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice 
public class RestResponseEntityExceptionHandler extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<Object> handleEntityNotFound(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EntityNotUpdatedException.class)
	public final ResponseEntity<Object> handleEntityNotUpdated(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public final ResponseEntity<Object> handleInternalServerError(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
