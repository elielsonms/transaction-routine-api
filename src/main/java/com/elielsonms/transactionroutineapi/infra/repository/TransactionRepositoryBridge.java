package com.elielsonms.transactionroutineapi.infra.repository;

import com.elielsonms.transactionroutineapi.infra.mapper.TransactionEntityMapper;
import com.elielsonms.transactionroutineapi.infra.model.jpa.OperationType;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.AccountEntityRepository;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.OperationTypeRepository;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.TransactionEntityRepository;
import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import com.elielsonms.transactionroutineapi.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Component;

@Component
public class TransactionRepositoryBridge implements TransactionRepository {

    public TransactionRepositoryBridge(
            TransactionEntityRepository transactionEntityRepository,
            AccountEntityRepository accountEntityRepository,
            OperationTypeRepository operationTypeRepository,
            TransactionEntityMapper transactionEntityMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.accountEntityRepository = accountEntityRepository;
        this.operationTypeRepository = operationTypeRepository;
        this.transactionEntityMapper = transactionEntityMapper;
    }

    private final TransactionEntityRepository transactionEntityRepository;

    private final AccountEntityRepository accountEntityRepository;
    private final OperationTypeRepository operationTypeRepository;
    private final TransactionEntityMapper transactionEntityMapper;
    @Override
    public Transaction createTransaction(Transaction transaction) {
        if (accountEntityRepository.findById(transaction.accountId()).isPresent()
                && operationTypeRepository.findById(transaction.operationTypeId()).isPresent()) {
            return transactionEntityMapper.fromJpaToDomain(
                    transactionEntityRepository.save(transactionEntityMapper.fromDomainToJpa(transaction)));
        }
        return null;
    }

    @Override
    public boolean isCreditOperation(int operationTypeId) {
        return operationTypeRepository.findById(operationTypeId).map(OperationType::getCreditOperation).orElse(false);
    }
}
