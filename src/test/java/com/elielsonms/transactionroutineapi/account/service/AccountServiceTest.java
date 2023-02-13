package com.elielsonms.transactionroutineapi.account.service;

import com.elielsonms.transactionroutineapi.account.model.Account;
import com.elielsonms.transactionroutineapi.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountServiceTest {

    private final AccountRepository accountRepository = mock(AccountRepository.class);
    private final AccountService accountService = new AccountService(accountRepository);

    @Test
    void createAccountSuccessfully() {
        final var expectedAccount = new Account(
                null,
                "documentNumber",
                BigDecimal.TEN);

        accountService.createAccount(expectedAccount.documentNumber(), expectedAccount.availableCreditLimit());

        verify(accountRepository).createAccount(expectedAccount);
    }

    @Test
    void fetchAccountSuccessfully() {
        final var accountId = 2L;
        accountService.fetchAccount(accountId);
        verify(accountRepository).fetchAccount(accountId);
    }


    @Test
    void createAccountSuccessfullyWithoutCredit() {
        final var expectedAccount = new Account(
                null,
                "documentNumber", BigDecimal.ZERO);

        accountService.createAccount(expectedAccount.documentNumber(), null);

        verify(accountRepository).createAccount(expectedAccount);
    }

}