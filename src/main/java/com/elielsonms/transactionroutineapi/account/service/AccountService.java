package com.elielsonms.transactionroutineapi.account.service;

import com.elielsonms.transactionroutineapi.account.model.Account;
import com.elielsonms.transactionroutineapi.account.repository.AccountRepository;

import java.math.BigDecimal;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account createAccount(String documentNumber, BigDecimal availableCreditLimit){
        final var adjustedAvailableCreditLimit = availableCreditLimit == null ? BigDecimal.ZERO : availableCreditLimit;
        final var account = new Account(null, documentNumber, adjustedAvailableCreditLimit);
        return accountRepository.createAccount(account);
    }

    public Account fetchAccount(Long accountId) {
        return accountRepository.fetchAccount(accountId);
    }
}
