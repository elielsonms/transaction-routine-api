package com.elielsonms.transactionroutineapi.infra.config;

import com.elielsonms.transactionroutineapi.account.repository.AccountRepository;
import com.elielsonms.transactionroutineapi.account.service.AccountService;
import com.elielsonms.transactionroutineapi.transaction.repository.TransactionRepository;
import com.elielsonms.transactionroutineapi.transaction.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TransactionService transactionService(TransactionRepository transactionRepository) {
        return new TransactionService(transactionRepository);
    }

    @Bean
    public AccountService accountService(AccountRepository accountRepository) {
        return new AccountService(accountRepository);
    }
}
