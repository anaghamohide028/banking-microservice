package com.banking.customer.dto.response;

import com.banking.customer.enums.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerResponse {

    private String firstName;

    private String lastName;

    private String email;

    private String customerNumber;

    private CustomerStatus status;

    private LocalDateTime createdAt;
}
