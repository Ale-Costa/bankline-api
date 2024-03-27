package com.dio.santander.bankline.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String exception;

    public ErrorResponse(String message, String exception) {
        this.message = message;
        this.exception = exception;
    }
}

