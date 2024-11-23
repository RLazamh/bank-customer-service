package com.pichincha.customerservice.infrastructure.db.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class PersonEntity {

    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;

}
