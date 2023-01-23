package com.elielsonms.transactionroutineapi.transaction.repository;

import com.elielsonms.transactionroutineapi.transaction.model.Transaction;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);

    boolean isCreditOperation(int operationTypeId);
}
