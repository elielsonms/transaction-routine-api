package com.elielsonms.transactionroutineapi.transaction.service;

import com.elielsonms.transactionroutineapi.transaction.model.OperationType;
import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import com.elielsonms.transactionroutineapi.transaction.repository.TransactionRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TransactionServiceTest {
    TransactionRepository transactionRepository = mock(TransactionRepository.class);
    TransactionService transactionService = new TransactionService(transactionRepository);

    @Test
    void createTransactionSuccessfully() {
        final var expectedTransaction = new Transaction(
                null,
                1L,
                new OperationType(1,""),
                BigDecimal.TEN,
                OffsetDateTime.now());

        transactionService.createTransaction(
                expectedTransaction.accountId(),
                expectedTransaction.operationType().operationTypeId(),
                expectedTransaction.amount(),
                expectedTransaction.eventDate());

        verify(transactionRepository).createTransaction(expectedTransaction);
    }

}