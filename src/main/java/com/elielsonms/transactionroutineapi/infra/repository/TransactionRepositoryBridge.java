package com.elielsonms.transactionroutineapi.infra.repository;

import com.elielsonms.transactionroutineapi.infra.mapper.TransactionEntityMapper;
import com.elielsonms.transactionroutineapi.infra.model.jpa.AccountEntity;
import com.elielsonms.transactionroutineapi.infra.model.jpa.OperationType;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.AccountEntityRepository;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.OperationTypeRepository;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.TransactionEntityRepository;
import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import com.elielsonms.transactionroutineapi.transaction.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        final var account = accountEntityRepository.findById(transaction.accountId());
        final var operationType = operationTypeRepository.findById(transaction.operationTypeId());
        if (account.isPresent() && operationType.isPresent()) {
            if (isTransactionAllowed(transaction, operationType.get(), account.get())) {
                final var transactionReturn = transactionEntityMapper.fromJpaToDomain(
                    transactionEntityRepository.save(transactionEntityMapper.fromDomainToJpa(transaction)));
                reflectCreditLimit(transaction, account.get());
                return transactionReturn;
            }
        }
        return null;
    }

    private void reflectCreditLimit(Transaction transaction, AccountEntity accountEntity) {
        accountEntity.setAvailableCreditLimit(
                accountEntity.getAvailableCreditLimit().add(transaction.amount()));
        accountEntityRepository.save(accountEntity);
    }

    private boolean isTransactionAllowed(Transaction transaction, OperationType operationType, AccountEntity account) {
        if (!operationType.getCreditOperation() ||  account.getAvailableCreditLimit().add(transaction.amount()).compareTo(BigDecimal.ZERO) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCreditOperation(int operationTypeId) {
        return operationTypeRepository.findById(operationTypeId).map(OperationType::getCreditOperation).orElse(false);
    }
}
