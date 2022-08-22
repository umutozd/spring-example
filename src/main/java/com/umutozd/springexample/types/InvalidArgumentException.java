package com.umutozd.springexample.types;

import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends RestException {
    public InvalidArgumentException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
