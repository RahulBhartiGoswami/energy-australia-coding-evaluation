package com.ea.coding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This generic method is handling the Rate Exceeding exception
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleRateLimitException(HttpClientErrorException ex){
        return new ResponseEntity<>("Rate Limit Exceeded, " + ex.getMessage() + " Try Again", HttpStatus.TOO_MANY_REQUESTS);
    }

}
