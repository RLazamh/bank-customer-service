package com.pichincha.customerservice.domain.customer;

import com.pichincha.customerservice.application.customer.exceptions.ValidationException;
import com.pichincha.customerservice.application.customer.dtos.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerDomainService {

    public void validateCustomerData(CustomerDTO customerDTO) {
        if (customerDTO.getName() == null || customerDTO.getName().isBlank()) {
            throw new ValidationException("Name is required.");
        }
        if (customerDTO.getPassword() == null || customerDTO.getPassword().isBlank()) {
            throw new ValidationException("Password is required.");
        }
        if (customerDTO.getIdentification() == null || customerDTO.getIdentification().isBlank()) {
            throw new ValidationException("Identification is required.");
        }
    }
}