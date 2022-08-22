package com.umutozd.springexample;

import com.umutozd.springexample.types.ErrorResponse;
import com.umutozd.springexample.types.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * GlobalExceptionHandler is the class that registers methods to intercept
 * exceptions raised from Rest controllers and returns formatted errors to
 * the clients.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        e.printStackTrace();
        return this.createExceptionResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = RestException.class)
    public ResponseEntity<ErrorResponse> handleRestException(RestException e) {
        return this.createExceptionResponse(e, e.getStatus());
    }

    private ResponseEntity<ErrorResponse> createExceptionResponse(Exception e, HttpStatus status) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), status);
    }
}
