package com.banking.account.mapper;

import com.banking.account.dto.AccountResponse;
import com.banking.account.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountResponse toResponse(Account account){
        return new AccountResponse(
                account.getAccountNumber(),
                account.getCustomerNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getStatus(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }
}
