package com.pichincha.customerservice.infrastructure.db.customer.entities;

import com.pichincha.customerservice.infrastructure.db.person.entities.PersonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "customers")
public class CustomerEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "status" , nullable = false)
    private Boolean status;

}
