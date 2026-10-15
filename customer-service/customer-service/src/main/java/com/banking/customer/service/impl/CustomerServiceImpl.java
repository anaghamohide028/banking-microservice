package com.banking.customer.service.impl;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.dto.response.CustomerResponse;
import com.banking.customer.entity.Customer;
import com.banking.customer.enums.CustomerStatus;
import com.banking.customer.exception.DuplicateCustomerException;
import com.banking.customer.repository.CustomerRepository;
import com.banking.customer.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
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

        CustomerResponse customerResponse =new CustomerResponse();

        customerResponse.setFirstName(savedCustomer.getFirstName());
        customerResponse.setLastName(savedCustomer.getLastName());
        customerResponse.setEmail(savedCustomer.getEmail());
        customerResponse.setCustomerNumber(savedCustomer.getCustomerNumber());
        customerResponse.setStatus(savedCustomer.getStatus());
        customerResponse.setCreatedAt(savedCustomer.getCreatedAt());


        return customerResponse;

    }
}
