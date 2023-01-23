package com.elielsonms.transactionroutineapi.transaction.service;

import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import com.elielsonms.transactionroutineapi.transaction.repository.TransactionRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TransactionEntityServiceTest {
    TransactionRepository transactionRepository = mock(TransactionRepository.class);
    TransactionService transactionService = new TransactionService(transactionRepository);

    @Test
    void createTransactionSuccessfully() {
        final var expectedTransaction = new Transaction(
                null,
                1L,
                1,
                BigDecimal.TEN,
                OffsetDateTime.now());

        transactionService.createTransaction(
                expectedTransaction.accountId(),
                expectedTransaction.operationTypeId(),
                expectedTransaction.amount());

        verify(transactionRepository).createTransaction(expectedTransaction);
    }

}