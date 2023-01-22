package com.elielsonms.transactionroutineapi.infra.repository;

import com.elielsonms.transactionroutineapi.infra.mapper.TransactionMapper;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.TransactionEntityRepository;
import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import com.elielsonms.transactionroutineapi.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Component;

@Component
public class RepositoryBridge implements TransactionRepository {

    public RepositoryBridge(
            TransactionEntityRepository transactionEntityRepository,
            TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    private final TransactionEntityRepository transactionEntityRepository;
    private final TransactionMapper transactionMapper;
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionMapper.fromJpaToDomain(
                transactionEntityRepository.save(transactionMapper.fromDomainToJpa(transaction)));
    }
}
