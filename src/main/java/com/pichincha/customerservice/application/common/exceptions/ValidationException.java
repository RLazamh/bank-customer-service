package com.pichincha.customerservice.application.common.exceptions;

public class ValidationException extends BaseException {

    public ValidationException(String message) {
        super(message, "VALIDATION_ERROR");
    }
}
