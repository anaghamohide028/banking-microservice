package com.banking.account.exception;

public class CustomerNotEligibleException extends RuntimeException{

    public CustomerNotEligibleException(String message){
        super(message);
    }
}
