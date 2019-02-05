package com.example.sdj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.sdj.model.RestError;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{


	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<RestError> handlePersonNotfoundException(EntityNotFoundException ex){
		RestError restError=new RestError(HttpStatus.NOT_FOUND,ex.getMessege());
		return buildResponseEntity(restError);
	}
	
	@ExceptionHandler(RequiredFieldMissingException.class)
	protected ResponseEntity<RestError> handleRequirefieldMissingException(RequiredFieldMissingException ex){
		RestError restError=new RestError(HttpStatus.UNPROCESSABLE_ENTITY,ex.getMessege());
		return buildResponseEntity(restError);
	}
	
	
	
	private ResponseEntity<RestError> buildResponseEntity(RestError restError) {
		return new ResponseEntity<>(restError, restError.getStatus());
	}
}
