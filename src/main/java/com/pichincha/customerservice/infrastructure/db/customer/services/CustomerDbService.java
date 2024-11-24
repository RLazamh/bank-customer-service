package com.pichincha.customerservice.infrastructure.db.customer.services;

import com.pichincha.customerservice.infrastructure.db.customer.entities.CustomerEntity;
import com.pichincha.customerservice.infrastructure.db.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDbService {

    private final CustomerRepository customerRepository;

    public CustomerDbService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    public Optional<CustomerEntity> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerEntity> findAllCustomers() {
        Iterable<CustomerEntity> iterable = customerRepository.findAll();
        List<CustomerEntity> customers = new ArrayList<>();
        iterable.forEach(customers::add);
        return customers;
    }
}
