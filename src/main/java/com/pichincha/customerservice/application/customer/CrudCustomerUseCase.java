package com.pichincha.customerservice.application.customer;

import com.pichincha.customerservice.application.customer.dtos.CustomerDTO;
import com.pichincha.customerservice.application.customer.exceptions.CustomerNotFoundException;
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

    public CrudCustomerUseCase(CustomerDbService customerDbService, CustomerDomainService customerDomainService) {
        this.customerDbService = customerDbService;
        this.customerDomainService = customerDomainService;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerDomainService.validateCustomerData(customerDTO);
        CustomerEntity customerEntity = mapToEntity(customerDTO);
        CustomerEntity savedEntity = customerDbService.saveCustomer(customerEntity);
        return mapToDTO(savedEntity);
    }

    public CustomerDTO getCustomerById(Long id) {
        Optional<CustomerEntity> customerEntity = customerDbService.findCustomerById(id);
        return customerEntity.map(this::mapToDTO)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        customerDomainService.validateCustomerData(customerDTO);
        CustomerEntity existingEntity = customerDbService.findCustomerById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        existingEntity.setName(customerDTO.getName());
        existingEntity.setGender(customerDTO.getGender());
        existingEntity.setAge(customerDTO.getAge());
        existingEntity.setIdentification(customerDTO.getIdentification());
        existingEntity.setAddress(customerDTO.getAddress());
        existingEntity.setPhone(customerDTO.getPhone());
        existingEntity.setPassword(customerDTO.getPassword());
        existingEntity.setStatus(customerDTO.getStatus());

        CustomerEntity updatedEntity = customerDbService.saveCustomer(existingEntity);
        return mapToDTO(updatedEntity);
    }

    public void deleteCustomer(Long id) {
        if (customerDbService.findCustomerById(id).isEmpty()) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerDbService.deleteCustomerById(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customers = customerDbService.findAllCustomers();
        return customers.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CustomerEntity mapToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDTO.getName());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setIdentification(customerDTO.getIdentification());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setPassword(customerDTO.getPassword());
        customerEntity.setStatus(customerDTO.getStatus());
        return customerEntity;
    }

    private CustomerDTO mapToDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setClientId(customerEntity.getClientId());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setGender(customerEntity.getGender());
        customerDTO.setAge(customerEntity.getAge());
        customerDTO.setIdentification(customerEntity.getIdentification());
        customerDTO.setAddress(customerEntity.getAddress());
        customerDTO.setPhone(customerEntity.getPhone());
        customerDTO.setPassword(customerEntity.getPassword());
        customerDTO.setStatus(customerEntity.getStatus());
        return customerDTO;
    }
}
