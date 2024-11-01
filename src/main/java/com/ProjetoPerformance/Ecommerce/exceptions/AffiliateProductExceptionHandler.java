package com.ProjetoPerformance.Ecommerce.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AffiliateProductExceptionHandler {

	@ExceptionHandler(AffiliateProductAlreadyExistsException.class)
    public ResponseEntity<String> handleAffiliateProductAlreadyExists(AffiliateProductAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	}
	
	 @ExceptionHandler(NoSuchElementException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND) 
	    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
    
	 @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

