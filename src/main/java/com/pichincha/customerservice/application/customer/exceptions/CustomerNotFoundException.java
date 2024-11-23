package com.pichincha.customerservice.application.customer.exceptions;

import com.pichincha.customerservice.application.common.exceptions.BaseException;

public class CustomerNotFoundException extends BaseException {

    public CustomerNotFoundException(Long id) {
        super("Customer with ID " + id + " not found.", "CUSTOMER_NOT_FOUND");
    }
}
