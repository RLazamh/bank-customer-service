package com.pichincha.customerservice.application.customer;

import com.pichincha.customerservice.application.customer.dtos.CustomerDTO;
import com.pichincha.customerservice.application.customer.exceptions.CustomerNotFoundException;
import com.pichincha.customerservice.application.customer.mappers.CustomerMapper;
import com.pichincha.customerservice.domain.customer.CustomerDomainService;
import com.pichincha.customerservice.infrastructure.db.entities.CustomerEntity;
import com.pichincha.customerservice.infrastructure.db.services.CustomerDbService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrudCustomerUseCase {

    private final CustomerDbService customerDbService;
    private final CustomerDomainService customerDomainService;
    private final CustomerMapper customerMapper;

    public CrudCustomerUseCase(
            CustomerDbService customerDbService,
            CustomerDomainService customerDomainService,
            CustomerMapper customerMapper
    ) {
        this.customerDbService = customerDbService;
        this.customerDomainService = customerDomainService;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerDomainService.validateCustomerData(customerDTO);
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);
        CustomerEntity savedEntity = customerDbService.saveCustomer(customerEntity);
        return customerMapper.toDTO(savedEntity);
    }

    public CustomerDTO getCustomerById(Long id) {
        Optional<CustomerEntity> customerEntity = customerDbService.findCustomerById(id);
        return customerEntity.map(customerMapper::toDTO)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        customerDomainService.validateCustomerData(customerDTO);

        CustomerEntity existingEntity = customerDbService.findCustomerById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customerMapper.updateEntityFromDTO(customerDTO, existingEntity);
        CustomerEntity updatedEntity = customerDbService.saveCustomer(existingEntity);
        return customerMapper.toDTO(updatedEntity);
    }

    public void deleteCustomer(Long id) {
        if (customerDbService.findCustomerById(id).isEmpty()) {
            throw new CustomerNotFoundException(id);
        }
        customerDbService.deleteCustomerById(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customers = customerDbService.findAllCustomers();
        return customers.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
