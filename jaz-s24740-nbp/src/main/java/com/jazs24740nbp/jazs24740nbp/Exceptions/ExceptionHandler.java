package com.jazs24740nbp.jazs24740nbp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler (HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleBadRequest (HttpClientErrorException. BadRequest exception) {
        String errorMessage = "400 Bad Request: " + exception.getMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler (HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFound (HttpClientErrorException. NotFound exception) {
        String errorMessage = "404 Not Found: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
