package com.example.customer.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleResponse(MethodArgumentNotValidException exception)
	{
      Map<String, Object> map=new HashMap<String, Object>();
      map.put("status", HttpStatus.BAD_REQUEST.value());
      map.put("error", exception.getBindingResult().getFieldErrors()
    		  .stream()
    		  .map(DefaultMessageSourceResolvable::getDefaultMessage)
    		  .collect(Collectors.toList()));
    		    
		return map;
	
	}
    
    @ExceptionHandler(Exception.class) 
	public ResponseEntity<String> handleResponse(Exception exception)
	{
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("An Error occured:"+exception.getMessage());
       
	
	}
    
    
    
	
}
