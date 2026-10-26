package com.banking.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotEligibleException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotEligibleException(CustomerNotEligibleException ex){
         ErrorResponse errorresponse =new ErrorResponse(
                 HttpStatus.UNPROCESSABLE_CONTENT.value(),
                 ex.getMessage(),
                 Instant.now()
         );

         return ResponseEntity
                 .status(HttpStatus.UNPROCESSABLE_CONTENT)
                 .body(errorresponse);
    }
}
