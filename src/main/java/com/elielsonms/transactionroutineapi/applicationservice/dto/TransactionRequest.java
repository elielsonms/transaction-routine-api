package com.elielsonms.transactionroutineapi.applicationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionRequest(
        @JsonProperty(value = "account_id") @NotNull
        Long accountId,
        @JsonProperty(value = "operation_type_id") @NotNull
        Integer operationTypeId,
        @NotNull
        BigDecimal amount
) {
}
