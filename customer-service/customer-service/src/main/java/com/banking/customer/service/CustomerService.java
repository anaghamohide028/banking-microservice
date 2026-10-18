package com.banking.customer.service;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.dto.request.CustomerUpdateRequest;
import com.banking.customer.dto.response.CustomerResponse;
import org.springframework.stereotype.Service;


public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRegistrationRequest request);
    CustomerResponse getCustomerByCustomerNumber(String customerNumber);
    CustomerResponse updateCustomer(String customerNumber, CustomerUpdateRequest request);
}
