package com.elielsonms.transactionroutineapi.transaction.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Transaction(
        Long transactionId,
        Long accountId,
        OperationType operationType,
        BigDecimal amount,
        OffsetDateTime eventDate) {
}
