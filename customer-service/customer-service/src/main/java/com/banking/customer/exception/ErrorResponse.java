package com.banking.customer.exception;

import java.time.Instant;

public record ErrorResponse(int status,
        String message,
        Instant timestamp) {

}
