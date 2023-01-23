package com.elielsonms.transactionroutineapi.transaction.service;

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
            BigDecimal amount) {
        final var adjustedAmount = applyAmountRule(operationTypeId, amount);

        return transactionRepository.createTransaction(new Transaction(
                null,
                accountId,
                operationTypeId,
                adjustedAmount,
                OffsetDateTime.now()
        ));
    }

    public BigDecimal applyAmountRule(int operationTypeId, BigDecimal amount) {
        final var isCreditOperation = transactionRepository.isCreditOperation(operationTypeId);
        final var isNegativeAmount = amount.signum() < 0;
        if (isCreditOperation ^ isNegativeAmount) {
            return amount.negate();
        }
        return  amount;
    }
}
