package com.pichincha.customerservice.application.customer.dtos;

import com.pichincha.customerservice.application.person.dtos.PersonDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO extends PersonDTO {
    private Long clientId;
    private String password;
    private Boolean status;
}
