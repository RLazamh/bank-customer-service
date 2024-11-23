package com.pichincha.customerservice.application.person.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
}
