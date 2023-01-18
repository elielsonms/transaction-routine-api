package com.elielsonms.transactionroutineapi.account.service;

import com.elielsonms.transactionroutineapi.account.model.Account;
import com.elielsonms.transactionroutineapi.account.repository.AccountRepository;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account createAccount(String documentNumber){
        return accountRepository.createAccount(new Account(null, documentNumber));
    }

    public Account fetchAccount(Long accountId) {
        return accountRepository.fetchAccount(accountId);
    }
}
