package com.banking.account.service;

import com.banking.account.dto.AccountCreateRequest;
import com.banking.account.dto.AccountResponse;

public interface AccountService {

    AccountResponse openAccount(AccountCreateRequest request);
}
