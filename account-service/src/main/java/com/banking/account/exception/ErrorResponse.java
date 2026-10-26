package com.banking.account.exception;

import java.time.Instant;
import java.time.LocalDateTime;

public record ErrorResponse( int status,
        String message,
         Instant timestamp

) {
}
