package com.pichincha.customerservice.presentation.customer;

import com.pichincha.customerservice.application.customer.CrudCustomerUseCase;
import com.pichincha.customerservice.application.customer.dtos.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CrudCustomerUseCase crudCustomerUseCase;

    public CustomerController(CrudCustomerUseCase crudCustomerUseCase) {
        this.crudCustomerUseCase = crudCustomerUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(
            @RequestBody CustomerDTO customerDTO
    ) {
        CustomerDTO createdCustomer = crudCustomerUseCase.createCustomer(customerDTO);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(
            @PathVariable Long id
    ) {
        CustomerDTO customer = crudCustomerUseCase.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerDTO customerDTO
    ) {
        CustomerDTO updatedCustomer = crudCustomerUseCase.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        crudCustomerUseCase.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = crudCustomerUseCase.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
