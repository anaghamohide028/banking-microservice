package com.banking.customer.service.impl;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.dto.request.CustomerStatusUpdateRequest;
import com.banking.customer.dto.request.CustomerUpdateRequest;
import com.banking.customer.dto.response.CustomerResponse;
import com.banking.customer.entity.Customer;
import com.banking.customer.enums.CustomerStatus;
import com.banking.customer.exception.CustomerNotFoundException;
import com.banking.customer.exception.DuplicateCustomerException;
import com.banking.customer.exception.InvalidCustomerStatusTransitionException;
import com.banking.customer.mapper.CustomerMapper;
import com.banking.customer.repository.CustomerRepository;
import com.banking.customer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.UUID;

@Service

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper){

        this.customerRepository=customerRepository;
        this.customerMapper=customerMapper;
    }

    @Override
    @Transactional
    public CustomerResponse registerCustomer(CustomerRegistrationRequest request) {

      if(customerRepository.existsByEmail(request.getEmail())){
          throw new DuplicateCustomerException("Email is already registered");
      }

           Customer customer= new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setStatus(CustomerStatus.ACTIVE);
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());

        String randomPart = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 16)
                .toUpperCase(Locale.ROOT);

        String customerNumber = "CUST" + randomPart;
        customer.setCustomerNumber(customerNumber);

        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponse(savedCustomer);

    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponse getCustomerByCustomerNumber(String customerNumber) {
        Customer customer = customerRepository.findByCustomerNumber(customerNumber)
                .orElseThrow(()->new CustomerNotFoundException(
                        "customer  not found with  Customer Number" +  customerNumber));

        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional
    public CustomerResponse updateCustomer(String customerNumber, CustomerUpdateRequest request) {

        Customer customer =customerRepository.findByCustomerNumber(customerNumber)
                .orElseThrow(()->new CustomerNotFoundException("Customer is already is registered with customer Number"));

         customer.setFirstName(request.getFirstName());
         customer.setLastName(request.getLastName());
         customer.setPhoneNumber(request.getPhoneNumber());

         Customer updatedCustomer = customerRepository.save(customer);

         return customerMapper.toResponse(updatedCustomer);

    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerResponse> getAllCustomers(Pageable pageable) {

        Page<Customer> customers = customerRepository.findAll(pageable);

        return customers.map(customerMapper::toResponse);

    }

    @Override
    @Transactional
    public CustomerResponse updateCustomerStatus(String customerNumber, CustomerStatusUpdateRequest request) {

        Customer customer =customerRepository.findByCustomerNumber(customerNumber)
                .orElseThrow(()->new CustomerNotFoundException("Customer not found with Customer Number" +customerNumber));

        CustomerStatus currentStatus = customer.getStatus();
        CustomerStatus requestedStatus = request.getStatus();

        if (currentStatus == requestedStatus) {
            throw new InvalidCustomerStatusTransitionException(
                    "Customer is already in " + currentStatus + " status"
            );
        }
        if (currentStatus == CustomerStatus.BLOCKED) {
            throw new InvalidCustomerStatusTransitionException(
                    "Blocked customer cannot change status through this API"
            );
        }
        customer.setStatus(request.getStatus());

        Customer upadtedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(upadtedCustomer);
    }
}


