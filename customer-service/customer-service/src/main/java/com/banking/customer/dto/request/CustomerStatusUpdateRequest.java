package com.banking.customer.dto.request;

import com.banking.customer.enums.CustomerStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerStatusUpdateRequest {

    @NotNull(message = "status is required")
    private CustomerStatus status;

}
