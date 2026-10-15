package com.banking.customer.Controller;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.dto.response.CustomerResponse;
import com.banking.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> registerCustomer(@RequestBody @Valid CustomerRegistrationRequest request){

        CustomerResponse response = customerService.registerCustomer(request);

        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
