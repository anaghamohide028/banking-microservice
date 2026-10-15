package com.banking.customer.service;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.dto.response.CustomerResponse;
import org.springframework.stereotype.Service;


public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRegistrationRequest request);
}
