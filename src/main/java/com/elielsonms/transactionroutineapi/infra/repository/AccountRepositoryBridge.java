package com.elielsonms.transactionroutineapi.infra.repository;

import com.elielsonms.transactionroutineapi.account.model.Account;
import com.elielsonms.transactionroutineapi.account.repository.AccountRepository;
import com.elielsonms.transactionroutineapi.infra.mapper.AccountEntityMapper;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.AccountEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryBridge implements AccountRepository {

    public AccountRepositoryBridge(
            AccountEntityRepository accountEntityRepository,
            AccountEntityMapper accountEntityMapper) {
        this.accountEntityRepository = accountEntityRepository;
        this.accountEntityMapper = accountEntityMapper;

    }
    private final AccountEntityRepository accountEntityRepository;
    private final AccountEntityMapper accountEntityMapper;

    @Override
    public Account createAccount(Account account) {
        if (accountEntityRepository.findByDocumentNumber(account.documentNumber()).isPresent()) {
            return null;
        }
        return accountEntityMapper
                .fromJpaToDomain(
                        accountEntityRepository.save(accountEntityMapper.fromDomainToJpa(account)));
    }

    @Override
    public Account fetchAccount(Long accountId) {
        return accountEntityRepository
                .findById(accountId)
                .map(accountEntityMapper::fromJpaToDomain)
                .orElse(null);
    }
}
