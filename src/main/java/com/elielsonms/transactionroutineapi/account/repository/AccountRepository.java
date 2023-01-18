package com.elielsonms.transactionroutineapi.account.repository;

import com.elielsonms.transactionroutineapi.account.model.Account;

public interface AccountRepository {

    Account createAccount(Account account);

    Account fetchAccount(Long accountId);
}
