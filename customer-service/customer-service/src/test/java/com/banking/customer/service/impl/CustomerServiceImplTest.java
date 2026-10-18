package com.banking.customer.service.impl;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.entity.Customer;
import com.banking.customer.exception.DuplicateCustomerException;
import com.banking.customer.mapper.CustomerMapper;
import com.banking.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private  CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void  shouldThrowExceptionWhenCustomerAlreadyExist() {

        CustomerRegistrationRequest request = new CustomerRegistrationRequest();

        request.setEmail("priya01@example.com");

        when(customerRepository.existsByEmail("priya01@example.com"))
                .thenReturn(true);

        assertThrows(DuplicateCustomerException.class,
                ()->customerService.registerCustomer(request));

        verify(customerRepository,never())
                .save(any(Customer.class));

    }
}
