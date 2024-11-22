package com.pichincha.customerservice.infrastructure.db.repositories;

import com.pichincha.customerservice.infrastructure.db.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}
