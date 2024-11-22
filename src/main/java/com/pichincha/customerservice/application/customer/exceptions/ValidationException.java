package com.pichincha.customerservice.application.customer.exceptions;

public class ValidationException extends BaseException {

    public ValidationException(String message) {
        super(message, "VALIDATION_ERROR");
    }
}
