package com.elielsonms.transactionroutineapi.transaction.service;

import com.elielsonms.transactionroutineapi.transaction.model.OperationType;
import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import com.elielsonms.transactionroutineapi.transaction.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransactionService {

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private final TransactionRepository transactionRepository;

    public Transaction createTransaction(
            long accountId,
            int operationTypeId,
            BigDecimal amount,
            OffsetDateTime eventDate) {
        return transactionRepository.createTransaction(new Transaction(
                null,
                accountId,
                new OperationType(operationTypeId, ""),
                amount,
                eventDate
        ));
    }
}
