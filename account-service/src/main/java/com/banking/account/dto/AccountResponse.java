package com.banking.account.dto;

import com.banking.account.enums.AccountStatus;
import com.banking.account.enums.AccountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountResponse(
        String accountNumber,
        String customerNumber,
        AccountType accountType,
        BigDecimal balance,
        AccountStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
