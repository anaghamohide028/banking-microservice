package com.banking.customer.service;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.dto.request.CustomerStatusUpdateRequest;
import com.banking.customer.dto.request.CustomerUpdateRequest;
import com.banking.customer.dto.response.CustomerResponse;
import com.banking.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.banking.customer.enums.CustomerStatus;
import org.springframework.stereotype.Service;


public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRegistrationRequest request);
    CustomerResponse getCustomerByCustomerNumber(String customerNumber);
    CustomerResponse updateCustomer(String customerNumber, CustomerUpdateRequest request);
    CustomerResponse updateCustomerStatus(String customerNumber,CustomerStatusUpdateRequest request);
    Page<CustomerResponse> getAllCustomers(Pageable pageable);
    Page<CustomerResponse> getCustomersByStatus(CustomerStatus status, Pageable pageable);
}
