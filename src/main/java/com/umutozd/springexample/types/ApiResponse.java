package com.umutozd.springexample.types;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ApiResponse {
    private String message;

    public ApiResponse() {
        this.message = "";
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    @JsonGetter
    public String getMessage() {
        return message;
    }

    @JsonSetter
    public void setMessage(String message) {
        this.message = message;
    }
}
