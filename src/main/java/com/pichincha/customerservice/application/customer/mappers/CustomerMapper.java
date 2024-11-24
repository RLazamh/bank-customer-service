package com.pichincha.customerservice.application.customer.mappers;

import com.pichincha.customerservice.application.customer.dtos.CustomerDTO;
import com.pichincha.customerservice.infrastructure.db.customer.entities.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity toEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        mapFieldsFromDtoToEntity(customerDTO, customerEntity);
        return customerEntity;
    }

    public CustomerDTO toDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();
        mapFieldsFromEntityToDto(customerEntity, customerDTO);
        return customerDTO;
    }

    public void updateEntityFromDTO(
            CustomerDTO customerDTO,
            CustomerEntity customerEntity
    ) {
        mapFieldsFromDtoToEntity(customerDTO, customerEntity);
    }

    private static void mapFieldsFromDtoToEntity(
            CustomerDTO customerDTO,
            CustomerEntity customerEntity
    ) {
        customerEntity.setName(customerDTO.getName());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setIdentification(customerDTO.getIdentification());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setPassword(customerDTO.getPassword());
        customerEntity.setStatus(customerDTO.getStatus());
    }

    private static void mapFieldsFromEntityToDto(
            CustomerEntity customerEntity,
            CustomerDTO customerDTO
    ) {
        customerDTO.setName(customerEntity.getName());
        customerDTO.setGender(customerEntity.getGender());
        customerDTO.setAge(customerEntity.getAge());
        customerDTO.setIdentification(customerEntity.getIdentification());
        customerDTO.setAddress(customerEntity.getAddress());
        customerDTO.setPhone(customerEntity.getPhone());
        customerDTO.setPassword(customerEntity.getPassword());
        customerDTO.setStatus(customerEntity.getStatus());
    }
}
