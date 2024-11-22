package com.pichincha.customerservice.application.customer.exceptions;

public class CustomerNotFoundException extends BaseException {

    public CustomerNotFoundException(Long id) {
        super("Customer with ID " + id + " not found.", "CUSTOMER_NOT_FOUND");
    }
}
