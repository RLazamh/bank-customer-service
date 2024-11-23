package com.pichincha.customerservice.customer;

import com.pichincha.customerservice.application.customer.CrudCustomerUseCase;
import com.pichincha.customerservice.application.customer.dtos.CustomerDTO;
import com.pichincha.customerservice.presentation.customer.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Mock
    private CrudCustomerUseCase crudCustomerUseCase;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer() {
        // Arrange
        CustomerDTO request = new CustomerDTO();
        request.setName("John Doe");
        request.setGender("Male");
        request.setAge(30);
        request.setIdentification("1234567890");
        request.setAddress("123 Main Street");
        request.setPhone("123-456-7890");
        request.setPassword("password123");
        request.setStatus(true);

        CustomerDTO response = new CustomerDTO();
        response.setClientId(1L);
        response.setName("John Doe");
        response.setGender("Male");
        response.setAge(30);
        response.setIdentification("1234567890");
        response.setAddress("123 Main Street");
        response.setPhone("123-456-7890");
        response.setPassword("password123");
        response.setStatus(true);

        when(crudCustomerUseCase.createCustomer(any(CustomerDTO.class))).thenReturn(response);

        ResponseEntity<CustomerDTO> result = customerController.createCustomer(request);

        assertNotNull(result);
        assertEquals(200, result.getStatusCode().value());
        assertNotNull(result.getBody());
        assertEquals("John Doe", result.getBody().getName());
        verify(crudCustomerUseCase, times(1)).createCustomer(any(CustomerDTO.class));
    }

    @Test
    void testGetCustomerById() {
        Long customerId = 1L;
        CustomerDTO response = new CustomerDTO();
        response.setClientId(customerId);
        response.setName("Jane Doe");

        when(crudCustomerUseCase.getCustomerById(customerId)).thenReturn(response);

        ResponseEntity<CustomerDTO> result = customerController.getCustomerById(customerId);

        assertNotNull(result);
        assertEquals(200, result.getStatusCode().value());
        assertNotNull(result.getBody());
        assertEquals("Jane Doe", result.getBody().getName());
        verify(crudCustomerUseCase, times(1)).getCustomerById(customerId);
    }

    @Test
    void testGetAllCustomers() {
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setClientId(1L);
        customer1.setName("John Doe");

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setClientId(2L);
        customer2.setName("Jane Doe");

        when(crudCustomerUseCase.getAllCustomers()).thenReturn(List.of(customer1, customer2));

        ResponseEntity<List<CustomerDTO>> result = customerController.getAllCustomers();

        assertNotNull(result);
        assertEquals(200, result.getStatusCode().value());
        assertNotNull(result.getBody());
        assertEquals(2, result.getBody().size());
        verify(crudCustomerUseCase, times(1)).getAllCustomers();
    }
}
