package com.banking.account.dto;

import com.banking.account.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AccountCreateRequest(

        @NotBlank(message = "Customer number is required")
        @Size(max = 50, message = "Customer number is too long")
        String customerNumber,

        @NotNull(message = "Account type is required")
        AccountType accountType
) {
}
