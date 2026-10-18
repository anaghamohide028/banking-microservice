package com.banking.customer.mapper;

import com.banking.customer.dto.response.CustomerResponse;
import com.banking.customer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponse toResponse(Customer customer){

        CustomerResponse response = new CustomerResponse();

        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setCustomerNumber(customer.getCustomerNumber());
        response.setEmail(customer.getEmail());
        response.setStatus(customer.getStatus());
        response.setCreatedAt(customer.getCreatedAt());

        return response;
    }
}
