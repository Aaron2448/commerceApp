package com.fdmgroup.flexdronepodq42022.Exception;

import org.springframework.http.HttpStatus;

public class EcommerceAPIException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public EcommerceAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public EcommerceAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
