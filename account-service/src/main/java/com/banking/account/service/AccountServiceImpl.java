package com.banking.account.service;

import com.banking.account.client.CustomerClient;
import com.banking.account.client.dto.CustomerDetailsResponse;
import com.banking.account.dto.AccountCreateRequest;
import com.banking.account.dto.AccountResponse;
import com.banking.account.entity.Account;
import com.banking.account.enums.AccountStatus;
import com.banking.account.exception.CustomerNotEligibleException;
import com.banking.account.mapper.AccountMapper;
import com.banking.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final CustomerClient customerClient;

    @Override
    public AccountResponse openAccount(AccountCreateRequest request) {

        CustomerDetailsResponse customer = customerClient.getCustomer(request.customerNumber());

        if (!"ACTIVE".equals(customer.status())) {
            throw new CustomerNotEligibleException( "Customer is not eligible to open bank Account");
        }

        Account account = new Account();

        String accountNumber = "ACC" +
                UUID.randomUUID().toString()
                        .replace("-", "")
                        .substring(0, 20);

        account.setAccountNumber(accountNumber);
        account.setCustomerNumber(request.customerNumber());
        account.setBalance(BigDecimal.ZERO);
        account.setStatus(AccountStatus.ACTIVE);
        account.setAccountType(request.accountType());

        Account savedAccount =accountRepository.save(account);

        return  accountMapper.toResponse(savedAccount);
    }

}
