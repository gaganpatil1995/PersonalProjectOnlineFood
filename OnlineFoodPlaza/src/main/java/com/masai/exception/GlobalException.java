package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<MyErrorDetails> UserExceptionHandler(UserNotFoundException un, WebRequest wr ){ 
		
		MyErrorDetails er = new MyErrorDetails() ;
		er.setDat(LocalDateTime.now());
		er.setMessage(un.getMessage());
		er.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<MyErrorDetails> globalExceptionHandler(Exception e,WebRequest wr){
		MyErrorDetails er  = new MyErrorDetails() ;
		er.setDat(LocalDateTime.now());
		er.setMessage(e.getMessage());
		er.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> MyNoFoundExceptionHandler(NoHandlerFoundException hf,WebRequest wr){
		MyErrorDetails er = new MyErrorDetails();
		er.setDat(LocalDateTime.now());
		er.setMessage(hf.getMessage());
		er.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationExceptionHandler(MethodArgumentNotValidException ma,WebRequest wr){
		MyErrorDetails er = new MyErrorDetails() ;
		er.setDat(LocalDateTime.now());
		er.setMessage(ma.getMessage());
		er.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(er,HttpStatus.METHOD_NOT_ALLOWED);
	}
}
