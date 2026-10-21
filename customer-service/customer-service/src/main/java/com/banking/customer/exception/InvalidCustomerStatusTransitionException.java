package com.banking.customer.exception;


public class InvalidCustomerStatusTransitionException extends RuntimeException{

    public InvalidCustomerStatusTransitionException(String message){
        super(message);
    }
}
