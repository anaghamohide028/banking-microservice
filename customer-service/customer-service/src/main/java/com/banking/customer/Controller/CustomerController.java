package com.banking.customer.Controller;

import com.banking.customer.dto.request.CustomerRegistrationRequest;
import com.banking.customer.dto.request.CustomerStatusUpdateRequest;
import com.banking.customer.dto.request.CustomerUpdateRequest;
import com.banking.customer.dto.response.CustomerResponse;
import com.banking.customer.entity.Customer;
import com.banking.customer.enums.CustomerStatus;
import com.banking.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerResponse> getCustomerByCustomerNumber(@PathVariable String customerNumber)
    {
        CustomerResponse response = customerService.getCustomerByCustomerNumber(customerNumber);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/{customerNumber}/profile")
    public ResponseEntity<CustomerResponse> updateCustomerByCustomerNumber(@PathVariable String customerNumber, @RequestBody @Valid CustomerUpdateRequest request){
        CustomerResponse response =customerService.updateCustomer(customerNumber,request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
    @PatchMapping("/{customerNumber}/status")
    public ResponseEntity<CustomerResponse> updateCustomerStatus(
            @PathVariable String customerNumber,
            @Valid @RequestBody CustomerStatusUpdateRequest request) {

        CustomerResponse response =
                customerService.updateCustomerStatus(customerNumber, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<Page<CustomerResponse>> getAllCustomer(  @PageableDefault(
            page = 0, size = 10,
            sort = "createdAt",
            direction = Sort.Direction.DESC )Pageable pageable)
    {

        Page<CustomerResponse> response =
                customerService.getAllCustomers(pageable);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/filter")
    public ResponseEntity<Page<CustomerResponse>> getCustomerByStatus(@RequestParam CustomerStatus status, @PageableDefault(
            page =0, size =10,
            sort ="createdAt",
            direction = Sort.Direction.DESC) Pageable pageable)
    {
        Page<CustomerResponse> response = customerService.getCustomersByStatus(status, pageable);
        return ResponseEntity.ok(response);
    }
}
