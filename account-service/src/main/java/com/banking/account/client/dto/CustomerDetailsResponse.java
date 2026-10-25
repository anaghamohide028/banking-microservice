package com.banking.account.client.dto;

public record CustomerDetailsResponse(
        String customerNumber,
        String status
) {
}
