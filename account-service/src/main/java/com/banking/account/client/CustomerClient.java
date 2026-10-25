package com.banking.account.client;


import com.banking.account.client.dto.CustomerDetailsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "customer-service",
        url = "${customer.service.url}"
)
public interface CustomerClient {

    @GetMapping("/api/v1/customers/{customerNumber}")
    CustomerDetailsResponse getCustomer(@PathVariable("customerNumber") String customerNumber);
}
