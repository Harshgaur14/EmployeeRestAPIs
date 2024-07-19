package com.pracproject.Practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pracproject.Practice.EmployeeNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	 @ResponseBody
	    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    @ResponseBody
	    public ResponseEntity<String> handleGenericException(Exception ex) {
	        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseBody
	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex){
	    	StringBuilder errorMsg=new StringBuilder("Validation failed: ");
	    	ex.getBindingResult().getAllErrors().forEach(error->{
	    		errorMsg.append(error.getDefaultMessage()).append("; ");
	    	});
	    	return new ResponseEntity<>(errorMsg.toString(),HttpStatus.BAD_REQUEST);
	    }
	
	
}
