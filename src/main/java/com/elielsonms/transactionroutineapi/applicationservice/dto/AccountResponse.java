package com.elielsonms.transactionroutineapi.applicationservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AccountResponse(Long accountId, String documentNumber, BigDecimal availableCreditLimit) {
}
